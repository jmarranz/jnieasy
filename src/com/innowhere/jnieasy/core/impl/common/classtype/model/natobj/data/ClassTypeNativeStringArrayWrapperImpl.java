/*
 * ClassTypeNativeStringArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringArrayImpl;

public abstract class ClassTypeNativeStringArrayWrapperImpl extends ClassTypeNativeStringBasedArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeStringArrayWrapperImpl
     */
    public ClassTypeNativeStringArrayWrapperImpl(ClassTypeNativeStringArrayImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }

    public static void registerClassTypeNativeStringArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringArrayWrapperDefaultImpl.registerClassTypeNativeStringArrayWrapperDefault(mgr);        
        ClassTypeNativeStringAnsiArrayWrapperImpl.registerClassTypeNativeStringAnsiArrayWrapper(mgr);  
        ClassTypeNativeStringUnicodeArrayWrapperImpl.registerClassTypeNativeStringUnicodeArrayWrapper(mgr);        
    }

    public ClassTypeNativeStringArrayImpl getClassTypeNativeStringArray()
    {
        return (ClassTypeNativeStringArrayImpl)fieldClassType;
    }
}
