/*
 * ClassTypeNativeDirectInstanceFieldCallbackRuntimeImpl.java
 *
 * Created on 22 de junio de 2005, 16:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeDirectInstanceFieldCallbackRuntimeImpl extends ClassTypeNativeDirectFieldCallbackRuntimeImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceFieldCallbackRuntimeImpl
     */
    public ClassTypeNativeDirectInstanceFieldCallbackRuntimeImpl(ClassTypeNativeDirectInstanceFieldCallbackImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getObjectSize()
    {
        return InstanceFieldCallbackStateManagerImpl.memorySize();
    }      
        
}
