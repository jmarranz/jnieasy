/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.method.ClassTypeNativeMemberReflectionArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;

public abstract class ClassTypeNativeMemberReflectionArrayImpl extends ClassTypeCanBeNativeCapableArrayImpl
{
    /** Creates a new instance of StringArrayType */
    public ClassTypeNativeMemberReflectionArrayImpl(ClassTypeNativeMemberReflectionImpl compType)
    {
        super(compType);
    }
     
    public static void registerClassTypeNativeMemberReflectionArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBehaviorReflectionArrayImpl.registerClassTypeNativeBehaviorReflectionArray(mgr);        
    }        
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeMemberReflectionArrayImpl(this);
    }
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeMemberReflectionArrayImpl(this,(TypeNativeMemberReflectionArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativeMemberReflectionArrayImpl(this,varTypeComp);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeMemberReflectionArrayRuntimeImpl(this,rtMgr);
    }            
}
