/*
 * TypeNativeBehaviorDefaultRender.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeCapableRender;

public class TypeNativeBehaviorDefaultRender extends TypeNativeCapableRender
{
    protected NativeBehaviorSignatureRender signatureRender;
    
    /**
     * Creates a new instance of TypeNativeBehaviorDefaultRender
     */
    public TypeNativeBehaviorDefaultRender(TypeNativeBehaviorDefaultImpl typeDec)
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
