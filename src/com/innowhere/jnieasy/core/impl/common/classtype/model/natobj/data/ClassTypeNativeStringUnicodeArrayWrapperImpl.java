/*
 * ClassTypeNativeStringUnicodeArrayWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringUnicodeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringUnicodeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;


public class ClassTypeNativeStringUnicodeArrayWrapperImpl extends ClassTypeNativeStringArrayWrapperImpl
{
    public static final Class INTERFACE = NativeStringUnicodeArray.class;
    public static final Class CLASS = NativeStringUnicodeArrayImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeStringUnicodeArrayWrapperImpl
     */
    public ClassTypeNativeStringUnicodeArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringArrayImpl.getClassTypeNativeStringArray(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringUnicodeArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringUnicodeArrayWrapperImpl classType = new ClassTypeNativeStringUnicodeArrayWrapperImpl(mgr);
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
        return new TypeNativeStringUnicodeArrayWrapperImpl(this);
    }  

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringUnicodeArrayWrapperImpl(this,(TypeNativeStringArrayImpl)typeDecWrapped);        
    } 
}

