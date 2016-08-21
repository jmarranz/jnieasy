/*
 * ClassTypeNativeStringBufferUnicodeWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringBufferUnicodeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferUnicodeWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;

public class ClassTypeNativeStringBufferUnicodeWrapperImpl extends ClassTypeNativeStringBufferWrapperImpl
{
    public static final Class INTERFACE = NativeStringBufferUnicode.class;
    public static final Class CLASS = NativeStringBufferUnicodeImpl.class;    
   
    /**
     * Creates a new instance of ClassTypeNativeStringBufferUnicodeWrapperImpl
     */
    public ClassTypeNativeStringBufferUnicodeWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringBufferImpl.getClassTypeStringBuffer(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringBufferUnicodeWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferUnicodeWrapperImpl classType = new ClassTypeNativeStringBufferUnicodeWrapperImpl(mgr);
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
        return new TypeNativeStringBufferUnicodeWrapperImpl(this);                
    }  

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringBufferUnicodeWrapperImpl(this,(TypeNativeStringBufferImpl)typeDecWrapped);        
    } 
}
