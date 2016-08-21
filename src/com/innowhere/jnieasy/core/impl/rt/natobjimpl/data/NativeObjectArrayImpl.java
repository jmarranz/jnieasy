/*
 * NativeObjectArrayImpl.java
 *
 * Created on 17 de noviembre de 2004, 21:09
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeObjectArrayStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.UnFetch;
import java.lang.reflect.Array;

public abstract class NativeObjectArrayImpl extends NativeArrayImpl implements NativeObjectArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeObjectArrayImpl
     */
    public NativeObjectArrayImpl()
    {
    }

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativeObjectArrayStateManagerImpl();    
    }
        
    public Object[] getObjectArray()
    {
        return (Object[])getValue(); 
    }
    
    public void setObjectArray(Object[] newValue)
    {
        setValue(newValue); 
    }    
    
    public Object[] jnieasyCastObjectArray()
    {
        return (Object[])jnieasyGetInternalValue();
    }    

    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {        
        // El caso de proxy la matriz será nula pues no se sabe el tamaño, 
        // pero es posible acceder via getTIPO(index) a cualquier elemento 
        // en el buffer
        Object[] value = jnieasyCastObjectArray();
        
        if (value == null) 
            throw new JNIEasyException("Unknown array length");

        for(int i = 0; i < value.length; i++)
            jnieasyGetObject(i,fetchMode,fetchCtx,(NativeObjectArrayStateManagerImpl)stateMgr); // Para que se actualice la matriz a partir de la memoria nativa
        
        return value; 
    }
    
    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {       
        ((NativeObjectArrayStateManagerImpl)stateMgr).updateAuxObjectArray(newValue);
        
        super.jnieasySetValue(newValue,stateMgr);
        
        Object[] valueArray = jnieasyCastObjectArray();        
//        if (valueArray != null)
//        {
            for(int i = 0; i < valueArray.length; i++)
            {
                Object obj = valueArray[i];
                jnieasySetObject(i,obj,unFetchMode,unfetchCtx,attachCopyCtx,(NativeObjectArrayStateManagerImpl)stateMgr);               
            }        
//        }
    }    
   
    public synchronized Object getElement(int index,int fetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
            return jnieasyCastObjectArray()[index];        
        
        NativeManagerImpl.checkFetchMode(fetchMode);        
        return jnieasyGetObject(index, fetchMode,NativeManagerImpl.newFetchContextIfNeeded(fetchMode),(NativeObjectArrayStateManagerImpl)stateMgr);
    }
    
    public synchronized void setElement(int index,Object newValue,int unFetchMode)
    {
        NativeStateManager stateMgr = jnieasyGetNativeStateManager();        
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            jnieasyCastObjectArray()[index] = newValue;        
            return;
        }
        
        NativeManagerImpl.checkUnFetchMode(unFetchMode);        
        jnieasySetObject(index,newValue, unFetchMode,NativeManagerImpl.newUnFetchContextIfNeeded(unFetchMode),null,(NativeObjectArrayStateManagerImpl)stateMgr);
    }
    
    public Object jnieasyGetObject(int index,int fetchMode,Object fetchCtx,NativeObjectArrayStateManagerImpl stateMgr)
    {
        VarTypeNativeObjectRuntimeImpl varTypeDecComp = (VarTypeNativeObjectRuntimeImpl)jnieasyGetComponentVarType();

        long compSize = stateMgr.getComponentSize();
        
        long offset = compSize * index;
        Object[] valueArray = jnieasyCastObjectArray();        
        if (valueArray != null)
        {           
            Object item = valueArray[index];            
            item = varTypeDecComp.getObject(index,offset,stateMgr,item,fetchMode,(FetchUnFetchContext)fetchCtx);         
            valueArray[index] = item;
            return item;
        }
        else
        {
            // De esta manera podemos obtener valores de matrices de dimensión desconocida (cuando es proxy)          
            return varTypeDecComp.getObject(index,offset,stateMgr,null,fetchMode,(FetchUnFetchContext)fetchCtx);
        }
    }    
    
    public void jnieasySetObject(int index, Object newValue,int unFetchMode,Object fetchCtx,Object attachCopyCtx,NativeObjectArrayStateManagerImpl stateMgr)
    {
        VarTypeNativeObjectRuntimeImpl varTypeDecComp = (VarTypeNativeObjectRuntimeImpl)jnieasyGetComponentVarType();

        long compSize = stateMgr.getComponentSize();
        
        long offset = index * compSize;
        Object[] valueArray = jnieasyCastObjectArray();        
        if (valueArray != null)
        {
            varTypeDecComp.setObject(index,offset,stateMgr,newValue,unFetchMode,(FetchUnFetchContext)fetchCtx,(AttachCopyContext)attachCopyCtx);            
            valueArray[index] = newValue;          
        }
        else
        {
            // De esta manera podemos poner valores en matrices de dimensión desconocida (cuando es proxy)
            varTypeDecComp.setObject(index,offset,stateMgr,newValue,unFetchMode,(FetchUnFetchContext)fetchCtx,(AttachCopyContext)attachCopyCtx);
        }
    }    

    public synchronized Object getElement(int index)
    {
        int defaultFetch = NativeManagerImpl.getDefaultFetchMode(this);
        return getElement(index,defaultFetch);
    }
    
    public synchronized void setElement(int index, Object value)
    {
        int defaultUnFetch = NativeManagerImpl.getDefaultUnFetchMode(this);        
        setElement(index,value,defaultUnFetch);
    }
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        Object[] valueArray = jnieasyCastObjectArray();
        if (valueArray != null)
        {
            VarTypeNativeObjectRuntimeImpl varTypeDecComp = (VarTypeNativeObjectRuntimeImpl)jnieasyGetComponentVarType();
                    
            for(int i=0; i < valueArray.length; i++)
            {
                Object obj = valueArray[i];
                varTypeDecComp.detachField(i,(NativeObjectArrayStateManagerImpl)stateMgr,obj,freeMemMode, deep);                
            }
        }       
    }
    
    public Object jnieasyCloneValue(Object valueToClone,Object cloneCtx,NativeStateManager stateMgr)
    {
        Object[] valueArray = (Object[])valueToClone;
        
        VarTypeNativeObjectRuntimeImpl varTypeDecComp = (VarTypeNativeObjectRuntimeImpl)jnieasyGetComponentVarType();

        Object[] valueArrayCloned = (Object[])valueArray.clone();
        for(int i=0; i < valueArray.length; i++)
        {
            Object obj = valueArray[i];
            obj = varTypeDecComp.clone(i,(NativeObjectArrayStateManagerImpl)stateMgr, obj,(CloneContext) cloneCtx);
            valueArrayCloned[i] = obj;
        }
        return valueArrayCloned;
    }

    
    public synchronized Object getElement(int[] dims,int dimStart,int fetchMode)
    {
        NativeObjectArrayStateManagerImpl stateMgr = (NativeObjectArrayStateManagerImpl)jnieasyGetNativeStateManager();
        if ((stateMgr == null)||(fetchMode == Fetch.NONE))
        {
            Object[] valueArray = jnieasyCastObjectArray();     
            if ((dims.length - dimStart) == 1)
                return valueArray[dims[dimStart]];
            else
            {
                Object res = valueArray;
                for(int i = dimStart; i < dims.length; i++)
                    res = Array.get(res,dims[i]);
                return res;
            }
        }
        
        NativeManagerImpl.checkFetchMode(fetchMode);        
        FetchUnFetchContext fetchCtx = NativeManagerImpl.newFetchContextIfNeeded(fetchMode);
        
        int index = dims[dimStart];
            
        if ((dims.length - dimStart) == 1)
            return jnieasyGetObject(index, fetchMode,fetchCtx,stateMgr);
        else
        {
            NativeArray elem = jnieasyGetNativeArrayElem(index,stateMgr);

            // elem no puede ser nulo
            dimStart++;
            return elem.getElement(dims,dimStart,fetchMode);
        }
    }    
    
    public synchronized void setElement(int[] dims,int dimStart,Object newValue,int unFetchMode)
    {
        NativeObjectArrayStateManagerImpl stateMgr = (NativeObjectArrayStateManagerImpl)jnieasyGetNativeStateManager();        
        if ((stateMgr == null)||(unFetchMode == UnFetch.NONE))
        {
            Object[] valueArray = jnieasyCastObjectArray();     
            if ((dims.length - dimStart) == 1)
                valueArray[dims[dimStart]] = newValue;
            else
            {
                Object res = valueArray;
                for(int i = dimStart; i < dims.length; i++)
                {
                    if ((dims.length - i) == 1)
                        Array.set(res,dims[i],newValue);
                    else
                        res = Array.get(res,dims[i]);
                }
            }
            return;
        }
        
        NativeManagerImpl.checkUnFetchMode(unFetchMode);    
        FetchUnFetchContext unFetchCtx = NativeManagerImpl.newUnFetchContextIfNeeded(unFetchMode);
        
        int index = dims[dimStart];
            
        if ((dims.length - dimStart) == 1)   
            jnieasySetObject(index,newValue, unFetchMode,unFetchCtx,null,stateMgr);
        else
        {
            NativeArray elem = jnieasyGetNativeArrayElem(index,stateMgr);

            // elem no puede ser nulo
            dimStart++;
            elem.setElement(dims,dimStart,newValue,unFetchMode);       
        }
    }    
    
    public NativeArray jnieasyGetNativeArrayElem(int index,NativeObjectArrayStateManagerImpl stateMgr)
    {
        int fetchMode = NativeManagerImpl.getDefaultFetchMode(this);
        FetchUnFetchContext fetchCtx = NativeManagerImpl.newFetchContextIfNeeded(fetchMode);        
        
        VarTypeNativeObjectRuntimeImpl varTypeDecComp = (VarTypeNativeObjectRuntimeImpl)jnieasyGetComponentVarType();

        long compSize = stateMgr.getComponentSize();

        long offset = compSize * index;
        Object[] valueArray = jnieasyCastObjectArray(); 
        NativeArray elem;
        if (valueArray != null)
        {           
            Object item = valueArray[index];            
            elem = (NativeArray)varTypeDecComp.getNativeCapable(index,offset,stateMgr,item,fetchMode,fetchCtx);         
        }
        else
        {
            // De esta manera podemos obtener valores de matrices de dimensión desconocida (cuando es proxy)          
            elem = (NativeArray)varTypeDecComp.getNativeCapable(index,offset,stateMgr,null,fetchMode,fetchCtx);
        }    

        return elem;
    }
    
    public synchronized int length()
    {              
        Object[] valueArray = jnieasyCastObjectArray();          
        return valueArray.length;
    }        
}
