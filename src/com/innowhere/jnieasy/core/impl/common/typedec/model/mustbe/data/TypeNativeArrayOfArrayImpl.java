/*
 * TypeNativeArrayOfArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayOfArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public class TypeNativeArrayOfArrayImpl extends TypeCanBeNativeCapableArrayImpl
{
    
    /**
     * Creates a new instance of TypeNativeArrayOfArrayImpl
     */
    public TypeNativeArrayOfArrayImpl(ClassTypeNativeArrayOfArrayImpl dataType)
    {
        super(dataType);
    }    
    
    public TypeNativeArrayOfArrayImpl(ClassTypeNativeArrayOfArrayImpl dataType,TypeNativeArrayOfArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeArrayOfArrayImpl(ClassTypeNativeArrayOfArrayImpl dataType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType,varTypeComp);
    }
    
    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeCompRt,RuntimeContext ctx)
    {
        return new TypeNativeArrayOfArrayRuntimeImpl(this,javaClass,isPrimary,varTypeCompRt,ctx);        
    }       
}

