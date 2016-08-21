/*
 * StaticMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:51
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.StaticFieldMethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.StaticFieldMethodOfClassGen;
import javassist.CtField;
import javassist.CtMember;


public class StaticFieldMethodOfClassImpl extends FieldMethodOfClassImpl
{
    
    /**
     * Creates a new instance of StaticMethodOfClassImpl 
     */
    public StaticFieldMethodOfClassImpl(NativeStaticFieldMethodSignatureImpl signature,ClassTypeNativeCapableImpl containerClassType)
    {
        super(signature,containerClassType);
    }
    
    public static StaticFieldMethodOfClassImpl newStaticFieldMethodOfClass(NativeStaticFieldMethodSignatureImpl sig,ClassTypeNativeCapableImpl containerClassType)
    {
        return new StaticFieldMethodOfClassImpl(sig,containerClassType);        
    }

    public NativeStaticFieldMethodSignatureImpl getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
    
    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }    

    public MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new StaticFieldMethodOfClassGen(this,classGen);
    }
    
    public BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer javaClassEnh)
    {
        return new StaticFieldMethodOfClassEnhancer((CtField)ctBehavior,this,javaClassEnh);
    }
    
}
