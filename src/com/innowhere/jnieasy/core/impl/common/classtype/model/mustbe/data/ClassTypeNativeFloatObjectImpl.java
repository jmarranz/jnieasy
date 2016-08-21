/*
 * FloatType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeFloatImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public class ClassTypeNativeFloatObjectImpl extends ClassTypeNativeNumberObjectImpl
{
    public static final Class CLASS = Float.class;
    
    /** Creates a new instance of FloatType */
    public ClassTypeNativeFloatObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeFloatImpl.getClassTypeNativeFloat(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeFloatObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFloatObjectImpl classType = new ClassTypeNativeFloatObjectImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeFloatObjectImpl getClassTypeNativeFloatObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeFloatObjectImpl)mgr.findClassType(CLASS.getName());   
    }
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }     
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
    
    public Object newValueDefaultClass()
    {
        return new Float(0); 
    }

}
