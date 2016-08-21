/*
 * TypeNativePrimitiveWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj.TypeNativePrimitiveWrapperParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativePrimitiveWrapperRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativePrimitiveWrapperXML;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;


public class TypeNativePrimitiveWrapperImpl extends TypeNativeSingleFieldContainerImpl
{
    protected TypeNativePrimitiveImpl fieldType; // No usamos "VarType" porque el "Var" lo gestiona el contenedor
    
    /**
     * Creates a new instance of TypeNativePrimitiveWrapperImpl
     */
    public TypeNativePrimitiveWrapperImpl(ClassTypeNativePrimitiveWrapperImpl dataType)
    {
        super(dataType);
        
        ClassTypeNativeImpl fieldClassType = dataType.getFieldClassType();
        this.fieldType = (TypeNativePrimitiveImpl)TypeNativeImpl.newTypeNative(fieldClassType);                 
    }
    
    public TypeNativePrimitiveWrapperImpl(ClassTypeNativePrimitiveWrapperImpl dataType,TypeNativePrimitiveImpl fieldTypeDec)
    {
        super(dataType);

        this.fieldType = fieldTypeDec;                 
    }          
    
    public static TypeNativePrimitiveWrapperImpl newTypeNativePrimitiveWrapper(TypeNativePrimitiveImpl fieldType)
    {
        ClassTypeNativePrimitiveImpl fieldClassType = fieldType.getClassTypeNativePrimitive();
        ClassTypeNativePrimitiveWrapperImpl classType = fieldClassType.getClassTypeNativePrimitiveWrapper();
        return classType.newTypeNativePrimitiveWrapper(fieldType);                
    }    
    
    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
        return fieldType;
    }
        
    public String getDeclarationStringComplement()
    {
        TypeNativePrimitiveImpl fieldType = getTypeNativePrimitive();
        return fieldType.getDeclarationStringComplement();
    }        
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativePrimitiveWrapperImpl(this);
    }
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveWrapperXML(this);
    }    
            
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativePrimitiveWrapperRender(this);
    }    
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativePrimitiveWrapperParserImpl(this);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass, RuntimeContext ctx)
    {
        return new TypeNativePrimitiveWrapperRuntimeImpl(this,javaClass,ctx);
    }    
    
    public TypeNativePrimitiveWrapperRuntimeImpl newTypeNativePrimitiveWrapperRuntime(Class javaClass,TypeNativePrimitiveRuntimeImpl fieldTypeRt,RuntimeContext ctx)    
    {
        return new TypeNativePrimitiveWrapperRuntimeImpl(this,javaClass,fieldTypeRt,ctx);
    }   
}

