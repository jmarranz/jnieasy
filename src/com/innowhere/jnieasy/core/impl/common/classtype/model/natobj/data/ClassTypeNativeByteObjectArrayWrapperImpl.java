/*
 * ClassTypeNativeByteObjectArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeByteObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeByteObjectArrayImpl;


public class ClassTypeNativeByteObjectArrayWrapperImpl extends ClassTypeNativeNumberObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeByteObjectArray.class;
    public static final Class CLASS = NativeByteObjectArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeByteObjectArrayWrapperImpl
     */
    public ClassTypeNativeByteObjectArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeByteObjectArrayImpl.getClassTypeNativeByteObjectArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeByteObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectArrayWrapperImpl classType = new ClassTypeNativeByteObjectArrayWrapperImpl(mgr);
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
