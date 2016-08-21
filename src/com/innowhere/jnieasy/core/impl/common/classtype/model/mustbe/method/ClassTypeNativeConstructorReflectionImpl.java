/*
 * ClassTypeNativeConstructorReflectionImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import java.lang.reflect.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeConstructorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method.ClassTypeNativeConstructorReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeConstructorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorReflectionWrapperImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeConstructorReflectionImpl extends ClassTypeNativeBehaviorReflectionImpl
{
    public static final Class CLASS = Constructor.class;
    
    /**
     * Creates a new instance of ClassTypeNativeConstructorReflectionImpl
     */
    public ClassTypeNativeConstructorReflectionImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeConstructorReflection(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorReflectionImpl classType = new ClassTypeNativeConstructorReflectionImpl(mgr);
        classType.registerClassType();
    }     
    
    public static ClassTypeNativeConstructorReflectionImpl getClassTypeNativeConstructorReflection(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeConstructorReflectionImpl)mgr.findClassType(CLASS.getName());   
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
        throw new JNIEasyException("Cannot instantiate a Constructor object");
    }
    
    public ClassTypeNativeConstructorReflectionWrapperImpl getClassTypeNativeConstructorReflectionWrapper()
    {
        return (ClassTypeNativeConstructorReflectionWrapperImpl)wrapperClassType;
    }
            
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeConstructorReflectionImpl(this);
    }    
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeConstructorReflectionImpl(this,(TypeNativeConstructorReflectionWrapperImpl)wrapperType);        
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeConstructorReflectionRuntimeImpl(this,rtMgr);
    }    

}
