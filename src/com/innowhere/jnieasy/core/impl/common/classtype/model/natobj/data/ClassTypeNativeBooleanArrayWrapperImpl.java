/*
 * ClassTypeNativeBooleanArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeBooleanArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeBooleanArrayImpl;



public class ClassTypeNativeBooleanArrayWrapperImpl extends ClassTypeNativePrimitiveArrayWrapperImpl
{
    public static final Class INTERFACE = NativeBooleanArray.class;
    public static final Class CLASS = NativeBooleanArrayImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeBooleanArrayWrapperImpl
     */
    public ClassTypeNativeBooleanArrayWrapperImpl(ClassTypeManagerImpl mgr)    
    {
        super(ClassTypeNativeBooleanArrayImpl.getClassTypeNativeBooleanArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeBooleanArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanArrayWrapperImpl classType = new ClassTypeNativeBooleanArrayWrapperImpl(mgr);
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

