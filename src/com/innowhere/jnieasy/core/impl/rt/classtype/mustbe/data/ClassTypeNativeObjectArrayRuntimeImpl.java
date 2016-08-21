/*
 * ClassTypeNativeObjectArrayRuntimeImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public abstract class ClassTypeNativeObjectArrayRuntimeImpl extends ClassTypeNativeArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayRuntimeImpl
     */
    public ClassTypeNativeObjectArrayRuntimeImpl(ClassTypeNativeObjectArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    

}
