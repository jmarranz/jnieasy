/*
 * ClassTypeNativeStringImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperImpl;

/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStringImpl extends ClassTypeNativeStringBasedImpl
{
    public static final Class CLASS = String.class;
    
    /**
     * Creates a new instance of ClassTypeNativeStringImpl
     */
    public ClassTypeNativeStringImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeString(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringImpl classType = new ClassTypeNativeStringImpl(mgr);
        classType.registerClassType();
    }     
    
    public static ClassTypeNativeStringImpl getClassTypeString(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeStringImpl)mgr.findClassType(CLASS.getName());   
    }
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
    
    public Object newValueDefaultClass()
    {
        return new String();
    }
        
    public ClassTypeNativeStringWrapperImpl getClassTypeStringWrapper()
    {
        return (ClassTypeNativeStringWrapperImpl)wrapperClassType;
    }
            
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeStringImpl(this);
    }
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeStringImpl(this,(TypeNativeStringWrapperImpl)wrapperType);        
    }
}
