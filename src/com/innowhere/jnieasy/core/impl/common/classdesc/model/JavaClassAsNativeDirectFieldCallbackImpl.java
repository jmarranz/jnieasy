/*
 * JavaClassAsNativeDirectFieldCallbackImpl.java
 *
 * Created on 7 de julio de 2005, 18:10
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectFieldCallbackImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectFieldCallbackImpl extends JavaClassAsNativeDirectCallbackImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectFieldCallbackImpl
     */
    public JavaClassAsNativeDirectFieldCallbackImpl(ClassTypeNativeDirectFieldCallbackImpl classType)
    {
        super(classType);
    }

}
