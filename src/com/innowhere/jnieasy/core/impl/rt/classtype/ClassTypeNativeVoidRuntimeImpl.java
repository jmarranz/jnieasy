/*
 * ClassTypeNativeNumberRuntimeImpl.java
 *
 * Created on 22 de agosto de 2006, 21:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeVoidImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeVoidRuntimeImpl extends ClassTypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeVoidRuntimeImpl
     */
    public ClassTypeNativeVoidRuntimeImpl(ClassTypeNativeVoidImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long defaultJavaPrimSize()
    {
        return 0;
    }                
    
    public long defaultJavaPrimAlignSize()
    {
        return 0;
    }
   
    public int returnTypeCode()
    {
        return VOID_RETURN;
    } 
        
    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown size, is void");        
    }
    
    public long getPreferredAlignSize()
    {
        throw new JNIEasyException("Unknown size, is void");    
    }    
    
    public boolean checkPositiveSize(long size)
    {
        throw new JNIEasyException("Void type can not have memory size");
    }    
    
    public boolean checkPositiveAlignSize(long size)
    {
        throw new JNIEasyException("Void type can not have align size");
    }    
}
