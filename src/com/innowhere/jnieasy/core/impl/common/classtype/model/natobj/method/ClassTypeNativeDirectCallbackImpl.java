/*
 * ClassTypeNativeDirectCallbackImpl.java
 *
 * Created on 15 de octubre de 2004, 20:48
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;



/**
 *
 * @author  jmarranz
 */


public abstract class ClassTypeNativeDirectCallbackImpl extends ClassTypeNativeCapableImpl
{
//    protected JavaClassAsNativeDirectCallbackImpl javaClass; // Sólo es != null en el caso de user defined (custom)
    
    /**
     * Creates a new instance of ClassTypeNativeDirectCallbackImpl
     */
    public ClassTypeNativeDirectCallbackImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeDirectCallback(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectMethodCallbackImpl.registerClassTypeNativeDirectMethodCallback(mgr);
        ClassTypeNativeDirectConstructorCallbackImpl.registerClassTypeNativeDirectConstructorCallback(mgr);        
        ClassTypeNativeDirectFieldCallbackImpl.registerClassTypeNativeDirectFieldCallback(mgr);        
    }
    
    public static ClassTypeNativeDirectCallbackImpl newCustomClassTypeNativeDirectCallback(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        if (MetaClassWrapper.isAssignableFrom(NativeDirectMethodCallback.class,valueClass))
            return ClassTypeNativeDirectMethodCallbackImpl.newCustomNativeDirectMethodCallbackType(valueClass,jniEasy);
        else if (MetaClassWrapper.isAssignableFrom(NativeDirectConstructorCallback.class,valueClass))
            return ClassTypeNativeDirectConstructorCallbackImpl.newCustomNativeDirectConstructorCallbackType(valueClass,jniEasy);
        else if (MetaClassWrapper.isAssignableFrom(NativeDirectFieldCallback.class,valueClass))
            return ClassTypeNativeDirectFieldCallbackImpl.newCustomNativeDirectFieldCallbackType(valueClass,jniEasy);        
     
        return null;
    }
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeDirectCallback.class,valueClass);
    }
    
    public void setJavaClassAsNativeDirectCallback(JavaClassAsNativeDirectCallbackImpl javaClass)
    {
        this.javaClass = javaClass;
    }    
    
    public JavaClassAsNativeDirectCallbackImpl getJavaClassAsNativeDirectCallback()
    {
        // Sólo es != null en el caso de user defined (custom)
        return (JavaClassAsNativeDirectCallbackImpl)javaClass;
    }
    
    public abstract boolean isCustom();
}
