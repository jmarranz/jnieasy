/*
 * InstanceFieldMethodOfClassEnhancer.java
 *
 * Created on 28 de febrero de 2005, 20:52
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.InstanceFieldMethodOfClassImpl;
import javassist.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;


public class InstanceFieldMethodOfClassEnhancer extends FieldMethodOfClassEnhancer
{
    
    /**
     * Creates a new instance of InstanceFieldMethodOfClassEnhancer
     */
    public InstanceFieldMethodOfClassEnhancer(CtField ctBehavior,InstanceFieldMethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(ctBehavior,accessObject,classEnhancer);
    }    
    
    public static InstanceFieldMethodOfClassEnhancer newDefaultInstanceFieldMethodOfClassEnhancer(CtField ctBehavior,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        NativeInstanceFieldMethodSignatureImpl sig = new NativeInstanceFieldMethodSignatureImpl(ctx.getJNIEasy());
        ClassTypeNativeMultipleFieldContainerImpl thisClassType = classEnhancer.getClassTypeMultipleFieldContainer();
        sig.setThisClassType(thisClassType);
        
        return (InstanceFieldMethodOfClassEnhancer)newDefaultFieldMethodOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClass, EnhancerSharedContext ctx)
    {
        return JavaClassAsNativeDirectInstanceFieldCallbackEnhancer.newJavaClassAsNativeDirectInstanceFieldCallbackEnhancer(ctClass,ctx);
    }
}
