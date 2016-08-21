/*
 * ClassTypeNativeMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionImpl;


/**
 *
 * @author  jmarranz
 */


public abstract class ClassTypeNativeMethodReflectionWrapperImpl extends ClassTypeNativeBehaviorReflectionWrapperImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeMethodReflectionWrapperImpl
     */
    public ClassTypeNativeMethodReflectionWrapperImpl(ClassTypeNativeMethodReflectionImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public ClassTypeNativeMethodReflectionImpl getClassTypeNativeMethodReflection()
    {
        return (ClassTypeNativeMethodReflectionImpl)fieldClassType;
    }
            
    public static void registerClassTypeNativeMethodReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeMethodReflectionWrapperDefaultImpl.registerClassTypeNativeMethodReflectionWrapperDefault(mgr);
        ClassTypeNativeStaticMethodReflectionWrapperImpl.registerClassTypeNativeStaticMethodReflectionWrapper(mgr);
        ClassTypeNativeInstanceMethodReflectionWrapperImpl.registerClassTypeNativeInstanceMethodReflectionWrapper(mgr); 
    }

}
