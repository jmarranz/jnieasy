/*
 * ByteType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeByteImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


public class ClassTypeNativeByteObjectImpl extends ClassTypeNativeNumberObjectImpl
{
    public static final Class CLASS = Byte.class;
    
    /** Creates a new instance of ByteType */
    public ClassTypeNativeByteObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeByteImpl.getClassTypeNativeByte(classTypeMgr),classTypeMgr);
    }

    public static void registerClassTypeNativeByteObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeByteObjectImpl classType = new ClassTypeNativeByteObjectImpl(mgr);
        classType.registerClassType();
    }    
    
    public static ClassTypeNativeByteObjectImpl getClassTypeNativeByteObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeByteObjectImpl)mgr.findClassType(CLASS.getName());   
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
        return new Byte((byte)0);
    }

}
