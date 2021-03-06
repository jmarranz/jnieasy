/*
 * ClassTypeNativeStringUnicodeWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringUnicodeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringUnicodeWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;


public class ClassTypeNativeStringUnicodeWrapperImpl extends ClassTypeNativeStringWrapperImpl
{
    public static final Class INTERFACE = NativeStringUnicode.class;
    public static final Class CLASS = NativeStringUnicodeImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeStringUnicodeWrapperImpl
     */
    public ClassTypeNativeStringUnicodeWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringImpl.getClassTypeString(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringUnicodeWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringUnicodeWrapperImpl classType = new ClassTypeNativeStringUnicodeWrapperImpl(mgr);
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
        return new TypeNativeStringUnicodeWrapperImpl(this);                
    }          

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringUnicodeWrapperImpl(this,(TypeNativeStringImpl)typeDecWrapped);        
    }     
}
