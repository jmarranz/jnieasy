/*
 * ClassTypeNativeFloatImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeFloatImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeFloatImpl extends ClassTypeNativeNumberImpl
{
    public static final Class CLASS = float.class;
  
    /**
     * Creates a new instance of ClassTypeNativeFloatImpl
     */
    public ClassTypeNativeFloatImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeFloatImpl getClassTypeNativeFloat(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeFloatImpl)mgr.findClassType(CLASS.getName());   
    }        
    
    public static void registerClassTypeNativeFloat(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatImpl classType = new ClassTypeNativeFloatImpl(mgr);
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
        return Float.class.getName();
    }     
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeFloatImpl(this);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeFloatRuntimeImpl(this,rtMgr);
    }      
}
