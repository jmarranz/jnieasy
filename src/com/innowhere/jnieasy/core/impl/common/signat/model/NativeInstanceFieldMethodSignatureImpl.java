/*
 * NativeInstanceFieldMethodSignatureImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classdesc.model.InstanceFieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeInstanceFieldMethodSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeInstanceFieldMethodSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceFieldMethodSignatureRuntimeImpl;
import java.util.ArrayList;
import java.util.List;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


/**
 *
 * @author jmarranz
 */
public class NativeInstanceFieldMethodSignatureImpl extends NativeFieldMethodSignatureImpl
{
    
    /**
     * Creates a new instance of NativeInstanceFieldMethodSignatureImpl
     */
    public NativeInstanceFieldMethodSignatureImpl(JNIEasyImpl jniEasy)
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

        NativeInstanceFieldMethodSignatureImpl sig2 = (NativeInstanceFieldMethodSignatureImpl)obj;
        
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
        return new NativeInstanceFieldMethodSignatureRender(this);
    }

    public NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        return new NativeInstanceFieldMethodSignatureRuntimeImpl(this,classRet,classParams,ctx);
    }
    
    public BehaviorOfClassImpl newBehaviorOfClass(ClassTypeNativeCapableImpl containerClassType) 
    {
        return new InstanceFieldMethodOfClassImpl(this,(ClassTypeNativeMultipleFieldContainerImpl)containerClassType);
    } 

    public NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeEnhancerImpl enhancer)
    {
        return new NativeInstanceFieldMethodSignatureEnhancerImpl(this,enhancer);
    }
    
}
