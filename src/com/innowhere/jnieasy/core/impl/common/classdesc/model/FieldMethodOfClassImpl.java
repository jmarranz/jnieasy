/*
 * MethodDec.java
 *
 * Created on 28 de febrero de 2005, 20:31
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.BehaviorOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldMethodOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Member;



public abstract class FieldMethodOfClassImpl extends BehaviorOfClassImpl
{
    /** Creates a new instance of MethodDec */
    public FieldMethodOfClassImpl(NativeFieldMethodSignatureImpl signature,ClassTypeNativeCapableImpl containerClassType)
    {
        super(signature,containerClassType);
    }

    public static FieldMethodOfClassImpl newFieldMethodOfClass(NativeFieldMethodSignatureImpl sig,ClassTypeNativeCapableImpl containerClassType)
    {
        return (FieldMethodOfClassImpl)sig.newBehaviorOfClass(containerClassType);
    }
        
    public boolean mustHaveName()
    {
        return true;
    }  
    
    public NativeFieldMethodSignatureImpl getFieldMethodSignature()
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }    
    
    public BehaviorOfClassRuntimeImpl newBehaviorOfClassRuntime(JavaClassAsNativeCapableRuntimeImpl javaClass,Member member,NativeBehaviorSignatureRuntimeImpl sig) 
    {
        return new FieldMethodOfClassRuntimeImpl(javaClass,this,(Field)member,(NativeFieldMethodSignatureRuntimeImpl)sig);
    }    
    
}
