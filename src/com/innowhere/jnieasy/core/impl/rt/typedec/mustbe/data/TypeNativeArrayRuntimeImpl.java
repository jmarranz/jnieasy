/*
 * TypeNativeArrayRuntimeImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeArrayInfoRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public abstract class TypeNativeArrayRuntimeImpl extends TypeCanBeNativeCapableRuntimeImpl implements TypeNativeArrayRuntime
{
    protected TypeNativeArrayInfoRuntime arrayInfo;
            
    /**
     * Creates a new instance of TypeNativeArrayRuntimeImpl
     */
    public TypeNativeArrayRuntimeImpl(TypeNativeArrayImpl typeDec,Class javaClass,VarTypeNativeRuntimeImpl varTypeDecCompRt,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);        
        
        this.arrayInfo = new TypeNativeArrayInfoRuntime(this,varTypeDecCompRt);                
    }
    
    public static int[] getDimensions(Class clasz)
    {
        int ndims = 0;
        
        while(clasz.isArray())
        {
            ndims++;
            clasz = clasz.getComponentType();
        }
        
        int[] dims = new int[ndims];
        for(int i = 0; i < dims.length; i++)
            dims[i] = -1;
        
        return dims;
    }
    
    public static TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Object value,RuntimeContext ctx)
    {
        Class cls = value.getClass();
        TypeNativeArrayRuntimeImpl typeDec = (TypeNativeArrayRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(cls,ctx);
        typeDec.getTypeNativeArrayInfoRuntime().setDimensionsFrom(value);
        return typeDec;
    }    

    public static TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(TypeNativeArrayImpl typeDec,VarTypeNativeRuntimeImpl lastCompVarType,RuntimeContext ctx)
    {     
        Class clasz = TypeNativeRuntimeImpl.getClassImpl(typeDec);
        return newTypeNativeArrayRuntime(clasz,typeDec,lastCompVarType,ctx);
    }
 

    public static TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class clasz,TypeNativeArrayImpl typeDec,VarTypeNativeRuntimeImpl lastCompVarType,RuntimeContext ctx)
    {     
        TypeNativeArrayRuntimeImpl typeDecRt = (TypeNativeArrayRuntimeImpl)typeDec.newTypeCanBeNativeCapableRuntime(clasz,true,ctx);
        typeDecRt.getTypeNativeArrayInfoRuntime().setLastComponentVarType(lastCompVarType);
        return typeDecRt;
    }    
    
    public static TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,VarTypeNativeRuntimeImpl lastCompVarType,RuntimeContext ctx)
    {     
        int[] dims = getDimensions(javaClass);
        return newTypeNativeArrayRuntime(javaClass,dims,lastCompVarType,ctx);
    }        
    
    public static TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(int[] dims,VarTypeNativeRuntimeImpl lastCompVarType,RuntimeContext ctx)
    {    
        TypeNativeArrayImpl typeDec = TypeNativeArrayImpl.newTypeNativeArray(dims, lastCompVarType.getVarTypeNative(), ctx);          
        Class arrayClass = TypeNativeRuntimeImpl.getClassImpl(typeDec);
        return (TypeNativeArrayRuntimeImpl)newTypeNativeArrayRuntime(arrayClass,typeDec,lastCompVarType,ctx);
    }
    
    public static TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class arrayClass,int[] dims,VarTypeNativeRuntimeImpl lastCompVarType,RuntimeContext ctx)
    {    
        TypeNativeArrayImpl typeDec = TypeNativeArrayImpl.newTypeNativeArray(dims, lastCompVarType.getVarTypeNative(), ctx);          
        return (TypeNativeArrayRuntimeImpl)newTypeNativeArrayRuntime(arrayClass,typeDec,lastCompVarType,ctx);
    }    
     
    public TypeNativeArrayWrapperRuntimeImpl getTypeNativeArrayWrapperRuntime()
    {
        return (TypeNativeArrayWrapperRuntimeImpl)getTypeCanBeNativeCapableWrapperRuntime();
    }    
            
    public TypeNativeArrayImpl getTypeNativeArray()
    {
        return (TypeNativeArrayImpl)typeDec;
    }
    
    public TypeNativeArrayInfoRuntime getTypeNativeArrayInfoRuntime()
    {
        return arrayInfo;
    }

    public VarTypeNativeRuntimeImpl getComponentDecRuntime()
    {
        return arrayInfo.getComponentVarType();
    }    
    
    public VarTypeNative getComponentDec()
    {
        return arrayInfo.getComponentVarType();
    }
    
    public VarTypeNative getLastComponentDec()
    {
        return arrayInfo.getLastComponentVarType();
    }    

    public int[] getDimensions()
    {
        // No hay problema de que se pueda modificar el array, pues se crea a propósito de la llamada
        return arrayInfo.getDimensions();
    }    
    
    public int getLength()
    {
        return arrayInfo.getLength();        
    }    
    
    public void checkValue(Object value) 
    {
        super.checkValue(value);
        arrayInfo.checkArrayValue(value);
    }

 
    public boolean isObjectKnownSize()
    {
        return arrayInfo.getTypeNativeArrayInfo().lengthKnown();
    }    
    
    public int getLength(Object value)
    {
        ClassTypeNativeArrayRuntimeImpl classType = (ClassTypeNativeArrayRuntimeImpl)getClassTypeRuntime();
        return classType.getLength(value);
    }
    
    public long getSize(Object value)
    {
        int len = getLength(value);
        if (len == 0) return 0;
            
        long componentSize = getTypeNativeArrayInfoRuntime().getComponentSize(value);
        return len * componentSize;
    }
    
    public long calcSize()
    {
        return arrayInfo.getArraySize();
    }        

    public long calcPreferredAlignSize()
    {
        // El alineamiento lo impone la componente (última) de la matriz
        return arrayInfo.getLastComponentVarType().preferredAlignSize();
    }    

    public Object newValueInternal()
    {
        // Es redefinida en el caso de ArrayOfArray
        ClassTypeNativeArrayRuntimeImpl classType = (ClassTypeNativeArrayRuntimeImpl)getClassTypeRuntime();
        return classType.newArrayValue(getLength());
    }
    
    public abstract Object pushVarArgs(Object value,NativeBufferIteratorImpl memIt);    
    public abstract void unwrapVarArgs(Object arg,Object argUsed);
}
