/*
 * InstanceMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:52
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.InstanceMethodOfClassGen;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.InstanceMethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import javassist.CtMember;
import javassist.CtMethod;

public class InstanceMethodOfClassImpl extends MethodOfClassImpl
{
    
    /**
     * Creates a new instance of InstanceMethodOfClassImpl
     */
    public InstanceMethodOfClassImpl(NativeInstanceMethodSignatureImpl signature,ClassTypeNativeMultipleFieldContainerImpl containerClassType)
    {
        super(signature,containerClassType);
    }

    
    public MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new InstanceMethodOfClassGen(this,classGen);
    }        
    
    public BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer javaClassEnh)
    {
        return new InstanceMethodOfClassEnhancer((CtMethod)ctBehavior,this,(JavaClassAsNativeMultipleFieldContainerEnhancer)javaClassEnh);
    }  
}
