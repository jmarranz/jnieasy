/*
 * NativeStaticFieldMethodSignatureRender.java
 *
 * Created on 18 de julio de 2005, 20:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethod;

/**
 *
 * @author jmarranz
 */
public class NativeStaticFieldMethodSignatureRender extends NativeFieldMethodSignatureRender
{
    
    /**
     * Creates a new instance of NativeStaticFieldMethodSignatureRender
     */
    public NativeStaticFieldMethodSignatureRender(NativeStaticFieldMethodSignatureImpl signature)
    {
        super(signature);
    }
    
    public NativeStaticFieldMethodSignatureImpl getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
    
    public StringBuffer getDeclareSignatureCallCode(boolean enhancer)
    {
        // public StaticFieldMethodSignature decStaticFieldMethod(Object fieldType,int callConv);
        
        StringBuffer code = new StringBuffer();
        code.append( "decStaticFieldMethod(" );
        code.append( retDecRender.getVarTypeCode(enhancer) );        
        code.append( "," + getCallConvConstantExpr() ); 
	code.append( ")" );
        
        return code;
    }    
    
    public String getSignatureString(String fieldName)
    {
        return fieldName + getParamsAsString(); 
    }
    
    public String getDeclarationString()
    {
        //NativeStaticFieldMethodSignatureImpl signature = getStaticFieldMethodSignature(); 
        String callConv = getCallConvDeclarationString();        
        return "static " + retDecRender.asString() + " " + callConv;
    }    

    public String getNativeBehaviorInterfaceName()
    {
        return NativeStaticFieldMethod.class.getName();
    }
}
