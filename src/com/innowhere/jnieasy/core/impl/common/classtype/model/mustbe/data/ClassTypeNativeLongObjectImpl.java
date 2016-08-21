/*
 * LongType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeLongImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public class ClassTypeNativeLongObjectImpl extends ClassTypeNativeNumberObjectImpl
{
    public static final Class CLASS = Long.class;
    
    /** Creates a new instance of LongType */
    public ClassTypeNativeLongObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeLongImpl.getClassTypeNativeLong(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeLongObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeLongObjectImpl classType = new ClassTypeNativeLongObjectImpl(mgr);
        classType.registerClassType();
    }        
    
    public static ClassTypeNativeLongObjectImpl getClassTypeNativeLongObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeLongObjectImpl)mgr.findClassType(CLASS.getName());   
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
        return new Long(0);
    }

}
