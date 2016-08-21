/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public class ClassTypeNativeFloatObjectArrayImpl extends ClassTypeNativeNumberObjectArrayImpl
{
    public static final Class CLASS = Float[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeFloatObjectArrayImpl
     */
    public ClassTypeNativeFloatObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFloatObjectImpl.getClassTypeNativeFloatObject(mgr));
    }

    public static void registerClassTypeNativeFloatObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatObjectArrayImpl classType = new ClassTypeNativeFloatObjectArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeFloatObjectArrayImpl getClassTypeNativeFloatObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeFloatObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Float[length];
    }    

}
