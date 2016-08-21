/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeInstanceMethodDefaultImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeInstanceMethodDefaultImpl extends ClassTypeNativeMethodDefaultImpl
{
    public static final Class INTERFACE = NativeInstanceMethod.class;
    public static final Class CLASS = NativeInstanceMethodDefaultImpl.class;    
    
    /** Creates a new instance of MethodType */
    public ClassTypeNativeInstanceMethodDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
  
    public static void registerClassTypeNativeInstanceMethodDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeInstanceMethodDefaultImpl classType = new ClassTypeNativeInstanceMethodDefaultImpl(mgr);
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
        return new TypeNativeInstanceMethodDefaultImpl(this);
    }         
}
