/*
 * ClassTypeNativeLongObjectArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeLongObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeLongObjectArrayImpl;



public class ClassTypeNativeLongObjectArrayWrapperImpl extends ClassTypeNativeNumberObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeLongObjectArray.class;
    public static final Class CLASS = NativeLongObjectArrayImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeLongObjectArrayWrapperImpl
     */
    public ClassTypeNativeLongObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeLongObjectArrayImpl.getClassTypeNativeLongObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeLongObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongObjectArrayWrapperImpl classType = new ClassTypeNativeLongObjectArrayWrapperImpl(mgr);
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
