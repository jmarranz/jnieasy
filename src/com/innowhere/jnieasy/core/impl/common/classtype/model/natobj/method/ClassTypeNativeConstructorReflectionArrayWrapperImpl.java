/*
 * ClassTypeNativeConstructorReflectionArrayWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:37
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeConstructorReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeConstructorReflectionArrayImpl;

public class ClassTypeNativeConstructorReflectionArrayWrapperImpl extends ClassTypeNativeBehaviorReflectionArrayWrapperImpl
{
    public static final Class INTERFACE = NativeConstructorReflectionArray.class;
    public static final Class CLASS = NativeConstructorReflectionArrayImpl.class;
    
    /**
     * Creates a new instance of ClassTypeNativeConstructorReflectionArrayWrapperImpl
     */
    public ClassTypeNativeConstructorReflectionArrayWrapperImpl(ClassTypeManagerImpl mgr)    
    {
        super(ClassTypeNativeConstructorReflectionArrayImpl.getClassTypeNativeConstructorReflectionArray(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeConstructorReflectionArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionArrayWrapperImpl classType = new ClassTypeNativeConstructorReflectionArrayWrapperImpl(mgr);
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
