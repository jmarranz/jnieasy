/*
 * ClassTypeNativeCharacterWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeCharacterImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCharacterImpl;

public class ClassTypeNativeCharacterWrapperImpl extends ClassTypeNativePrimitiveWrapperImpl
{
    public static final Class INTERFACE = NativeCharacter.class;
    public static final Class CLASS = NativeCharacterImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeCharacterWrapperImpl
     */
    public ClassTypeNativeCharacterWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeCharacterImpl.getClassTypeNativeCharacter(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeCharacterWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterWrapperImpl classType = new ClassTypeNativeCharacterWrapperImpl(mgr);
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

