/*
 * TypeDLLBehaviorImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeDLLBehaviorImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeDLLBehaviorImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method.TypeDLLBehaviorRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeDLLBehaviorXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeBehaviorParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;

public abstract class TypeDLLBehaviorImpl extends TypeNativeCapableImpl implements TypeNativeBehaviorInterface
{
    protected NativeBehaviorSignatureImpl signature;
    
    /**
     * Creates a new instance of TypeDLLBehaviorImpl
     */
    public TypeDLLBehaviorImpl(ClassTypeDLLBehaviorImpl dataType)
    {
        super(dataType);
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
            throw new JNIEasyException("Behavior signature cannot be null"); 
        //signature.check();        
    }     

    public String getDeclarationStringComplement()
    {    
        NativeBehaviorSignatureRender sigRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(signature);
        return sigRender.asDeclarationBlockString();
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeDLLBehaviorImpl(this);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeDLLBehaviorRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeDLLBehaviorXML(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeBehaviorParserImpl(this);
    }
    
    public abstract NativeBehaviorSignatureXML newBehaviorSignatureXML();
}
