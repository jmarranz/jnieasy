/*
 * ClassTypeNativePrimitiveWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveWrapperRuntimeImpl;

public abstract class ClassTypeNativePrimitiveWrapperImpl extends ClassTypeNativeSingleFieldContainerImpl
{
    /**
     * Creates a new instance of ClassTypeNativePrimitiveWrapperImpl
     */
    public ClassTypeNativePrimitiveWrapperImpl(ClassTypeNativePrimitiveImpl fieldClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(fieldClassType,classTypeMgr);
        
        fieldClassType.setClassTypeNativePrimitiveWrapper(this);
    }
    
    public static void registerClassTypeNativePrimitiveWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanWrapperImpl.registerClassTypeNativeBooleanWrapper(mgr);
        ClassTypeNativeCharacterWrapperImpl.registerClassTypeNativeCharacterWrapper(mgr);
        ClassTypeNativeNumberWrapperImpl.registerClassTypeNativeNumberWrapper(mgr);
    } 
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativePrimitive.class,valueClass);
    }    
    
    public ClassTypeNativePrimitiveImpl getClassTypeNativePrimitive()
    {
        return (ClassTypeNativePrimitiveImpl)fieldClassType;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveWrapperRuntimeImpl(this,rtMgr);
    }
   
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
    
    public TypeNativePrimitiveWrapperImpl newTypeNativePrimitiveWrapper(TypeNativePrimitiveImpl fieldType)
    {
        return new TypeNativePrimitiveWrapperImpl(this,fieldType);
    }    

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveWrapperImpl(this);
    }     

}

