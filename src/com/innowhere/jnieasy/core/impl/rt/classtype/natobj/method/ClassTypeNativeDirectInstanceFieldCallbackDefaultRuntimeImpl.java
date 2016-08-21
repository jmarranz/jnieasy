/*
 * ClassTypeNativeDirectInstanceFieldCallbackDefaultRuntimeImpl.java
 *
 * Created on 13 de julio de 2005, 13:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectInstanceFieldCallbackDefaultRuntimeImpl extends ClassTypeNativeDirectInstanceFieldCallbackRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceFieldCallbackDefaultRuntimeImpl
     */
    public ClassTypeNativeDirectInstanceFieldCallbackDefaultRuntimeImpl(ClassTypeNativeDirectInstanceFieldCallbackDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }  
}
