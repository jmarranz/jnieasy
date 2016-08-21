/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.CPPConstructorImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeCPPConstructorImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeCPPConstructorImpl extends ClassTypeDLLBehaviorImpl
{
    public static final Class INTERFACE = CPPConstructor.class;
    public static final Class CLASS = CPPConstructorImpl.class;
    
    /** Creates a new instance of MethodType */
    public ClassTypeCPPConstructorImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeCPPConstructor(ClassTypeManagerImpl mgr)
    {
        ClassTypeCPPConstructorImpl classType = new ClassTypeCPPConstructorImpl(mgr);
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
        return new TypeCPPConstructorImpl(this);
    }    
    
}
