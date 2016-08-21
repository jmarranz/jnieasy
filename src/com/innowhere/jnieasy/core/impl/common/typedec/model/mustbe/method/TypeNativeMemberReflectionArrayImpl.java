/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMemberReflectionArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeMemberReflectionArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.*;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;



public class TypeNativeMemberReflectionArrayImpl extends TypeCanBeNativeCapableArrayImpl
{
    /** Creates a new instance of StringArrayType */
    public TypeNativeMemberReflectionArrayImpl(ClassTypeNativeMemberReflectionArrayImpl dataType)
    {
        super(dataType);
    }    
        
    public TypeNativeMemberReflectionArrayImpl(ClassTypeNativeMemberReflectionArrayImpl dataType,TypeNativeMemberReflectionArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }       
    
    public TypeNativeMemberReflectionArrayImpl(ClassTypeNativeMemberReflectionArrayImpl dataType,VarTypeNativeImpl varTypeDecComp)
    {
        super(dataType,varTypeDecComp);
    }

    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        return new TypeNativeMemberReflectionArrayRuntimeImpl(this,javaClass,isPrimary,varTypeDecCompRt,ctx);        
    }           
}
