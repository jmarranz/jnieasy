/*
 * ClassTypeNativeCharacterObjectArrayWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCharacterObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCharacterObjectArrayImpl;


public class ClassTypeNativeCharacterObjectArrayWrapperImpl extends ClassTypeNativePrimitiveObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeCharacterObjectArray.class;
    public static final Class CLASS = NativeCharacterObjectArrayImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeCharacterObjectArrayWrapperImpl
     */
    public ClassTypeNativeCharacterObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeCharacterObjectArrayImpl.getClassTypeNativeCharacterObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeCharacterObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterObjectArrayWrapperImpl classType = new ClassTypeNativeCharacterObjectArrayWrapperImpl(mgr);
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
