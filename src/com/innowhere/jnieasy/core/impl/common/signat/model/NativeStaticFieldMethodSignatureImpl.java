/*
 * NativeStaticFieldMethodSignatureImpl.java
 *
 * Created on 6 de junio de 2005, 21:17
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.StaticFieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeStaticFieldMethodSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeStaticFieldMethodSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


/**
 *
 * @author jmarranz
 */
public class NativeStaticFieldMethodSignatureImpl extends NativeFieldMethodSignatureImpl
{
    
    /**
     * Creates a new instance of NativeStaticFieldMethodSignatureImpl
     */
    public NativeStaticFieldMethodSignatureImpl(JNIEasyImpl jniEasy)
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
        return new NativeStaticFieldMethodSignatureRender(this);
    }  
    
    public NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        return new NativeStaticFieldMethodSignatureRuntimeImpl(this,classRet,classParams,ctx);
    }
    
    public BehaviorOfClassImpl newBehaviorOfClass(ClassTypeNativeCapableImpl containerClassType) 
    {
        return new StaticFieldMethodOfClassImpl(this,containerClassType);
    }      
    
    public NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeEnhancerImpl enhancer)
    {
        return new NativeStaticFieldMethodSignatureEnhancerImpl(this,enhancer);
    }    
}
