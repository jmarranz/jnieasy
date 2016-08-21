/*
 * ClassTypeNativeFieldMethodReflectionImpl.java
 *
 * Created on 29 de noviembre de 2004, 20:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import java.lang.reflect.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method.ClassTypeNativeFieldMethodReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodReflectionWrapperImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeFieldMethodReflectionImpl extends ClassTypeNativeBehaviorReflectionImpl
{
    public static final Class CLASS = Field.class;
    
    /** Creates a new instance of FieldType */
    public ClassTypeNativeFieldMethodReflectionImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeFieldMethodReflection(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFieldMethodReflectionImpl classType = new ClassTypeNativeFieldMethodReflectionImpl(mgr);
        classType.registerClassType();
    } 
    
    public static ClassTypeNativeFieldMethodReflectionImpl getClassTypeNativeFieldMethodReflection(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeFieldMethodReflectionImpl)mgr.findClassType(CLASS.getName());   
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
        throw new JNIEasyException("Cannot instantiate a Field object");
    }
    
    public ClassTypeNativeFieldMethodReflectionWrapperImpl getClassTypeNativeFieldMethodReflectionWrapper()
    {
        return (ClassTypeNativeFieldMethodReflectionWrapperImpl)wrapperClassType;
    }
            
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeFieldMethodReflectionImpl(this);
    }
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeFieldMethodReflectionImpl(this,(TypeNativeFieldMethodReflectionWrapperImpl)wrapperType);        
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeFieldMethodReflectionRuntimeImpl(this,rtMgr);
    }        
}
