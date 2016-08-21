/*
 * AddressedArrayImpl.java
 *
 * Created on 15 de octubre de 2004, 12:35
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;


public abstract class NativeArrayImpl extends CanBeNativeCapableImpl implements NativeArray
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of AddressedArrayImpl */
    public NativeArrayImpl()
    {
    }
    
    public TypeNativeArrayWrapperRuntimeImpl jnieasyGetTypeNativeArray()
    {
        return (TypeNativeArrayWrapperRuntimeImpl)jnieasyGetType();
    }
    
    public long jnieasyCalcSize(Object newValue)
    {
        // Es llamada cada vez que se asigna un nuevo value 
        // y puede cambiar el tamaño en memoria

        TypeNativeArrayWrapperRuntimeImpl typeDec = jnieasyGetTypeNativeArray();
        TypeNativeArrayRuntimeImpl typeDecWrapped = typeDec.getTypeNativeArrayRuntime();        
        return typeDecWrapped.getSize(newValue);     
    }
  
    public VarTypeNativeRuntimeImpl jnieasyGetComponentVarType()
    {
	TypeNativeArrayWrapperRuntimeImpl typeDec = jnieasyGetTypeNativeArray();
        return typeDec.getTypeNativeArrayInfoRuntime().getComponentVarType();
    }

    public TypeNativeRuntimeImpl jnieasyGetTypeNativeRuntimeComponent()
    {
        TypeNativeArrayWrapperRuntimeImpl typeDec = (TypeNativeArrayWrapperRuntimeImpl)jnieasyGetType();
        return typeDec.getComponentDecRuntime().getTypeNativeRuntime();
    }    
    
    public synchronized Object getElement(int[] dims)
    {
        int defaultFetch = NativeManagerImpl.getDefaultFetchMode(this);        
        return getElement(dims,0,defaultFetch);
    }
        
    public synchronized void setElement(int[] dims,Object value)
    {
        int defaultUnFetch = NativeManagerImpl.getDefaultUnFetchMode(this);        
        setElement(dims,0,value,defaultUnFetch);
    }    

   
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        Object valueArray = jnieasyGetInternalValue();
        if (valueArray != null)
        {
            Object valueArrayCloned = jnieasyCloneValue(valueArray,cloneCtx,stateMgr);
            jnieasySetInternalValue(valueArrayCloned);            
        } 
    }        
}
