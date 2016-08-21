/*
 * ClassTypeNativeFloatObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeFloatObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeFloatObjectImpl;


public class ClassTypeNativeFloatObjectWrapperImpl extends ClassTypeNativeNumberObjectWrapperImpl
{
    public static final Class INTERFACE = NativeFloatObject.class;
    public static final Class CLASS = NativeFloatObjectImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeFloatObjectWrapperImpl
     */
    public ClassTypeNativeFloatObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeFloatObjectImpl.getClassTypeNativeFloatObject(classTypeMgr), classTypeMgr,true);
    }   
    
    public static void registerClassTypeNativeFloatObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatObjectWrapperImpl classType = new ClassTypeNativeFloatObjectWrapperImpl(mgr);
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
