/*
 * ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl.java
 *
 * Created on 22 de junio de 2005, 16:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectConstructorCallbackCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeDirectConstructorCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;



/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl extends ClassTypeNativeDirectConstructorCallbackRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
   
    /**
     * Creates a new instance of ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl
     */
    public ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl(ClassTypeNativeDirectConstructorCallbackCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public ClassTypeNativeDirectConstructorCallbackCustomImpl getClassTypeNativeDirectConstructorCallbackCustom()
    {
        return (ClassTypeNativeDirectConstructorCallbackCustomImpl)classType;
    }

    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        return new JavaClassAsNativeDirectConstructorCallbackRuntimeImpl((JavaClassAsNativeDirectConstructorCallbackImpl)getClassTypeNativeDirectConstructorCallbackCustom().getJavaClassAsNativeCapable(),this);
    }    
   
}
