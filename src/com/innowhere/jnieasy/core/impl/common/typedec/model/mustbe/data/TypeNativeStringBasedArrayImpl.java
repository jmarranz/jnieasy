/*
 * StringBasedType.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBasedArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBasedArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringBasedArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;



public abstract class TypeNativeStringBasedArrayImpl extends TypeCanBeNativeCapableArrayImpl
{
    
    /** Creates a new instance of StringBasedType */
    public TypeNativeStringBasedArrayImpl(ClassTypeNativeStringBasedArrayImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeStringBasedArrayImpl(ClassTypeNativeStringBasedArrayImpl dataType,TypeNativeStringBasedArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeStringBasedArrayImpl(ClassTypeNativeStringBasedArrayImpl dataType,VarTypeNativeImpl varTypeDecComp)
    {
        super(dataType,varTypeDecComp);
    }    

    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        return new TypeNativeStringBasedArrayRuntimeImpl(this,javaClass,isPrimary,varTypeDecCompRt,ctx);        
    }       
}
