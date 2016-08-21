/*
 * IntegerType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


public class ClassTypeNativeIntegerObjectImpl extends ClassTypeNativeNumberObjectImpl
{
    public static final Class CLASS = Integer.class;
    
    /** Creates a new instance of IntegerType */
    public ClassTypeNativeIntegerObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeIntegerImpl.getClassTypeNativeInteger(classTypeMgr),classTypeMgr);
    }

    public static void registerClassTypeNativeIntegerObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeIntegerObjectImpl classType = new ClassTypeNativeIntegerObjectImpl(mgr);
        classType.registerClassType();
    }        
    
    public static ClassTypeNativeIntegerObjectImpl getClassTypeNativeIntegerObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeIntegerObjectImpl)mgr.findClassType(CLASS.getName());   
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
        return new Integer(0);
    } 

}
