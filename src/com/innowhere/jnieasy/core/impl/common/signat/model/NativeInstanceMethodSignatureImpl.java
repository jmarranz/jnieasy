/*
 * NativeInstanceMethodSignatureImpl.java
 *
 * Created on 11 de febrero de 2004, 21:56
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.InstanceMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeInstanceMethodSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeInstanceMethodSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceMethodSignatureRuntimeImpl;
import java.util.ArrayList;
import java.util.List;

public class NativeInstanceMethodSignatureImpl extends NativeMethodSignatureImpl
{
    /**
     * Creates a new instance of NativeInstanceMethodSignatureImpl
     */
    public NativeInstanceMethodSignatureImpl(JNIEasyImpl jniEasy)
    {
        super(jniEasy);
    }     
    
    public boolean isStatic()
    {
        return false;
    }
    
    public boolean equals(Object obj)
    {
        boolean res = super.equals(obj);
        if (!res) return false;

        NativeInstanceMethodSignatureImpl sig2 = (NativeInstanceMethodSignatureImpl)obj;
        
        if (!getThisClassType().equals(sig2.getThisClassType()))
            return false;
        return true;
    }    

    public ClassTypeNativeMultipleFieldContainerImpl getThisClassType()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)super.getParameterDec(0).getVarTypeNative().getTypeNative().getClassType();
    }
    
    public void setThisClassType(ClassTypeNativeMultipleFieldContainerImpl classType)
    {
        paramDecList.addParameterDec(0,new ParameterDecImpl(ThisClassSignatureUtil.decThisVarTypeNative(classType)));
    }
    
    public ParameterDecImpl getParameterDec(int index)
    {
        // Sumamos +1 porque el primer parámetro es del objeto (this), pero no 
        // es el primer parámetro desde el punto de vista de la función C++
        return super.getParameterDec(index + 1);
    }
    
    public int getParameterCount()
    {
        return super.getParameterCount() - 1;
    }
    
    public List getParameters()    
    {
        ArrayList paramList = paramDecList.getParameterDecList();
        return paramList.subList(1, paramList.size());        
    }  
    
    public int getFirstParamIndex()
    {
        return 1;
    }    
    
    public NativeBehaviorSignatureRender newBehaviorSignatureRender()
    {
        return new NativeInstanceMethodSignatureRender(this);
    }

    public NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        return new NativeInstanceMethodSignatureRuntimeImpl(this,classRet,classParams,ctx);
    }
    
    public BehaviorOfClassImpl newBehaviorOfClass(ClassTypeNativeCapableImpl containerClassType) 
    {
        return new InstanceMethodOfClassImpl(this,(ClassTypeNativeMultipleFieldContainerImpl)containerClassType);
    }
    
    public NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeEnhancerImpl enhancer)
    {
        return new NativeInstanceMethodSignatureEnhancerImpl(this,enhancer);
    }    
}
