/*
 * NativeInstanceFieldMethodSignatureRender.java
 *
 * Created on 18 de julio de 2005, 19:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.*;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod;

/**
 *
 * @author jmarranz
 */
public class NativeInstanceFieldMethodSignatureRender extends NativeFieldMethodSignatureRender
{
    
    /**
     * Creates a new instance of NativeInstanceFieldMethodSignatureRender
     */
    public NativeInstanceFieldMethodSignatureRender(NativeInstanceFieldMethodSignatureImpl signature)
    {
        super(signature);
    }
    
    public NativeInstanceFieldMethodSignatureImpl getInstanceFieldMethodSignature()
    {
	return (NativeInstanceFieldMethodSignatureImpl)signature;
    }
    
    public StringBuffer getDeclareSignatureCallCode(boolean enhancer)
    {
        NativeInstanceFieldMethodSignatureImpl sig = getInstanceFieldMethodSignature();
        String className = sig.getThisClassType().getClassName();
        
        // public InstanceFieldMethodSignature decInstanceFieldMethod(Class classObj,Object fieldType, int callConv);
        
        StringBuffer code = new StringBuffer();
        code.append( "decInstanceFieldMethod(" );
        code.append( TypeNativeRender.getClassCode(className,enhancer) );
        code.append( "," + retDecRender.getVarTypeCode(enhancer) );        
        code.append( "," + getCallConvConstantExpr() );        
	code.append( ")" );
    
        return code;
    }    
    
    public String getSignatureString(String fieldName)
    {
        NativeInstanceFieldMethodSignatureImpl signature = getInstanceFieldMethodSignature();
        String className = signature.getThisClassType().getClassName();
        return className + "." + fieldName + getParamsAsString(); 
    }
    
    public String getDeclarationString()
    {
        NativeInstanceFieldMethodSignatureImpl signature = getInstanceFieldMethodSignature();        
        String callConv = getCallConvDeclarationString();
        String className = signature.getThisClassType().getClassName();        
        return retDecRender.asString() + " " + callConv + " " + className;
    }        
    
    public String generateCallParams(boolean enhancer)
    {
        return "this," + super.generateCallParams(enhancer);
    }
        
    public String getNativeBehaviorInterfaceName()
    {
        return NativeInstanceFieldMethod.class.getName();
    }    
}
