/*
 * NativeConstructorSignatureRender.java
 *
 * Created on 28 de marzo de 2005, 18:04
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.*;
import com.innowhere.jnieasy.core.method.NativeConstructor;

/**
 *
 * @author  jmarranz
 */


public class NativeConstructorSignatureRender extends NativeBehaviorSignatureRender
{
    public static final String NAME = "<init>";
    
    /**
     * Creates a new instance of NativeConstructorSignatureRender
     */
    public NativeConstructorSignatureRender(NativeConstructorSignatureImpl signature)
    {
        super(signature);
    }
    
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
	return (NativeConstructorSignatureImpl)signature;
    }
    
    public StringBuffer getDeclareSignatureCallCode(boolean enhancer)
    {
        // public ConstructorSignature decConstructor(Class returnClass,Object[] params,int callConv);        
        
        NativeConstructorSignatureImpl sig = getConstructorSignature();
        String returnClass = sig.getThisClassType().getClassName();
        
        StringBuffer code = new StringBuffer();
        code.append( "decConstructor(" );
        code.append( TypeNativeRender.getClassCode(returnClass,enhancer) + "," );
        code.append( paramDecListRender.getParameterDecListCode(0, enhancer) );
        code.append( "," + getCallConvConstantExpr() ); 
	code.append( ")" );
        
        return code;
    }

    public String getSignatureString(String methodName)
    {
        // Ignoramos methodName que puede ser null (o es <init>)   
        NativeConstructorSignatureImpl signature = getConstructorSignature();
        String returnClass = signature.getThisClassType().getClassName();
        return returnClass + "." + NAME + getParamsAsString(); 
    }
    
    public String getDeclarationString()
    {
        NativeConstructorSignatureImpl signature = getConstructorSignature();        
        String callConv = getCallConvDeclarationString();
        String returnClass = signature.getThisClassType().getClassName();
        return callConv + " " + returnClass + getParamsAsString();
    }

    public String generateCallParams(boolean enhancer)
    {
        return "this," + super.generateCallParams(enhancer);
    }    
        
    public String getReturnAndCast()
    {
        return "";
    }        
            
    public String generateCallName()
    {
        return "call";
    }    
        
    public String getNativeBehaviorInterfaceName()
    {
        return NativeConstructor.class.getName();
    }    
}
