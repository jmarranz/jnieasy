/*
 * ClassTypeNativeFloatArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeFloatImpl;


public class ClassTypeNativeFloatArrayImpl extends ClassTypeNativeNumberArrayImpl
{
    public static final Class CLASS = float[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeFloatArrayImpl
     */
    public ClassTypeNativeFloatArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeFloatImpl.getClassTypeNativeFloat(mgr));
    }

    public static void registerClassTypeNativeFloatArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatArrayImpl classType = new ClassTypeNativeFloatArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeFloatArrayImpl getClassTypeNativeFloatArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeFloatArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new float[length];
    }
    
    public int getLength(Object value)
    {
        return ((float[])value).length;
    }    

}

