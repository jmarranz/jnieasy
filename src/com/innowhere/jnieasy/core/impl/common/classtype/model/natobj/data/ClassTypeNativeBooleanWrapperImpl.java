/*
 * ClassTypeNativeBooleanWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeBooleanImpl;

public class ClassTypeNativeBooleanWrapperImpl extends ClassTypeNativePrimitiveWrapperImpl
{
    public static final Class INTERFACE = NativeBoolean.class;
    public static final Class CLASS = NativeBooleanImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeBooleanWrapperImpl
     */
    public ClassTypeNativeBooleanWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeBooleanImpl.getClassTypeNativeBoolean(classTypeMgr),classTypeMgr);
    }
        
    public static void registerClassTypeNativeBooleanWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanWrapperImpl classType = new ClassTypeNativeBooleanWrapperImpl(mgr);
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

