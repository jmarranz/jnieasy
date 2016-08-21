/*
 * VarTypeNativeObjectDefaultRuntimeImpl.java
 *
 * Created on 7 de marzo de 2005, 11:26
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextNotUsingImports;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;

/* Sólo es válido el caso de paso por referencia tanto en métodos
 *como en atributos, se indica en TypeDecNativeObjectDefaultImpl
 */

public class VarTypeNativeObjectDefaultRuntimeImpl extends VarTypeNativeObjectRuntimeImpl
{
    public VarTypeNativeCapableDefaultRuntimeImpl varTypeDefault;
    
    /**
     * Creates a new instance of VarTypeNativeObjectDefaultRuntimeImpl
     */ 
    public VarTypeNativeObjectDefaultRuntimeImpl(VarTypeNativeObjectDefaultImpl varTypeDec,TypeNativeObjectDefaultRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        super(varTypeDec,typeDecRt);

        this.varTypeDefault = (VarTypeNativeCapableDefaultRuntimeImpl)VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(ClassTypeNativeCapableDefaultImpl.INTERFACE,varTypeDec.getVarTypeNativeCapableDefault(),ctx);
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        // No tenemos más opción que considerar el caso de objeto NativeCapableInternal (por referencia claro)
        // pues no tenemos ni idea de lo que nos envían desde la parte nativa
        // Usamos NativeCapableDefault porque así empleamos su objeto proxy
        // que vale para cualquier tipo para el caso en el que no haya un objeto (NativeCapableInternal derivado)
        // asociado a la dirección
        return varTypeDefault.pop(memIt);
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        //int varConv = getVarConv();
        if (value != null)
        {
            VarTypeNativeRuntimeImpl varType = getDefaultAssociatedType(value,true);
            return varType.push(value,memIt);
        }
        else 
        {
            return varTypeDefault.push(null,memIt);
        }
    }
    
    public Object pushVarArgs(Object value,NativeBufferIteratorImpl memIt)
    {
        // Nunca debería llegarse aquí pero por si acaso
        throw new JNIEasyException("An Object type parameter cannot be a vararg");        
    }         
        
    public void unwrapVarArgs(Object arg,Object argUsed)  
    {
        // Nunca debería llegarse aquí pero por si acaso
        throw new JNIEasyException("An Object type parameter cannot be a vararg");        
    }    
    
    public Object unwrap(Object argUsed)
    {
        // de esta manera obtenemos el objeto original unwrapped posiblemente cambiado a partir de la memoria nativa
        // pues la memoria nativa del wrapper durante la llamada puede haber sido modificada
        return ((CanBeNativeCapableInternal)argUsed).getValue();
    }    
   
    
    public Object getObject2(int fieldIndex,long offset, NativeFieldContainerStateManagerImpl stateMgr, Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {
        // Quien manda es la dirección de memoria y el posible objeto asociado a la misma independientemente 
        // del tipo que sea currValue.
        // Usamos el NativeCapableDefault pues nos devolverá el NativeCapable asociado a la dirección
        // o bien el Proxy si no hay ninguno asociado
        // A través del NativeCapableInternal devuelto podemos intentar obtener el objeto wrapped si es el caso
        
        boolean[] fetched = new boolean[1];
        NativeCapableInternal nativeObjRes = varTypeDefault.getNativeCapable(fieldIndex,offset, stateMgr, null,fetchMode,fetchCtx,fetched);        
        if (nativeObjRes == null)
            return null;
       
        if (currValue == null)
            return nativeObjRes; 

        if (!(currValue instanceof NativeCapable))
        {
            int auxIndex = stateMgr.getAbsAuxNativeObjectIndex(fieldIndex);
            CanBeNativeCapableInternal auxNativeObj = stateMgr.getAuxObject(auxIndex);
            if (auxNativeObj == nativeObjRes)
            {
                // auxNativeObj es no nulo, significa que currValue es un objeto no nativo fruto de una previa asignación
                // y que no ha cambiado la memoria pues se obtiene el mismo NativeCapableInternal
                if (fetched[0])
                    return auxNativeObj.jnieasyGetInternalValue();
                else
                {
                    synchronized (auxNativeObj)
                    {
                        NativeStateManager stateMgrAux = auxNativeObj.jnieasyGetNativeStateManager();
                        return auxNativeObj.jnieasyGetValue(fetchMode,fetchCtx,stateMgrAux);
                    }
                }
            }
        }
        
        // No hay manera de detectar un posible objeto no addressed, pues aunque sea un wrapper nada impide que devolvamos el propio objeto pues también puede ser atributo
        // Llegado a este punto no tenemos más remedio que devolver
        // el nativeObjRes, aunque hubiera habido una previa asignación de un objeto no addressed (y por tanto se esperara devolver un objeto no addressed)
        // pero como la memoria ha cambiado (indirectamente pero eso es válido) puede ser cualquier cosa
        // el tipo de objeto que se devuelve o es cualquier tipo NativeCapableInternal vinculado
        // a esa dirección de memoria o bien el proxy default 
        
        return nativeObjRes;
    }    

    public void setObject2(int fieldIndex,long offset, NativeFieldContainerStateManagerImpl stateMgr, Object newValue,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        if (newValue != null)
        {
            int auxIndex = stateMgr.getAbsAuxNativeObjectIndex(fieldIndex);
            stateMgr.setAuxObject(auxIndex,null); // Pues lo que hubiera antes puede ser de diferente tipo, de esta manera se crea de nuevo del tipo adecuado (o no se crea si newValue es NativeCapableInternal derivado)
            VarTypeNativeObjectRuntimeImpl typeDec = (VarTypeNativeObjectRuntimeImpl)getDefaultAssociatedType(newValue,false);
            typeDec.setObject(fieldIndex,offset,stateMgr,newValue,unFetchMode,unfetchCtx,attachCopyCtx);
        }
        else
        {
            varTypeDefault.setObject(fieldIndex,offset, stateMgr, null, unFetchMode, unfetchCtx, attachCopyCtx);
        }   
    }
    
    public RuntimeContextNotUsingImports getDefaultRuntimeContext()
    {
        return typeRt.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
    }
    
    public VarTypeNativeRuntimeImpl getDefaultAssociatedType(Object value,boolean primitiveByValue)
    {
        RuntimeContext ctx = getDefaultRuntimeContext();
        VarTypeNativeRuntimeImpl varType = getDefaultAssociatedType(value,primitiveByValue,ctx);
//        int varConv = getVarConv(); // es siempre por referencia
//        varType.setVarConv(varConv); 
        return varType;
    }
    
    public Object clone2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,CloneContext cloneCtx)
    {
        if (currValue == null)
            return null; 

        VarTypeNativeObjectRuntimeImpl varTypeDec = (VarTypeNativeObjectRuntimeImpl)getDefaultAssociatedType(currValue,false);
        return varTypeDec.clone(fieldIndex,stateMgr,currValue,cloneCtx);
    }
    
    public void detachField2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object fieldValue,int freeMemMode,boolean deep)
    {
        if (fieldValue == null)
            return; 
                
        VarTypeNativeObjectRuntimeImpl varTypeDec = (VarTypeNativeObjectRuntimeImpl)getDefaultAssociatedType(fieldValue,false);
        varTypeDec.detachField(fieldIndex,stateMgr,fieldValue,freeMemMode,deep);                   
    }   
        
    public NativeCapableInternal getNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {        
        return varTypeDefault.getNativeCapable(fieldIndex,offset, stateMgr,(NativeCapableInternal)currValue,fetchMode,fetchCtx,null);  
    }     
}
