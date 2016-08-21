/*
 * ClassTypeNativePrimitiveArrayRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativePrimitiveArrayRuntimeImpl extends ClassTypeNativeArrayRuntimeImpl
{
    /**
     * Creates a new instance of ClassTypeNativePrimitiveArrayRuntimeImpl
     */
    public ClassTypeNativePrimitiveArrayRuntimeImpl(ClassTypeNativePrimitiveArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    

    public ClassTypeNativePrimitiveArrayImpl getClassTypeNativePrimitiveArray()
    {
        return (ClassTypeNativePrimitiveArrayImpl)classType;
    }
    
    public Object newArrayValue(int length)
    {
        return getClassTypeNativePrimitiveArray().newValueDefaultClass(length);
    }
        
    public long getPreferredAlignSize()
    {
        ClassTypeNativeRuntimeImpl classTypeComp = getClassTypeComponent();
        return classTypeComp.getPreferredAlignSize();
    }
}

