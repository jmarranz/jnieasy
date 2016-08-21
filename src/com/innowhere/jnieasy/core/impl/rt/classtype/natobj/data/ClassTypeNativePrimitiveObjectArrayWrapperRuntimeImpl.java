/*
 * ClassTypeNativePrimitiveObjectArrayWrapperRuntimeImpl.java
 *
 * Created on 19 de junio de 2005, 21:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativePrimitiveObjectArrayWrapperRuntimeImpl extends ClassTypeCanBeNativeCapableArrayWrapperRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativePrimitiveObjectArrayWrapperRuntimeImpl
     */
    public ClassTypeNativePrimitiveObjectArrayWrapperRuntimeImpl(ClassTypeNativePrimitiveObjectArrayWrapperImpl classType,RuntimeManagerImpl rtMgr)
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
