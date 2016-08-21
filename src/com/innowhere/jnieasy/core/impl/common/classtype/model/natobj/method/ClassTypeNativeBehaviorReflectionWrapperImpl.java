/*
 * ConstructorWrapperType.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeBehaviorReflectionImpl;



public abstract class ClassTypeNativeBehaviorReflectionWrapperImpl extends ClassTypeNativeMemberReflectionWrapperImpl
{
    /** Creates a new instance of ConstructorWrapperType */
    public ClassTypeNativeBehaviorReflectionWrapperImpl(ClassTypeNativeBehaviorReflectionImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeBehaviorReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionWrapperImpl.registerClassTypeNativeConstructorReflectionWrapper(mgr);
        ClassTypeNativeMethodReflectionWrapperImpl.registerClassTypeNativeMethodReflectionWrapper(mgr);      
        ClassTypeNativeFieldMethodReflectionWrapperImpl.registerClassTypeNativeFieldMethodReflectionWrapper(mgr);        
    }

}
