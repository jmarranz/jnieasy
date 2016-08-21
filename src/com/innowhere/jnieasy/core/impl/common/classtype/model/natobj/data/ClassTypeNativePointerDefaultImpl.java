/*
 * ClassTypeNativePointerDefaultImpl.java
 *
 * Created on 23 de septiembre de 2005, 17:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.NativePointer;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePointerDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativePointerDefaultImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativePointerDefaultImpl extends ClassTypeNativePointerImpl
{
    public static final Class INTERFACE = NativePointer.class;
    public static final Class CLASS = NativePointerDefaultImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativePointerDefaultImpl
     */
    public ClassTypeNativePointerDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeObjectDefaultImpl.getClassTypeNativeObjectDefault(classTypeMgr),classTypeMgr);
    }
    
    public static ClassTypeNativePointerDefaultImpl getClassTypeNativePointerDefault(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativePointerDefaultImpl)mgr.findClassType(CLASS.getName());   
    }        
    
    public static void registerClassTypeNativePointerDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePointerDefaultImpl classType = new ClassTypeNativePointerDefaultImpl(mgr);
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
        return new ClassTypeNativePointerDefaultRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePointerDefaultImpl(this);
    }        
}
