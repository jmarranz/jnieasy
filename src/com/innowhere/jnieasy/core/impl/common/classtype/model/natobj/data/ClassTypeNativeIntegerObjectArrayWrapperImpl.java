/*
 * ClassTypeNativeIntegerObjectArrayWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeIntegerObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeIntegerObjectArrayImpl;



public class ClassTypeNativeIntegerObjectArrayWrapperImpl extends ClassTypeNativeNumberObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeIntegerObjectArray.class;
    public static final Class CLASS = NativeIntegerObjectArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeIntegerObjectArrayWrapperImpl
     */
    public ClassTypeNativeIntegerObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeIntegerObjectArrayImpl.getClassTypeNativeIntegerObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeIntegerObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerObjectArrayWrapperImpl classType = new ClassTypeNativeIntegerObjectArrayWrapperImpl(mgr);
        classType.registerClassType();
    }

    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 
    
    public String getVMClassImplName()
    {
        return CLASS.getName();
    }

}
