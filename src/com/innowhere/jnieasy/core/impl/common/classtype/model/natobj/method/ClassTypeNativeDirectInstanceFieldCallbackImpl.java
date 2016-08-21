/*
 * ClassTypeNativeDirectInstanceFieldCallbackImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectInstanceFieldCallbackImpl;

/**
 *
 * @author  jmarranz
 */

public abstract class ClassTypeNativeDirectInstanceFieldCallbackImpl extends ClassTypeNativeDirectFieldCallbackImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceFieldCallbackImpl
     */
    public ClassTypeNativeDirectInstanceFieldCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerNativeDirectInstanceFieldCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectInstanceFieldCallbackDefaultImpl.registerClassTypeNativeDirectInstanceFieldCallbackDefault(mgr);
    }
    
    public static ClassTypeNativeDirectInstanceFieldCallbackImpl newCustomNativeDirectInstanceFieldCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeDirectInstanceFieldCallbackCustomImpl.newNativeDirectInstanceFieldCallbackCustomType(valueClass.getName(),jniEasy);
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeDirectInstanceFieldCallbackImpl(this);
    }  
}
