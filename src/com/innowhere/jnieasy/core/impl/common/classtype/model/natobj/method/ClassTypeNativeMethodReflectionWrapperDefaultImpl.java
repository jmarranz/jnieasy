/*
 * ClassTypeNativeMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeMethodReflectionDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodReflectionWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;



/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeMethodReflectionWrapperDefaultImpl extends ClassTypeNativeMethodReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeMethodReflection.class;
    public static final Class CLASS = NativeMethodReflectionDefaultImpl.class;
        
    /**
     * Creates a new instance of ClassTypeNativeMethodReflectionWrapperImpl
     */
    public ClassTypeNativeMethodReflectionWrapperDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeMethodReflectionImpl.getClassTypeNativeMethodReflection(classTypeMgr), classTypeMgr, true);
    }
    
    public static void registerClassTypeNativeMethodReflectionWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeMethodReflectionWrapperDefaultImpl classType = new ClassTypeNativeMethodReflectionWrapperDefaultImpl(mgr);
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
        return new TypeNativeMethodReflectionWrapperDefaultImpl(this);                
    }
    
    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeMethodReflectionWrapperDefaultImpl(this,(TypeNativeMethodReflectionImpl)typeDecWrapped);        
    }     
}
