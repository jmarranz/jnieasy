/*
 * ClassTypeNativeByteArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeByteImpl;

public class ClassTypeNativeByteArrayImpl extends ClassTypeNativeNumberArrayImpl
{
    public static final Class CLASS = byte[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeByteArrayImpl
     */
    public ClassTypeNativeByteArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeByteImpl.getClassTypeNativeByte(mgr));
    }

    public static void registerClassTypeNativeByteArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteArrayImpl classType = new ClassTypeNativeByteArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeByteArrayImpl getClassTypeNativeByteArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeByteArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new byte[length];
    }
        
    public int getLength(Object value)
    {
        return ((byte[])value).length;
    }

}

