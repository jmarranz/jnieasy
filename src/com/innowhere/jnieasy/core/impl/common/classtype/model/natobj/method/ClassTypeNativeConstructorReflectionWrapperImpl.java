/*
 * ConstructorWrapperType.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeConstructorReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeConstructorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeConstructorReflectionImpl;



/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeConstructorReflectionWrapperImpl extends ClassTypeNativeBehaviorReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeConstructorReflection.class;
    public static final Class CLASS = NativeConstructorReflectionImpl.class;
    
    /**
     * Creates a new instance of ClassTypeNativeConstructorReflectionWrapperImpl
     */
    public ClassTypeNativeConstructorReflectionWrapperImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeConstructorReflectionImpl.getClassTypeNativeConstructorReflection(classTypeMgr), classTypeMgr,true);
    }

    public static void registerClassTypeNativeConstructorReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionWrapperImpl classType = new ClassTypeNativeConstructorReflectionWrapperImpl(mgr);
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
    
    public ClassTypeNativeConstructorReflectionImpl getClassTypeNativeConstructorReflection()
    {
        return (ClassTypeNativeConstructorReflectionImpl)fieldClassType;
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeConstructorReflectionWrapperImpl(this);                
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeConstructorReflectionWrapperImpl(this,(TypeNativeConstructorReflectionImpl)typeDecWrapped);        
    }  
}
