/*
 * ClassTypeNativeDoubleWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeDoubleImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeDoubleImpl;

public class ClassTypeNativeDoubleWrapperImpl extends ClassTypeNativeNumberWrapperImpl
{
    public static final Class INTERFACE = NativeDouble.class;
    public static final Class CLASS = NativeDoubleImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeDoubleWrapperImpl
     */
    public ClassTypeNativeDoubleWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeDoubleImpl.getClassTypeNativeDouble(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeDoubleWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleWrapperImpl classType = new ClassTypeNativeDoubleWrapperImpl(mgr);
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

