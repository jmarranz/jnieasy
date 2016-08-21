/*
 * TypeNativePrimitiveObjectWrapperRuntimeImpl.java
 *
 * Created on 3 de febrero de 2005, 13:32
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveObjectRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNativePrimitive;

public class TypeNativePrimitiveObjectWrapperRuntimeImpl extends TypeCanBeNativeCapableWrapperRuntimeImpl implements TypeNativePrimitiveObjectRuntime
{
    
    /**
     * Creates a new instance of TypeNativePrimitiveObjectWrapperRuntimeImpl
     */
    public TypeNativePrimitiveObjectWrapperRuntimeImpl(TypeNativePrimitiveObjectWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }     
    
    public TypeNativePrimitiveObjectWrapperRuntimeImpl(TypeNativePrimitiveObjectWrapperImpl typeDec,Class javaClass,TypeNativePrimitiveObjectRuntimeImpl fieldTypeRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,fieldTypeRt,ctx);
    }        
    
    public static TypeNativePrimitiveObjectWrapperRuntimeImpl newTypeNativePrimitiveObjectWrapperRuntime(Class javaClass,TypeNativePrimitiveObjectRuntimeImpl fieldTypeRt,RuntimeContext ctx)
    {
        boolean isPrimary = true;
        TypeNativePrimitiveObjectWrapperImpl typeDec = TypeNativePrimitiveObjectWrapperImpl.newTypeNativePrimitiveObjectWrapper(fieldTypeRt.getTypeNativePrimitiveObject());
        return typeDec.newTypeNativePrimitiveObjectWrapperRuntime(javaClass,fieldTypeRt,ctx);
    }    
    
    public TypeNativePrimitiveObjectRuntimeImpl getTypeNativePrimitiveObjectRuntime()
    {
        return (TypeNativePrimitiveObjectRuntimeImpl)getTypeCanBeNativeCapableRuntime();
    }

    public void setSizeAndPreferredAlignSize(long size, long preferredAlignSize)
    {
        getTypeNativePrimitiveObjectRuntime().setSizeAndPreferredAlignSize(size,preferredAlignSize);
    }

    public void setSizeAndPreferredAlignSize(String size, String preferredAlignSize)
    {
        getTypeNativePrimitiveObjectRuntime().setSizeAndPreferredAlignSize(size,preferredAlignSize);        
    }
   
    public void checkValueNotNull(Object value)
    {
        super.checkValueNotNull(value);

        TypeNativePrimitiveObjectWrapperRuntimeImpl typeValue = (TypeNativePrimitiveObjectWrapperRuntimeImpl)((NativeCapable)value).jnieasyGetType();
        TypeNativePrimitiveRuntimeImpl typeValueComp = typeValue.getTypeNativePrimitiveObjectRuntime().getTypeNativePrimitiveRuntime();
        
        getTypeNativePrimitiveObjectRuntime().getTypeNativePrimitiveRuntime().checkTypeNativeCompatible(typeValueComp);
    }    

    public TypeNativePrimitive getPrimitiveDec()
    {
        return getTypeNativePrimitiveObjectRuntime().getTypeNativePrimitiveRuntime();
    }
}
