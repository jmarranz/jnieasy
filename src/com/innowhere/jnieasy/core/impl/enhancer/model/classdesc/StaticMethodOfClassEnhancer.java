/*
 * StaticMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:51
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import javassist.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.StaticMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;



public class StaticMethodOfClassEnhancer extends MethodOfClassEnhancer
{
    
    /**
     * Creates a new instance of StaticMethodOfClassImpl 
     */
    public StaticMethodOfClassEnhancer(CtMethod ctBehavior,StaticMethodOfClassImpl accessObject,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(ctBehavior,accessObject,classEnhancer);
    }

    public static StaticMethodOfClassEnhancer newDefaultStaticMethodOfClassEnhancer(CtMethod ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        NativeStaticMethodSignatureImpl sig = new NativeStaticMethodSignatureImpl(ctx.getJNIEasy());
        return (StaticMethodOfClassEnhancer)newDefaultMethodOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }    
    
    public StaticMethodOfClassImpl getStaticMethodOfClass()
    {
        return (StaticMethodOfClassImpl)memberOfClass;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClass, EnhancerSharedContext ctx)
    {
        return JavaClassAsNativeDirectStaticMethodCallbackEnhancer.newJavaClassAsNativeDirectStaticMethodCallbackEnhancer(ctClass,ctx);
    }    
}
