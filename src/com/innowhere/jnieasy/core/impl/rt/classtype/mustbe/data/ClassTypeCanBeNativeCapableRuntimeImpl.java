/*
 * ClassTypeCanBeNativeCapableRuntimeImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:18
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeObjectRuntimeImpl;


public abstract class ClassTypeCanBeNativeCapableRuntimeImpl extends ClassTypeNativeObjectRuntimeImpl
{
    /**
     * Creates a new instance of ClassTypeCanBeNativeCapableRuntimeImpl 
     */
    public ClassTypeCanBeNativeCapableRuntimeImpl(ClassTypeCanBeNativeCapableImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeCanBeNativeCapableImpl getClassTypeCanBeNativeCapable()
    {
        return (ClassTypeCanBeNativeCapableImpl)classType;
    }
    
    public Object newValue()
    {    
        return getClassTypeCanBeNativeCapable().newValueDefaultClass();
    }    
}
