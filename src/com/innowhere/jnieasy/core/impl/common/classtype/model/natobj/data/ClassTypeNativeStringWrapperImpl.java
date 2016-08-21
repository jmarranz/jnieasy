/*
 * ClassTypeNativeStringWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringImpl;



public abstract class ClassTypeNativeStringWrapperImpl extends ClassTypeNativeStringBasedWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeStringWrapperImpl
     */
    public ClassTypeNativeStringWrapperImpl(ClassTypeNativeStringImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }

    public static void registerClassTypeStringWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringWrapperDefaultImpl.registerClassTypeStringWrapperDefault(mgr);
        ClassTypeNativeStringAnsiWrapperImpl.registerClassTypeNativeStringAnsiWrapper(mgr);  
        ClassTypeNativeStringUnicodeWrapperImpl.registerClassTypeNativeStringUnicodeWrapper(mgr);        
    }
 
    public ClassTypeNativeStringImpl getClassTypeString()
    {
        return (ClassTypeNativeStringImpl)fieldClassType;
    }
}
