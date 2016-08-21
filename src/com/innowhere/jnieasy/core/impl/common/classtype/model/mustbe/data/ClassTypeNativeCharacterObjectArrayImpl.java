/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;




public class ClassTypeNativeCharacterObjectArrayImpl extends ClassTypeNativePrimitiveObjectArrayImpl
{
    public static final Class CLASS = Character[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeCharacterObjectArrayImpl
     */
    public ClassTypeNativeCharacterObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeCharacterObjectImpl.getClassTypeNativeCharacterObject(mgr));
    }
    
    public static void registerClassTypeNativeCharacterObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterObjectArrayImpl classType = new ClassTypeNativeCharacterObjectArrayImpl(mgr);
        classType.registerClassType();
    }     
    
    public static ClassTypeNativeCharacterObjectArrayImpl getClassTypeNativeCharacterObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeCharacterObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Character[length];
    }    

}
