/*
 * ClassTypeNativeObjectDefaultRuntimeImpl.java
 *
 * Created on 7 de marzo de 2005, 11:21
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

public class ClassTypeNativeObjectDefaultRuntimeImpl extends ClassTypeNativeObjectRuntimeImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeObjectDefaultRuntimeImpl
     */
    public ClassTypeNativeObjectDefaultRuntimeImpl(ClassTypeNativeObjectDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown size");
    }    
    
    public long getPreferredAlignSize()
    {
        throw new JNIEasyException("Unknown data type size");
    }     
    
    public Object newValue()
    {
        // De nada sirve devolver new Object()
        throw new JNIEasyException("Cannot make an instance, unknown native type");
    }     
}
