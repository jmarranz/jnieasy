/*
 * ClassTypeNativeStaticFieldMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeStaticFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeStaticFieldMethodReflectionWrapperImpl extends ClassTypeNativeFieldMethodReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeStaticFieldMethodReflection.class;
    public static final Class CLASS = NativeStaticFieldMethodReflectionImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeStaticFieldMethodReflectionWrapperImpl
     */
    public ClassTypeNativeStaticFieldMethodReflectionWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFieldMethodReflectionImpl.getClassTypeNativeFieldMethodReflection(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStaticFieldMethodReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticFieldMethodReflectionWrapperImpl classType = new ClassTypeNativeStaticFieldMethodReflectionWrapperImpl(mgr);
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
        return new TypeNativeStaticFieldMethodReflectionWrapperImpl(this);                
    }

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStaticFieldMethodReflectionWrapperImpl(this,(TypeNativeFieldMethodReflectionImpl)typeDecWrapped);        
    }     
}
