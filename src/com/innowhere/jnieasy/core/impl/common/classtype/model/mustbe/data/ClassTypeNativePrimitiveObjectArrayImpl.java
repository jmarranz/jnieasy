/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativePrimitiveObjectArrayRuntimeImpl;


public abstract class ClassTypeNativePrimitiveObjectArrayImpl extends ClassTypeCanBeNativeCapableArrayImpl
{
    /** Creates a new instance of StringArrayType */
    public ClassTypeNativePrimitiveObjectArrayImpl(ClassTypeNativePrimitiveObjectImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativePrimitiveObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectArrayImpl.registerClassTypeNativeBooleanObjectArray(mgr);        
        ClassTypeNativeCharacterObjectArrayImpl.registerClassTypeNativeCharacterObjectArray(mgr);        
        ClassTypeNativeNumberObjectArrayImpl.registerClassTypeNativeNumberObjectArray(mgr);                
    }      
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveObjectArrayImpl(this);
    }  
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativePrimitiveObjectArrayImpl(this,(TypeNativePrimitiveObjectArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativePrimitiveObjectArrayImpl(this,varTypeComp);
    }
        
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveObjectArrayRuntimeImpl(this,rtMgr);
    }        
}
