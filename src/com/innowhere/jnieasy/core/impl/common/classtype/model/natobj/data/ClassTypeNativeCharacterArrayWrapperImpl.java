/*
 * ClassTypeNativeCharacterArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCharacterArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCharacterArrayImpl;




public class ClassTypeNativeCharacterArrayWrapperImpl extends ClassTypeNativePrimitiveArrayWrapperImpl
{
    public static final Class INTERFACE = NativeCharacterArray.class;
    public static final Class CLASS = NativeCharacterArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeCharacterArrayWrapperImpl
     */
    public ClassTypeNativeCharacterArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeCharacterArrayImpl.getClassTypeNativeCharacterArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeCharacterArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterArrayWrapperImpl classType = new ClassTypeNativeCharacterArrayWrapperImpl(mgr);
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

