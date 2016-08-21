/*
 * ConstructorWrapperType.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeBehaviorReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.*;



public abstract class ClassTypeNativeBehaviorReflectionArrayWrapperImpl extends ClassTypeNativeMemberReflectionArrayWrapperImpl
{
    /** Creates a new instance of ConstructorWrapperType */
    public ClassTypeNativeBehaviorReflectionArrayWrapperImpl(ClassTypeNativeBehaviorReflectionArrayImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeBehaviorReflectionArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionArrayWrapperImpl.registerClassTypeNativeConstructorReflectionArrayWrapper(mgr);
        ClassTypeNativeMethodReflectionArrayWrapperImpl.registerClassTypeNativeMethodReflectionArrayWrapper(mgr);      
        ClassTypeNativeFieldMethodReflectionArrayWrapperImpl.registerClassTypeNativeFieldMethodReflectionArrayWrapper(mgr);        
    }
}
