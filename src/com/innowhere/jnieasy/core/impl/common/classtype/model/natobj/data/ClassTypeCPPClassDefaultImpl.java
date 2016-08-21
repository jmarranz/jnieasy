/*
 * ClassTypeCPPClassDefaultImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeCPPClassDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.CPPClassDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public class ClassTypeCPPClassDefaultImpl extends ClassTypeCPPClassImpl
{
    public static final Class INTERFACE = CPPClass.class;
    public static final Class CLASS = CPPClassDefaultImpl.class;    
    
    /** Creates a new instance of ClassTypeCPPClassDefaultImpl */
    public ClassTypeCPPClassDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }    
    
    public static void registerClassTypeCPPClassDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeCPPClassDefaultImpl classType = new ClassTypeCPPClassDefaultImpl(mgr);
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
         
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeCPPClassDefaultRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
