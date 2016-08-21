/*
 * ClassTypeNativeStringBufferArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStringBufferArrayImpl extends ClassTypeNativeStringBasedArrayImpl
{
    public static final Class CLASS = StringBuffer[].class;
    
   
    /**
     * Creates a new instance of ClassTypeNativeStringBufferArrayImpl
     */
    public ClassTypeNativeStringBufferArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringBufferImpl.getClassTypeStringBuffer(mgr));
    }
    
    public static void registerClassTypeNativeStringBufferArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferArrayImpl classType = new ClassTypeNativeStringBufferArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeStringBufferArrayImpl getClassTypeNativeStringBufferArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeStringBufferArrayImpl)mgr.findClassType(CLASS.getName());   
    }
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
  
    public Object newValueDefaultClass(int length)
    {
        return new StringBuffer[length];
    }        
    
    public ClassTypeNativeStringBufferArrayWrapperImpl getClassTypeNativeStringBufferArrayWrapper()
    {
        return (ClassTypeNativeStringBufferArrayWrapperImpl)wrapperClassType;
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeStringBufferArrayImpl(this);
    }  
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeStringBufferArrayImpl(this,(TypeNativeStringBufferArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativeStringBufferArrayImpl(this,varTypeComp);
    }
}
