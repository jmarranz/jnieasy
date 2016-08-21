/*
 * ClassTypeNativeFieldMethodReflectionArrayWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.NativeFieldMethodReflectionArray;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeFieldMethodReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.*;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeFieldMethodReflectionArrayWrapperImpl extends ClassTypeNativeBehaviorReflectionArrayWrapperImpl
{
    public static final Class INTERFACE = NativeFieldMethodReflectionArray.class;
    public static final Class CLASS = NativeFieldMethodReflectionArrayImpl.class;
  
    
    /**
     * Creates a new instance of ClassTypeNativeFieldMethodReflectionArrayWrapperImpl
     */
    public ClassTypeNativeFieldMethodReflectionArrayWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFieldMethodReflectionArrayImpl.getClassTypeNativeFieldMethodReflectionArray(mgr), mgr,true);
    }    
    
    public static void registerClassTypeNativeFieldMethodReflectionArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFieldMethodReflectionArrayWrapperImpl classType = new ClassTypeNativeFieldMethodReflectionArrayWrapperImpl(mgr);
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
