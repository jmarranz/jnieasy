/*
 * ClassTypeNativeFloatObjectArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeFloatObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeFloatObjectArrayImpl;


public class ClassTypeNativeFloatObjectArrayWrapperImpl extends ClassTypeNativeNumberObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeFloatObjectArray.class;
    public static final Class CLASS = NativeFloatObjectArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeFloatObjectArrayWrapperImpl
     */
    public ClassTypeNativeFloatObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFloatObjectArrayImpl.getClassTypeNativeFloatObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeFloatObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatObjectArrayWrapperImpl classType = new ClassTypeNativeFloatObjectArrayWrapperImpl(mgr);
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
