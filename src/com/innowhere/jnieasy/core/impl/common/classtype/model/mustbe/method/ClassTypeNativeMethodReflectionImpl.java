/*
 * ClassTypeNativeMethodReflectionImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import java.lang.reflect.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method.ClassTypeNativeMethodReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodReflectionWrapperImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeMethodReflectionImpl extends ClassTypeNativeBehaviorReflectionImpl
{
    public static final Class CLASS = Method.class;
    
    /** Creates a new instance of MethodType */
    public ClassTypeNativeMethodReflectionImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }

    public static void registerClassTypeNativeMethodReflection(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeMethodReflectionImpl classType = new ClassTypeNativeMethodReflectionImpl(mgr);
        classType.registerClassType();
    }         
    
    public static ClassTypeNativeMethodReflectionImpl getClassTypeNativeMethodReflection(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeMethodReflectionImpl)mgr.findClassType(CLASS.getName());   
    }
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
    
    public Object newValueDefaultClass()
    {
        throw new JNIEasyException("Cannot instantiate a Method object");
    }
    
    public ClassTypeNativeMethodReflectionWrapperImpl getClassTypeNativeMethodReflectionWrapper()
    {
        return (ClassTypeNativeMethodReflectionWrapperImpl)wrapperClassType;
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeMethodReflectionImpl(this);
    }
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeMethodReflectionImpl(this,(TypeNativeMethodReflectionWrapperImpl)wrapperType);        
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeMethodReflectionRuntimeImpl(this,rtMgr);
    }        
}
