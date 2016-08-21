/*
 * ClassTypeNativeNumberImpl.java
 *
 * Created on 3 de febrero de 2005, 11:19
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;

/**
 *
 * @author  jmarranz
 */
public abstract class ClassTypeNativeNumberImpl extends ClassTypeNativePrimitiveImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberImpl
     */
    public ClassTypeNativeNumberImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeNumber(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteImpl.registerClassTypeNativeByte(mgr);
        ClassTypeNativeShortImpl.registerClassTypeNativeShort(mgr);
        ClassTypeNativeIntegerImpl.registerClassTypeNativeInteger(mgr);
        ClassTypeNativeLongImpl.registerClassTypeNativeLong(mgr);
        ClassTypeNativeFloatImpl.registerClassTypeNativeFloat(mgr);
        ClassTypeNativeDoubleImpl.registerClassTypeNativeDouble(mgr);
    }
    
}
