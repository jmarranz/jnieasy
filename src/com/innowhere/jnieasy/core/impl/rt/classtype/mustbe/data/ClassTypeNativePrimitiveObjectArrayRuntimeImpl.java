/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class ClassTypeNativePrimitiveObjectArrayRuntimeImpl extends ClassTypeCanBeNativeCapableArrayRuntimeImpl
{
    /** Creates a new instance of StringArrayType */
    public ClassTypeNativePrimitiveObjectArrayRuntimeImpl(ClassTypeNativePrimitiveObjectArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    

    public ClassTypeNativePrimitiveObjectArrayImpl getClassTypeNativeçPrimitiveObjectArray()
    {
        return (ClassTypeNativePrimitiveObjectArrayImpl)classType;
    }
    
    public Object newArrayValue(int length)
    {
        return getClassTypeNativeçPrimitiveObjectArray().newValueDefaultClass(length);
    }

    public long getPreferredAlignSize()
    {
        // Los elementos de estos tipos de array siempre son punteros
        return TypeSizes.getADDRESS();
    }    
}
