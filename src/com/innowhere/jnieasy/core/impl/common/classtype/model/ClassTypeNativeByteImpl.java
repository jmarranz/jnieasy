/*
 * ClassTypeNativeByteImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeByteImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeByteImpl extends ClassTypeNativeNumberImpl
{
    public static final Class CLASS = byte.class;
   
    /**
     * Creates a new instance of ClassTypeNativeByteImpl
     */
    public ClassTypeNativeByteImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeByteImpl getClassTypeNativeByte(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeByteImpl)mgr.findClassType(CLASS.getName());   
    }    
    
    public static void registerClassTypeNativeByte(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteImpl classType = new ClassTypeNativeByteImpl(mgr);
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
        return Byte.class.getName();
    }    
       
       
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeByteImpl(this);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeByteRuntimeImpl(this,rtMgr);
    }    
}
