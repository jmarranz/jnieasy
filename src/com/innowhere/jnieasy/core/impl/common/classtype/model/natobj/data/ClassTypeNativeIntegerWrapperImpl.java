/*
 * ClassTypeNativeIntegerWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeIntegerImpl;

public class ClassTypeNativeIntegerWrapperImpl extends ClassTypeNativeNumberWrapperImpl
{
    public static final Class INTERFACE = NativeInteger.class;
    public static final Class CLASS = NativeIntegerImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeIntegerWrapperImpl
     */
    public ClassTypeNativeIntegerWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeIntegerImpl.getClassTypeNativeInteger(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeIntegerWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerWrapperImpl classType = new ClassTypeNativeIntegerWrapperImpl(mgr);
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

