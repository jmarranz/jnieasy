/*
 * ClassTypeNativeBehaviorReflectionRuntimeImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeBehaviorReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public abstract class ClassTypeNativeBehaviorReflectionRuntimeImpl extends ClassTypeNativeMemberReflectionRuntimeImpl
{
   
    /** Creates a new instance of ClassTypeNativeBehaviorReflectionRuntimeImpl */
    public ClassTypeNativeBehaviorReflectionRuntimeImpl(ClassTypeNativeBehaviorReflectionImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

}
