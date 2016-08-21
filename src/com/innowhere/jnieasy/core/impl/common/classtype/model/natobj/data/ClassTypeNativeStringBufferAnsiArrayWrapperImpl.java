/*
 * ClassTypeNativeStringBufferAnsiArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringBufferAnsiArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferAnsiArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;


public class ClassTypeNativeStringBufferAnsiArrayWrapperImpl extends ClassTypeNativeStringBufferArrayWrapperImpl
{
    public static final Class INTERFACE = NativeStringBufferAnsiArray.class;
    public static final Class CLASS = NativeStringBufferAnsiArrayImpl.class; 
    
    /**
     * Creates a new instance of ClassTypeNativeStringBufferAnsiArrayWrapperImpl
     */
    public ClassTypeNativeStringBufferAnsiArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringBufferArrayImpl.getClassTypeNativeStringBufferArray(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringBufferAnsiArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferAnsiArrayWrapperImpl classType = new ClassTypeNativeStringBufferAnsiArrayWrapperImpl(mgr);
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
        return new TypeNativeStringBufferAnsiArrayWrapperImpl(this);                
    }
    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringBufferAnsiArrayWrapperImpl(this,(TypeNativeStringBufferArrayImpl)typeDecWrapped);        
    }     
}

