/*
 * ClassTypeNativePrimitiveObjectArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveObjectArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectArrayWrapperImpl;


public abstract class ClassTypeNativePrimitiveObjectArrayWrapperImpl extends ClassTypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativePrimitiveObjectArrayWrapperImpl
     */
    public ClassTypeNativePrimitiveObjectArrayWrapperImpl(ClassTypeNativePrimitiveObjectArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public ClassTypeNativePrimitiveObjectArrayImpl getPrimitiveObjectArrayType()
    {
        return (ClassTypeNativePrimitiveObjectArrayImpl)getClassTypeCanBeNativeCapable();
    }
    
    public static void registerClassTypeNativePrimitiveObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectArrayWrapperImpl.registerClassTypeNativeBooleanObjectArrayWrapper(mgr);
        ClassTypeNativeCharacterObjectArrayWrapperImpl.registerClassTypeNativeCharacterObjectArrayWrapper(mgr);
        ClassTypeNativeNumberObjectArrayWrapperImpl.registerClassTypeNativeNumberObjectArrayWrapper(mgr);
    }    
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveObjectArrayWrapperImpl(this);
    }     

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativePrimitiveObjectArrayWrapperImpl(this,(TypeNativePrimitiveObjectArrayImpl)typeDecWrapped);        
    } 
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveObjectArrayWrapperRuntimeImpl(this,rtMgr);
    }    
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
