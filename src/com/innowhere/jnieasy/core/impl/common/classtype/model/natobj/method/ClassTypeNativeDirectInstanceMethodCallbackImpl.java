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
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectInstanceMethodCallbackImpl;

/**
 *
 * @author  jmarranz
 */

public abstract class ClassTypeNativeDirectInstanceMethodCallbackImpl extends ClassTypeNativeDirectMethodCallbackImpl
{
   
    /** Creates a new instance of MethodType */
    public ClassTypeNativeDirectInstanceMethodCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeDirectInstanceMethodCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl.registerClassTypeNativeDirectInstanceMethodCallbackDefault(mgr);
    }
    
    public static ClassTypeNativeDirectInstanceMethodCallbackImpl newCustomNativeDirectInstanceMethodCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeDirectInstanceMethodCallbackCustomImpl.newNativeDirectInstanceMethodCallbackCustomType(valueClass.getName(),jniEasy);
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeDirectInstanceMethodCallbackImpl(this);
    }  
}
