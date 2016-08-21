/*
 * ClassTypeNativeMethodReflectionArrayImpl.java
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


public class ClassTypeNativeMethodReflectionArrayImpl extends ClassTypeNativeBehaviorReflectionArrayImpl
{
    public static final Class CLASS = Method[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeMethodReflectionArrayImpl
     */
    public ClassTypeNativeMethodReflectionArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeMethodReflectionImpl.getClassTypeNativeMethodReflection(mgr));
    }
    
    public static void registerClassTypeNativeMethodReflectionArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeMethodReflectionArrayImpl classType = new ClassTypeNativeMethodReflectionArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeMethodReflectionArrayImpl getClassTypeNativeMethodReflectionArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeMethodReflectionArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Method[length];
    }    

}
