/*
 * ClassTypeNativeObjectImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:18
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;



public abstract class ClassTypeCanBeNativeCapableImpl extends ClassTypeNativeObjectImpl
{
    protected ClassTypeCanBeNativeCapableWrapperImpl wrapperClassType;
    
    /**
     * Creates a new instance of ClassTypeNativeObjectImpl
     */
    public ClassTypeCanBeNativeCapableImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeCanBeNativeCapable(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveObjectImpl.registerClassTypeNativePrimitiveObject(mgr);        
        ClassTypeNativeStringBasedImpl.registerClassTypeNativeStringBased(mgr);
        ClassTypeNativeMemberReflectionImpl.registerClassTypeNativeMemberReflection(mgr);                
        ClassTypeNativeArrayImpl.registerClassTypeNativeArray(mgr);    
    } 
    
    public static ClassTypeCanBeNativeCapableImpl newCustomClassTypeCanBeNativeCapable(MetaClassWrapper valueClass,TaskContext ctx)
    {
        return ClassTypeNativeArrayImpl.newCustomArrayType(valueClass,ctx);
    }
        
    public String getVMClassImplName()
    {
        // No hay distinción entre ambos tipos de clases, sólo hay una
        return getVMClassName();
    }
    
    public ClassTypeCanBeNativeCapableWrapperImpl getDefaultClassTypeCanBeNativeCapableWrapper()
    {
        return wrapperClassType;
    }
    
    public void setDefaultClassTypeCanBeNativeCapableWrapper(ClassTypeCanBeNativeCapableWrapperImpl wrapperClassType)
    {
        this.wrapperClassType = wrapperClassType;
    }

    public abstract TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType);
}
