/*
 * TypeNativeDirectCallbackRender.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeCapableRender;


public class TypeNativeDirectCallbackRender extends TypeNativeCapableRender
{
    protected NativeBehaviorSignatureRender signatureRender;
    
    /**
     * Creates a new instance of TypeNativeDirectCallbackRender
     */
    public TypeNativeDirectCallbackRender(TypeNativeDirectCallbackImpl typeDec)
    {
        super(typeDec);
        
        this.signatureRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(typeDec.getBehaviorSignature());        
    }
    
    public TypeNativeDirectCallbackImpl getTypeNativeDirectCallback()
    {
        return (TypeNativeDirectCallbackImpl)typeDec;
    }
    
    public String getDeclareTypeMethodName()
    {
        TypeNativeDirectCallbackImpl typeDec = getTypeNativeDirectCallback();
        if (typeDec.isDefaultSignature())
            return "dec";
        else
            return signatureRender.getDeclareTypeMethodName();            
    }
    
    public String getDecOtherParams(boolean enhancer)
    {
        TypeNativeDirectCallbackImpl typeDec = getTypeNativeDirectCallback();
        if (typeDec.isDefaultSignature())        
            return "";
        else
            return signatureRender.getDeclareSignatureCode(enhancer).toString();            
    }     
    
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        // REVISAR
        return signatureRender.getDeclareComponentTypeCall(enhancer);
    }     
}
