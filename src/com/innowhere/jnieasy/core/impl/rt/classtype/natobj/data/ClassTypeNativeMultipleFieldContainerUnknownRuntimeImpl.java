/*
 * ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 13:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerUnknownImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl extends ClassTypeNativeMultipleFieldContainerRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
    
    /**
     * Creates a new instance of ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl
     */
    public ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl(ClassTypeNativeMultipleFieldContainerUnknownImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public static ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl newClassTypeMultipleFieldContainerUnknownRuntime(String className,RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl(ClassTypeNativeMultipleFieldContainerUnknownImpl.newClassTypeMultipleFieldContainerUnknown(className, rtMgr.getJNIEasy()),rtMgr);
    }
    
    public long getPreferredAlignSize()
    {
        throw new JNIEasyException("Unknown alignment size");
    }

    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown size");        
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    } 
}
