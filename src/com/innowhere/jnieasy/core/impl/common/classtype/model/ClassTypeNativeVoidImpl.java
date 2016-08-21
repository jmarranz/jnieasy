/*
 * ClassTypeNativeVoidImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeVoidImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeVoidRuntimeImpl;

public class ClassTypeNativeVoidImpl extends ClassTypeNativePrimitiveImpl
{
    public static final Class CLASS = void.class;
    
    /**
     * Creates a new instance of ClassTypeNativeVoidImpl
     */
    public ClassTypeNativeVoidImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeVoidImpl getClassTypeNativeVoid(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeVoidImpl)mgr.findClassType(CLASS.getName());   
    }    
    
    public static void registerClassTypeNativeVoid(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeVoidImpl classType = new ClassTypeNativeVoidImpl(mgr);
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
        return Void.class.getName();
    }    
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeVoidImpl(this);
    }    
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeVoidRuntimeImpl(this,rtMgr);
    }    
}
