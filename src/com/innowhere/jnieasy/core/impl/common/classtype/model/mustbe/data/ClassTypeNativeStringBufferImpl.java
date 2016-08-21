/*
 * StringType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferWrapperImpl;

/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStringBufferImpl extends ClassTypeNativeStringBasedImpl
{
    public static final Class CLASS = StringBuffer.class;
    
    /** Creates a new instance of StringType */
    public ClassTypeNativeStringBufferImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeStringBuffer(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferImpl classType = new ClassTypeNativeStringBufferImpl(mgr);
        classType.registerClassType();
    }     
    
    public static ClassTypeNativeStringBufferImpl getClassTypeStringBuffer(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeStringBufferImpl)mgr.findClassType(CLASS.getName());   
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
        return new StringBuffer();
    }
        
    public ClassTypeNativeStringBufferWrapperImpl getClassTypeStringBufferWrapper()
    {
        return (ClassTypeNativeStringBufferWrapperImpl)wrapperClassType;
    }
            
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeStringBufferImpl(this);
    }       
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeStringBufferImpl(this,(TypeNativeStringBufferWrapperImpl)wrapperType);        
    }    
}
