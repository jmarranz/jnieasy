/*
 * ClassTypeNativeNumberWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 11:28
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeNumberImpl;

public abstract class ClassTypeNativeNumberWrapperImpl extends ClassTypeNativePrimitiveWrapperImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberWrapperImpl
     */
    public ClassTypeNativeNumberWrapperImpl(ClassTypeNativeNumberImpl fieldClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(fieldClassType,classTypeMgr);
    }
    
    public static void registerClassTypeNativeNumberWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteWrapperImpl.registerClassTypeNativeByteWrapper(mgr);
        ClassTypeNativeShortWrapperImpl.registerClassTypeNativeShortWrapper(mgr);
        ClassTypeNativeIntegerWrapperImpl.registerClassTypeNativeIntegerWrapper(mgr);
        ClassTypeNativeLongWrapperImpl.registerClassTypeNativeLongWrapper(mgr);
        ClassTypeNativeFloatWrapperImpl.registerClassTypeNativeFloatWrapper(mgr);
        ClassTypeNativeDoubleWrapperImpl.registerClassTypeNativeDoubleWrapper(mgr);        
    }    
}
