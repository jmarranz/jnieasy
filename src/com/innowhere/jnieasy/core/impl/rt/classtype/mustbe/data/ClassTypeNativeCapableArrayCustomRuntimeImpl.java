/*
 * ClassTypeNativeCapableArrayCustomRuntimeImpl.java
 *
 * Created on 3 de diciembre de 2004, 9:54
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;



public class ClassTypeNativeCapableArrayCustomRuntimeImpl extends ClassTypeNativeCapableArrayRuntimeImpl
{
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayCustomRuntimeImpl
     */
    public ClassTypeNativeCapableArrayCustomRuntimeImpl(ClassTypeNativeCapableArrayCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
  
    public Object newArrayValue(int length)
    {
        ClassTypeNativeCapableRuntimeImpl classTypeComp = (ClassTypeNativeCapableRuntimeImpl)getClassTypeComponent();
        return classTypeComp.newArrayValue(length);
    }

    public long getPreferredAlignSize()
    {
        // El array puede ser de elementos por valor o por referencia,
        // aquí no lo conocemos (se da en el TypeNative),
        // esto influye el alineamiento
        throw new JNIEasyException("Unknown array element size");
    }    
}
