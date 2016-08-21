/*
 * TypeCanBeNativeCapableWrapperRuntimeImpl.java
 *
 * Created on 6 de enero de 2005, 16:09
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeCanBeNativeCapableRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public abstract class TypeCanBeNativeCapableWrapperRuntimeImpl extends TypeNativeObjectFieldContainerRuntimeImpl implements TypeCanBeNativeCapableRuntime
{
    protected TypeCanBeNativeCapableRuntimeImpl fieldType;
    
    /**
     * Creates a new instance of TypeCanBeNativeCapableWrapperRuntimeImpl
     */
    public TypeCanBeNativeCapableWrapperRuntimeImpl(TypeCanBeNativeCapableWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,ctx.getRuntimeManager());
        
        if (isPrimary)
        {
            setTypeCanBeNativeCapableRuntime(ctx);
        }
    }
      
    public TypeCanBeNativeCapableWrapperRuntimeImpl(TypeCanBeNativeCapableWrapperImpl typeDec,Class javaClass,TypeCanBeNativeCapableRuntimeImpl fieldType,RuntimeContext ctx)
    {
        super(typeDec,javaClass,ctx.getRuntimeManager());    
        
        setTypeCanBeNativeCapableRuntime(fieldType);        
    }
    
    public TypeCanBeNativeCapableWrapperImpl getTypeCanBeNativeCapableWrapper()
    {
        return (TypeCanBeNativeCapableWrapperImpl)typeDec;
    }

    public TypeCanBeNativeCapableRuntimeImpl getTypeCanBeNativeCapableRuntime()
    {     
        if (fieldType == null)
            throw new JNIEasyException("Incomplete type");
        return fieldType;
    }    

    public void setTypeCanBeNativeCapableRuntime(RuntimeContext ctx)
    {
        TypeCanBeNativeCapableWrapperImpl typeDec = getTypeCanBeNativeCapableWrapper();
        TypeCanBeNativeCapableImpl wrappedTypeDec = typeDec.getTypeCanBeNativeCapable();       

        TypeCanBeNativeCapableRuntimeImpl wrappedTypeDecRt = wrappedTypeDec.newTypeCanBeNativeCapableRuntime(this.getWrappedClass(),false,ctx);

        setTypeCanBeNativeCapableRuntime(wrappedTypeDecRt);       
    }        
    
    public void setTypeCanBeNativeCapableRuntime(TypeCanBeNativeCapableRuntimeImpl wrappedTypeDec)
    {
        this.fieldType = wrappedTypeDec;
        this.fieldType.setTypeCanBeNativeCapableWrapperRuntime(this);
        getTypeCanBeNativeCapableWrapper().setTypeCanBeNativeCapable(wrappedTypeDec.getTypeCanBeNativeCapable());
    }
    
    public CanBeNativeCapable wrapAndMakeNative(Object value)
    {
        if (value == null) return null;
        CanBeNativeCapable wrapper = (CanBeNativeCapable)newValue();
        wrapper.setValue(value);
        getNativeManager().makeNative(wrapper);
        return wrapper;
    }
    
    public CanBeNativeCapable wrapValue(Object value)
    {
        if (value == null) return null;
        CanBeNativeCapable wrapper = (CanBeNativeCapable)newValue();
        wrapper.setValue(value);
        return wrapper;
    }
    
    public long calcSize()
    {
        return getTypeCanBeNativeCapableRuntime().size();
    }
    
    public long calcPreferredAlignSize()
    {
        return getTypeCanBeNativeCapableRuntime().preferredAlignSize();
    }       
    
    public Class getWrappedClass()
    {
        TypeCanBeNativeCapableWrapperImpl typeDec = getTypeCanBeNativeCapableWrapper();
        TypeCanBeNativeCapableImpl typeDecWrapped = typeDec.getTypeCanBeNativeCapable();
        return TypeNativeRuntimeImpl.getClassImpl(typeDecWrapped);
    }
 
    public void check()
    {
        super.check();
        getTypeCanBeNativeCapableRuntime().checkShared();
    }     
}
