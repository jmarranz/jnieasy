/*
 * ClassTypeNativeConstructorReflectionImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import java.lang.reflect.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeConstructorReflectionArrayImpl extends ClassTypeNativeBehaviorReflectionArrayImpl
{
    public static final Class CLASS = Constructor[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeConstructorReflectionImpl
     */
    public ClassTypeNativeConstructorReflectionArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeConstructorReflectionImpl.getClassTypeNativeConstructorReflection(mgr));
    }
    
    public static void registerClassTypeNativeConstructorReflectionArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionArrayImpl classType = new ClassTypeNativeConstructorReflectionArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeConstructorReflectionArrayImpl getClassTypeNativeConstructorReflectionArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeConstructorReflectionArrayImpl)mgr.findClassType(CLASS.getName());   
    }   
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
  
    public Object newValueDefaultClass(int length)
    {
        return new Constructor[length];
    }        

}
