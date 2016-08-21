/*
 * ClassTypeNativeObjectArrayWrapperDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeObjectArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeObjectArrayWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeObjectArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeObjectArrayDefaultImpl;

public class ClassTypeNativeObjectArrayWrapperDefaultImpl extends ClassTypeNativeObjectArrayWrapperImpl
{
    public static final Class INTERFACE = NativeObjectArray.class;
    public static final Class CLASS = NativeObjectArrayDefaultImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayWrapperDefaultImpl
     */
    public ClassTypeNativeObjectArrayWrapperDefaultImpl(ClassTypeManagerImpl mgr)    
    {
        super(ClassTypeNativeObjectArrayDefaultImpl.getClassTypeNativeObjectArrayDefault(mgr), mgr,true);
    }
    
    public static void registerClassTypeNativeObjectArrayWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeObjectArrayWrapperDefaultImpl classType = new ClassTypeNativeObjectArrayWrapperDefaultImpl(mgr);
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
    
    public ClassTypeNativeObjectArrayDefaultImpl getClassTypeNativeObjectArrayDefault()
    {
        return (ClassTypeNativeObjectArrayDefaultImpl)fieldClassType;
    }
 

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeObjectArrayWrapperDefaultImpl(this);
    }

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeObjectArrayWrapperDefaultImpl(this,(TypeNativeObjectArrayDefaultImpl)typeDecWrapped);        
    }     
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeObjectArrayWrapperDefaultRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    } 

}
