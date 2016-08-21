/*
 * ClassTypeNativeLongArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeLongImpl;


public class ClassTypeNativeLongArrayImpl extends ClassTypeNativeNumberArrayImpl
{
    public static final Class CLASS = long[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeLongArrayImpl
     */
    public ClassTypeNativeLongArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeLongImpl.getClassTypeNativeLong(mgr));
    }

    public static void registerClassTypeNativeLongArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongArrayImpl classType = new ClassTypeNativeLongArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeLongArrayImpl getClassTypeNativeLongArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeLongArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new long[length];
    }
    
    public int getLength(Object value)
    {
        return ((long[])value).length;
    }    

}

