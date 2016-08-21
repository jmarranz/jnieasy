/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeStaticMethodDefaultImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStaticMethodDefaultImpl extends ClassTypeNativeMethodDefaultImpl
{
    public static final Class INTERFACE = NativeStaticMethod.class;
    public static final Class CLASS = NativeStaticMethodDefaultImpl.class;    
    
    /** Creates a new instance of MethodType */
    public ClassTypeNativeStaticMethodDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);         
    }
  
    public static void registerClassTypeNativeStaticMethodDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticMethodDefaultImpl classType = new ClassTypeNativeStaticMethodDefaultImpl(mgr);
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
        return new TypeNativeStaticMethodDefaultImpl(this);
    }
}
