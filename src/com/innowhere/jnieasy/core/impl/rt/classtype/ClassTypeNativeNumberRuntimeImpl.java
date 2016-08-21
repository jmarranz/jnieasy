/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeNumberImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeNumberRuntimeImpl extends ClassTypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeNumberRuntimeImpl
     */
    public ClassTypeNativeNumberRuntimeImpl(ClassTypeNativeNumberImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
