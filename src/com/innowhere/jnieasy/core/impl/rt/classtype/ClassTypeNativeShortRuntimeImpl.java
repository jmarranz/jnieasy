/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeShortImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeShortRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeShortRuntimeImpl extends ClassTypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeShortRuntimeImpl
     */
    public ClassTypeNativeShortRuntimeImpl(ClassTypeNativeShortImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
        
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getShortSize();
    }      
    
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getShortAlignSize();        
    }
            
    public int returnTypeCode()
    {
        return SHORT_RETURN;
    }    

    public boolean checkPositiveSize(long size)
    {
        return TypeNativeShortRuntimeImpl.checkPositiveSize(size);
    }
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeShortRuntimeImpl.checkPositiveAlignSize(size);
    }       
}
