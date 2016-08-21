/*
 * ClassTypeNativeStringBasedArrayRuntimeImpl.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBasedArrayImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class ClassTypeNativeStringBasedArrayRuntimeImpl extends ClassTypeCanBeNativeCapableArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedArrayRuntimeImpl 
     */
    public ClassTypeNativeStringBasedArrayRuntimeImpl(ClassTypeNativeStringBasedArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    } 

    public ClassTypeNativeStringBasedArrayImpl getClassTypeNativeStringBasedArray()
    {
        return (ClassTypeNativeStringBasedArrayImpl)classType;
    }
    
    public Object newArrayValue(int length)
    {
        return getClassTypeNativeStringBasedArray().newValueDefaultClass(length);
    }
    
    public long getPreferredAlignSize()
    {
        // El alignment de un array es el del tipo de sus elementos
        // En los arrays de cadenas siempre son punteros las cadenas
        return TypeSizes.getADDRESS();
    }
}
