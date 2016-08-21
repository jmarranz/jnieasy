/*
 * ClassTypeNativeStringArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeStringArrayImpl extends ClassTypeNativeStringBasedArrayImpl
{
    public static final Class CLASS = String[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeStringArrayImpl
     */
    public ClassTypeNativeStringArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringImpl.getClassTypeString(mgr));
    }

    public static void registerClassTypeNativeStringArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringArrayImpl classType = new ClassTypeNativeStringArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeStringArrayImpl getClassTypeNativeStringArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeStringArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new String[length];
    }        
    
    public ClassTypeNativeStringArrayWrapperImpl getClassTypeNativeStringArrayWrapper()
    {
        return (ClassTypeNativeStringArrayWrapperImpl)wrapperClassType;
    }
            
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeStringArrayImpl(this);
    }
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeStringArrayImpl(this,(TypeNativeStringArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativeStringArrayImpl(this,varTypeComp);
    }
}
