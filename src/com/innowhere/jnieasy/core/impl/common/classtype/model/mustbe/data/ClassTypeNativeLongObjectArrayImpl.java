/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;




public class ClassTypeNativeLongObjectArrayImpl extends ClassTypeNativeNumberObjectArrayImpl
{
    public static final Class CLASS = Long[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeLongObjectArrayImpl
     */
    public ClassTypeNativeLongObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeLongObjectImpl.getClassTypeNativeLongObject(mgr));
    }

    public static void registerClassTypeNativeLongObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongObjectArrayImpl classType = new ClassTypeNativeLongObjectArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeLongObjectArrayImpl getClassTypeNativeLongObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeLongObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Long[length];
    }    

}
