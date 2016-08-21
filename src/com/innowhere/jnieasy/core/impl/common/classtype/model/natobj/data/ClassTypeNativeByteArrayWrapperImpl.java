/*
 * ClassTypeNativeByteArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeByteArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeByteArrayImpl;


public class ClassTypeNativeByteArrayWrapperImpl extends ClassTypeNativeNumberArrayWrapperImpl
{
    public static final Class INTERFACE = NativeByteArray.class;
    public static final Class CLASS = NativeByteArrayImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeByteArrayWrapperImpl
     */
    public ClassTypeNativeByteArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeByteArrayImpl.getClassTypeNativeByteArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeByteArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteArrayWrapperImpl classType = new ClassTypeNativeByteArrayWrapperImpl(mgr);
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

