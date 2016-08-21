/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectStaticMethodCallbackImpl;

/**
 *
 * @author  jmarranz
 */


public abstract class ClassTypeNativeDirectStaticMethodCallbackImpl extends ClassTypeNativeDirectMethodCallbackImpl
{
    
    /** Creates a new instance of MethodType */
    public ClassTypeNativeDirectStaticMethodCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeDirectStaticMethodCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectStaticMethodCallbackDefaultImpl.registerClassTypeNativeDirectStaticMethodCallbackDefault(mgr);
    }
    
    public static ClassTypeNativeDirectStaticMethodCallbackImpl newCustomNativeDirectStaticMethodCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeDirectStaticMethodCallbackCustomImpl.newNativeDirectStaticMethodCallbackCustomType(valueClass.getName(),jniEasy);
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeDirectStaticMethodCallbackImpl(this);
    }
}
