/*
 * ClassTypeNativeMemberReflectionRuntimeImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:46
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeCanBeNativeCapableRuntimeImpl;

public abstract class ClassTypeNativeMemberReflectionRuntimeImpl extends ClassTypeCanBeNativeCapableRuntimeImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeMemberReflectionRuntimeImpl
     */
    public ClassTypeNativeMemberReflectionRuntimeImpl(ClassTypeNativeMemberReflectionImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getPreferredAlignSize()
    {
        // Nunca será llamada porque no puede ser por valor nunca
        throw new JNIEasyException("INTERNAL ERROR");
    }        
}
