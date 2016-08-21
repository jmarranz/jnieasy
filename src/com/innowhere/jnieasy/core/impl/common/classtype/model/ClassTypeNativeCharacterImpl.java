/*
 * ClassTypeNativeCharacterImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeCharacterImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;

public class ClassTypeNativeCharacterImpl extends ClassTypeNativePrimitiveImpl
{
    public static final Class CLASS = char.class;
    
    /**
     * Creates a new instance of ClassTypeNativeCharacterImpl
     */
    public ClassTypeNativeCharacterImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeCharacterImpl getClassTypeNativeCharacter(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeCharacterImpl)mgr.findClassType(CLASS.getName());   
    }    
        
    public static void registerClassTypeNativeCharacter(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterImpl classType = new ClassTypeNativeCharacterImpl(mgr);
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
        return Character.class.getName();
    }    
        
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeCharacterImpl(this);
    }    
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeCharacterRuntimeImpl(this,rtMgr);
    }    
}
