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
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectConstructorCallbackImpl;




/**
 *
 * @author  jmarranz
 */

public abstract class ClassTypeNativeDirectConstructorCallbackImpl extends ClassTypeNativeDirectCallbackImpl
{
   
    /** Creates a new instance of MethodType */
    public ClassTypeNativeDirectConstructorCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }

    public static void registerClassTypeNativeDirectConstructorCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectConstructorCallbackDefaultImpl.registerClassTypeNativeDirectConstructorCallbackDefault(mgr);
    }
    
    public static ClassTypeNativeDirectConstructorCallbackImpl newCustomNativeDirectConstructorCallbackType(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeDirectConstructorCallbackCustomImpl.newNativeDirectConstructorCallbackCustomType(valueClass.getName(),jniEasy);
    }    
        
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeDirectConstructorCallbackImpl(this);
    }        
}
