/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticMethodCallbackDefaultImpl;



/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStaticMethodCallbackDefaultImpl extends ClassTypeNativeMethodCallbackDefaultImpl
{
    public static final Class INTERFACE = NativeStaticMethodCallback.class;
    
    /** Creates a new instance of MethodType */
    public ClassTypeNativeStaticMethodCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);         
    }
  
    public static void registerClassTypeNativeStaticMethodCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticMethodCallbackDefaultImpl classType = new ClassTypeNativeStaticMethodCallbackDefaultImpl(mgr);
        classType.registerClassType(); 
    }

    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 
    
    public String getVMClassImplName()
    {
        return null;
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeStaticMethodCallbackDefaultImpl(this);
    }
}
