/*
 * ClassTypeNativeNumberArrayWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 11:23
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeNumberArrayImpl;


public abstract class ClassTypeNativeNumberArrayWrapperImpl extends ClassTypeNativePrimitiveArrayWrapperImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberArrayWrapperImpl
     */
    public ClassTypeNativeNumberArrayWrapperImpl(ClassTypeNativeNumberArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeNumberArrayWrapper(ClassTypeManagerImpl mgr)
    {        
        ClassTypeNativeByteArrayWrapperImpl.registerClassTypeNativeByteArrayWrapper(mgr);        
        ClassTypeNativeShortArrayWrapperImpl.registerClassTypeNativeShortArrayWrapper(mgr);
        ClassTypeNativeIntegerArrayWrapperImpl.registerClassTypeNativeIntegerArrayWrapper(mgr);
        ClassTypeNativeLongArrayWrapperImpl.registerClassTypeNativeLongArrayWrapper(mgr);
        ClassTypeNativeFloatArrayWrapperImpl.registerClassTypeNativeFloatArrayWrapper(mgr);
        ClassTypeNativeDoubleArrayWrapperImpl.registerClassTypeNativeDoubleArrayWrapper(mgr);    
    }
}
