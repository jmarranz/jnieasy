/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeDoubleImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeDoubleRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDoubleRuntimeImpl extends ClassTypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDoubleRuntimeImpl
     */
    public ClassTypeNativeDoubleRuntimeImpl(ClassTypeNativeDoubleImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getDoubleSize();
    }   
    
    public long defaultJavaPrimAlignSize()
    {    
        return TypeSizes.getDoubleAlignSize();        
    }
                
    public int returnTypeCode()
    {
        return DOUBLE_RETURN;
    }    
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeDoubleRuntimeImpl.checkPositiveSize(size);
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeDoubleRuntimeImpl.checkPositiveAlignSize(size);
    }    
}
