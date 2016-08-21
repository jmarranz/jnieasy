/*
 * ClassTypeNativeStringAnsiWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringAnsiImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;

public class ClassTypeNativeStringAnsiWrapperImpl extends ClassTypeNativeStringWrapperImpl
{
    public static final Class INTERFACE = NativeStringAnsi.class;
    public static final Class CLASS = NativeStringAnsiImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeStringAnsiWrapperImpl
     */
    public ClassTypeNativeStringAnsiWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringImpl.getClassTypeString(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringAnsiWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringAnsiWrapperImpl classType = new ClassTypeNativeStringAnsiWrapperImpl(mgr);
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
        return new TypeNativeStringAnsiWrapperImpl(this);                
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringAnsiWrapperImpl(this,(TypeNativeStringImpl)typeDecWrapped);        
    }
}
