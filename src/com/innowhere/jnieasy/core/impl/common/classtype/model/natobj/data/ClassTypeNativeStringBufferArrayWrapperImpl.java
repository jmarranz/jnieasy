/*
 * ClassTypeNativeStringBufferArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferArrayImpl;




public abstract class ClassTypeNativeStringBufferArrayWrapperImpl extends ClassTypeNativeStringBasedArrayWrapperImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeStringBufferArrayWrapperImpl
     */
    public ClassTypeNativeStringBufferArrayWrapperImpl(ClassTypeNativeStringBufferArrayImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType, classTypeMgr,isDefault);
    }

    public static void registerClassTypeNativeStringBufferArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferArrayWrapperDefaultImpl.registerClassTypeNativeStringBufferArrayWrapperDefault(mgr);
        ClassTypeNativeStringBufferAnsiArrayWrapperImpl.registerClassTypeNativeStringBufferAnsiArrayWrapper(mgr);  
        ClassTypeNativeStringBufferUnicodeArrayWrapperImpl.registerClassTypeNativeStringBufferUnicodeArrayWrapper(mgr);        
    }

    public ClassTypeNativeStringBufferArrayImpl getClassTypeNativeStringBufferArray()
    {
        return (ClassTypeNativeStringBufferArrayImpl)fieldClassType;
    }
}
