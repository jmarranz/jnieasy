/*
 * ClassTypeNativeFloatArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeFloatArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeFloatArrayImpl;



public class ClassTypeNativeFloatArrayWrapperImpl extends ClassTypeNativeNumberArrayWrapperImpl
{
    public static final Class INTERFACE = NativeFloatArray.class;
    public static final Class CLASS = NativeFloatArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeFloatArrayWrapperImpl
     */
    public ClassTypeNativeFloatArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFloatArrayImpl.getClassTypeNativeFloatArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeFloatArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatArrayWrapperImpl classType = new ClassTypeNativeFloatArrayWrapperImpl(mgr);
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

