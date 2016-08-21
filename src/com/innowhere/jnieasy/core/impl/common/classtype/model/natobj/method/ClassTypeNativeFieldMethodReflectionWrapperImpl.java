/*
 * ConstructorWrapperType.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionImpl;




public abstract class ClassTypeNativeFieldMethodReflectionWrapperImpl extends ClassTypeNativeBehaviorReflectionWrapperImpl
{
    /** Creates a new instance of ConstructorWrapperType */
    public ClassTypeNativeFieldMethodReflectionWrapperImpl(ClassTypeNativeFieldMethodReflectionImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public ClassTypeNativeFieldMethodReflectionImpl getClassTypeNativeFieldMethodReflection()
    {
        return (ClassTypeNativeFieldMethodReflectionImpl)fieldClassType;
    }
    
    public static void registerClassTypeNativeFieldMethodReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFieldMethodReflectionWrapperDefaultImpl.registerClassTypeNativeFieldMethodReflectionWrapperDefault(mgr);
        ClassTypeNativeStaticFieldMethodReflectionWrapperImpl.registerClassTypeNativeStaticFieldMethodReflectionWrapper(mgr);
        ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl.registerClassTypeNativeInstanceFieldMethodReflectionWrapper(mgr); 
    }

}
