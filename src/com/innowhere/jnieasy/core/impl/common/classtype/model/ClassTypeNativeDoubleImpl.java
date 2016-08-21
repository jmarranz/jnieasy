/*
 * ClassTypeNativeDoubleImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeDoubleImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeDoubleImpl extends ClassTypeNativeNumberImpl
{
    public static final Class CLASS = double.class;

    /**
     * Creates a new instance of ClassTypeNativeDoubleImpl
     */
    public ClassTypeNativeDoubleImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeDoubleImpl getClassTypeNativeDouble(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeDoubleImpl)mgr.findClassType(CLASS.getName());   
    }    
        
    public static void registerClassTypeNativeDouble(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleImpl classType = new ClassTypeNativeDoubleImpl(mgr);
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
        return Double.class.getName();
    }    
        
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeDoubleImpl(this);
    }    
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeDoubleRuntimeImpl(this,rtMgr);
    }    
}
