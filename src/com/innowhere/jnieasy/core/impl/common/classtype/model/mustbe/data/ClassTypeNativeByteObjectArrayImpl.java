/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;




public class ClassTypeNativeByteObjectArrayImpl extends ClassTypeNativeNumberObjectArrayImpl
{
    public static final Class CLASS = Byte[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeByteObjectArrayImpl
     */
    public ClassTypeNativeByteObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeByteObjectImpl.getClassTypeNativeByteObject(mgr));
    }
        
    public static void registerClassTypeNativeByteObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectArrayImpl classType = new ClassTypeNativeByteObjectArrayImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeByteObjectArrayImpl getClassTypeNativeByteObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeByteObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Byte[length];
    }

}
