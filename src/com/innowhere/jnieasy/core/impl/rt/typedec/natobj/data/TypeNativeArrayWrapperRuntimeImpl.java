/*
 * TypeNativeArrayWrapperRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayInfoRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public class TypeNativeArrayWrapperRuntimeImpl extends TypeCanBeNativeCapableWrapperRuntimeImpl implements TypeNativeArrayRuntime
{
    /** Creates a new instance of TypeNativeArrayWrapperRuntimeImpl */
    public TypeNativeArrayWrapperRuntimeImpl(TypeNativeArrayWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }   
    
    public static TypeNativeArrayWrapperRuntimeImpl newTypeNativeArrayWrapperRuntime(Class clasz,int[] dims,VarTypeNativeRuntimeImpl lastCompVarType,RuntimeContext ctx)
    {
        TypeNativeArrayImpl typeDecWrapped = TypeNativeArrayImpl.newTypeNativeArray(dims,lastCompVarType.getVarTypeNative(),ctx);
        TypeNativeArrayWrapperImpl typeDecWrapper = typeDecWrapped.getTypeNativeArrayWrapper();
        TypeNativeArrayWrapperRuntimeImpl typeDecRt = (TypeNativeArrayWrapperRuntimeImpl)typeDecWrapper.newTypeCanBeNativeCapableWrapperRuntime(clasz,true,ctx);
        typeDecRt.getTypeNativeArrayInfoRuntime().setLastComponentVarType(lastCompVarType);
        return typeDecRt;
    }
       
    public void setTypeCanBeNativeCapableRuntime(RuntimeContext ctx)
    {
        TypeNativeArrayWrapperImpl typeDec = getTypeNativeArrayWrapper();    
        if (typeDec.isCompleteDeclaration()) // Si no es completa se tendrá que definir wrappedType con el set           
            super.setTypeCanBeNativeCapableRuntime(ctx); 
    }    
    
    public TypeNativeArrayRuntimeImpl getTypeNativeArrayRuntime()
    {
        return (TypeNativeArrayRuntimeImpl)getTypeCanBeNativeCapableRuntime();
    }    
    
    public TypeNativeArrayWrapperImpl getTypeNativeArrayWrapper()
    {
        return (TypeNativeArrayWrapperImpl)typeDec;
    }

    public TypeNativeArrayInfoRuntime getTypeNativeArrayInfoRuntime()
    {
        return getTypeNativeArrayRuntime().getTypeNativeArrayInfoRuntime();
    }
    
    public VarTypeNativeRuntimeImpl getComponentDecRuntime()
    {
        return getTypeNativeArrayRuntime().getComponentDecRuntime();
    }    
    
    public VarTypeNative getComponentDec()
    {
        return getTypeNativeArrayRuntime().getComponentDec();
    }
    
    public VarTypeNative getLastComponentDec()
    {
        return getTypeNativeArrayRuntime().getLastComponentDec();
    }    
    
    public int[] getDimensions()
    {
        return getTypeNativeArrayRuntime().getDimensions();        
    }
    
    public int getLength()
    {
        return getTypeNativeArrayRuntime().getLength();        
    }
   
    public int getLength(Object arrayValue)
    {
        ClassTypeNativeArrayWrapperRuntimeImpl classType = (ClassTypeNativeArrayWrapperRuntimeImpl)getClassTypeRuntime();
        return classType.getLength(arrayValue);
    }
}
