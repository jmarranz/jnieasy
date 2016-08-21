/*
 * ClassTypeNativeDirectMethodCallbackImpl.java
 *
 * Created on 1 de abril de 2005, 12:44
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;


public abstract class ClassTypeNativeDirectMethodCallbackImpl extends ClassTypeNativeDirectCallbackImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDirectMethodCallbackImpl
     */
    public ClassTypeNativeDirectMethodCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeDirectMethodCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectStaticMethodCallbackImpl.registerClassTypeNativeDirectStaticMethodCallback(mgr);
        ClassTypeNativeDirectInstanceMethodCallbackImpl.registerClassTypeNativeDirectInstanceMethodCallback(mgr); 
    }
    
    public static ClassTypeNativeDirectMethodCallbackImpl newCustomNativeDirectMethodCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        if (MetaClassWrapper.isAssignableFrom(NativeDirectStaticMethodCallback.class,valueClass))
            return ClassTypeNativeDirectStaticMethodCallbackImpl.newCustomNativeDirectStaticMethodCallbackType(valueClass,jniEasy);
        else if (MetaClassWrapper.isAssignableFrom(NativeDirectInstanceMethodCallback.class,valueClass))
            return ClassTypeNativeDirectInstanceMethodCallbackImpl.newCustomNativeDirectInstanceMethodCallbackType(valueClass,jniEasy);        
        return null;
    }

}
