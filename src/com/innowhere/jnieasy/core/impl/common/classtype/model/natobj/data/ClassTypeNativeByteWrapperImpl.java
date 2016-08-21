/*
 * ClassTypeNativeByteWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeByteImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeByteImpl;

public class ClassTypeNativeByteWrapperImpl extends ClassTypeNativeNumberWrapperImpl
{
    public static final Class INTERFACE = NativeByte.class;
    public static final Class CLASS = NativeByteImpl.class;    
   
    /**
     * Creates a new instance of ClassTypeNativeByteWrapperImpl
     */
    public ClassTypeNativeByteWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeByteImpl.getClassTypeNativeByte(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeByteWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteWrapperImpl classType = new ClassTypeNativeByteWrapperImpl(mgr);
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

