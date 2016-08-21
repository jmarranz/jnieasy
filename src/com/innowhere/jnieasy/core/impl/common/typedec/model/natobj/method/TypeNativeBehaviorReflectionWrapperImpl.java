/*
 * TypeNativeBehaviorReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeBehaviorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeBehaviorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeBehaviorParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method.TypeNativeBehaviorReflectionWrapperRender;



public abstract class TypeNativeBehaviorReflectionWrapperImpl extends TypeNativeMemberReflectionWrapperImpl implements TypeNativeBehaviorInterface
{
    protected NativeBehaviorSignatureImpl signature;
    
    /** Creates a new instance of TypeNativeBehaviorReflectionWrapperImpl */
    public TypeNativeBehaviorReflectionWrapperImpl(ClassTypeNativeBehaviorReflectionWrapperImpl dataType)
    {
        super(dataType);
    }
 
    public TypeNativeBehaviorReflectionWrapperImpl(ClassTypeNativeBehaviorReflectionWrapperImpl dataType,TypeNativeBehaviorReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }    
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
            
    public abstract NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature);

    public void setBehaviorSignature(NativeBehaviorSignatureImpl signature)
    {
        this.signature = checkSignature(signature);
    }
    
    public void check()
    {
        if (signature == null)
            throw new JNIEasyException("Behavior signature is null"); 
        //signature.check();
    }    
    
    public String getDeclarationStringComplement()
    {    
        NativeBehaviorSignatureRender sigRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(signature);
        return sigRender.asDeclarationBlockString();
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeBehaviorReflectionWrapperRender(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeBehaviorParserImpl(this);
    }
    
    public abstract NativeBehaviorSignatureXML newBehaviorSignatureXML();
}
