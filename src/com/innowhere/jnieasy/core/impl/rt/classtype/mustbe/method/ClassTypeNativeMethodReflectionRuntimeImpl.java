/*
 * ClassTypeNativeMethodReflectionRuntimeImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import java.lang.reflect.Method;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeMethodReflectionRuntimeImpl extends ClassTypeNativeBehaviorReflectionRuntimeImpl
{
   
    /** Creates a new instance of MethodType */
    public ClassTypeNativeMethodReflectionRuntimeImpl(ClassTypeNativeMethodReflectionImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    
    
    public long getObjectSize()
    {
        // desconocemos aqu� si es est�tico o no
        throw new JNIEasyException("Unknown size");
    }    
}
