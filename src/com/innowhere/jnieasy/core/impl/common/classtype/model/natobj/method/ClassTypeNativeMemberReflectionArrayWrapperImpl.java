/*
 * ClassTypeNativeMemberReflectionArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeMemberReflectionArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;


public abstract class ClassTypeNativeMemberReflectionArrayWrapperImpl extends ClassTypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeMemberReflectionArrayWrapperImpl
     */
    public ClassTypeNativeMemberReflectionArrayWrapperImpl(ClassTypeNativeMemberReflectionArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public ClassTypeNativeMemberReflectionArrayImpl getClassTypeNativeMemberReflectionArray()
    {
        return (ClassTypeNativeMemberReflectionArrayImpl)getClassTypeCanBeNativeCapable();
    }
    
    public static void registerClassTypeNativeMemberReflectionArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBehaviorReflectionArrayWrapperImpl.registerClassTypeNativeBehaviorReflectionArrayWrapper(mgr);
    }    

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeMemberReflectionArrayWrapperImpl(this);
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeMemberReflectionArrayWrapperImpl(this,(TypeNativeMemberReflectionArrayImpl)typeDecWrapped);        
    } 
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeMemberReflectionArrayWrapperRuntimeImpl(this,rtMgr);
    }        
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
