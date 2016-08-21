/*
 * ClassTypeNativeShortWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeShortImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeShortImpl;

public class ClassTypeNativeShortWrapperImpl extends ClassTypeNativeNumberWrapperImpl
{
    public static final Class INTERFACE = NativeShort.class;
    public static final Class CLASS = NativeShortImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeShortWrapperImpl
     */
    public ClassTypeNativeShortWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeShortImpl.getClassTypeNativeShort(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeShortWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortWrapperImpl classType = new ClassTypeNativeShortWrapperImpl(mgr);
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

