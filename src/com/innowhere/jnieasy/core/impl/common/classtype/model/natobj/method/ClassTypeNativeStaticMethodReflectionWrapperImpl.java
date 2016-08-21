/*
 * ClassTypeNativeStaticMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeStaticMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeStaticMethodReflectionWrapperImpl extends ClassTypeNativeMethodReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeStaticMethodReflection.class;
    public static final Class CLASS = NativeStaticMethodReflectionImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeStaticMethodReflectionWrapperImpl
     */
    public ClassTypeNativeStaticMethodReflectionWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeMethodReflectionImpl.getClassTypeNativeMethodReflection(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStaticMethodReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticMethodReflectionWrapperImpl classType = new ClassTypeNativeStaticMethodReflectionWrapperImpl(mgr);
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
        return new TypeNativeStaticMethodReflectionWrapperImpl(this);                
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStaticMethodReflectionWrapperImpl(this,(TypeNativeMethodReflectionImpl)typeDecWrapped);        
    }     
}
