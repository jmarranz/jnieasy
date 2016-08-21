/*
 * InstanceFieldMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:52
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.InstanceFieldMethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import javassist.CtField;
import javassist.CtMember;


public class InstanceFieldMethodOfClassImpl extends FieldMethodOfClassImpl
{
    
    /**
     * Creates a new instance of InstanceFieldMethodOfClassImpl
     */
    public InstanceFieldMethodOfClassImpl(NativeInstanceFieldMethodSignatureImpl signature,ClassTypeNativeMultipleFieldContainerImpl containerClassType)
    {
        super(signature,containerClassType);
    }


    public MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }        
 
    public BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer javaClassEnh)
    {
        return new InstanceFieldMethodOfClassEnhancer((CtField)ctBehavior,this,(JavaClassAsNativeMultipleFieldContainerEnhancer)javaClassEnh);
    }    
}
