/*
 * ClassTypeNativeShortObjectArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeShortObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeShortObjectArrayImpl;



public class ClassTypeNativeShortObjectArrayWrapperImpl extends ClassTypeNativeNumberObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeShortObjectArray.class;
    public static final Class CLASS = NativeShortObjectArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeShortObjectArrayWrapperImpl
     */
    public ClassTypeNativeShortObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeShortObjectArrayImpl.getClassTypeNativeShortObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeShortObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortObjectArrayWrapperImpl classType = new ClassTypeNativeShortObjectArrayWrapperImpl(mgr);
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
