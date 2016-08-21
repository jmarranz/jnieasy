/*
 * TypeNativeArrayOfArrayRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayInfoRuntime;
import java.lang.reflect.Array;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public class TypeNativeArrayOfArrayRuntimeImpl extends TypeCanBeNativeCapableArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeArrayOfArrayRuntimeImpl
     */   
    public TypeNativeArrayOfArrayRuntimeImpl(TypeNativeArrayOfArrayImpl typeDec,Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        super(typeDec,javaClass,varTypeDecCompRt,isPrimary,ctx);
    }
    
    public Object newValueInternal()
    {
        TypeNativeArrayInfoRuntime arrayInfoRt = getTypeNativeArrayInfoRuntime();
        int[] dims = arrayInfoRt.getDimensions();
        Class componentType = arrayInfo.getLastComponentVarType().getTypeNativeRuntime().getDeclaredClass();
        return Array.newInstance(componentType,dims);
    }
}

