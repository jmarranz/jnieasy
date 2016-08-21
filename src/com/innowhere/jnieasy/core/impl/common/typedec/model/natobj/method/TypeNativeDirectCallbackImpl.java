/*
 * TypeNativeDirectCallbackImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeBehaviorParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method.TypeNativeDirectCallbackRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeDirectCallbackXML;

public abstract class TypeNativeDirectCallbackImpl extends TypeNativeCapableImpl  implements TypeNativeBehaviorInterface
{
    protected NativeBehaviorSignatureImpl signature;
            
    /**
     * Creates a new instance of TypeNativeDirectCallbackImpl
     */
    public TypeNativeDirectCallbackImpl(ClassTypeNativeDirectCallbackImpl dataType)
    {
        super(dataType);
    }

    public boolean isCustom()
    {
        ClassTypeNativeDirectCallbackImpl classType = (ClassTypeNativeDirectCallbackImpl)getClassType();
        return classType.isCustom();
    }    
    
    public NativeBehaviorSignatureImpl getDefaultBehaviorSignature()
    {
        ClassTypeNativeDirectCallbackImpl classType = (ClassTypeNativeDirectCallbackImpl)getClassType();
        JavaClassAsNativeDirectCallbackImpl javaClassDesc = (JavaClassAsNativeDirectCallbackImpl)classType.getJavaClassAsNativeDirectCallback();
        return javaClassDesc.getBehaviorSignature();             
    }
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        if ((this.signature == null) && isCustom())
            return getDefaultBehaviorSignature();      
        else
            return this.signature; // puede ser null (debe dar error en el check())
    }   

    public void setBehaviorSignature(NativeBehaviorSignatureImpl signature)
    {
        this.signature = checkSignature(signature);        
    }
    
    public boolean isDefaultSignature()
    {
        return (this.signature == null) && isCustom();        
    }
    
    public abstract NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature);
    
    
    public void check()
    {
        if (getBehaviorSignature() == null)
            throw new JNIEasyException("Method signature is null"); 
        //signature.check();        
    }        
    
    public String getDeclarationStringComplement()
    {    
        if ((this.signature == null) && isCustom())
        {
            return "";
        }
        else
        {
            NativeBehaviorSignatureRender sigRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(signature);
            return sigRender.asDeclarationBlockString();            
        }
    }    
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeDirectCallbackImpl(this);
    }

    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeDirectCallbackXML(this);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeDirectCallbackRender(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeBehaviorParserImpl(this);
    }
    
    public abstract NativeBehaviorSignatureXML newBehaviorSignatureXML();  
     
}
