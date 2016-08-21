/*
 * ConstructorDec.java
 *
 * Created on 28 de febrero de 2005, 20:33
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.ConstructorOfClassGen;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeConstructorSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.ConstructorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.BehaviorOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.ConstructorOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import javassist.CtConstructor;
import javassist.CtMember;

public class ConstructorOfClassImpl extends BehaviorOfClassImpl
{
    /** Creates a new instance of ConstructorDec */
    public ConstructorOfClassImpl(NativeConstructorSignatureImpl signature,ClassTypeNativeMultipleFieldContainerImpl containerClassType)
    {
        super(signature,containerClassType);
    }
    
    public static ConstructorOfClassImpl newConstructorOfClass(NativeConstructorSignatureImpl sig,ClassTypeNativeMultipleFieldContainerImpl containerClassType)
    {
        return new ConstructorOfClassImpl(sig,containerClassType);
    }

    public boolean mustHaveName()
    {
        return false;
    }
    
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)signature;
    }    
    
    public void setConstructorSignature(NativeConstructorSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }        
    
    public String getName()
    {
        return NativeConstructorSignatureRender.NAME;
    }    
    
    public void setName(String name)
    {
        if (!NativeConstructorSignatureRender.NAME.equals(name))
            throw new JNIEasyException("Not valid constructor name: " + name);
    }    
    
    public MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new ConstructorOfClassGen(this,classGen);
    }
        
    public BehaviorOfClassRuntimeImpl newBehaviorOfClassRuntime(JavaClassAsNativeCapableRuntimeImpl javaClass,Member member,NativeBehaviorSignatureRuntimeImpl sig) 
    {
        return new ConstructorOfClassRuntimeImpl(javaClass,this,(Constructor)member,(NativeConstructorSignatureRuntimeImpl)sig);
    }    
    
    public BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer javaClassEnh)
    {
        return new ConstructorOfClassEnhancer((CtConstructor)ctBehavior,this,(JavaClassAsNativeMultipleFieldContainerEnhancer)javaClassEnh);
    }    
}
