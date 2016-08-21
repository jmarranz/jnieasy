/*
 * ClassTypeUnionDefaultRuntimeImpl.java
 *
 * Created on 20 de junio de 2005, 12:39
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeUnionDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeUnionDefaultRuntimeImpl extends ClassTypeUnionRuntimeImpl
{
    
    /** Creates a new instance of ClassTypeUnionDefaultRuntimeImpl */
    public ClassTypeUnionDefaultRuntimeImpl(ClassTypeUnionDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown size");        
    }

    public long getPreferredAlignSize()
    {
        throw new JNIEasyException("Unknown alignment size");
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
