/*
 * MethodReflectionType.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeNativeBehaviorReflectionArrayImpl extends ClassTypeNativeMemberReflectionArrayImpl
{
   
    /** Creates a new instance of MethodType */
    public ClassTypeNativeBehaviorReflectionArrayImpl(ClassTypeNativeBehaviorReflectionImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativeBehaviorReflectionArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionArrayImpl.registerClassTypeNativeConstructorReflectionArray(mgr);                
        ClassTypeNativeMethodReflectionArrayImpl.registerClassTypeNativeMethodReflectionArray(mgr);        
        ClassTypeNativeFieldMethodReflectionArrayImpl.registerClassTypeNativeFieldMethodReflectionArray(mgr);         
    }     
}
