/*
 * ClassTypeNativeCharacterArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeCharacterImpl;




public class ClassTypeNativeCharacterArrayImpl extends ClassTypeNativePrimitiveArrayImpl
{
    public static final Class CLASS = char[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeCharacterArrayImpl
     */
    public ClassTypeNativeCharacterArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeCharacterImpl.getClassTypeNativeCharacter(mgr));
    }

    public static void registerClassTypeNativeCharacterArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterArrayImpl classType = new ClassTypeNativeCharacterArrayImpl(mgr);
        classType.registerClassType();
    }        
    
    public static ClassTypeNativeCharacterArrayImpl getClassTypeNativeCharacterArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeCharacterArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new char[length];
    }
    
    public int getLength(Object value)
    {
        return ((char[])value).length;
    }         

}

