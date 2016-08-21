/*
 * TypeNativeBehaviorReflectionWrapperRender.java
 *
 * Created on 30 de marzo de 2005, 12:29
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;


public class TypeNativeBehaviorReflectionWrapperRender extends TypeNativeMemberReflectionWrapperRender
{
    protected NativeBehaviorSignatureRender signatureRender;
    
    /**
     * Creates a new instance of TypeNativeBehaviorReflectionWrapperRender
     */
    public TypeNativeBehaviorReflectionWrapperRender(TypeNativeBehaviorReflectionWrapperImpl typeDec)
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
