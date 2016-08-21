/*
 * InstanceMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:52
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import javassist.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.InstanceMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;




public class InstanceMethodOfClassEnhancer extends MethodOfClassEnhancer
{
    
    /**
     * Creates a new instance of InstanceMethodOfClassImpl
     */
    public InstanceMethodOfClassEnhancer(CtMethod ctBehavior,InstanceMethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(ctBehavior,accessObject,classEnhancer);
    }    
    
    public static InstanceMethodOfClassEnhancer newDefaultInstanceMethodOfClassEnhancer(CtMethod ctBehavior,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        NativeInstanceMethodSignatureImpl sig = new NativeInstanceMethodSignatureImpl(ctx.getJNIEasy());
        ClassTypeNativeMultipleFieldContainerImpl thisClassType = classEnhancer.getClassTypeMultipleFieldContainer();
        sig.setThisClassType(thisClassType);
        
        return (InstanceMethodOfClassEnhancer)newDefaultMethodOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }
    
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClass, EnhancerSharedContext ctx)
    {
        return JavaClassAsNativeDirectInstanceMethodCallbackEnhancer.newJavaClassAsNativeDirectInstanceMethodCallbackEnhancer(ctClass,ctx);
    }
}
