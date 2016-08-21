/*
 * TypeNativeBehaviorDefaultImpl.java
 *
 * Created on 21 de septiembre de 2005, 13:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeBehaviorDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method.TypeNativeBehaviorDefaultRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeBehaviorDefaultXML;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeBehaviorDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeBehaviorParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeBehaviorDefaultImpl extends TypeNativeCapableImpl implements TypeNativeBehaviorInterface
{
    protected NativeBehaviorSignatureImpl signature;
    
    /**
     * Creates a new instance of TypeNativeBehaviorDefaultImpl
     */
    public TypeNativeBehaviorDefaultImpl(ClassTypeNativeBehaviorDefaultImpl dataType)
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
            throw new JNIEasyException("Behavior signature is null"); 
        //signature.check();        
    }     
    
    public String getDeclarationStringComplement()
    {    
        NativeBehaviorSignatureRender sigRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(signature);
        return sigRender.asDeclarationBlockString();
    }    
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeBehaviorDefaultImpl(this);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeBehaviorDefaultRender(this);
    }  
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeBehaviorDefaultXML(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeBehaviorParserImpl(this);
    }
    
    public abstract NativeBehaviorSignatureXML newBehaviorSignatureXML();    
}
