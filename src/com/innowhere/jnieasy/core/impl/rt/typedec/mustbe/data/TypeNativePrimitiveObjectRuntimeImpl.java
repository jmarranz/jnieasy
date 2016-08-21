/*
 * TypeNativePrimitiveObjectRuntimeImpl.java
 *
 * Created on 2 de febrero de 2005, 14:03
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveObjectRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNativePrimitive;

public class TypeNativePrimitiveObjectRuntimeImpl extends TypeCanBeNativeCapableRuntimeImpl implements TypeNativePrimitiveObjectRuntime
{
    protected TypeNativePrimitiveRuntimeImpl fieldTypeRt;
            
    /**
     * Creates a new instance of TypeNativePrimitiveObjectRuntimeImpl
     */
    public TypeNativePrimitiveObjectRuntimeImpl(TypeNativePrimitiveObjectImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
        
        this.fieldTypeRt = (TypeNativePrimitiveRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(typeDec.getTypeNativePrimitive(),ctx);
    } 
    
    public TypeNativePrimitiveObjectRuntimeImpl(TypeNativePrimitiveObjectImpl typeDec,Class javaClass,boolean isPrimary,TypeNativePrimitiveRuntimeImpl fieldTypeRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
        
        this.fieldTypeRt = fieldTypeRt;
    }        
    
    public static TypeNativePrimitiveObjectRuntimeImpl newTypeNativePrimitiveObjectRuntime(Class javaClass,boolean isPrimary,TypeNativePrimitiveRuntimeImpl fieldTypeRt,RuntimeContext ctx)
    {
        TypeNativePrimitiveObjectImpl typeDec = TypeNativePrimitiveObjectImpl.newTypeNativePrimitiveObject(fieldTypeRt.getTypeNativePrimitive());
        return typeDec.newTypeNativePrimitiveObjectRuntime(javaClass,isPrimary,fieldTypeRt,ctx);
    }    
    
    public TypeNativePrimitiveObjectImpl getTypeNativePrimitiveObject()
    {
        return (TypeNativePrimitiveObjectImpl)typeDec;
    }
    
    public TypeNativePrimitiveObjectWrapperRuntimeImpl getTypeNativePrimitiveObjectWrapperRuntime()
    {
        return (TypeNativePrimitiveObjectWrapperRuntimeImpl)getTypeCanBeNativeCapableWrapperRuntime();
    }

    public TypeNativePrimitiveRuntimeImpl getTypeNativePrimitiveRuntime()
    {
        return fieldTypeRt;
    }
    
    public boolean isObjectKnownSize()
    {
        return true;
    }
    
    public long calcSize()
    {
        return getTypeNativePrimitiveRuntime().calcSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        return getTypeNativePrimitiveRuntime().calcPreferredAlignSize();
    }        
    
    public Object newValueInternal()
    {    
        return getClassTypeNativeObjectRuntime().newValue();
    }

    public void setSizeAndPreferredAlignSize(long size, long preferredAlignSize)
    {
        getTypeNativePrimitiveRuntime().setSizeAndPreferredAlignSize(size,preferredAlignSize);
    }

    public void setSizeAndPreferredAlignSize(String size, String preferredAlignSize)
    {
        getTypeNativePrimitiveRuntime().setSizeAndPreferredAlignSize(size,preferredAlignSize);
    }

    public TypeNativePrimitive getPrimitiveDec()
    {
        return getTypeNativePrimitiveRuntime();
    }
}

