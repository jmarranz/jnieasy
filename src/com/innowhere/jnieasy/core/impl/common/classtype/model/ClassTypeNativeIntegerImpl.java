/*
 * ClassTypeNativeIntegerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeIntegerImpl extends ClassTypeNativeNumberImpl
{
    public static final Class CLASS = int.class;
    
    /**
     * Creates a new instance of ClassTypeNativeIntegerImpl
     */
    public ClassTypeNativeIntegerImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeIntegerImpl getClassTypeNativeInteger(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeIntegerImpl)mgr.findClassType(CLASS.getName());   
    }    
        
    public static void registerClassTypeNativeInteger(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerImpl classType = new ClassTypeNativeIntegerImpl(mgr);
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
        return Integer.class.getName();
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeIntegerImpl(this);
    }        
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeIntegerRuntimeImpl(this,rtMgr);
    }    
}
