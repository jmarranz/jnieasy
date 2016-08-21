/*
 * ClassTypeNativeMemberReflectionWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeMemberReflectionWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCanBeNativeCapableWrapperImpl;


public abstract class ClassTypeNativeMemberReflectionWrapperImpl extends ClassTypeCanBeNativeCapableWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeMemberReflectionWrapperImpl
     */
    public ClassTypeNativeMemberReflectionWrapperImpl(ClassTypeNativeMemberReflectionImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeMemberReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBehaviorReflectionWrapperImpl.registerClassTypeNativeBehaviorReflectionWrapper(mgr);
    }   

    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeMemberReflectionWrapperRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
