/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeCharacterImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCharacterRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeCharacterRuntimeImpl extends ClassTypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeCharacterRuntimeImpl
     */
    public ClassTypeNativeCharacterRuntimeImpl(ClassTypeNativeCharacterImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
        
    public long defaultJavaPrimSize()
    {
        return TypeSizes.getCharSize();
    }    
    
    public long defaultJavaPrimAlignSize()
    {
        return TypeSizes.getCharAlignSize();        
    }
    
    public int returnTypeCode()
    {
        return CHAR_RETURN;
    }    
    
    public boolean checkPositiveSize(long size)
    {
        return TypeNativeCharacterRuntimeImpl.checkPositiveSize(size);
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        return TypeNativeCharacterRuntimeImpl.checkPositiveAlignSize(size);
    }    
}
