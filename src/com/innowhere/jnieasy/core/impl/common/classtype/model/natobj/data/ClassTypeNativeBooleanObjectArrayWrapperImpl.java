/*
 * ClassTypeNativeBooleanObjectArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeBooleanObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeBooleanObjectArrayImpl;


public class ClassTypeNativeBooleanObjectArrayWrapperImpl extends ClassTypeNativePrimitiveObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeBooleanObjectArray.class;
    public static final Class CLASS = NativeBooleanObjectArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeBooleanObjectArrayWrapperImpl
     */
    public ClassTypeNativeBooleanObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeBooleanObjectArrayImpl.getClassTypeNativeBooleanObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeBooleanObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectArrayWrapperImpl classType = new ClassTypeNativeBooleanObjectArrayWrapperImpl(mgr);
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
