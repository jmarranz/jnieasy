/*
 * ClassTypeNativeLongImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeLongImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeLongImpl extends ClassTypeNativeNumberImpl
{
    public static final Class CLASS = long.class;
 
    /**
     * Creates a new instance of ClassTypeNativeLongImpl
     */
    public ClassTypeNativeLongImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeLongImpl getClassTypeNativeLong(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeLongImpl)mgr.findClassType(CLASS.getName());   
    }    
        
    public static void registerClassTypeNativeLong(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongImpl classType = new ClassTypeNativeLongImpl(mgr);
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
        return Long.class.getName();
    }
       
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeLongImpl(this);
    }     
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeLongRuntimeImpl(this,rtMgr);
    }    
}
