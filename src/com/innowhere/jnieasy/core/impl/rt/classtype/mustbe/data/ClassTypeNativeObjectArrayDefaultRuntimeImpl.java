/*
 * ClassTypeNativeObjectArrayDefaultRuntimeImpl.java
 *
 * Created on 7 de marzo de 2005, 13:43
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeObjectArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class ClassTypeNativeObjectArrayDefaultRuntimeImpl extends ClassTypeNativeObjectArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayDefaultRuntimeImpl
     */
    public ClassTypeNativeObjectArrayDefaultRuntimeImpl(ClassTypeNativeObjectArrayDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    
  
    public ClassTypeNativeObjectArrayDefaultImpl getClassTypeNativeObjectArrayDefault()
    {
        return (ClassTypeNativeObjectArrayDefaultImpl)classType;
    }
    
    public Object newArrayValue(int length)
    {
        return getClassTypeNativeObjectArrayDefault().newValueDefaultClass(length);
    }
    
    public long getPreferredAlignSize()
    {
        throw new JNIEasyException("Unknown array element type to calc alignment size");
    }
}
