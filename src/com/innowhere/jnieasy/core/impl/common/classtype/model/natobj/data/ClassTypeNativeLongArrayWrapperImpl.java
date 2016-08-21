/*
 * ClassTypeNativeLongArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeLongArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeLongArrayImpl;



public class ClassTypeNativeLongArrayWrapperImpl extends ClassTypeNativeNumberArrayWrapperImpl
{
    public static final Class INTERFACE = NativeLongArray.class;
    public static final Class CLASS = NativeLongArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeLongArrayWrapperImpl
     */
    public ClassTypeNativeLongArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeLongArrayImpl.getClassTypeNativeLongArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeLongArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongArrayWrapperImpl classType = new ClassTypeNativeLongArrayWrapperImpl(mgr);
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

