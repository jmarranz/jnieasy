/*
 * ClassTypeNativeIntegerArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;




public class ClassTypeNativeIntegerArrayImpl extends ClassTypeNativeNumberArrayImpl
{
    public static final Class CLASS = int[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeIntegerArrayImpl
     */
    public ClassTypeNativeIntegerArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeIntegerImpl.getClassTypeNativeInteger(mgr));
    }

    public static void registerClassTypeNativeIntegerArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerArrayImpl classType = new ClassTypeNativeIntegerArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeIntegerArrayImpl getClassTypeNativeIntegerArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeIntegerArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new int[length];
    }
        
    public int getLength(Object value)
    {
        return ((int[])value).length;
    }

}

