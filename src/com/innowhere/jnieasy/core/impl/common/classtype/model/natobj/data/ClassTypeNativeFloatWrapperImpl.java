/*
 * ClassTypeNativeFloatWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeFloatImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeFloatImpl;

public class ClassTypeNativeFloatWrapperImpl extends ClassTypeNativeNumberWrapperImpl
{
    public static final Class INTERFACE = NativeFloat.class;
    public static final Class CLASS = NativeFloatImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeFloatWrapperImpl
     */
    public ClassTypeNativeFloatWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeFloatImpl.getClassTypeNativeFloat(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeFloatWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatWrapperImpl classType = new ClassTypeNativeFloatWrapperImpl(mgr);
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

