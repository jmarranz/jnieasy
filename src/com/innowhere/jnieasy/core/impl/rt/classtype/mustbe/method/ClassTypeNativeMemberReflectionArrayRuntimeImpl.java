/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.*;


public class ClassTypeNativeMemberReflectionArrayRuntimeImpl extends ClassTypeCanBeNativeCapableArrayRuntimeImpl
{
    /** Creates a new instance of StringArrayType */
    public ClassTypeNativeMemberReflectionArrayRuntimeImpl(ClassTypeNativeMemberReflectionArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public ClassTypeNativeMemberReflectionArrayImpl getClassTypeNativeMemberReflectionArray()
    {
        return (ClassTypeNativeMemberReflectionArrayImpl)classType;
    }
    
    public Object newArrayValue(int length)
    {
        return getClassTypeNativeMemberReflectionArray().newValueDefaultClass(length);
    }

    public long getPreferredAlignSize()
    {
        // Los elementos de estos tipos de array siempre son punteros (callbacks)
        return TypeSizes.getADDRESS();
    }    
}
