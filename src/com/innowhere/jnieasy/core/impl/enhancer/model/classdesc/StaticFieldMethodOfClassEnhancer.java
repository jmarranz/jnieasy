/*
 * StaticMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:51
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.StaticFieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import javassist.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;



public class StaticFieldMethodOfClassEnhancer extends FieldMethodOfClassEnhancer
{
    
    /**
     * Creates a new instance of StaticMethodOfClassImpl 
     */
    public StaticFieldMethodOfClassEnhancer(CtField ctBehavior,StaticFieldMethodOfClassImpl accessObject,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(ctBehavior,accessObject,classEnhancer);
    }

    public static StaticFieldMethodOfClassEnhancer newDefaultStaticFieldMethodOfClassEnhancer(CtField ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        NativeStaticFieldMethodSignatureImpl sig = new NativeStaticFieldMethodSignatureImpl(ctx.getJNIEasy());
        return (StaticFieldMethodOfClassEnhancer)newDefaultFieldMethodOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }    
    
    public StaticFieldMethodOfClassImpl getStaticFieldMethodOfClass()
    {
        return (StaticFieldMethodOfClassImpl)memberOfClass;
    }

    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClass, EnhancerSharedContext ctx)
    {
        return JavaClassAsNativeDirectStaticFieldCallbackEnhancer.newJavaClassAsNativeDirectStaticFieldCallbackEnhancer(ctClass,ctx);
    }
}
