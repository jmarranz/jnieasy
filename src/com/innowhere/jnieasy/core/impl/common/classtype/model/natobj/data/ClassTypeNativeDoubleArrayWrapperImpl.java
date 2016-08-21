/*
 * ClassTypeNativeDoubleArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeDoubleArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeDoubleArrayImpl;




public class ClassTypeNativeDoubleArrayWrapperImpl extends ClassTypeNativeNumberArrayWrapperImpl
{
    public static final Class INTERFACE = NativeDoubleArray.class;
    public static final Class CLASS = NativeDoubleArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeDoubleArrayWrapperImpl
     */
    public ClassTypeNativeDoubleArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeDoubleArrayImpl.getClassTypeNativeDoubleArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeDoubleArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleArrayWrapperImpl classType = new ClassTypeNativeDoubleArrayWrapperImpl(mgr);
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

