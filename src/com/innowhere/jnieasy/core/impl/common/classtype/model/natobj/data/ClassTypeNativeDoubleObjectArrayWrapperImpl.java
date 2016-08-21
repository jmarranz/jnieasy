/*
 * ClassTypeNativeDoubleObjectArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeDoubleObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeDoubleObjectArrayImpl;



public class ClassTypeNativeDoubleObjectArrayWrapperImpl extends ClassTypeNativeNumberObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeDoubleObjectArray.class;
    public static final Class CLASS = NativeDoubleObjectArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeDoubleObjectArrayWrapperImpl
     */
    public ClassTypeNativeDoubleObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeDoubleObjectArrayImpl.getClassTypeNativeDoubleObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeDoubleObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleObjectArrayWrapperImpl classType = new ClassTypeNativeDoubleObjectArrayWrapperImpl(mgr);
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
