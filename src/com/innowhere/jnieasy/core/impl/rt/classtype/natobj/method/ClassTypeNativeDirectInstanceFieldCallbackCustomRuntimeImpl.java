/*
 * ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl.java
 *
 * Created on 22 de junio de 2005, 16:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectInstanceFieldCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl extends ClassTypeNativeDirectInstanceFieldCallbackRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
   
    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl
     */
    public ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl(ClassTypeNativeDirectInstanceFieldCallbackCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeNativeDirectInstanceFieldCallbackCustomImpl getClassTypeNativeDirectInstanceFieldCallbackCustom()
    {
        return (ClassTypeNativeDirectInstanceFieldCallbackCustomImpl)classType;
    }

    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        return new JavaClassAsNativeDirectInstanceFieldCallbackRuntimeImpl((JavaClassAsNativeDirectInstanceFieldCallbackImpl)getClassTypeNativeDirectInstanceFieldCallbackCustom().getJavaClassAsNativeCapable(),this);
    }

}
