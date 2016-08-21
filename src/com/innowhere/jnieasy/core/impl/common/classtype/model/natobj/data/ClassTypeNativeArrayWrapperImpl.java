/*
 * ClassTypeNativeArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeArrayInfo;



public abstract class ClassTypeNativeArrayWrapperImpl extends ClassTypeCanBeNativeCapableWrapperImpl implements ClassTypeNativeArrayInterface
{
    /**
     * Creates a new instance of ClassTypeNativeArrayWrapperImpl
     */
    public ClassTypeNativeArrayWrapperImpl(ClassTypeNativeArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveArrayWrapperImpl.registerClassTypeNativePrimitiveArrayWrapper(mgr);
        ClassTypeNativeObjectArrayWrapperImpl.registerClassTypeNativeObjectArrayWrapper(mgr);
    }

    public ClassTypeNativeArrayInfo getArrayInfo()
    {
        ClassTypeNativeArrayImpl arrayType = (ClassTypeNativeArrayImpl)getClassTypeCanBeNativeCapable();
        return arrayType.getArrayInfo();        
    }
    
    public ClassTypeNativeArrayImpl getArrayType()
    {
        return (ClassTypeNativeArrayImpl)getClassTypeCanBeNativeCapable();
    }

    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeArray.class,valueClass);
    }        
    
    public static ClassTypeNativeArrayWrapperImpl newCustomClassTypeArrayWrapper(MetaClassWrapper valueClass,TaskContext ctx)
    {
       	return ClassTypeNativeObjectArrayWrapperImpl.newCustomClassTypeNativeObjectArrayWrapper(valueClass,ctx);
    }
}
