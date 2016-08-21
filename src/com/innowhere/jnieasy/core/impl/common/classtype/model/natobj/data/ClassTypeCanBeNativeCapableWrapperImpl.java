/*
 * ClassTypeCanBeNativeCapableWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;

public abstract class ClassTypeCanBeNativeCapableWrapperImpl extends ClassTypeNativeObjectFieldContainerImpl
{
    /**
     * Creates a new instance of ClassTypeCanBeNativeCapableWrapperImpl
     */
    public ClassTypeCanBeNativeCapableWrapperImpl(ClassTypeCanBeNativeCapableImpl fieldClassType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(fieldClassType,classTypeMgr);

        if (isDefault)
            fieldClassType.setDefaultClassTypeCanBeNativeCapableWrapper(this);         
    }    

    public static void registerClassTypeCanBeNativeCapableWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveObjectWrapperImpl.registerClassTypeNativePrimitiveObjectWrapper(mgr);        
        ClassTypeNativeStringBasedWrapperImpl.registerClassTypeNativeStringBasedWrapper(mgr);
        ClassTypeNativeMemberReflectionWrapperImpl.registerClassTypeNativeMemberReflectionWrapper(mgr);
        ClassTypeNativeArrayWrapperImpl.registerClassTypeArrayWrapper(mgr);        
    }

    public ClassTypeCanBeNativeCapableImpl getClassTypeCanBeNativeCapable()
    {
        return (ClassTypeCanBeNativeCapableImpl)fieldClassType;
    }
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(CanBeNativeCapable.class,valueClass);
    }        
    
    public static ClassTypeCanBeNativeCapableWrapperImpl newCustomClassTypeCanBeNativeCapableWrapper(MetaClassWrapper valueClass,TaskContext ctx)
    {
        return ClassTypeNativeArrayWrapperImpl.newCustomClassTypeArrayWrapper(valueClass,ctx);
    }

    public abstract TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped);
}
