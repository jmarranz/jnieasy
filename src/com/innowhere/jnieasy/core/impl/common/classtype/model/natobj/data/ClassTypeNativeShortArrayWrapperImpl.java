/*
 * ClassTypeNativeShortArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeShortArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeShortArrayImpl;




public class ClassTypeNativeShortArrayWrapperImpl extends ClassTypeNativeNumberArrayWrapperImpl
{
    public static final Class INTERFACE = NativeShortArray.class;
    public static final Class CLASS = NativeShortArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeShortArrayWrapperImpl
     */
    public ClassTypeNativeShortArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeShortArrayImpl.getClassTypeNativeShortArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeShortArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortArrayWrapperImpl classType = new ClassTypeNativeShortArrayWrapperImpl(mgr);
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

