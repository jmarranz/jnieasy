/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceMethodCallbackDefaultImpl;



/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeInstanceMethodCallbackDefaultImpl extends ClassTypeNativeMethodCallbackDefaultImpl
{
    public static final Class INTERFACE = NativeInstanceMethodCallback.class;
    
    /** Creates a new instance of MethodType */
    public ClassTypeNativeInstanceMethodCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
  
    public static void registerClassTypeNativeInstanceMethodCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeInstanceMethodCallbackDefaultImpl classType = new ClassTypeNativeInstanceMethodCallbackDefaultImpl(mgr);
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
        return new TypeNativeInstanceMethodCallbackDefaultImpl(this);
    }         
}
