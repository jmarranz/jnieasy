/*
 * ClassTypeNativeBooleanImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeBooleanImpl extends ClassTypeNativePrimitiveImpl
{
    public static final Class CLASS = boolean.class;
    
    /**
     * Creates a new instance of ClassTypeNativeBooleanImpl
     */
    public ClassTypeNativeBooleanImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }

    public static ClassTypeNativeBooleanImpl getClassTypeNativeBoolean(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeBooleanImpl)mgr.findClassType(CLASS.getName());   
    }    
    
    public static void registerClassTypeNativeBoolean(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanImpl classType = new ClassTypeNativeBooleanImpl(mgr);
        classType.registerClassType();
    }

    public String getVMClassName()
    {
        return CLASS.getName();
    } 
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
    
    public String getWrapperClassName()
    {
        return Boolean.class.getName();
    }     
  
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeBooleanImpl(this);
    }     
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeBooleanRuntimeImpl(this,rtMgr);
    }
}
