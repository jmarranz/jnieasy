/*
 * VarTypeCanBeNativeCapableRuntimeImpl.java
 *
 * Created on 6 de enero de 2005, 15:58
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.FieldAccessExceptionUtil;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.NativeTransactionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

public abstract class VarTypeCanBeNativeCapableRuntimeImpl extends VarTypeNativeObjectRuntimeImpl
{
    protected VarTypeCanBeNativeCapableWrapperRuntimeImpl wrapperVarType;
    
    /**
     * Creates a new instance of VarTypeCanBeNativeCapableRuntimeImpl
     */
    public VarTypeCanBeNativeCapableRuntimeImpl(VarTypeCanBeNativeCapableImpl varTypeDec,TypeCanBeNativeCapableRuntimeImpl typeDecRt,
                VarTypeCanBeNativeCapableWrapperRuntimeImpl wrapperVarType)
    {
        super(varTypeDec,typeDecRt);
        
        if (wrapperVarType != null)
        {
            this.wrapperVarType = wrapperVarType;
            this.wrapperVarType.setWrappedVarType(this);
        }
    }

    public TypeCanBeNativeCapableRuntimeImpl getTypeCanBeNativeCapableRuntime()
    {
        return (TypeCanBeNativeCapableRuntimeImpl)typeRt;
    }
    
    public VarTypeCanBeNativeCapableWrapperRuntimeImpl getWrapperVarType()
    {
        return wrapperVarType;
    }
    
    public void setWrapperVarType(VarTypeCanBeNativeCapableWrapperRuntimeImpl wrapperVarType)
    {
        this.wrapperVarType = wrapperVarType;
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
        // El paso de un array o una cadena (const char* o char* ) como par�metro y retorno de funci�n
        // en C/C++ es siempre a trav�s
        // de un puntero (no por valor)
        // Lo envolvemos por eso en un Wrapper y lo devolvemos para que se pueda sujetar y no se lo lleve el GC
        
        VarTypeCanBeNativeCapableWrapperRuntimeImpl wrapperVarType = getWrapperVarType();
        CanBeNativeCapableInternal wrapValue = null;
        if (value != null)
        {
            TypeCanBeNativeCapableWrapperRuntimeImpl typeDecRt = wrapperVarType.getTypeCanBeNativeCapableWrapperRuntime();            
            wrapValue = (CanBeNativeCapableInternal)typeDecRt.wrapAndMakeNative(value);
        }
        wrapperVarType.push(wrapValue,memIt);
        return wrapValue;
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        VarTypeCanBeNativeCapableWrapperRuntimeImpl wrapperVarType = getWrapperVarType();
        CanBeNativeCapableInternal wrapValue = (CanBeNativeCapableInternal)wrapperVarType.pop(memIt);
        if (wrapValue == null) return null;
        // Lo desenvolvemos (unwrap)
        return wrapValue.getValue();
    }
 
    public Object pushVarArgs(Object value,NativeBufferIteratorImpl memIt)
    {
        // value es un array Java 
        TypeNativeArrayRuntimeImpl typeDecRt = (TypeNativeArrayRuntimeImpl)getTypeCanBeNativeCapableRuntime();
        return typeDecRt.pushVarArgs(value,memIt);
    }
    
    public Object unwrap(Object argUsed)
    {
        // de esta manera obtenemos el objeto original unwrapped posiblemente cambiado a partir de la memoria nativa
        // pues la memoria nativa del wrapper durante la llamada puede haber sido modificada
        return ((CanBeNativeCapableInternal)argUsed).getValue();
    }    
    
    public void unwrapVarArgs(Object arg,Object argUsed)  
    {
        // arg es un array Java 
        TypeNativeArrayRuntimeImpl typeDecRt = (TypeNativeArrayRuntimeImpl)getTypeCanBeNativeCapableRuntime();
        typeDecRt.unwrapVarArgs(arg,argUsed);        
    }
    
    public CanBeNativeCapableInternal setNativePointerFromCanBeNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object newValue,CanBeNativeCapableInternal auxObj,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx,boolean[] unfetched)
    {
        if (newValue != null)
        {
            if (auxObj == null)
            {
                TypeCanBeNativeCapableRuntimeImpl typeDecRt = getTypeCanBeNativeCapableRuntime();
                auxObj = (CanBeNativeCapableInternal)typeDecRt.wrapValue(newValue);
            }
            else
            {
                if (newValue != auxObj.jnieasyGetInternalValue())
                {
                    // Creamos un nuevo auxiliar, no podemos reutilizarlo porque
                    // por ejemplo si es un array ya nativo el array almacenado impuso el tama�o
                    // y sin embargo el nuevo valor puede tener una longitud diferente
                    // el nuevo valor indica un nuevo objeto nativo al que apuntar
                    TypeCanBeNativeCapableRuntimeImpl typeDecRt = getTypeCanBeNativeCapableRuntime();
                    auxObj = (CanBeNativeCapableInternal)typeDecRt.wrapValue(newValue); 
                }
            }
        }
        else auxObj = null;
        
        // Si auxObj no es todav�a nativo se har� en el m�todo setNativePointerFromNativeCapable()
        getWrapperVarType().setNativePointerFromNativeCapable(fieldIndex,offset,stateMgr,auxObj,true,unFetchMode,unfetchCtx,attachCopyCtx,unfetched);

        return auxObj;
    }
    
    public CanBeNativeCapableInternal setNativeEmbeddedFromCanBeNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object newValue,CanBeNativeCapableInternal auxObj,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx,boolean[] unfetched)
    {
        // No se admite newValue nulo pues es embebido, de todas formas seguramente es detectado antes
        if (newValue == null) throw new JNIEasyException("An embedded object can not be null");    
    
        if (auxObj == null) // es la primera vez que se usa este field
        {
            TypeCanBeNativeCapableRuntimeImpl typeDecRt = getTypeCanBeNativeCapableRuntime();
            auxObj = (CanBeNativeCapableInternal)typeDecRt.wrapValue(newValue);
        }
        else
        {
            if (newValue != auxObj.jnieasyGetInternalValue())
            {
                // Reutilizamos el auxiliar porque dicho auxiliar mapea una zona fija
                // de la memoria por lo que en el caso de array dicho array no puede
                // ser de una longitud diferente a la esperada (se detecta antes)
                // No preocuparse por el unfetch se hace m�s adelante
                auxObj.jnieasySetInternalValue(newValue);
            }
        }      
                
        // El auxObj aqu� no ser� nulo.

        getWrapperVarType().makeNativeAndAttachNativeCapableEmbedded(fieldIndex,offset,stateMgr,auxObj,true,unFetchMode,unfetchCtx,attachCopyCtx,unfetched); // Hace nativo y el attachment si es necesario            
        
        return auxObj;
    }        
    
    public CanBeNativeCapableInternal getCanBeNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx,boolean[] fetched)
    {    
        int auxIndex = stateMgr.getAbsAuxNativeObjectIndex(fieldIndex);
        CanBeNativeCapableInternal auxObj = stateMgr.getAuxObject(auxIndex);
        
        int varConv = getVarConv();
        if (varConv == VarTypeNative.BY_PTR)
        {        
            // Aqu� currValue no pinta nada, la memoria es la que manda
            auxObj = (CanBeNativeCapableInternal)getWrapperVarType().getNativeCapableFromNativePointer(fieldIndex,offset,stateMgr,auxObj,true,fetchMode,fetchCtx,fetched);           
        }
        else
        {
            // Seguramente el caso currValue null es detectado antes.
            if (currValue == null) throw new JNIEasyException(FieldAccessExceptionUtil.createMessage("Undefined embedded object, set before access",fieldIndex,null,stateMgr.getNativeCapable()));
            if (auxObj == null) 
            {              
                // Esto puede ocurrir cuando el field fue definido antes de hacer nativo (con attach) el objeto por lo que no se cre�
                // el objeto auxiliar
                TypeCanBeNativeCapableRuntimeImpl typeDecRt = getTypeCanBeNativeCapableRuntime();            
                auxObj = (CanBeNativeCapableInternal)typeDecRt.wrapValue(currValue);
                // El attachment se hace m�s adelante              
            }
            auxObj = (CanBeNativeCapableInternal)getWrapperVarType().attachNativeCapableEmbedded(fieldIndex,offset, stateMgr, auxObj,true,fetchMode,fetchCtx,fetched);            
        }
        
        stateMgr.setAuxObject(auxIndex,auxObj); 
        
        return auxObj;                
    }
    
    public CanBeNativeCapableInternal setCanBeNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr, Object newValue,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx,boolean[] unfetched)
    {
        int auxIndex = stateMgr.getAbsAuxNativeObjectIndex(fieldIndex);        
        CanBeNativeCapableInternal auxObj = stateMgr.getAuxObject(auxIndex);      
        
        int varConv = getVarConv();
        if (varConv == VarTypeNative.BY_PTR)
        {        
            auxObj = setNativePointerFromCanBeNativeCapable(fieldIndex,offset,stateMgr,newValue,auxObj,unFetchMode,unfetchCtx,attachCopyCtx,unfetched);
        }
        else
        {
            auxObj = setNativeEmbeddedFromCanBeNativeCapable(fieldIndex,offset,stateMgr,newValue,auxObj,unFetchMode,unfetchCtx,attachCopyCtx,unfetched);
        }
        
        stateMgr.setAuxObject(auxIndex,auxObj);
        
        return auxObj;
    }        
    
    public Object getCanBeNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {
        boolean[] fetched = new boolean[1];
        CanBeNativeCapableInternal auxObj = (CanBeNativeCapableInternal)getCanBeNativeCapable(fieldIndex, offset, stateMgr, currValue, fetchMode, fetchCtx, fetched);
        
        if (auxObj == null) return null;
                
        // Necesitamos sacar el valor interno, debe hacerse con fetch pero las operaciones anteriores pueden haberlo hecho ya
        // El fetchMode aqu� es al menos FAST
        if (fetched[0])
        {
            // Ya se ha hecho fetch, repetirlo es una tonter�a
            return auxObj.jnieasyGetInternalValue();
        }
        else
        {
            synchronized (auxObj)
            {            
                NativeStateManager stateMgrAux = auxObj.jnieasyGetNativeStateManager();
                return auxObj.jnieasyGetValue(fetchMode,fetchCtx,stateMgrAux); 
            }
        }
    }
    
    public void setCanBeNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object newValue,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        boolean[] unfetched = new boolean[1]; 
        CanBeNativeCapableInternal auxObj = setCanBeNativeCapable(fieldIndex,offset,stateMgr,newValue,unFetchMode,unfetchCtx,attachCopyCtx,unfetched);

        if (auxObj == null) return;        
        
        // si se hizo ya unfetch repetirlo es una tonter�a
        // el unFetchMode es al menos FAST
        if (!unfetched[0]) 
        {
            synchronized (auxObj)
            {            
                NativeStateManager stateMgrAux = auxObj.jnieasyGetNativeStateManager();
                auxObj.jnieasySetValue(newValue,unFetchMode,unfetchCtx,attachCopyCtx,stateMgrAux); // actualiza la memoria nativa
            }
        }
    }
    
    public Object getObject2(int fieldIndex,long offset, NativeFieldContainerStateManagerImpl stateMgr, Object currValue, int fetchMode,FetchUnFetchContext fetchCtx)
    {
        return getCanBeNativeCapable(fieldIndex,offset,stateMgr,currValue,fetchMode,fetchCtx);
    }
    
    public void setObject2(int fieldIndex,long offset, NativeFieldContainerStateManagerImpl stateMgr, Object newValue, int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        setCanBeNativeCapable(fieldIndex,offset,stateMgr,newValue, unFetchMode,unfetchCtx,attachCopyCtx);
    }

    public Object clone2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,CloneContext cloneCtx)
    {
        // El motivo de hacer esto es que el objeto puede ser un array Java de NativeCapable por ejemplo y por tanto
        // necesitamos clonar el contenido del array
        // De todas formas as� est� preparado por si hay que clonar aquellos objetos Java no s�lo lectura que pudieran ser conveniente clonar tal y como el StringBuffer
        int auxIndex = stateMgr.getAbsAuxNativeObjectIndex(fieldIndex);        
        CanBeNativeCapableInternal wrapValue = stateMgr.getAuxObject(auxIndex);
        if (wrapValue == null) return null;

        // Una optimizaci�n para el futuro es que no hace falta clonar el CanBeNativeCapableInternal s�lo el objeto contenido que es que se devuelve
        // por otra parte la cach� permite no clonar cuando ya fue clonado, �til cuando hay varias referencias al mismo objeto
        wrapValue = (CanBeNativeCapableInternal)getWrapperVarType().clone(wrapValue, cloneCtx);
        
        return wrapValue.jnieasyGetInternalValue();
    }
    
    public void detachField2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object fieldValue,int freeMemMode,boolean deep)
    {
        int auxIndex = stateMgr.getAbsAuxNativeObjectIndex(fieldIndex);           
        CanBeNativeCapableInternal auxObj = stateMgr.getAuxObject(auxIndex);
        if (auxObj == null) return;

        // Hay que tener en cuenta que detachField() es llamado en el contexto del detach 
        // del objeto contenedor, esto supone que el array de auxiliares se perder� 
        // y por tanto se perder� el CanBeNativeCapableInternal auxiliar, 
        // en el caso por referencia dicho objeto es propietario de la memoria, 
        // tenemos por tanto que sea freeMemMode true o no, sea deep true o no los objetos auxiliares
        // ser�n destruidos. 
        // Existe el caso de que fieldValue sea un array Java de NativeCapables por valor 
        // si no destruimos ahora el CanBeNativeCapableInternal los objetos albergados estar�n attached 
        // a una direcci�n que "morir�" pero que no ocurre hasta que act�e el GC,
        // el problema es que no podr�n ser utilizados en la recreaci�n
        // del objeto en el �mbito de una transacci�n por ejemplo.
        // No nos vale el comportamiento si fuera el CanBeNativeCapableInternal directamente un field
        // del objeto contenedor por referencia, pues dicho objeto podr�a estar referenciado por otros objetos
        // Conclusi�n: nos cargamos el auxiliar ya, aqu� y ahora.
        synchronized (auxObj)
        {
            NativeStateManagerImpl auxObjStateMgr = (NativeStateManagerImpl)auxObj.jnieasyGetNativeStateManager();
            NativeManagerImpl nativeMgr = getNativeManager();       
            nativeMgr.detach(auxObj,NativeManager.FREE_MEMORY,deep);
            // Lo siguiente es necesario porque en transacciones se recuerda el objeto detached 
            // y es posible que pueda "recrearse" y modificar el objeto albergado (delicado en el caso de array por valor de NativeCapable,pues hay un "reattach" a un contenedor que muere despu�s), as� queda "olvidado" del todo
            NativeTransactionImpl txn = (NativeTransactionImpl)nativeMgr.findCurrentWorkingTransaction();
            if (txn != null)
                txn.unenroll(auxObjStateMgr);               
            //auxObj.jnieasySetInternalValue(null); // No es necesario pero por si acaso (desconexi�n total)
        }
        
        stateMgr.setAuxObject(auxIndex,null);  
    }   

    public NativeCapableInternal getNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {        
        return getCanBeNativeCapable(fieldIndex,offset,stateMgr,currValue,fetchMode,fetchCtx,null);
    }
}
