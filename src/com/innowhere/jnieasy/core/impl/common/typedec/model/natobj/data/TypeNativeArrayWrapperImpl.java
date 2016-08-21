/*
 * TypeNativeArrayWrapperImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInfo;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj.TypeNativeArrayWrapperParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeArrayWrapperRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativeArrayWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;


/**
 *
 * @author  jmarranz
 */

public abstract class TypeNativeArrayWrapperImpl extends TypeCanBeNativeCapableWrapperImpl implements TypeNativeArrayInterface
{
    /** Creates a new instance of TypeNativeArrayWrapperImpl */
    public TypeNativeArrayWrapperImpl(ClassTypeNativeArrayWrapperImpl dataType)
    {
        super(dataType);
    }       
 
    public TypeNativeArrayWrapperImpl(ClassTypeNativeArrayWrapperImpl dataType,TypeNativeArrayImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    } 
    
    public boolean isCompleteDeclaration()
    {
        if (fieldType != null)
            return true;
        ClassTypeCanBeNativeCapableImpl wrappedClassType = getClassTypeCanBeNativeCapableWrapper().getClassTypeCanBeNativeCapable();
        return (wrappedClassType != null);  // En el caso de NativeArrayOfArray puede ser null     
    }
    
    public TypeNativeArrayImpl getTypeNativeArray()
    {
        return (TypeNativeArrayImpl)getTypeCanBeNativeCapable();
    }
    
    public ClassTypeNativeArrayWrapperImpl getClassTypeArrayTypeWrapper()
    {
        return (ClassTypeNativeArrayWrapperImpl)dataType;
    }

    public TypeNativeArrayInfo getTypeNativeArrayInfo()
    {
        return getTypeNativeArray().getTypeNativeArrayInfo();
    }    

    public void check()
    {    
        super.check();
        getTypeNativeArray().checkShared();
    }
    
    public String getDeclarationStringComplement()
    {
        return "{" + getTypeNativeArray().getDeclarationString() + "}";
    }    
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeArrayWrapperRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeArrayWrapperXML(this);
    }

    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeArrayWrapperImpl(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeArrayWrapperParserImpl(this);
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass, boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeArrayWrapperRuntimeImpl(this, javaClass, isPrimary, ctx);
    }
   
}
