/*
 * ClassTypeNativeStringBufferAnsiWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeStringBufferAnsiImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;

public class ClassTypeNativeStringBufferAnsiWrapperImpl extends ClassTypeNativeStringBufferWrapperImpl
{
    public static final Class INTERFACE = NativeStringBufferAnsi.class;
    public static final Class CLASS = NativeStringBufferAnsiImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeStringBufferAnsiWrapperImpl
     */
    public ClassTypeNativeStringBufferAnsiWrapperImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeStringBufferImpl.getClassTypeStringBuffer(mgr), mgr,false);
    }
    
    public static void registerClassTypeNativeStringBufferAnsiWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringBufferAnsiWrapperImpl classType = new ClassTypeNativeStringBufferAnsiWrapperImpl(mgr);
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
        return new TypeNativeStringBufferAnsiWrapperImpl(this);                
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeStringBufferAnsiWrapperImpl(this,(TypeNativeStringBufferImpl)typeDecWrapped);        
    }     
}
