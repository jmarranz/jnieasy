/*
 * TypeNativeBehaviorReflectionRender.java
 *
 * Created on 7 de diciembre de 2004, 14:41
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeBehaviorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;



public class TypeNativeBehaviorReflectionRender extends TypeNativeMemberReflectionRender
{
    protected NativeBehaviorSignatureRender signatureRender;
    
    /**
     * Creates a new instance of TypeNativeMemberReflectionRender
     */
    public TypeNativeBehaviorReflectionRender(TypeNativeBehaviorReflectionImpl typeDec)
    {
        super(typeDec);
        
        this.signatureRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(typeDec.getBehaviorSignature());
    }
   
    public String getDeclareTypeMethodName()
    {
        return signatureRender.getDeclareTypeMethodName();
    }
    
    public String getDecOtherParams(boolean enhancer)
    {
        return signatureRender.getDeclareSignatureCode(enhancer).toString();
    }    
        
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return signatureRender.getDeclareComponentTypeCall(enhancer);
    }       
}
