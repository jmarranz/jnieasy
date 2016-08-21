/*
 * ClassTypeNativePrimitiveObjectImpl.java
 *
 * Created on 9 de diciembre de 2004, 13:49
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativePrimitiveObjectRuntimeImpl;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class ClassTypeNativePrimitiveObjectImpl extends ClassTypeCanBeNativeCapableImpl
{
    protected static final Set primitiveWrapperClasses = Collections.synchronizedSet(new HashSet());

    static
    {
        primitiveWrapperClasses.add(Void.class);
        primitiveWrapperClasses.add(Boolean.class);
        primitiveWrapperClasses.add(Byte.class);
        primitiveWrapperClasses.add(Character.class);
        primitiveWrapperClasses.add(Short.class);
        primitiveWrapperClasses.add(Integer.class);
        primitiveWrapperClasses.add(Long.class);        
        primitiveWrapperClasses.add(Float.class);
        primitiveWrapperClasses.add(Double.class);        
    }    
    
    protected ClassTypeNativePrimitiveImpl primClassType;
    
    /**
     * Creates a new instance of ClassTypeNativePrimitiveObjectImpl
     */
    public ClassTypeNativePrimitiveObjectImpl(ClassTypeNativePrimitiveImpl primClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.primClassType = primClassType;
        this.primClassType.setClassTypeNativePrimitiveObject(this);
    }
    
    public static void registerClassTypeNativePrimitiveObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeBooleanObjectImpl.registerClassTypeNativeBooleanObject(mgr);     
        ClassTypeNativeCharacterObjectImpl.registerClassTypeNativeCharacterObject(mgr);        
        ClassTypeNativeNumberObjectImpl.registerClassTypeNativeNumberObject(mgr);        
    }
    
    public static boolean isPrimitiveWrapperClass(Class clasz)
    {
        return primitiveWrapperClasses.contains(clasz);
    }
    
    public ClassTypeNativePrimitiveImpl getClassTypeNativePrimitive()
    {
        return primClassType;
    }
    
    public ClassTypeNativePrimitiveObjectWrapperImpl getClassTypeNativePrimitiveObjectWrapper()
    {
        return (ClassTypeNativePrimitiveObjectWrapperImpl)getDefaultClassTypeCanBeNativeCapableWrapper();
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePrimitiveObjectRuntimeImpl(this,rtMgr);
    }   
    
    public TypeNativePrimitiveObjectImpl newTypeNativePrimitiveObject(TypeNativePrimitiveImpl fieldType)
    {
        return new TypeNativePrimitiveObjectImpl(this,fieldType);
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePrimitiveObjectImpl(this);
    }   
        
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativePrimitiveObjectImpl(this,(TypeNativePrimitiveObjectWrapperImpl)wrapperType);        
    }    
}

 