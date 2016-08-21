/*
 * ClassTypeNativeLongObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeLongObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeLongObjectImpl;


public class ClassTypeNativeLongObjectWrapperImpl extends ClassTypeNativeNumberObjectWrapperImpl
{
    public static final Class INTERFACE = NativeLongObject.class;
    public static final Class CLASS = NativeLongObjectImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeLongObjectWrapperImpl
     */
    public ClassTypeNativeLongObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeLongObjectImpl.getClassTypeNativeLongObject(classTypeMgr),classTypeMgr,true);
    }   
    
    public static void registerClassTypeNativeLongObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongObjectWrapperImpl classType = new ClassTypeNativeLongObjectWrapperImpl(mgr);
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
