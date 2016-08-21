/*
 * TypeNativeBehaviorReflectionImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeBehaviorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeBehaviorParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.method.TypeNativeBehaviorReflectionRender;


public abstract class TypeNativeBehaviorReflectionImpl extends TypeNativeMemberReflectionImpl implements TypeNativeBehaviorInterface
{
    /** Creates a new instance of TypeNativeBehaviorReflectionImpl */
    public TypeNativeBehaviorReflectionImpl(ClassTypeNativeBehaviorReflectionImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeBehaviorReflectionImpl(ClassTypeNativeBehaviorReflectionImpl dataType,TypeNativeBehaviorReflectionWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }   
    
    public TypeNativeBehaviorReflectionWrapperImpl getTypeNativeBehaviorReflectionWrapper()
    {
        return (TypeNativeBehaviorReflectionWrapperImpl)getTypeCanBeNativeCapableWrapper();
    }

    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return getTypeNativeBehaviorReflectionWrapper().getBehaviorSignature();
    }
    
    public void setBehaviorSignature(NativeBehaviorSignatureImpl signature)
    {
        getTypeNativeBehaviorReflectionWrapper().setBehaviorSignature(signature);
    }

    public String getDeclarationStringComplement()
    {    
        return getTypeNativeBehaviorReflectionWrapper().getDeclarationStringComplement();
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeBehaviorReflectionRender(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeBehaviorParserImpl(this);
    }
    
    public abstract NativeBehaviorSignatureXML newBehaviorSignatureXML();
}
