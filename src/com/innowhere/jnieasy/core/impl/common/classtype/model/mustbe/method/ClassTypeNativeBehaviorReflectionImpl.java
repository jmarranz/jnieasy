/*
 * ClassTypeNativeMethodReflectionImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;



public abstract class ClassTypeNativeBehaviorReflectionImpl extends ClassTypeNativeMemberReflectionImpl
{
   
    /** Creates a new instance of MethodType */
    public ClassTypeNativeBehaviorReflectionImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeBehaviorReflection(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFieldMethodReflectionImpl.registerClassTypeNativeFieldMethodReflection(mgr);        
        ClassTypeNativeConstructorReflectionImpl.registerClassTypeNativeConstructorReflection(mgr);        
        ClassTypeNativeMethodReflectionImpl.registerClassTypeNativeMethodReflection(mgr);        
    }    
}
