/*
 * ClassTypeCanBeNativeCapableArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMemberReflectionArrayWrapperImpl;



public abstract class ClassTypeCanBeNativeCapableArrayWrapperImpl extends ClassTypeNativeObjectArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeCanBeNativeCapableArrayWrapperImpl
     */
    public ClassTypeCanBeNativeCapableArrayWrapperImpl(ClassTypeCanBeNativeCapableArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeCanBeNativeCapableArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveObjectArrayWrapperImpl.registerClassTypeNativePrimitiveObjectArrayWrapper(mgr);
        ClassTypeNativeStringBasedArrayWrapperImpl.registerClassTypeNativeStringBasedArrayWrapper(mgr);
        ClassTypeNativeMemberReflectionArrayWrapperImpl.registerClassTypeNativeMemberReflectionArrayWrapper(mgr);
        ClassTypeNativeArrayOfArrayWrapperImpl.registerClassTypeNativeArrayOfArrayWrapper(mgr);
    }
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(CanBeNativeCapableArray.class,valueClass);
    }    

    public static ClassTypeCanBeNativeCapableArrayWrapperImpl newCustomClassTypeCanBeNativeCapableArrayWrapper(MetaClassWrapper valueClass,String arrayClassName,ClassTypeCanBeNativeCapableImpl compType,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeArrayOfArrayWrapperCustomImpl.newClassTypeNativeArrayOfArrayWrapperCustom(valueClass.getName(),arrayClassName,(ClassTypeNativeArrayImpl)compType,jniEasy);
    }

}
