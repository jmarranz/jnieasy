/*
 * ClassTypeNativeShortObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeShortObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeShortObjectImpl;

public class ClassTypeNativeShortObjectWrapperImpl extends ClassTypeNativeNumberObjectWrapperImpl
{
    public static final Class INTERFACE = NativeShortObject.class;
    public static final Class CLASS = NativeShortObjectImpl.class;     

    
    /**
     * Creates a new instance of ClassTypeNativeShortObjectWrapperImpl
     */
    public ClassTypeNativeShortObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeShortObjectImpl.getClassTypeNativeShortObject(classTypeMgr),classTypeMgr,true);
    }
    
    public static void registerClassTypeNativeShortObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortObjectWrapperImpl classType = new ClassTypeNativeShortObjectWrapperImpl(mgr);
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
