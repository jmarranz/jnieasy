/*
 * ClassTypeNativeShortImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeShortImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeShortRuntimeImpl;

public class ClassTypeNativeShortImpl extends ClassTypeNativeNumberImpl
{
    public static final Class CLASS = short.class;
   
    /**
     * Creates a new instance of ClassTypeNativeShortImpl
     */
    public ClassTypeNativeShortImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeShortImpl getClassTypeNativeShort(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeShortImpl)mgr.findClassType(CLASS.getName());   
    }    
        
    public static void registerClassTypeNativeShort(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortImpl classType = new ClassTypeNativeShortImpl(mgr);
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
        return Short.class.getName();
    }    

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeShortImpl(this);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeShortRuntimeImpl(this,rtMgr);
    }    
}
