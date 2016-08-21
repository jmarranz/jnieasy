/*
 * ClassTypeNativeStringBufferUnicodeArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringBufferUnicodeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferUnicodeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;



public class ClassTypeNativeStringBufferUnicodeArrayWrapperImpl extends ClassTypeNativeStringBufferArrayWrapperImpl
{
    public static final Class INTERFACE = NativeStringBufferUnicodeArray.class;
    public static final Class CLASS = NativeStringBufferUnicodeArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeStringBufferUnicodeArrayWrapperImpl
     */
    public ClassTypeNativeStringBufferUnicodeArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringBufferArrayImpl.getClassTypeNativeStringBufferArray(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringBufferUnicodeArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferUnicodeArrayWrapperImpl classType = new ClassTypeNativeStringBufferUnicodeArrayWrapperImpl(mgr);
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
        return new TypeNativeStringBufferUnicodeArrayWrapperImpl(this);
    }  

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringBufferUnicodeArrayWrapperImpl(this,(TypeNativeStringBufferArrayImpl)typeDecWrapped);        
    }    
}

