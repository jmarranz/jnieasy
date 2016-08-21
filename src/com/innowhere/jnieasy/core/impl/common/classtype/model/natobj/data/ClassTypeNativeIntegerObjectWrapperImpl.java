/*
 * ClassTypeNativeIntegerObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeIntegerObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeIntegerObjectImpl;


public class ClassTypeNativeIntegerObjectWrapperImpl extends ClassTypeNativeNumberObjectWrapperImpl
{
    public static final Class INTERFACE = NativeIntegerObject.class;
    public static final Class CLASS = NativeIntegerObjectImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeIntegerObjectWrapperImpl
     */
    public ClassTypeNativeIntegerObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeIntegerObjectImpl.getClassTypeNativeIntegerObject(classTypeMgr), classTypeMgr,true);
    }   
    
    public static void registerClassTypeNativeIntegerObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerObjectWrapperImpl classType = new ClassTypeNativeIntegerObjectWrapperImpl(mgr);
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
