/*
 * ClassTypeNativeArrayOfArrayWrapperImpl.java
 *
 * Created on 3 de diciembre de 2004, 11:04
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;


public abstract class ClassTypeNativeArrayOfArrayWrapperImpl extends ClassTypeCanBeNativeCapableArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayWrapperImpl
     */

    public ClassTypeNativeArrayOfArrayWrapperImpl(ClassTypeNativeArrayOfArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }    
 
    public static void registerClassTypeNativeArrayOfArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeArrayOfArrayWrapperDefaultImpl.registerClassTypeNativeArrayOfArrayWrapperDefault(mgr);       
    }
    
    public ClassTypeNativeArrayOfArrayImpl getClassTypeNativeArrayOfArray()
    {
        return (ClassTypeNativeArrayOfArrayImpl)fieldClassType;
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeArrayOfArrayWrapperImpl(this);
    }        

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        return new TypeNativeArrayOfArrayWrapperImpl(this,(TypeNativeArrayOfArrayImpl)typeDecWrapped);
    }        
}
