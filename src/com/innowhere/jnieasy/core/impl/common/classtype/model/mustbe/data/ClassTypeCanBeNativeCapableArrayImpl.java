/*
 * ClassTypeNativeObjectArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionArrayImpl;


public abstract class ClassTypeCanBeNativeCapableArrayImpl extends ClassTypeNativeObjectArrayImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayImpl
     */
    public ClassTypeCanBeNativeCapableArrayImpl(ClassTypeCanBeNativeCapableImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeCanBeNativeCapableArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeMemberReflectionArrayImpl.registerClassTypeNativeMemberReflectionArray(mgr);        
        ClassTypeNativeArrayOfArrayImpl.registerClassTypeNativeArrayOfArray(mgr);   
        ClassTypeNativePrimitiveObjectArrayImpl.registerClassTypeNativePrimitiveObjectArray(mgr);        
        ClassTypeNativeStringBasedArrayImpl.registerClassTypeNativeStringBasedArray(mgr);        
    }    
    
    public static ClassTypeCanBeNativeCapableArrayImpl newCustomCanBeNativeCapableArrayType(MetaClassWrapper valueClass,ClassTypeCanBeNativeCapableImpl classTypeComp,TaskContext ctx)
    {
        return ClassTypeNativeArrayOfArrayImpl.newCustomNativeArrayOfArrayType(valueClass.getName(),(ClassTypeNativeArrayImpl)classTypeComp,ctx);
    }
}
