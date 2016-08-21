/*
 * NativeStaticMethodSignatureRender.java
 *
 * Created on 28 de marzo de 2005, 18:04
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.method.NativeStaticMethod;

/**
 *
 * @author  jmarranz
 */


public class NativeStaticMethodSignatureRender extends NativeMethodSignatureRender
{
    
    /**
     * Creates a new instance of NativeStaticMethodSignatureRender
     */
    public NativeStaticMethodSignatureRender(NativeStaticMethodSignatureImpl signature)
    {
        super(signature);
    }
   
    public NativeStaticMethodSignatureImpl getStaticMethodSignature()
    {
	return (NativeStaticMethodSignatureImpl)signature;
    }
    
    public StringBuffer getDeclareSignatureCallCode(boolean enhancer)
    {
        // public StaticMethodSignature decStaticMethod(Object returnType,Object[] params,int callConv);        
        
        StringBuffer code = new StringBuffer();
        code.append( "decStaticMethod(" );
        code.append( retDecRender.getVarTypeCode(enhancer) );        
        code.append( "," + paramDecListRender.getParameterDecListCode(0, enhancer) );
        code.append( "," + getCallConvConstantExpr() ); 
	code.append( ")" );
        
        return code;
    }    
    
    public String getSignatureString(String methodName)
    {
        return methodName + getParamsAsString(); 
    }
    
    public String getDeclarationString()
    {
        // NativeStaticMethodSignatureImpl signature = getStaticMethodSignature();        
        String callConv = getCallConvDeclarationString();
        return "static " + retDecRender.asString() + " " + callConv + " " + getParamsAsString();
    }

    public String getNativeBehaviorInterfaceName()
    {
        return NativeStaticMethod.class.getName();
    }       
}
