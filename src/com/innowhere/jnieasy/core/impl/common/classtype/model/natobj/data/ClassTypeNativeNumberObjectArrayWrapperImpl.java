/*
 * ClassTypeNativeNumberObjectArrayWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 11:25
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeNumberObjectArrayImpl;


public abstract class ClassTypeNativeNumberObjectArrayWrapperImpl extends ClassTypeNativePrimitiveObjectArrayWrapperImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberObjectArrayWrapperImpl
     */
    public ClassTypeNativeNumberObjectArrayWrapperImpl(ClassTypeNativeNumberObjectArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType, classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeNumberObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectArrayWrapperImpl.registerClassTypeNativeByteObjectArrayWrapper(mgr);
        ClassTypeNativeShortObjectArrayWrapperImpl.registerClassTypeNativeShortObjectArrayWrapper(mgr);
        ClassTypeNativeIntegerObjectArrayWrapperImpl.registerClassTypeNativeIntegerObjectArrayWrapper(mgr);
        ClassTypeNativeLongObjectArrayWrapperImpl.registerClassTypeNativeLongObjectArrayWrapper(mgr);
        ClassTypeNativeFloatObjectArrayWrapperImpl.registerClassTypeNativeFloatObjectArrayWrapper(mgr);
        ClassTypeNativeDoubleObjectArrayWrapperImpl.registerClassTypeNativeDoubleObjectArrayWrapper(mgr);
    }        
}
