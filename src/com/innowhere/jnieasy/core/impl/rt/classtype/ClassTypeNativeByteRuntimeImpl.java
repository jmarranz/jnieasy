/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeByteImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeByteRuntimeImpl extends ClassTypeNativeNumberRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeByteRuntimeImpl
     */
    public ClassTypeNativeByteRuntimeImpl(ClassTypeNativeByteImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getByteSize();
    }    
        
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getByteAlignSize();        
    }
        
    public int returnTypeCode()
    {
        return BYTE_RETURN;
    }    
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeByteRuntimeImpl.checkPositiveSize(size);
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeByteRuntimeImpl.checkPositiveAlignSize(size);
    }    
}
