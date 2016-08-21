/*
 * BooleanType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

public class ClassTypeNativeBooleanObjectImpl extends ClassTypeNativePrimitiveObjectImpl
{
    public static final Class CLASS = Boolean.class;
    
    /** Creates a new instance of BooleanType */
    public ClassTypeNativeBooleanObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeBooleanImpl.getClassTypeNativeBoolean(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeBooleanObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectImpl classType = new ClassTypeNativeBooleanObjectImpl(mgr);
        classType.registerClassType();       
    }
    
    public static ClassTypeNativeBooleanObjectImpl getClassTypeNativeBooleanObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeBooleanObjectImpl)mgr.findClassType(CLASS.getName());   
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
        return Boolean.valueOf(false);
    }

}
