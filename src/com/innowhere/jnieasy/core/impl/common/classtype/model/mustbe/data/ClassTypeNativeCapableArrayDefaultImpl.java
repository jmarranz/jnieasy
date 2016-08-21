/*
 * ClassTypeNativeCapableArrayDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeCapableArrayDefaultRuntimeImpl;


public class ClassTypeNativeCapableArrayDefaultImpl extends ClassTypeNativeCapableArrayImpl
{
    public static final Class CLASS = NativeCapable[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayDefaultImpl
     */
    public ClassTypeNativeCapableArrayDefaultImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeCapableDefaultImpl.getClassTypeNativeCapableDefault(mgr));
    }

    public static void registerClassTypeNativeCapableArrayDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCapableArrayDefaultImpl classType = new ClassTypeNativeCapableArrayDefaultImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeCapableArrayDefaultImpl getClassTypeNativeCapableArrayDefault(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeCapableArrayDefaultImpl)mgr.findClassType(CLASS.getName());   
    }
        
    public String getVMClassName()
    {
        return CLASS.getName();
    } 
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
    
    public Object newValueDefaultClass(int length)
    {
        return new NativeCapable[length];
    }
    
    public ClassTypeNativeCapableArrayWrapperDefaultImpl getClassTypeNativeCapableArrayWrapperDefault()
    {
        return (ClassTypeNativeCapableArrayWrapperDefaultImpl)wrapperClassType;
    }
        
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeCapableArrayDefaultRuntimeImpl(this,rtMgr);
    }    
}

