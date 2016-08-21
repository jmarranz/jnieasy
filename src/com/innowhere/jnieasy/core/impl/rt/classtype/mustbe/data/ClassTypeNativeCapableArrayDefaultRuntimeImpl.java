/*
 * ClassTypeNativeCapableArrayDefaultRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class ClassTypeNativeCapableArrayDefaultRuntimeImpl extends ClassTypeNativeCapableArrayRuntimeImpl
{
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayDefaultRuntimeImpl
     */
    public ClassTypeNativeCapableArrayDefaultRuntimeImpl(ClassTypeNativeCapableArrayDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    } 
    
    public ClassTypeNativeCapableArrayDefaultImpl getClassTypeNativeCapableArrayDefault()
    {
        return (ClassTypeNativeCapableArrayDefaultImpl)classType;
    }
    
    public Object newArrayValue(int length)
    {
        return getClassTypeNativeCapableArrayDefault().newValueDefaultClass(length);
    }

    public long getPreferredAlignSize()
    {
        // El array puede ser de elementos por valor o por referencia,
        // aquí no lo conocemos (se da en el TypeNative),
        // esto influye el alineamiento
        throw new JNIEasyException("Unknown array element size");
    }    
}

