/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

public class ClassTypeNativeDoubleObjectArrayImpl extends ClassTypeNativeNumberObjectArrayImpl
{
    public static final Class CLASS = Double[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeDoubleObjectArrayImpl
     */
    public ClassTypeNativeDoubleObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeDoubleObjectImpl.getClassTypeNativeDoubleObject(mgr));
    }

    public static void registerClassTypeNativeDoubleObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleObjectArrayImpl classType = new ClassTypeNativeDoubleObjectArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeDoubleObjectArrayImpl getClassTypeNativeDoubleObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeDoubleObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Double[length];
    }          

}
