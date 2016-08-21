/*
 * ClassTypeNativeConstructorReflectionRuntimeImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeConstructorReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.ConstructorCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import java.lang.reflect.Constructor;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeConstructorReflectionRuntimeImpl extends ClassTypeNativeBehaviorReflectionRuntimeImpl
{
  
    /**
     * Creates a new instance of ClassTypeNativeConstructorReflectionRuntimeImpl
     */
    public ClassTypeNativeConstructorReflectionRuntimeImpl(ClassTypeNativeConstructorReflectionImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public long getObjectSize()
    {
        return ConstructorCallbackStateManagerImpl.memorySize();
    }  
   
}
