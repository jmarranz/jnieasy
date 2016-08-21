/*
 * ClassTypeNativeShortArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeShortImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

public class ClassTypeNativeShortArrayImpl extends ClassTypeNativeNumberArrayImpl
{
    public static final Class CLASS = short[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeShortArrayImpl
     */
    public ClassTypeNativeShortArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeShortImpl.getClassTypeNativeShort(mgr));
    }

    public static void registerClassTypeNativeShortArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortArrayImpl classType = new ClassTypeNativeShortArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeShortArrayImpl getClassTypeNativeShortArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeShortArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new short[length];
    }
        
    public int getLength(Object value)
    {
        return ((short[])value).length;
    }

}

