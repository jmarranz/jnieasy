/*
 * ClassTypeNativeCapableArrayWrapperDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableArrayWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCapableArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;




public class ClassTypeNativeCapableArrayWrapperDefaultImpl extends ClassTypeNativeCapableArrayWrapperImpl
{
    public static final Class INTERFACE = NativeCapableArray.class;
    public static final Class CLASS = NativeCapableArrayDefaultImpl.class;     
    
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayWrapperDefaultImpl
     */
    public ClassTypeNativeCapableArrayWrapperDefaultImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeCapableArrayDefaultImpl.getClassTypeNativeCapableArrayDefault(mgr), mgr,true);
    }
    
    public ClassTypeNativeCapableArrayWrapperDefaultImpl(ClassTypeNativeCapableArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }    
    
    public static void registerClassTypeNativeCapableArrayWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCapableArrayWrapperDefaultImpl classType = new ClassTypeNativeCapableArrayWrapperDefaultImpl(mgr);
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
        return new ClassTypeNativeCapableArrayWrapperDefaultRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
    
}
