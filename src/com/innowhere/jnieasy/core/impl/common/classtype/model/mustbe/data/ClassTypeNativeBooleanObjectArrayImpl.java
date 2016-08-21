/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;




public class ClassTypeNativeBooleanObjectArrayImpl extends ClassTypeNativePrimitiveObjectArrayImpl
{
    public static final Class CLASS = Boolean[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeBooleanObjectArrayImpl
     */
    public ClassTypeNativeBooleanObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeBooleanObjectImpl.getClassTypeNativeBooleanObject(mgr));
    }

    public static void registerClassTypeNativeBooleanObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectArrayImpl classType = new ClassTypeNativeBooleanObjectArrayImpl(mgr);
        classType.registerClassType();
    }        
    
    public static ClassTypeNativeBooleanObjectArrayImpl getClassTypeNativeBooleanObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeBooleanObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Boolean[length];
    }    

}
