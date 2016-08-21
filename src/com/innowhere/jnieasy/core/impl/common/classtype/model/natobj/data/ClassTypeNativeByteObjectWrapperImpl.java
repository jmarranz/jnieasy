/*
 * ClassTypeNativeByteObjectWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeByteObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeByteObjectImpl;


public class ClassTypeNativeByteObjectWrapperImpl extends ClassTypeNativeNumberObjectWrapperImpl
{
    public static final Class INTERFACE = NativeByteObject.class;
    public static final Class CLASS = NativeByteObjectImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeByteObjectWrapperImpl
     */
    public ClassTypeNativeByteObjectWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeByteObjectImpl.getClassTypeNativeByteObject(classTypeMgr), classTypeMgr,true);
    }    
    
    public static void registerClassTypeNativeByteObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectWrapperImpl classType = new ClassTypeNativeByteObjectWrapperImpl(mgr);
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
