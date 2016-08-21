/*
 * TypeNativePrimitiveObjectWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 13:32
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj.TypeNativePrimitiveObjectWrapperParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativePrimitiveObjectWrapperRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativePrimitiveObjectWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;

public class TypeNativePrimitiveObjectWrapperImpl extends TypeCanBeNativeCapableWrapperImpl
{
    /**
     * Creates a new instance of TypeNativePrimitiveObjectWrapperImpl
     */
    public TypeNativePrimitiveObjectWrapperImpl(ClassTypeNativePrimitiveObjectWrapperImpl dataType)
    {
        super(dataType);
    }     
    
    public TypeNativePrimitiveObjectWrapperImpl(ClassTypeNativePrimitiveObjectWrapperImpl dataType,TypeNativePrimitiveObjectImpl fieldType)
    {
        super(dataType,fieldType);     
    }    
        
    public static TypeNativePrimitiveObjectWrapperImpl newTypeNativePrimitiveObjectWrapper(TypeNativePrimitiveObjectImpl fieldType)
    {
        ClassTypeNativePrimitiveObjectImpl fieldClassType = fieldType.getClassTypeNativePrimitiveObject();
        ClassTypeNativePrimitiveObjectWrapperImpl classType = fieldClassType.getClassTypeNativePrimitiveObjectWrapper();
        return classType.newTypeNativePrimitiveObjectWrapper(fieldType);                
    }
    
    public TypeNativePrimitiveObjectImpl getTypeNativePrimitiveObject()
    {
        return (TypeNativePrimitiveObjectImpl)getTypeCanBeNativeCapable();
    }
    
    public String getDeclarationStringComplement()
    {
        return getTypeNativePrimitiveObject().getDeclarationStringComplement();
    }    

  
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativePrimitiveObjectWrapperRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveObjectWrapperXML(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativePrimitiveObjectWrapperParserImpl(this);
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativePrimitiveObjectWrapperImpl(this);
    }
        
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativePrimitiveObjectWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);
    }
    
    public TypeNativePrimitiveObjectWrapperRuntimeImpl newTypeNativePrimitiveObjectWrapperRuntime(Class javaClass,TypeNativePrimitiveObjectRuntimeImpl compType,RuntimeContext ctx)
    {
        return new TypeNativePrimitiveObjectWrapperRuntimeImpl(this,javaClass,compType,ctx);        
    }
}
