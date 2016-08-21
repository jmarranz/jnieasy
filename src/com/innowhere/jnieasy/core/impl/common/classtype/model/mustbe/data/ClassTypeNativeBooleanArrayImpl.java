/*
 * ClassTypeNativeBooleanArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeBooleanArrayImpl extends ClassTypeNativePrimitiveArrayImpl
{
    public static final Class CLASS = boolean[].class;

    /**
     * Creates a new instance of ClassTypeNativeBooleanArrayImpl
     */
    public ClassTypeNativeBooleanArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeBooleanImpl.getClassTypeNativeBoolean(mgr));
    }
    
    public static void registerClassTypeNativeBooleanArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanArrayImpl classType = new ClassTypeNativeBooleanArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeBooleanArrayImpl getClassTypeNativeBooleanArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeBooleanArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new boolean[length];
    }    
        
    public int getLength(Object value)
    {
        return ((boolean[])value).length;
    }  

}

