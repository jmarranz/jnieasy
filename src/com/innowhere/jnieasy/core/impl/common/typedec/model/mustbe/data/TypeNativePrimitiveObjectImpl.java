/*
 * TypeNativePrimitiveObjectImpl.java
 *
 * Created on 2 de febrero de 2005, 14:03
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe.TypeNativePrimitiveObjectParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data.TypeNativePrimitiveObjectRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data.TypeNativePrimitiveObjectXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;

public class TypeNativePrimitiveObjectImpl extends TypeCanBeNativeCapableImpl
{
    protected TypeNativePrimitiveImpl fieldType;    
    
    /**
     * Creates a new instance of TypeNativePrimitiveObjectImpl
     */
    public TypeNativePrimitiveObjectImpl(ClassTypeNativePrimitiveObjectImpl dataType)
    {
        super(dataType);
      
        this.fieldType = (TypeNativePrimitiveImpl)TypeNativeImpl.newTypeNative(dataType.getClassTypeNativePrimitive());
    }
    
    public TypeNativePrimitiveObjectImpl(ClassTypeNativePrimitiveObjectImpl dataType,TypeNativePrimitiveObjectWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
        
        this.fieldType = (TypeNativePrimitiveImpl)TypeNativeImpl.newTypeNative(dataType.getClassTypeNativePrimitive());        
    }    
    
    public TypeNativePrimitiveObjectImpl(ClassTypeNativePrimitiveObjectImpl dataType,TypeNativePrimitiveImpl fieldType)
    {
        super(dataType);
        
        this.fieldType = fieldType;
    }    
    
    public static TypeNativePrimitiveObjectImpl newTypeNativePrimitiveObject(TypeNativePrimitiveImpl fieldType)
    {
        ClassTypeNativePrimitiveImpl fieldClassType = fieldType.getClassTypeNativePrimitive();
        ClassTypeNativePrimitiveObjectImpl classType = fieldClassType.getClassTypeNativePrimitiveObject();
        return classType.newTypeNativePrimitiveObject(fieldType);                
    }     
    
    public TypeNativePrimitiveObjectWrapperImpl getTypeNativePrimitiveObjectWrapper()
    {
        return (TypeNativePrimitiveObjectWrapperImpl)getTypeCanBeNativeCapableWrapper();
    }

    public ClassTypeNativePrimitiveObjectImpl getClassTypeNativePrimitiveObject()
    {
        return (ClassTypeNativePrimitiveObjectImpl)dataType;
    }
    
    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
        return fieldType;
    }
    
    public String getDeclarationStringComplement()
    {
        return getTypeNativePrimitive().getDeclarationStringComplement();
    }   
   
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativePrimitiveObjectRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveObjectXML(this);
    }

    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativePrimitiveObjectImpl(this);
    }
     
    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativePrimitiveObjectRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }    
    
    public TypeNativePrimitiveObjectRuntimeImpl newTypeNativePrimitiveObjectRuntime(Class javaClass,boolean isPrimary,TypeNativePrimitiveRuntimeImpl fieldTypeRt,RuntimeContext ctx)    
    {
        return new TypeNativePrimitiveObjectRuntimeImpl(this,javaClass,isPrimary,fieldTypeRt,ctx);
    } 
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativePrimitiveObjectParserImpl(this);
    }    
}
