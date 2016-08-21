/*
 * ClassTypeNativeCapableArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


public abstract class ClassTypeNativeCapableArrayImpl extends ClassTypeNativeObjectArrayImpl
{
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayImpl
     */
    public ClassTypeNativeCapableArrayImpl(ClassTypeNativeCapableImpl compType)
    {
        super(compType);
    }    
    
    public static void registerClassTypeNativeCapableArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCapableArrayCustomImpl.registerClassTypeNativeCapableArrayCustom(mgr);        
        ClassTypeNativeCapableArrayDefaultImpl.registerClassTypeNativeCapableArrayDefault(mgr);                
    }
    
    public ClassTypeNativeCapableArrayWrapperImpl getClassTypeNativeCapableArrayWrapper()
    {
        return (ClassTypeNativeCapableArrayWrapperImpl)wrapperClassType;
    }
    
    public static ClassTypeNativeCapableArrayImpl newCustomNativeCapableArrayType(MetaClassWrapper valueClass,ClassTypeNativeCapableImpl classTypeComp,TaskContext ctx)
    {
        return ClassTypeNativeCapableArrayCustomImpl.newNativeCapableArrayCustomType(valueClass.getName(),classTypeComp,ctx);
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeCapableArrayImpl(this);
    } 
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeCapableArrayImpl(this,(TypeNativeCapableArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativeCapableArrayImpl(this,varTypeComp);
    }
        
}

