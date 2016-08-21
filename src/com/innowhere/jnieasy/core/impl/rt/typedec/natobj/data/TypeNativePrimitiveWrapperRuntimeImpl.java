/*
 * TypeNativePrimitiveWrapperRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNativePrimitive;
import com.innowhere.jnieasy.core.typedec.TypeNativePrimitiveWrapper;

public class TypeNativePrimitiveWrapperRuntimeImpl extends TypeNativeSingleFieldContainerRuntimeImpl implements TypeNativePrimitiveWrapper
{
    protected TypeNativePrimitiveRuntimeImpl fieldTypeRt;
    
    /**
     * Creates a new instance of TypeNativePrimitiveWrapperRuntimeImpl
     */
    public TypeNativePrimitiveWrapperRuntimeImpl(TypeNativePrimitiveWrapperImpl typeDec,Class javaClass,RuntimeContext ctx)
    {
        super(typeDec,javaClass,ctx.getRuntimeManager());

        this.fieldTypeRt = (TypeNativePrimitiveRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(typeDec.getTypeNativePrimitive(),ctx);
    }   
    
    public TypeNativePrimitiveWrapperRuntimeImpl(TypeNativePrimitiveWrapperImpl typeDec,Class javaClass,TypeNativePrimitiveRuntimeImpl fieldTypeRt,RuntimeContext ctx)
    {  
        super(typeDec,javaClass,ctx.getRuntimeManager()); 
        
        this.fieldTypeRt = fieldTypeRt;        
    }
    
    public static TypeNativePrimitiveWrapperRuntimeImpl newTypeNativePrimitiveWrapperRuntime(Class javaClass,TypeNativePrimitiveRuntimeImpl fieldTypeRt,RuntimeContext ctx)
    {
        TypeNativePrimitiveWrapperImpl typeDec = TypeNativePrimitiveWrapperImpl.newTypeNativePrimitiveWrapper(fieldTypeRt.getTypeNativePrimitive());
        return typeDec.newTypeNativePrimitiveWrapperRuntime(javaClass,fieldTypeRt,ctx);
    }
    
    public TypeNativePrimitiveRuntimeImpl getypeNativePrimitiveRuntime()
    {
        return fieldTypeRt;
    }
    
    public long calcSize()
    {
        return getypeNativePrimitiveRuntime().size();
    }  
    
    public long calcPreferredAlignSize()
    {
        return getypeNativePrimitiveRuntime().preferredAlignSize();
    }  
    
    public void setSizeAndPreferredAlignSize(long size,long preferredAlignSize)
    {
        getypeNativePrimitiveRuntime().setSizeAndPreferredAlignSize(size,preferredAlignSize);
    }    
    
    public void setSizeAndPreferredAlignSize(String sizeExpr,String alignSizeExpr)
    {
        getypeNativePrimitiveRuntime().setSizeAndPreferredAlignSize(sizeExpr,alignSizeExpr);
    }    

    public void checkValueNotNull(Object value)
    {
        super.checkValueNotNull(value);

        TypeNativePrimitiveWrapperRuntimeImpl typeValue = (TypeNativePrimitiveWrapperRuntimeImpl)((NativeCapable)value).jnieasyGetType();
        TypeNativePrimitiveRuntimeImpl typeValueComp = typeValue.getypeNativePrimitiveRuntime();
        
        getypeNativePrimitiveRuntime().checkTypeNativeCompatible(typeValueComp);
    }

    public TypeNativePrimitive getPrimitiveDec()
    {
        return getypeNativePrimitiveRuntime();
    }
}

