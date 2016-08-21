/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBooleanRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeBooleanRuntimeImpl extends ClassTypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeBooleanRuntimeImpl
     */
    public ClassTypeNativeBooleanRuntimeImpl(ClassTypeNativeBooleanImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getBooleanSize();
    }        
    
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getBooleanAlignSize();        
    }
    
    public int returnTypeCode()
    {
        return BOOLEAN_RETURN;
    }    
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeBooleanRuntimeImpl.checkPositiveSize(size);
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeBooleanRuntimeImpl.checkPositiveAlignSize(size);
    }    
}
