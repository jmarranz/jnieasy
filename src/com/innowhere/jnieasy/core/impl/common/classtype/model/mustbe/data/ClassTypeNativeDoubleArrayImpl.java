/*
 * ClassTypeNativeDoubleArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeDoubleImpl;


public class ClassTypeNativeDoubleArrayImpl extends ClassTypeNativeNumberArrayImpl
{
    public static final Class CLASS = double[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeDoubleArrayImpl
     */
    public ClassTypeNativeDoubleArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeDoubleImpl.getClassTypeNativeDouble(mgr));
    }

    public static void registerClassTypeNativeDoubleArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleArrayImpl classType = new ClassTypeNativeDoubleArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeDoubleArrayImpl getClassTypeNativeDoubleArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeDoubleArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new double[length];
    }
    
    public int getLength(Object value)
    {
        return ((double[])value).length;
    }            

}

