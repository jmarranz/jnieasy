/*
 * ClassTypeNativeFieldMethodReflectionRuntimeImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import java.lang.reflect.Field;



/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeFieldMethodReflectionRuntimeImpl extends ClassTypeNativeBehaviorReflectionRuntimeImpl
{
    /** Creates a new instance of FieldType */
    public ClassTypeNativeFieldMethodReflectionRuntimeImpl(ClassTypeNativeFieldMethodReflectionImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public long getObjectSize()
    {
        // desconocemos aquí si es estático o no
        throw new JNIEasyException("Unknown size");
    }    
}
