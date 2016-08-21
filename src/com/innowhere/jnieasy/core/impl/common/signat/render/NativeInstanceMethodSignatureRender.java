/*
 * NativeInstanceMethodSignatureRender.java
 *
 * Created on 28 de marzo de 2005, 18:05
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.*;
import com.innowhere.jnieasy.core.method.NativeInstanceMethod;

/**
 *
 * @author  jmarranz
 */


public class NativeInstanceMethodSignatureRender extends NativeMethodSignatureRender
{
    
    /**
     * Creates a new instance of NativeInstanceMethodSignatureRender
     */
    public NativeInstanceMethodSignatureRender(NativeInstanceMethodSignatureImpl signature)
    {
        super(signature);
    }

    public NativeInstanceMethodSignatureImpl getInstanceMethodSignature()
    {
	return (NativeInstanceMethodSignatureImpl)signature;
    }

    public StringBuffer getDeclareSignatureCallCode(boolean enhancer)
    {
        NativeInstanceMethodSignatureImpl sig = getInstanceMethodSignature();
        String className = sig.getThisClassType().getClassName();
        
        // public InstanceMethodSignature decInstanceMethod(Class classObj,Object returnType,Object[] params, int callConv);        
        
        StringBuffer code = new StringBuffer();
        code.append( "decInstanceMethod(" );
        code.append( TypeNativeRender.getClassCode(className,enhancer) );
        code.append( "," + retDecRender.getVarTypeCode(enhancer) );        
        code.append( "," + paramDecListRender.getParameterDecListCode(1, enhancer) );
        code.append( "," + getCallConvConstantExpr() );        
	code.append( ")" );
    
        return code;
    }
    
    public String getSignatureString(String methodName)
    {
        NativeInstanceMethodSignatureImpl signature = getInstanceMethodSignature();
        String className = signature.getThisClassType().getClassName();
        return className + "." + methodName + getParamsAsString(); 
    }
    
    public String getDeclarationString()
    {
        NativeInstanceMethodSignatureImpl signature = getInstanceMethodSignature();        
        String callConv = getCallConvDeclarationString();
        String className = signature.getThisClassType().getClassName();        
        return retDecRender.asString() + " " + callConv + " " + className + getParamsAsString();
    }    

    
    public String generateCallParams(boolean enhancer)
    {
        return "this," + super.generateCallParams(enhancer);
    }    
    

    public String getNativeBehaviorInterfaceName()
    {
        return NativeInstanceMethod.class.getName();
    }    
}
