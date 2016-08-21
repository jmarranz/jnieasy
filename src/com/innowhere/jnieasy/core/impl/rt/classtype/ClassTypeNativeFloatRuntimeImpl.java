/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeFloatImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFloatRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeFloatRuntimeImpl extends ClassTypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeFloatRuntimeImpl
     */
    public ClassTypeNativeFloatRuntimeImpl(ClassTypeNativeFloatImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getFloatSize();
    }    
        
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getFloatAlignSize();        
    }
    
    public int returnTypeCode()
    {
        return FLOAT_RETURN;
    }    
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeFloatRuntimeImpl.checkPositiveSize(size);
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeFloatRuntimeImpl.checkPositiveAlignSize(size);
    } 
}
