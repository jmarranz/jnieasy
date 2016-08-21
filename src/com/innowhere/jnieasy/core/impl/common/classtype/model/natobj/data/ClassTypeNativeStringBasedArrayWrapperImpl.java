/*
 * ClassTypeNativeStringBasedArrayWrapperImpl.java
 *
 * Created on 11 de febrero de 2005, 11:54
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBasedArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeStringBasedArrayWrapperRuntimeImpl;



public abstract class ClassTypeNativeStringBasedArrayWrapperImpl extends ClassTypeCanBeNativeCapableArrayWrapperImpl 
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedArrayWrapperImpl
     */
    public ClassTypeNativeStringBasedArrayWrapperImpl(ClassTypeNativeStringBasedArrayImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeStringBasedArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringArrayWrapperImpl.registerClassTypeNativeStringArrayWrapper(mgr);
        ClassTypeNativeStringBufferArrayWrapperImpl.registerClassTypeNativeStringBufferArrayWrapper(mgr);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeStringBasedArrayWrapperRuntimeImpl(this,rtMgr);
    }     
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
