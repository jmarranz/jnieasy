/*
 * ClassTypeNativeNumberObjectWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 11:27
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeNumberObjectImpl;

public abstract class ClassTypeNativeNumberObjectWrapperImpl extends ClassTypeNativePrimitiveObjectWrapperImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberObjectWrapperImpl
     */
    public ClassTypeNativeNumberObjectWrapperImpl(ClassTypeNativeNumberObjectImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeNumberObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectWrapperImpl.registerClassTypeNativeByteObjectWrapper(mgr);
        ClassTypeNativeShortObjectWrapperImpl.registerClassTypeNativeShortObjectWrapper(mgr);
        ClassTypeNativeIntegerObjectWrapperImpl.registerClassTypeNativeIntegerObjectWrapper(mgr);
        ClassTypeNativeLongObjectWrapperImpl.registerClassTypeNativeLongObjectWrapper(mgr);
        ClassTypeNativeFloatObjectWrapperImpl.registerClassTypeNativeFloatObjectWrapper(mgr);
        ClassTypeNativeDoubleObjectWrapperImpl.registerClassTypeNativeDoubleObjectWrapper(mgr);
    }      
}
