/*
 * ClassTypeNativeInstanceMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeInstanceMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeInstanceMethodReflectionWrapperImpl extends ClassTypeNativeMethodReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeInstanceMethodReflection.class;
    public static final Class CLASS = NativeInstanceMethodReflectionImpl.class;
    
    /**
     * Creates a new instance of ClassTypeNativeInstanceMethodReflectionWrapperImpl
     */
    public ClassTypeNativeInstanceMethodReflectionWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeMethodReflectionImpl.getClassTypeNativeMethodReflection(mgr), mgr, false);
    }
    
    public static void registerClassTypeNativeInstanceMethodReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeInstanceMethodReflectionWrapperImpl classType = new ClassTypeNativeInstanceMethodReflectionWrapperImpl(mgr);
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
        return new TypeNativeInstanceMethodReflectionWrapperImpl(this);                
    }
    
    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeInstanceMethodReflectionWrapperImpl(this,(TypeNativeMethodReflectionImpl)typeDecWrapped);        
    }     
}
