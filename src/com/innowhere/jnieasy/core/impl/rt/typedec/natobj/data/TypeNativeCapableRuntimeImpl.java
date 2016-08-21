/*
 * TypeNativeCapableRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.JavaAllocatedObjectRegistry;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCapableRuntime;

public abstract class TypeNativeCapableRuntimeImpl extends TypeNativeObjectRuntimeImpl implements TypeNativeCapableRuntime
{
    /**
     * Creates a new instance of TypeNativeCapableRuntimeImpl
     */
    public TypeNativeCapableRuntimeImpl(TypeNativeCapableImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public static TypeNativeCapableRuntimeImpl newTypeNativeCapableRuntime(NativeCapableInternal value,RuntimeContext ctx)
    {
        return (TypeNativeCapableRuntimeImpl)value.jnieasyGetType();
    }
    
    public JavaAllocatedObjectRegistry getJavaAllocatedObjectRegistry()
    {
        return getNativeManager().getJavaAllocatedObjectRegistry();
    }
  
    public NativeCapableInternal newProxyValue(NativeAddressImpl addr, long offset,boolean isAuxiliar)
    {
        NativeCapableInternal value = (NativeCapableInternal)newValue();
        getNativeManager().attach(value,isAuxiliar,addr,offset,this); 
        return value;
    }

    public NativeCapableInternal findNativeCapable(NativeAddressImpl addr, long offset)
    {    
        if (offset == 0)
            return findNativeCapable(addr);
        else
            return findNativeCapable(new NativeAddressImpl(addr.getValue() + offset));
    }
    
    public NativeCapableInternal findNativeCapable(NativeAddressImpl addr)
    {
        NativeCapableInternal value = getJavaAllocatedObjectRegistry().findObject(addr);    
        if (value != null)  // Comprobamos si es del tipo esperado  
        {
            if (rtMgr.getNativeManager().isRuntimeChecking())
            {
                try
                {
                    checkValue(value);
                }
                catch(JNIEasyException ex)
                {
                    throw new JNIEasyException("Existing and previously allocated object with address: " + addr.getValue() + " and type: " + value.getClass().getName() + " has different type, it must implement " + typeDec.getClassType().getClassName(), ex);
                }
            }
        }     
        return value;
    }
    
    public NativeCapableInternal getNativeCapable(NativeAddressImpl addr, long offset,boolean isAuxiliar)
    {
        NativeCapableInternal value = findNativeCapable(addr,offset);    
        if (value == null)
            value = newProxyValue(addr,offset,isAuxiliar);
       
        return value;
    }    
    
    public Object getObject(NativeAddressImpl addr, long offset)
    {
        return getNativeCapable(addr,offset,false);
    }

    public Object newValue()
    {
        NativeCapableInternal newObject = (NativeCapableInternal)getClassTypeNativeObjectRuntime().newValue();
        newObject.jnieasySetType(this);
        return newObject;
    }    

    public boolean isValidAsReturnOfCallback()
    {
        return true;
    }

}

