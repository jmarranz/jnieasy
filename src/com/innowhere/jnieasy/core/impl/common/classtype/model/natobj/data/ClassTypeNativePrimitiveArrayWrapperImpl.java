/*
 * ClassTypeNativePrimitiveArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveArrayWrapperImpl;



public abstract class ClassTypeNativePrimitiveArrayWrapperImpl extends ClassTypeNativeArrayWrapperImpl 
{
    /**
     * Creates a new instance of ClassTypeNativePrimitiveArrayWrapperImpl
     */
    public ClassTypeNativePrimitiveArrayWrapperImpl(ClassTypeNativePrimitiveArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public ClassTypeNativePrimitiveArrayImpl getPrimitiveArrayType()    
    {
        return (ClassTypeNativePrimitiveArrayImpl)getClassTypeCanBeNativeCapable();
    }

    public static void registerClassTypeNativePrimitiveArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanArrayWrapperImpl.registerClassTypeNativeBooleanArrayWrapper(mgr);
        ClassTypeNativeCharacterArrayWrapperImpl.registerClassTypeNativeCharacterArrayWrapper(mgr);
        ClassTypeNativeNumberArrayWrapperImpl.registerClassTypeNativeNumberArrayWrapper(mgr);
    } 
  
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveArrayWrapperRuntimeImpl(this,rtMgr);
    }    
        
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveArrayWrapperImpl(this);
    }     

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativePrimitiveArrayWrapperImpl(this,(TypeNativePrimitiveArrayImpl)typeDecWrapped);        
    }     
}

