/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;




public class ClassTypeNativeShortObjectArrayImpl extends ClassTypeNativeNumberObjectArrayImpl
{
    public static final Class CLASS = Short[].class;
   
    /**
     * Creates a new instance of ClassTypeNativeShortObjectArrayImpl
     */
    public ClassTypeNativeShortObjectArrayImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeShortObjectImpl.getClassTypeNativeShortObject(mgr));
    }

    public static void registerClassTypeNativeShortObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortObjectArrayImpl classType = new ClassTypeNativeShortObjectArrayImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeShortObjectArrayImpl getClassTypeNativeShortObjectArray(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeShortObjectArrayImpl)mgr.findClassType(CLASS.getName());   
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
        return new Short[length];
    }    

}
