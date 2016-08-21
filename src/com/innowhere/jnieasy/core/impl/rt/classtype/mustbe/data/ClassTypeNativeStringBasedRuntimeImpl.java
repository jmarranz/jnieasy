/*
 * ClassTypeNativeStringBasedRuntimeImpl.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

public class ClassTypeNativeStringBasedRuntimeImpl extends ClassTypeCanBeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedRuntimeImpl
     */
    public ClassTypeNativeStringBasedRuntimeImpl(ClassTypeNativeStringBasedImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown string length");
    }   
    
    public long getPreferredAlignSize()
    {
        // Nunca será llamada porque no puede ser por valor nunca
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
