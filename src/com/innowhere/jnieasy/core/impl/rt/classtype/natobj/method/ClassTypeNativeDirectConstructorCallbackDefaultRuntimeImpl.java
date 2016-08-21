/*
 * ClassTypeNativeDirectConstructorCallbackDefaultRuntimeImpl.java
 *
 * Created on 13 de julio de 2005, 13:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectConstructorCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectConstructorCallbackDefaultRuntimeImpl extends ClassTypeNativeDirectConstructorCallbackRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDirectConstructorCallbackDefaultRuntimeImpl
     */
    public ClassTypeNativeDirectConstructorCallbackDefaultRuntimeImpl(ClassTypeNativeDirectConstructorCallbackDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
}
