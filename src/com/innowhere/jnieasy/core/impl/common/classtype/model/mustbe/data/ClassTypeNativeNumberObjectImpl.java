/*
 * ClassTypeNativeNumberObjectImpl.java
 *
 * Created on 3 de febrero de 2005, 11:39
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeNumberImpl;

public abstract class ClassTypeNativeNumberObjectImpl extends ClassTypeNativePrimitiveObjectImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberObjectImpl
     */
    public ClassTypeNativeNumberObjectImpl(ClassTypeNativeNumberImpl primClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(primClassType,classTypeMgr);
    }
    
    public static void registerClassTypeNativeNumberObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectImpl.registerClassTypeNativeByteObject(mgr);        
        ClassTypeNativeShortObjectImpl.registerClassTypeNativeShortObject(mgr);   
        ClassTypeNativeIntegerObjectImpl.registerClassTypeNativeIntegerObject(mgr);         
        ClassTypeNativeLongObjectImpl.registerClassTypeNativeLongObject(mgr);
        ClassTypeNativeFloatObjectImpl.registerClassTypeNativeFloatObject(mgr);        
        ClassTypeNativeDoubleObjectImpl.registerClassTypeNativeDoubleObject(mgr);             
    }    
}
