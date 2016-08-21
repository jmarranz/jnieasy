/*
 * ClassTypeNativeCharacterObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCharacterObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCharacterObjectImpl;


public class ClassTypeNativeCharacterObjectWrapperImpl extends ClassTypeNativePrimitiveObjectWrapperImpl
{
    public static final Class INTERFACE = NativeCharacterObject.class;
    public static final Class CLASS = NativeCharacterObjectImpl.class;     

    
    /**
     * Creates a new instance of ClassTypeNativeCharacterObjectWrapperImpl
     */
    public ClassTypeNativeCharacterObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeCharacterObjectImpl.getClassTypeNativeCharacterObject(classTypeMgr), classTypeMgr,true);
    }   
    
    public static void registerClassTypeNativeCharacterObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterObjectWrapperImpl classType = new ClassTypeNativeCharacterObjectWrapperImpl(mgr);
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
