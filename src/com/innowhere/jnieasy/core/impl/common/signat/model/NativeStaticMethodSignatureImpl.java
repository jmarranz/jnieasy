/*
 * StaticMethodSignature.java
 *
 * Created on 25 de febrero de 2004, 19:25
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.StaticMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeStaticMethodSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeStaticMethodSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


/**
 *
 * @author  jmarranz
 */


public class NativeStaticMethodSignatureImpl extends NativeMethodSignatureImpl
{
    /** Creates a new instance of StaticMethodSignature */
    public NativeStaticMethodSignatureImpl(JNIEasyImpl jniEasy)
    {
        super(jniEasy);
    }            
    
    public int getFirstParamIndex()
    {
        return 0;
    }        
    
    public boolean isStatic()
    {
        return true;
    }
    
    public NativeBehaviorSignatureRender newBehaviorSignatureRender()
    {
        return new NativeStaticMethodSignatureRender(this);
    }  
    
    public NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        return new NativeStaticMethodSignatureRuntimeImpl(this,classRet,classParams,ctx);
    }    
    
    public BehaviorOfClassImpl newBehaviorOfClass(ClassTypeNativeCapableImpl containerClassType) 
    {
        return new StaticMethodOfClassImpl(this,containerClassType);
    }    
    
    public NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeEnhancerImpl enhancer)
    {
        return new NativeStaticMethodSignatureEnhancerImpl(this,enhancer);
    }    
}
