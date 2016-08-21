/*
 * ClassTypeNativeIntegerArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeIntegerArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeIntegerArrayImpl;



public class ClassTypeNativeIntegerArrayWrapperImpl extends ClassTypeNativeNumberArrayWrapperImpl
{
    public static final Class INTERFACE = NativeIntegerArray.class;
    public static final Class CLASS = NativeIntegerArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeIntegerArrayWrapperImpl
     */
    public ClassTypeNativeIntegerArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeIntegerArrayImpl.getClassTypeNativeIntegerArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeIntegerArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerArrayWrapperImpl classType = new ClassTypeNativeIntegerArrayWrapperImpl(mgr);
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

