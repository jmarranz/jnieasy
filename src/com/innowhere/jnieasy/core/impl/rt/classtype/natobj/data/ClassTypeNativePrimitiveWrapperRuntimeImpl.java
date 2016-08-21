/*
 * ClassTypeNativePrimitiveWrapperRuntimeImpl.java
 *
 * Created on 20 de junio de 2005, 12:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativePrimitiveRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativePrimitiveWrapperRuntimeImpl extends ClassTypeNativeFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativePrimitiveWrapperRuntimeImpl
     */
    public ClassTypeNativePrimitiveWrapperRuntimeImpl(ClassTypeNativePrimitiveWrapperImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public ClassTypeNativePrimitiveWrapperImpl getClassTypeNativePrimitiveWrapper()
    {
        return (ClassTypeNativePrimitiveWrapperImpl)classType;
    }        

    public ClassTypeNativePrimitiveRuntimeImpl getClassTypeNativePrimitiveRuntime()
    {
        return (ClassTypeNativePrimitiveRuntimeImpl)getClassTypeNativePrimitiveWrapper().getClassTypeNativePrimitive().getClassTypeRuntime();
    }
    
    public long getObjectSize()
    {
        return getClassTypeNativePrimitiveRuntime().getObjectSize();
    }  
    
    public long getPreferredAlignSize()
    {
        return getClassTypeNativePrimitiveRuntime().getPreferredAlignSize();
    }        
    
}
