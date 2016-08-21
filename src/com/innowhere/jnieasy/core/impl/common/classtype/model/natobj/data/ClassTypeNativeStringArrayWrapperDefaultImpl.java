/*
 * ClassTypeNativeStringArrayWrapperDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;

public class ClassTypeNativeStringArrayWrapperDefaultImpl extends ClassTypeNativeStringArrayWrapperImpl
{
    public static final Class INTERFACE = NativeStringArray.class;
    public static final Class CLASS = NativeStringArrayDefaultImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeStringArrayWrapperDefaultImpl
     */
    public ClassTypeNativeStringArrayWrapperDefaultImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringArrayImpl.getClassTypeNativeStringArray(mgr),mgr,true);
    }
    
    public static void registerClassTypeNativeStringArrayWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringArrayWrapperDefaultImpl classType = new ClassTypeNativeStringArrayWrapperDefaultImpl(mgr);
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
        return new TypeNativeStringArrayWrapperDefaultImpl(this);
    }        

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringArrayWrapperDefaultImpl(this,(TypeNativeStringArrayImpl)typeDecWrapped);        
    }     
}
