/*
 * ClassTypeNativePrimitiveArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativePrimitiveArrayRuntimeImpl;


/**
 *
 * @author  jmarranz
 */


public abstract class ClassTypeNativePrimitiveArrayImpl extends ClassTypeNativeArrayImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativePrimitiveArrayImpl
     */
    public ClassTypeNativePrimitiveArrayImpl(ClassTypeNativePrimitiveImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativePrimitiveArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanArrayImpl.registerClassTypeNativeBooleanArray(mgr);        
        ClassTypeNativeCharacterArrayImpl.registerClassTypeNativeCharacterArray(mgr);        
        ClassTypeNativeNumberArrayImpl.registerClassTypeNativeNumberArray(mgr);    
    }            
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveArrayImpl(this);
    }  
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativePrimitiveArrayImpl(this,(TypeNativePrimitiveArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativePrimitiveArrayImpl(this,varTypeComp);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveArrayRuntimeImpl(this,rtMgr);
    }
}

