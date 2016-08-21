/*
 * ClassTypeNativeFieldMethodReflectionArrayImpl.java
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


public class ClassTypeNativeFieldMethodReflectionArrayImpl extends ClassTypeNativeBehaviorReflectionArrayImpl
{
    public static final Class CLASS = Field[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeFieldMethodReflectionArrayImpl
     */
    public ClassTypeNativeFieldMethodReflectionArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFieldMethodReflectionImpl.getClassTypeNativeFieldMethodReflection(mgr));
    }
    
    public static void registerClassTypeNativeFieldMethodReflectionArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFieldMethodReflectionArrayImpl classType = new ClassTypeNativeFieldMethodReflectionArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeFieldMethodReflectionArrayImpl getClassTypeNativeFieldMethodReflectionArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeFieldMethodReflectionArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Field[length];
    }    

}
