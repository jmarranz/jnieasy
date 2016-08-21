/*
 * ClassTypeNativePrimitiveObjectWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;

/**
 *
 * @author  jmarranz
 */


public abstract class ClassTypeNativePrimitiveObjectWrapperImpl extends ClassTypeCanBeNativeCapableWrapperImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativePrimitiveObjectWrapperImpl
     */
    public ClassTypeNativePrimitiveObjectWrapperImpl(ClassTypeNativePrimitiveObjectImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }    
    
    public static void registerClassTypeNativePrimitiveObjectWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectWrapperImpl.registerClassTypeNativeBooleanObjectWrapper(mgr);
        ClassTypeNativeCharacterObjectWrapperImpl.registerClassTypeNativeCharacterObjectWrapper(mgr);
        ClassTypeNativeNumberObjectWrapperImpl.registerClassTypeNativeNumberObjectWrapper(mgr);
    } 
    

    public ClassTypeNativePrimitiveObjectImpl getPrimitiveObjectType()
    {
        return (ClassTypeNativePrimitiveObjectImpl)getClassTypeCanBeNativeCapable();
    }

    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveObjectWrapperRuntimeImpl(this,rtMgr);
    }   
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
    
    public TypeNativePrimitiveObjectWrapperImpl newTypeNativePrimitiveObjectWrapper(TypeNativePrimitiveObjectImpl fieldType)
    {
        return new TypeNativePrimitiveObjectWrapperImpl(this,fieldType);
    }  
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveObjectWrapperImpl(this);                
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativePrimitiveObjectWrapperImpl(this,(TypeNativePrimitiveObjectImpl)typeDecWrapped);        
    }     
}
