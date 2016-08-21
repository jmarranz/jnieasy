/*
 * ClassTypeNativeBooleanObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeBooleanObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeBooleanObjectImpl;


public class ClassTypeNativeBooleanObjectWrapperImpl extends ClassTypeNativePrimitiveObjectWrapperImpl
{
    public static final Class INTERFACE = NativeBooleanObject.class;
    public static final Class CLASS = NativeBooleanObjectImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeBooleanObjectWrapperImpl
     */
    public ClassTypeNativeBooleanObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeBooleanObjectImpl.getClassTypeNativeBooleanObject(classTypeMgr), classTypeMgr,true);
    }   

    public static void registerClassTypeNativeBooleanObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectWrapperImpl classType = new ClassTypeNativeBooleanObjectWrapperImpl(mgr);
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
