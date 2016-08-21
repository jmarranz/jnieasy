/*
 * TypeNativePrimitiveArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;



public class TypeNativePrimitiveArrayImpl extends TypeNativeArrayImpl
{
    /**
     * Creates a new instance of TypeNativePrimitiveArrayImpl
     */
    public TypeNativePrimitiveArrayImpl(ClassTypeNativePrimitiveArrayImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativePrimitiveArrayImpl(ClassTypeNativePrimitiveArrayImpl dataType,TypeNativePrimitiveArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativePrimitiveArrayImpl(ClassTypeNativePrimitiveArrayImpl dataType,VarTypeNativeImpl varTypeDecComp)
    {
        super(dataType,varTypeDecComp);
    }    

    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        return new TypeNativePrimitiveArrayRuntimeImpl(this,javaClass,isPrimary,varTypeDecCompRt,ctx);        
    }             
}

