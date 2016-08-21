/*
 * ClassTypeNativeStringBasedWrapperImpl.java
 *
 * Created on 11 de febrero de 2005, 11:43
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeStringBasedWrapperRuntimeImpl;


public abstract class ClassTypeNativeStringBasedWrapperImpl extends ClassTypeCanBeNativeCapableWrapperImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedWrapperImpl
     */
    public ClassTypeNativeStringBasedWrapperImpl(ClassTypeNativeStringBasedImpl wrappedClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedClassType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeStringBasedWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringWrapperImpl.registerClassTypeStringWrapper(mgr);
        ClassTypeNativeStringBufferWrapperImpl.registerClassTypeStringBufferWrapper(mgr);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeStringBasedWrapperRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
