/*
 * JavaClassAsNativeFieldContainerRuntimeImpl.java
 *
 * Created on 14 de septiembre de 2005, 12:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeFieldContainerRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeFieldContainerRuntimeImpl extends JavaClassAsNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeFieldContainerRuntimeImpl
     */
    public JavaClassAsNativeFieldContainerRuntimeImpl(JavaClassAsNativeFieldContainerImpl javaClass,ClassTypeNativeFieldContainerRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
}
