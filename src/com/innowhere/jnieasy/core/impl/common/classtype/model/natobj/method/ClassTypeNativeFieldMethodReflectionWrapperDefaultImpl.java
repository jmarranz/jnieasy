/*
 * ClassTypeNativeFieldMethodReflectionWrapperImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:38
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.NativeFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeFieldMethodReflectionDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodReflectionWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;



/**
 *
 * @author  jmarranz
 */


public class ClassTypeNativeFieldMethodReflectionWrapperDefaultImpl extends ClassTypeNativeFieldMethodReflectionWrapperImpl
{
    public static final Class INTERFACE = NativeFieldMethodReflection.class;
    public static final Class CLASS = NativeFieldMethodReflectionDefaultImpl.class;
        
    /**
     * Creates a new instance of ClassTypeNativeFieldMethodReflectionWrapperImpl
     */
    public ClassTypeNativeFieldMethodReflectionWrapperDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeFieldMethodReflectionImpl.getClassTypeNativeFieldMethodReflection(classTypeMgr), classTypeMgr,true);
    }
    
    public static void registerClassTypeNativeFieldMethodReflectionWrapperDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeFieldMethodReflectionWrapperDefaultImpl classType = new ClassTypeNativeFieldMethodReflectionWrapperDefaultImpl(mgr);
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
        return new TypeNativeFieldMethodReflectionWrapperDefaultImpl(this);                
    }
    
    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeFieldMethodReflectionWrapperDefaultImpl(this,(TypeNativeFieldMethodReflectionImpl)typeDecWrapped);        
    }     
}
