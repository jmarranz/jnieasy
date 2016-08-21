/*
 * ClassTypeNativeStringBufferArrayWrapperDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringBufferArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;




public class ClassTypeNativeStringBufferArrayWrapperDefaultImpl extends ClassTypeNativeStringBufferArrayWrapperImpl
{
    public static final Class INTERFACE = NativeStringBufferArray.class;
    public static final Class CLASS = NativeStringBufferArrayDefaultImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeStringBufferArrayWrapperDefaultImpl
     */
    public ClassTypeNativeStringBufferArrayWrapperDefaultImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringBufferArrayImpl.getClassTypeNativeStringBufferArray(mgr),mgr,true);
    }
    
    public static void registerClassTypeNativeStringBufferArrayWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferArrayWrapperDefaultImpl classType = new ClassTypeNativeStringBufferArrayWrapperDefaultImpl(mgr);
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
        return new TypeNativeStringBufferArrayWrapperDefaultImpl(this);
    }           

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringBufferArrayWrapperDefaultImpl(this,(TypeNativeStringBufferArrayImpl)typeDecWrapped);        
    }     
}
