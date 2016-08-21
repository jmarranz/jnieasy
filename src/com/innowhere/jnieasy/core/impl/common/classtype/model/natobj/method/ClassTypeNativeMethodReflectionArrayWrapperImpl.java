/*
 * MethodReflectionWrapperType.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeMethodReflectionArrayImpl;

/**
 *
 * @author  jmarranz
 */



public class ClassTypeNativeMethodReflectionArrayWrapperImpl extends ClassTypeNativeBehaviorReflectionArrayWrapperImpl
{
    public static final Class INTERFACE = NativeMethodReflectionArray.class;
    public static final Class CLASS = NativeMethodReflectionArrayImpl.class;
  
    
    /** Creates a new instance of MethodReflectionWrapperType */
    public ClassTypeNativeMethodReflectionArrayWrapperImpl(ClassTypeManagerImpl mgr)    
    {
        super(ClassTypeNativeMethodReflectionArrayImpl.getClassTypeNativeMethodReflectionArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeMethodReflectionArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeMethodReflectionArrayWrapperImpl classType = new ClassTypeNativeMethodReflectionArrayWrapperImpl(mgr);
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

}
