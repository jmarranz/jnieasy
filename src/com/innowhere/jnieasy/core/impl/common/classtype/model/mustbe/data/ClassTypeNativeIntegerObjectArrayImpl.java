/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;




public class ClassTypeNativeIntegerObjectArrayImpl extends ClassTypeNativeNumberObjectArrayImpl
{
    public static final Class CLASS = Integer[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeIntegerObjectArrayImpl
     */
    public ClassTypeNativeIntegerObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeIntegerObjectImpl.getClassTypeNativeIntegerObject(mgr));
    }

    public static void registerClassTypeNativeIntegerObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerObjectArrayImpl classType = new ClassTypeNativeIntegerObjectArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeIntegerObjectArrayImpl getClassTypeNativeIntegerObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeIntegerObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Integer[length];
    }    

}
