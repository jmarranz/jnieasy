/*
 * ClassTypeNativeCapableArrayRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public abstract class ClassTypeNativeCapableArrayRuntimeImpl extends ClassTypeNativeObjectArrayRuntimeImpl
{
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayRuntimeImpl
     */
    public ClassTypeNativeCapableArrayRuntimeImpl(ClassTypeNativeCapableArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    

}

