/*
 * ShortType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeShortImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public class ClassTypeNativeShortObjectImpl extends ClassTypeNativeNumberObjectImpl
{
    public static final Class CLASS = Short.class;
    
    /** Creates a new instance of ShortType */
    public ClassTypeNativeShortObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeShortImpl.getClassTypeNativeShort(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeShortObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeShortObjectImpl classType = new ClassTypeNativeShortObjectImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeShortObjectImpl getClassTypeNativeShortObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeShortObjectImpl)mgr.findClassType(CLASS.getName());   
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
        return new Short((short)0);
    }

}
