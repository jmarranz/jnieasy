/*
 * ClassTypeNativeStringAnsiArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringAnsiArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringAnsiArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;


public class ClassTypeNativeStringAnsiArrayWrapperImpl extends ClassTypeNativeStringArrayWrapperImpl
{
    public static final Class INTERFACE = NativeStringAnsiArray.class;
    public static final Class CLASS = NativeStringAnsiArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeStringAnsiArrayWrapperImpl
     */
    public ClassTypeNativeStringAnsiArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringArrayImpl.getClassTypeNativeStringArray(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringAnsiArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringAnsiArrayWrapperImpl classType = new ClassTypeNativeStringAnsiArrayWrapperImpl(mgr);
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
        return new TypeNativeStringAnsiArrayWrapperImpl(this);
    }        
    
    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringAnsiArrayWrapperImpl(this,(TypeNativeStringArrayImpl)typeDecWrapped);        
    }     
}

