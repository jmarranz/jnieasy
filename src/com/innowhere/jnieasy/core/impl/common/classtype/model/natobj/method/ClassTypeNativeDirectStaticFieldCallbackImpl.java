/*
 * FieldType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectStaticFieldCallbackImpl;

/**
 *
 * @author  jmarranz
 */

public abstract class ClassTypeNativeDirectStaticFieldCallbackImpl extends ClassTypeNativeDirectFieldCallbackImpl
{
    
    /** Creates a new instance of FieldType */
    public ClassTypeNativeDirectStaticFieldCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeDirectStaticFieldCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectStaticFieldCallbackDefaultImpl.registerClassTypeNativeDirectStaticFieldCallbackDefault(mgr);
    }
    
    public static ClassTypeNativeDirectStaticFieldCallbackImpl newCustomNativeDirectStaticFieldCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeDirectStaticFieldCallbackCustomImpl.newNativeDirectStaticFieldCallbackCustomType(valueClass.getName(),jniEasy);
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeDirectStaticFieldCallbackImpl(this);
    }
}
