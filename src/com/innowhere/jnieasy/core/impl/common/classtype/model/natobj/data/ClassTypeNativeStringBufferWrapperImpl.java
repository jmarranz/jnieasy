/*
 * ClassTypeNativeStringBufferWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferImpl;


public abstract class ClassTypeNativeStringBufferWrapperImpl extends ClassTypeNativeStringBasedWrapperImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeStringBufferWrapperImpl
     */
    public ClassTypeNativeStringBufferWrapperImpl(ClassTypeNativeStringBufferImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }

    public static void registerClassTypeStringBufferWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferWrapperDefaultImpl.registerClassTypeStringBufferWrapperDefault(mgr);        
        ClassTypeNativeStringBufferAnsiWrapperImpl.registerClassTypeNativeStringBufferAnsiWrapper(mgr);  
        ClassTypeNativeStringBufferUnicodeWrapperImpl.registerClassTypeNativeStringBufferUnicodeWrapper(mgr);        
    }
/*    
    public static ClassTypeNativeStringBufferImpl getClassTypeStringBuffer(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeStringBufferImpl)mgr.findClassType(ClassTypeNativeStringBufferImpl.CLASS.getName());
    }
*/    
    public ClassTypeNativeStringBufferImpl getClassTypeStringBuffer()
    {
        return (ClassTypeNativeStringBufferImpl)fieldClassType;
    }
}
