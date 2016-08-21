/*
 * ClassTypeNativeCapableArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableArrayWrapperImpl;


public abstract class ClassTypeNativeCapableArrayWrapperImpl extends ClassTypeNativeObjectArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayWrapperImpl
     */
    public ClassTypeNativeCapableArrayWrapperImpl(ClassTypeNativeCapableArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType, classTypeMgr,isDefault);
    }   
        
    public ClassTypeNativeCapableArrayImpl getClassTypeNativeCapableArray()
    {
        return (ClassTypeNativeCapableArrayImpl)fieldClassType;
    }
    
    public static void registerClassTypeNativeCapableArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCapableArrayWrapperDefaultImpl.registerClassTypeNativeCapableArrayWrapperDefault(mgr);
    } 
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeCapableArray.class,valueClass);
    }    
    
    public static ClassTypeNativeCapableArrayWrapperImpl newCustomClassTypeNativeCapableArrayWrapper(MetaClassWrapper valueClass,String arrayClassName,ClassTypeNativeCapableImpl compClassType,JNIEasyImpl jniEasy)
    {
        return ClassTypeNativeCapableArrayWrapperCustomImpl.newClassTypeNativeCapableArrayWrapperCustom(valueClass.getName(),arrayClassName,compClassType,jniEasy);
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeCapableArrayWrapperImpl(this);
    }

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeCapableArrayWrapperImpl(this,(TypeNativeCapableArrayImpl)typeDecWrapped);        
    }        
}
