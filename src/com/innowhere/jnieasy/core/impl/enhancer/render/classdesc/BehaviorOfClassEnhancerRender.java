/*
 * BehaviorOfClassEnhancerRender.java
 *
 * Created on 13 de octubre de 2004, 17:57
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeMultipleFieldContainerEnhancerImpl;




public abstract class BehaviorOfClassEnhancerRender extends MemberOfClassEnhancerRender
{
    protected NativeBehaviorSignatureRender signatureRender;
    
    /**
     * Creates a new instance of BehaviorOfClassEnhancerRender 
     */    
    public BehaviorOfClassEnhancerRender(BehaviorOfClassEnhancer behaviorEnhancer)
    {
        super(behaviorEnhancer);
        
        NativeBehaviorSignatureImpl sig = behaviorEnhancer.getBehaviorOfClass().getBehaviorSignature();
        this.signatureRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(sig);
    }
    
    public static BehaviorOfClassEnhancerRender newBehaviorOfClassEnhancerRender(BehaviorOfClassEnhancer behaviorEnhancer)
    {
        return behaviorEnhancer.newBehaviorOfClassEnhancerRender();
    }
    
    public BehaviorOfClassEnhancer getBehaviorOfClassEnhancer()
    {
        return (BehaviorOfClassEnhancer)accessObjectEnh;
    }
    
    public String getContainerClassName()
    {
        return getBehaviorOfClassEnhancer().getJavaClassAsNativeCapableEnhancer().getClassTypeNativeCapable().getClassName();
    }
    
    public NativeBehaviorSignatureRender getBehaviorSignatureRender()
    {
        return signatureRender;
    }
    
    public abstract String getAddMethodCallName();
    public abstract String getMethodNameParam();
    
    public String getAddMethodCall(boolean isDirectCallback)
    {
        BehaviorOfClassEnhancer behaviorEnh = getBehaviorOfClassEnhancer();

        String javaClassContainer = getContainerClassName();
        StringBuffer code = new StringBuffer();        
        code.append( getAddMethodCallName() + "(" );
        code.append( "jnieasyClassInfo" );
        code.append( ",\"" + javaClassContainer + "\"" );
        code.append( getMethodNameParam() );
        code.append( "," + behaviorEnh.isExportMethod() );
   
        if (!isDirectCallback)
        {
            code.append( "," + behaviorEnh.isOnLibrary() );
            code.append( "," + behaviorEnh.isUseReflection() );        
            String nativeName = behaviorEnh.getBehaviorOfClass().getNativeNameExpr();
            if (nativeName == null) nativeName = "null";
            else nativeName = "\"" + nativeName + "\"";
            code.append( "," + nativeName );        
        }
        code.append( signatureRender.getDeclareSignatureCode(true) );
        code.append( "); \n" );

        return code.toString();        
    }
       
    public void enhanceDLLBasedBehavior(EnhancerSourceFileContext ctx)
    {
        BehaviorOfClassEnhancer behaviorEnh = getBehaviorOfClassEnhancer();     
        int index = behaviorEnh.getIndex();
        String methodRef = NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getNativeBehavior(jnieasyClassInfo," + index + ")";
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( signatureRender.getNativeBehaviorCallAndReturnSentence(methodRef,true) + " \n" );    
        body.append( "}" ); 
        
        setDLLBasedBehaviorBody(body.toString());       
    }

    public abstract void setDLLBasedBehaviorBody(String body);
}
