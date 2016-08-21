/*
 * ClassTypeNativeStringBufferWrapperDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringBufferWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;



public class ClassTypeNativeStringBufferWrapperDefaultImpl extends ClassTypeNativeStringBufferWrapperImpl
{
    public static final Class INTERFACE = NativeStringBuffer.class;
    public static final Class CLASS = NativeStringBufferWrapperDefaultImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeStringBufferWrapperDefaultImpl
     */
    public ClassTypeNativeStringBufferWrapperDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeStringBufferImpl.getClassTypeStringBuffer(classTypeMgr),classTypeMgr,true);
    }
    
    public static void registerClassTypeStringBufferWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferWrapperDefaultImpl classType = new ClassTypeNativeStringBufferWrapperDefaultImpl(mgr);
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
        return new TypeNativeStringBufferWrapperDefaultImpl(this);                
    }              

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringBufferWrapperDefaultImpl(this,(TypeNativeStringBufferImpl)typeDecWrapped);        
    }     
}
