/*
 * VarTypeNativeCapableRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public abstract class VarTypeNativeCapableRuntimeImpl extends VarTypeNativeObjectRuntimeImpl
{
    /**
     * Creates a new instance of VarTypeNativeCapableRuntimeImpl
     */
    public VarTypeNativeCapableRuntimeImpl(VarTypeNativeCapableImpl varTypeDec,TypeNativeCapableRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }
    
    public TypeNativeCapableRuntimeImpl getTypeNativeCapableRuntime()
    {
        return (TypeNativeCapableRuntimeImpl)typeRt;
    }
    
    public NativeCapableInternal getNativeCapableFromNativePointer(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr, NativeCapableInternal currValue,boolean isAuxiliar,int fetchMode,FetchUnFetchContext fetchCtx,boolean[] fetched)
    {
        long addr = stateMgr.getAddress(fieldIndex,offset);
        if (addr == 0) return null;

        NativeCapableInternal newValue;        
        if (currValue != null) 
        {
            synchronized(currValue)
            {
                NativeStateManagerImpl currValueStateMgr = (NativeStateManagerImpl)currValue.jnieasyGetNativeStateManager();
                if (currValueStateMgr != null)
                {
                    if (currValueStateMgr.getBuffer().getValue() == addr)
                    {
                        newValue = currValue; // No ha cambiado 
                    }
                    else // Ha cambiado
                    {  
                        TypeNativeCapableRuntimeImpl typeDecRt = getTypeNativeCapableRuntime();
                        newValue = typeDecRt.getNativeCapable(new NativeAddressImpl(addr),0,isAuxiliar);               
                    }
                }
                else
                {
                    /* El caso de currValueStateMgr == null ocurre en el proceso de attachment de los fields, los fields NativeCapable no son nativos todavía

                       No devolvemos currValue directamente pues la dirección de memoria puede estar asociada a un objeto diferente al que representa el actual currValue
                       es posible que se obtenga un nuevo objeto (de diferente tipo)
                     **/
                    NativeAddressImpl addrObj = new NativeAddressImpl(addr);
                    TypeNativeCapableRuntimeImpl typeDecRt = getTypeNativeCapableRuntime();                
                    newValue = typeDecRt.findNativeCapable(addrObj);
                    if (newValue == null) // La dirección no está ocupada
                    {
                        newValue = currValue;                    
                        getNativeManager().attach(newValue,isAuxiliar, addrObj,0);
                    }
                }
            }
        }
        else 
        {
            TypeNativeCapableRuntimeImpl typeDecRt = getTypeNativeCapableRuntime();
            newValue = typeDecRt.getNativeCapable(new NativeAddressImpl(addr),0,isAuxiliar);
        }
    
        // Llegado aquí newValue no puede ser nulo
        if (fetchMode == Fetch.DEEP)
        {
            getNativeManager().fetch(newValue,fetchMode,fetchCtx);
            if (fetched != null) fetched[0] = true;
        }
        
        return newValue;
    }   
    
    public void setNativePointerFromNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,NativeCapableInternal newValue,boolean isAuxiliar,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx,boolean[] unfetched)
    {
        if (newValue != null)
        {
            if (attachCopyCtx != null) 
            {
                // Resuelve el problema del attachCopy() cuando hay referencias de objetos detached que apuntan al detached que original se copia y que deberán apuntar tras la copia al nativo destino
                if (newValue == attachCopyCtx.fromObject())
                {
                    newValue = attachCopyCtx.toObject();
                }
            }
            
            synchronized(newValue)
            {            
                if (!getNativeManager().makeNative(newValue,isAuxiliar,unFetchMode,unfetchCtx,attachCopyCtx))  // si ya es nativo no hace nada
                {
                    // El makeNative hace por si mismo un deep unFetch, por lo que si ya era nativo
                    // lo tenemos que hacer explícitamente
                    if (unFetchMode == UnFetch.DEEP) 
                    {
                        getNativeManager().unFetch(newValue, unFetchMode, unfetchCtx,attachCopyCtx);
                        if (unfetched != null) unfetched[0] = true;                    
                    }
                }
                else if (unfetched != null) unfetched[0] = true;

                NativeStateManagerImpl newValueStateMgr = (NativeStateManagerImpl)newValue.jnieasyGetNativeStateManager();
                long addr = newValueStateMgr.getBuffer().getValue();
                stateMgr.setAddress(fieldIndex,offset,addr);                
            }
        }
        else stateMgr.setAddress(fieldIndex,offset,0);
            
    }    
    
    public void makeNativeAndAttachNativeCapableEmbedded(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr, NativeCapableInternal newValue,boolean isAuxiliar,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx,boolean[] unfetched)
    {
        // newValue no puede ser nulo, es detectado antes
        synchronized (newValue)
        {
            NativeBuffer buffToAttach = stateMgr.getBuffer();        
            if (!getNativeManager().makeNativeAttach(newValue,isAuxiliar,buffToAttach,offset,typeRt,unFetchMode,unfetchCtx,attachCopyCtx)) // Si ya está attached no hace nada
            {
                // El makeNativeAttach hace por si mismo un deepUnFetch, por lo que si ya era nativo
                // lo tenemos que hacer explícitamente
                if (unFetchMode >= UnFetch.EMBEDDED)
                {
                    getNativeManager().unFetch(newValue, unFetchMode, unfetchCtx,attachCopyCtx);                
                    if (unfetched != null) unfetched[0] = true;                    
                }
            }
            else if (unfetched != null) unfetched[0] = true;  
        }
    }      
    
    public NativeCapableInternal attachNativeCapableEmbedded(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr, NativeCapableInternal currValue,boolean isAuxiliar,int fetchMode,FetchUnFetchContext fetchCtx,boolean[] fetched)
    {
        // El que currValue sea nulo puede deberse a un "get" de un atributo por valor derivado de Object que no ha sido definido nunca (y es null)
        // o bien a un array wrapper por valor embebido en una estructura por ejemplo
        // tal que dicho array wrapper es de longitud indefinda, se creará un
        // objecto auxiliar al efecto aunque luego se pierda.
       
        NativeBufferImpl buffToAttach = (NativeBufferImpl)stateMgr.getBuffer();  

        if (currValue == null)
        {
            TypeNativeCapableRuntimeImpl typeDecRt = getTypeNativeCapableRuntime();
            currValue = typeDecRt.getNativeCapable(buffToAttach,offset,isAuxiliar);        
        }        
        
        synchronized (currValue)
        {
            getNativeManager().attach(currValue,isAuxiliar,buffToAttach,offset,typeRt); // Si ya está attached no hace nada
            if (fetchMode >= Fetch.EMBEDDED)
            {            
                getNativeManager().fetch(currValue,fetchMode,fetchCtx);
                if (fetched != null) fetched[0] = true;            
            }
        }
        
        return currValue;
    }       
    
    public NativeCapableInternal getNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,NativeCapableInternal currValue,int fetchMode,FetchUnFetchContext fetchCtx,boolean[] fetched)
    {
        int varConv = getVarConv();
        if (varConv == VarTypeNative.BY_PTR)
        {
            return getNativeCapableFromNativePointer(fieldIndex,offset,stateMgr,currValue,false,fetchMode,fetchCtx,fetched);
        }
        else  // Caso embebido (BY_VALUE), por ej. atributos de tipo estructura, clase o arrays (custom o no)
        {
            return attachNativeCapableEmbedded(fieldIndex,offset, stateMgr, currValue,false,fetchMode,fetchCtx,fetched);
        }
    }                
   
    public void setNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,NativeCapableInternal newValue,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx,boolean[] unfetched)
    {
        int pasConv = getVarConv();
        if (pasConv == VarTypeNative.BY_PTR)
        {
            setNativePointerFromNativeCapable(fieldIndex,offset,stateMgr,newValue,false,unFetchMode,unfetchCtx,attachCopyCtx,unfetched);
        }
        else // Caso embebido
        {
            makeNativeAndAttachNativeCapableEmbedded(fieldIndex,offset,stateMgr,newValue,false,unFetchMode,unfetchCtx,attachCopyCtx,unfetched);
        }
    }    
    
    public Object push(Object value, NativeBufferIteratorImpl memIt)
    {
        if (value != null) getNativeManager().makeNative(value); // Si ya es native no hace nada

        if (getVarConv() == VarTypeNative.BY_PTR)
        {
            long address = 0;
            if (value != null)
            {
                synchronized(value)
                {
                    address = ((NativeCapableInternal)value).jnieasyGetNativeStateManager().getBuffer().getValue();
                }
            }
            memIt.setAddress(address);
        }
        else
        {
            // value no puede ser nulo
            synchronized(value)
            {            
                NativeStateManager stateMgr = ((NativeCapableInternal)value).jnieasyGetNativeStateManager();
                NativeBuffer bufferValue = stateMgr.getBuffer();
                memIt.setBuffer(bufferValue); // Copia el contenido de uno en el otro
                // El iterador ha avanzado el tamaño del buffer pasado, pero 
                // como estamos en el stack tenemos que avanzar más por el redondeo
                // del alineamiento al address.
                long paramSize = bufferValue.size();
                memIt.forward( TypeNativeRuntimeImpl.roundToStackSizeByValue(paramSize) - paramSize );
            }
        }
        return value;
    }

    public Object pop(NativeBufferIteratorImpl memIt)
    {
        TypeNativeCapableRuntimeImpl typeDecRt = getTypeNativeCapableRuntime();
        
        if (getVarConv() == VarTypeNative.BY_PTR)
        {
            long addr = memIt.nextAddress();
            return typeDecRt.getObject(addr);
        }
        else
        {
            return typeDecRt.getObject((NativeBufferImpl)memIt.getBuffer(),memIt.currentOffset()); 
        }
    }
    
    public Object pushVarArgs(Object value,NativeBufferIteratorImpl memIt)
    {
        throw new JNIEasyException("Varargs not supported with native array wrappers");
    }
    
    public void unwrapVarArgs(Object arg,Object argUsed)  
    {
        throw new JNIEasyException("Varargs not supported with native array wrappers");       
    }    
    
    public Object getObject2(int fieldIndex,long offset, NativeFieldContainerStateManagerImpl stateMgr, Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {
        return getNativeCapable(fieldIndex,offset,stateMgr,(NativeCapableInternal)currValue,fetchMode,fetchCtx,null);
    }
    
    public void setObject2(int fieldIndex,long offset, NativeFieldContainerStateManagerImpl stateMgr, Object newValue,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        setNativeCapable(fieldIndex,offset,stateMgr,(NativeCapableInternal)newValue,unFetchMode,unfetchCtx,attachCopyCtx,null);
    }

    public Object clone2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,CloneContext cloneCtx)
    {
        return clone((NativeCapableInternal)currValue, cloneCtx);
    }    
    
    public void detachField2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object fieldValue,int freeMemMode,boolean deep)
    {
        // No es necesario el auxiliar
        detachField((NativeCapableInternal)fieldValue,freeMemMode,deep);
    }        
    
    public NativeCapableInternal clone(NativeCapableInternal currValue,CloneContext cloneCtx)
    {
        if (currValue == null) return null;
        
        return getNativeManager().clone(currValue, cloneCtx);
    }        
    
    public void detachField(NativeCapableInternal fieldValue,int freeMemMode,boolean deep)
    {
        if (fieldValue == null) return;
        
        boolean detach = (getVarConv() == VarTypeNative.BY_VALUE) || deep;
        // En el caso por referencia sólo se hace el detach si deep es true
        if (detach) getNativeManager().detach(fieldValue, freeMemMode, deep);
    }
    
    public NativeCapableInternal getNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {        
        return getNativeCapable(fieldIndex,offset,stateMgr,(NativeCapableInternal)currValue,fetchMode,fetchCtx,null);
    }    
    
    public Object unwrap(Object argUsed)
    {
        return argUsed;
    }    
}

