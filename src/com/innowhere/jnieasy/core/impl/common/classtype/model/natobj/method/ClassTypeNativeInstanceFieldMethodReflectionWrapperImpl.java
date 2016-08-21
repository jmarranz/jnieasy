/*
 * ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeInstanceFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;



/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl extends ClassTypeNativeFieldMethodReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeInstanceFieldMethodReflection.class;
    public static final Class CLASS = NativeInstanceFieldMethodReflectionImpl.class;
    
    /**
     * Creates a new instance of ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl
     */
    public ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFieldMethodReflectionImpl.getClassTypeNativeFieldMethodReflection(mgr),mgr,false);
    }
    
    public static void registerClassTypeNativeInstanceFieldMethodReflectionWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl classType = new ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl(mgr);
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
        return new TypeNativeInstanceFieldMethodReflectionWrapperImpl(this);                
    }
    
    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeInstanceFieldMethodReflectionWrapperImpl(this,(TypeNativeFieldMethodReflectionImpl)typeDecWrapped);        
    }     
}
