/*
 * ClassTypeNativeNumberObjectArrayImpl.java
 *
 * Created on 3 de febrero de 2005, 11:36
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeNativeNumberObjectArrayImpl extends ClassTypeNativePrimitiveObjectArrayImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberObjectArrayImpl
     */
    public ClassTypeNativeNumberObjectArrayImpl(ClassTypeNativeNumberObjectImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativeNumberObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectArrayImpl.registerClassTypeNativeByteObjectArray(mgr);                
        ClassTypeNativeShortObjectArrayImpl.registerClassTypeNativeShortObjectArray(mgr);        
        ClassTypeNativeIntegerObjectArrayImpl.registerClassTypeNativeIntegerObjectArray(mgr);        
        ClassTypeNativeLongObjectArrayImpl.registerClassTypeNativeLongObjectArray(mgr);        
        ClassTypeNativeFloatObjectArrayImpl.registerClassTypeNativeFloatObjectArray(mgr);                
        ClassTypeNativeDoubleObjectArrayImpl.registerClassTypeNativeDoubleObjectArray(mgr);        
    }
}
