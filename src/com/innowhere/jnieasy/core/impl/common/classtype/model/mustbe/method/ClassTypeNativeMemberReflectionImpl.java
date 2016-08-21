/*
 * ClassTypeNativeMemberReflectionImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:46
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;

public abstract class ClassTypeNativeMemberReflectionImpl extends ClassTypeCanBeNativeCapableImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeMemberReflectionImpl
     */
    public ClassTypeNativeMemberReflectionImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeMemberReflection(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBehaviorReflectionImpl.registerClassTypeNativeBehaviorReflection(mgr);        
    }          
}
