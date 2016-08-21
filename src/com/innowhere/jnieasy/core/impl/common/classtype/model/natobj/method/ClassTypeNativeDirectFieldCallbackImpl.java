/*
 * ClassTypeNativeDirectFieldCallbackImpl.java
 *
 * Created on 1 de abril de 2005, 12:44
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;


public abstract class ClassTypeNativeDirectFieldCallbackImpl extends ClassTypeNativeDirectCallbackImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDirectFieldCallbackImpl
     */
    public ClassTypeNativeDirectFieldCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeDirectFieldCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectStaticFieldCallbackImpl.registerClassTypeNativeDirectStaticFieldCallback(mgr);
        ClassTypeNativeDirectInstanceFieldCallbackImpl.registerNativeDirectInstanceFieldCallback(mgr); 
    }
    
    public static ClassTypeNativeDirectFieldCallbackImpl newCustomNativeDirectFieldCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        if (MetaClassWrapper.isAssignableFrom(NativeDirectStaticFieldCallback.class,valueClass))
            return ClassTypeNativeDirectStaticFieldCallbackImpl.newCustomNativeDirectStaticFieldCallbackType(valueClass,jniEasy);
        else if (MetaClassWrapper.isAssignableFrom(NativeDirectInstanceFieldCallback.class,valueClass))
            return ClassTypeNativeDirectInstanceFieldCallbackImpl.newCustomNativeDirectInstanceFieldCallbackType(valueClass,jniEasy);        
        return null;
    }

}
