/*
 * ClassTypeNativeStringWrapperDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;


public class ClassTypeNativeStringWrapperDefaultImpl extends ClassTypeNativeStringWrapperImpl
{
    public static final Class INTERFACE = NativeString.class;
    public static final Class CLASS = NativeStringWrapperDefaultImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeStringWrapperDefaultImpl
     */
    public ClassTypeNativeStringWrapperDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeStringImpl.getClassTypeString(classTypeMgr), classTypeMgr,true);
    }
    
    public static void registerClassTypeStringWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringWrapperDefaultImpl classType = new ClassTypeNativeStringWrapperDefaultImpl(mgr);
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

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeStringWrapperDefaultImpl(this);
    }              

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringWrapperDefaultImpl(this,(TypeNativeStringImpl)typeDecWrapped);        
    }     
}
