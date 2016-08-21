/*
 * ClassTypeNativeDoubleObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeDoubleObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeDoubleObjectImpl;


public class ClassTypeNativeDoubleObjectWrapperImpl extends ClassTypeNativeNumberObjectWrapperImpl
{
    public static final Class INTERFACE = NativeDoubleObject.class;
    public static final Class CLASS = NativeDoubleObjectImpl.class;     

    
    /**
     * Creates a new instance of ClassTypeNativeDoubleObjectWrapperImpl
     */
    public ClassTypeNativeDoubleObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeDoubleObjectImpl.getClassTypeNativeDoubleObject(classTypeMgr), classTypeMgr,true);
    }   
    
    public static void registerClassTypeNativeDoubleObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleObjectWrapperImpl classType = new ClassTypeNativeDoubleObjectWrapperImpl(mgr);
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
