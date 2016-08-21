/*
 * ClassTypeNativePointerRuntimeImpl.java
 *
 * Created on 23 de septiembre de 2005, 17:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativePointerRuntimeImpl extends ClassTypeNativeFieldContainerRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativePointerRuntimeImpl
     */
    public ClassTypeNativePointerRuntimeImpl(ClassTypeNativePointerImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public long getObjectSize()
    {
        return TypeSizes.getADDRESS();
    }

    public static long getObjectSizeStatic()
    {
        return TypeSizes.getADDRESS();
    }    
    
    public long getPreferredAlignSize()
    {
        // Es un tipo intrínsecamente puntero, no puede ser atributo "por valor" en una estructura
        return TypeSizes.getADDRESS();        
    }
    
}
