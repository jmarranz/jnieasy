/*
 * ConstructorSignature.java
 *
 * Created on 11 de febrero de 2004, 21:12
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeConstructorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.ConstructorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


public class NativeConstructorSignatureImpl extends NativeBehaviorSignatureImpl
{
    /** Creates a new instance of ConstructorSignature */
    public NativeConstructorSignatureImpl(JNIEasyImpl jniEasy)
    {
        super(jniEasy);
    }        
    
    public boolean equals(Object obj)
    {
        boolean res = super.equals(obj);
        if (!res) return false;

        NativeConstructorSignatureImpl sig2 = (NativeConstructorSignatureImpl)obj;
        
        if (!getThisClassType().equals(sig2.getThisClassType()))
            return false;
        return true;
    }   
    
    public int getFirstParamIndex()
    {
        return 0;
    }
    
    public ClassTypeNativeMultipleFieldContainerImpl getThisClassType()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)returnType.getVarTypeNative().getTypeNative().getClassType();
    }    
        
    public void setThisClassType(ClassTypeNativeMultipleFieldContainerImpl classType)
    {
        returnType = new ReturnDeclarationImpl(ThisClassSignatureUtil.decThisVarTypeNative(classType));
    }    
        
    public static String formNativeDirectCallbackUniqueClassName(String className,String[] params)
    {
        return className + "_" + "_init_" + formUniqueClassNameParams(params);
    }            
    
    public NativeBehaviorSignatureRender newBehaviorSignatureRender()
    {
        return new NativeConstructorSignatureRender(this);
    }
    
    public NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        return new NativeConstructorSignatureRuntimeImpl(this,classRet,classParams,ctx);
    }  
    
    public BehaviorOfClassImpl newBehaviorOfClass(ClassTypeNativeCapableImpl containerClassType) 
    {
        return new ConstructorOfClassImpl(this,(ClassTypeNativeMultipleFieldContainerImpl)containerClassType);
    }    
    
    public NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeEnhancerImpl enhancer)
    {
        return new ConstructorSignatureEnhancerImpl(this, enhancer);
    }    
}
