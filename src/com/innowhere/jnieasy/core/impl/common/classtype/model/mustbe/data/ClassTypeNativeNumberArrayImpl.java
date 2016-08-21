/*
 * ClassTypeNativeNumberArrayImpl.java
 *
 * Created on 3 de febrero de 2005, 11:34
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeNumberImpl;


public abstract class ClassTypeNativeNumberArrayImpl extends ClassTypeNativePrimitiveArrayImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberArrayImpl
     */
    public ClassTypeNativeNumberArrayImpl(ClassTypeNativeNumberImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativeNumberArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteArrayImpl.registerClassTypeNativeByteArray(mgr);               
        ClassTypeNativeShortArrayImpl.registerClassTypeNativeShortArray(mgr);      
        ClassTypeNativeIntegerArrayImpl.registerClassTypeNativeIntegerArray(mgr);
        ClassTypeNativeLongArrayImpl.registerClassTypeNativeLongArray(mgr);         
        ClassTypeNativeFloatArrayImpl.registerClassTypeNativeFloatArray(mgr);        
        ClassTypeNativeDoubleArrayImpl.registerClassTypeNativeDoubleArray(mgr);        
    }   
}
