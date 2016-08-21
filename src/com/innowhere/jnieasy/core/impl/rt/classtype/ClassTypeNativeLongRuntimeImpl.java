/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeLongImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeLongRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeLongRuntimeImpl extends ClassTypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeLongRuntimeImpl
     */
    public ClassTypeNativeLongRuntimeImpl(ClassTypeNativeLongImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getLongSize();
    }  
    
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getLongAlignSize();        
    }
    
    public int returnTypeCode()
    {
        return LONG_RETURN;
    }          
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeLongRuntimeImpl.checkPositiveSize(size);
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeLongRuntimeImpl.checkPositiveAlignSize(size);
    }    
}
