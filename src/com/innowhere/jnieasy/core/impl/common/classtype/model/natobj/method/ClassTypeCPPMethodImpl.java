/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.CPPMethodImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeCPPMethodImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeCPPMethodImpl extends ClassTypeDLLMethodImpl
{
    public static final Class INTERFACE = CPPMethod.class;
    public static final Class CLASS = CPPMethodImpl.class;
    
    /** Creates a new instance of MethodType */
    public ClassTypeCPPMethodImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
  
    public static void registerClassTypeCPPMethod(ClassTypeManagerImpl mgr)
    {
        ClassTypeCPPMethodImpl classType = new ClassTypeCPPMethodImpl(mgr);
        classType.registerClassType();
    }

    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 
    
    public String getVMClassImplName()
    {
        return CLASS.getName();
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeCPPMethodImpl(this);
    }         
}
