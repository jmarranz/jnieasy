/*
 * ClassTypeNativeArrayOfArrayWrapperDefaultRuntimeImpl.java
 *
 * Created on 20 de junio de 2005, 12:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeArrayOfArrayWrapperDefaultRuntimeImpl extends ClassTypeNativeArrayOfArrayWrapperRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayWrapperDefaultRuntimeImpl
     */
    public ClassTypeNativeArrayOfArrayWrapperDefaultRuntimeImpl(ClassTypeNativeArrayOfArrayWrapperDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getObjectSize()
    {
        return getClassTypeCanBeNativeCapableRuntime().getObjectSize();
    }   
        
    public long getPreferredAlignSize()
    {
        return getClassTypeCanBeNativeCapableRuntime().getPreferredAlignSize();
    }        
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
}
