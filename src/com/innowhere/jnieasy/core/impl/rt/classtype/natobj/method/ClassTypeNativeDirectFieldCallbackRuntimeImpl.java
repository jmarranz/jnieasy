/*
 * ClassTypeNativeDirectFieldCallbackRuntimeImpl.java
 *
 * Created on 22 de junio de 2005, 16:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;




/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeDirectFieldCallbackRuntimeImpl extends ClassTypeNativeDirectCallbackRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDirectFieldCallbackRuntimeImpl
     */
    public ClassTypeNativeDirectFieldCallbackRuntimeImpl(ClassTypeNativeDirectFieldCallbackImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
