/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeIntegerRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeIntegerRuntimeImpl extends ClassTypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeIntegerRuntimeImpl
     */
    public ClassTypeNativeIntegerRuntimeImpl(ClassTypeNativeIntegerImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getIntSize();
    }   
    
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getIntAlignSize();        
    }
        
    public int returnTypeCode()
    {
        return INT_RETURN;
    }
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeIntegerRuntimeImpl.checkPositiveSize(size);
    }            
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeIntegerRuntimeImpl.checkPositiveAlignSize(size);
    }    
}
