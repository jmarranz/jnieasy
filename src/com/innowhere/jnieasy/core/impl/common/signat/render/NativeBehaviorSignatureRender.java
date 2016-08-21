/*
 * NativeBehaviorSignatureRender.java
 *
 * Created on 28 de marzo de 2005, 18:11
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.typedec.CallConv;



public abstract class NativeBehaviorSignatureRender
{
    protected NativeBehaviorSignatureImpl signature;
    protected ReturnDeclarationRender retDecRender;
    protected ParameterDecListRender paramDecListRender;
    
    /**
     * Creates a new instance of NativeBehaviorSignatureRender
     */
    public NativeBehaviorSignatureRender(NativeBehaviorSignatureImpl signature)
    {
        this.signature = signature;
      
        this.retDecRender = ReturnDeclarationRender.newReturnDeclarationRender(signature.getReturnDeclaration());
        this.paramDecListRender = ParameterDecListRender.newParameterDecListRender(signature.getParameterDecList());        
    }
    
    public static NativeBehaviorSignatureRender newBehaviorSignatureRender(NativeBehaviorSignatureImpl signature)
    {
        return signature.getBehaviorSignatureRender(); // es un singleton
    }  
    
    public ParameterDecListRender getParameterDecListRender()
    {
        return paramDecListRender;
    }
    
    public ReturnDeclarationRender getReturnDeclarationRender()
    {
        return retDecRender;
    }
    
    public String returnCastToObject(String code)
    {
        return retDecRender.getVarTypeNativeRender().getTypeNativeRender().returnCastToObject(code);
    }    
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
    
    public String getDeclareTypeMethodName()
    {
        return "decBehavior";
    }
    
    public StringBuffer getDeclareSignatureCode(boolean enhancer)    
    {
        StringBuffer code = new StringBuffer();
        code.append( "," );
        code.append( "jnieasyRoot.getSignatureManager()." );
        code.append( getDeclareSignatureCallCode(enhancer) );
        return code;
    }
    
    public String renderPassObjectArrayParams(String paramsArray)
    {    
        int first = signature.getFirstParamIndex();
        return "(" + paramDecListRender.renderPassObjectArrayParams(first,paramsArray) + ")";
    }
    
    public String renderPassParamFromObject(int index,String param)
    {
        int first = signature.getFirstParamIndex();        
        int realIndex = index + first;
        return paramDecListRender.renderPassParamFromObject(realIndex,param);
    }
    
    public abstract StringBuffer getDeclareSignatureCallCode(boolean enhancer);
    
    public abstract String getSignatureString(String methodName);
    
    public String asDeclarationBlockString()
    {
        return "{" + getDeclarationString() + "}";
    }
    
    public abstract String getDeclarationString();
    
    public String getParamsAsString()
    {
        int first = signature.getFirstParamIndex();        
        return "(" + paramDecListRender.getParamsAsString(first) + ")";
    }   
      
    public String getCallConvDeclarationString()
    {
        int callConv = signature.getCallConv();
        if (CallConv.STD_CALL == callConv)        
            return "__stdcall";
        else if (CallConv.C_CALL == callConv)
            return "__cdecl";        
        else
            throw new JNIEasyException("INTERNAL ERROR");
    }    
        
    public String getCallConvConstantExpr()
    {    
        int callConv = signature.getCallConv();
        
        // suponemos que el valor es válido
        String callConvValue;
        if (CallConv.C_CALL == callConv)
            callConvValue = "C_CALL";
        else if (CallConv.STD_CALL == callConv)
            callConvValue = "STD_CALL";
        else
            throw new JNIEasyException("INTERNAL ERROR");
        
        return CallConv.class.getName() + "." + callConvValue;
    }
        
    public String generateCallName()
    {
        // Se redefine
        return retDecRender.generateCallName();
    }    
    
    public String getReturnAndCast()
    {
        return retDecRender.getReturnAndCast();
    }    
    
    public String generateCallParams(boolean enhancer)
    {
        // se redefine
        int index = getFirstParamIndex();  
        return getParameterDecListRender().generateCallParams( index, enhancer );
    }    
    
    public int getFirstParamIndex()
    {
        return getBehaviorSignature().getFirstParamIndex();
    }  
        
    public String getNativeBehaviorCallAndReturnSentence(String methodRef,boolean enhancer)
    {
        return getReturnAndCast() + "((" + getNativeBehaviorInterfaceName() + ")" + methodRef + ")." + generateCallName() + "(" + generateCallParams(enhancer) + ");";
    }    
    
    public abstract String getNativeBehaviorInterfaceName(); 
    
        
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return "";
    }       
}

