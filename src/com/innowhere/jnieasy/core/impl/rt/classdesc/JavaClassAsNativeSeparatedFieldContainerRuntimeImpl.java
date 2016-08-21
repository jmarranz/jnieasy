/*
 * JavaClassAsNativeSeparatedFieldContainerRuntimeImpl.java
 *
 * Created on 13 de octubre de 2005, 19:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeSeparatedFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeSeparatedFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeSeparatedFieldContainerDescriptor;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeSeparatedFieldContainerRuntimeImpl extends JavaClassAsNativeMultipleFieldContainerRuntimeImpl implements NativeSeparatedFieldContainerDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeSeparatedFieldContainerRuntimeImpl
     */
    public JavaClassAsNativeSeparatedFieldContainerRuntimeImpl(JavaClassAsNativeSeparatedFieldContainerImpl javaClass,ClassTypeNativeSeparatedFieldContainerRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }

    public JavaClassAsNativeSeparatedFieldContainerImpl getJavaClassAsSeparatedFieldContainer()
    {
        return (JavaClassAsNativeSeparatedFieldContainerImpl)javaClass;
    }    
}
