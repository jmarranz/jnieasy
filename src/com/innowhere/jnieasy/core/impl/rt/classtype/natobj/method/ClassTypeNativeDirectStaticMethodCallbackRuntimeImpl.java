/*
 * ClassTypeNativeDirectStaticMethodCallbackRuntimeImpl.java
 *
 * Created on 22 de junio de 2005, 16:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectStaticMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticMethodCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeDirectStaticMethodCallbackRuntimeImpl extends ClassTypeNativeDirectMethodCallbackRuntimeImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeDirectStaticMethodCallbackRuntimeImpl
     */
    public ClassTypeNativeDirectStaticMethodCallbackRuntimeImpl(ClassTypeNativeDirectStaticMethodCallbackImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
        
    public long getObjectSize()
    {
        return StaticMethodCallbackStateManagerImpl.memorySize();
    }        
}
