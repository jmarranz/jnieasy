/*
 * ClassTypeNativeCapableDefaultImpl.java
 *
 * Created on 11 de febrero de 2005, 17:19
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
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


public class ClassTypeNativeCapableDefaultImpl extends ClassTypeNativeCapableImpl
{
    public static final Class INTERFACE = NativeCapable.class;
    public static final Class CLASS = NativeCapableDefaultImpl.class;    

    
    /**
     * Creates a new instance of ClassTypeNativeCapableDefaultImpl
     */
    public ClassTypeNativeCapableDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeCapableDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCapableDefaultImpl classType = new ClassTypeNativeCapableDefaultImpl(mgr);
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

    public static ClassTypeNativeCapableDefaultImpl getClassTypeNativeCapableDefault(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeCapableDefaultImpl)mgr.findClassType(INTERFACE.getName());
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeCapableDefaultRuntimeImpl(this,rtMgr);
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeCapableDefaultImpl(this);
    }
    
    public TypeNativeCapableDefaultImpl newTypeNativeCapableDefault()
    {
        return new TypeNativeCapableDefaultImpl(this);
    }    

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
