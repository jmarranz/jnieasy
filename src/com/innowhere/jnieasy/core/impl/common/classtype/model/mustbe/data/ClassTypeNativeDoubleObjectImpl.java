/*
 * DoubleType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeDoubleImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


public class ClassTypeNativeDoubleObjectImpl extends ClassTypeNativeNumberObjectImpl
{
    public static final Class CLASS = Double.class;
    
    /** Creates a new instance of DoubleType */
    public ClassTypeNativeDoubleObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeDoubleImpl.getClassTypeNativeDouble(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeDoubleObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDoubleObjectImpl classType = new ClassTypeNativeDoubleObjectImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeDoubleObjectImpl getClassTypeNativeDoubleObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeDoubleObjectImpl)mgr.findClassType(CLASS.getName());   
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
        return new Double(0);
    }

}
