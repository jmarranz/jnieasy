/*
 * VarTypeNativeRuntimeImpl.java
 *
 * Created on 10 de diciembre de 2004, 11:53
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextUsingImports;
import com.innowhere.jnieasy.core.impl.rt.signat.ParameterDecRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;


public abstract class VarTypeNativeRuntimeImpl implements VarTypeNativeRuntime
{
    protected VarTypeNativeImpl varType;    
    protected TypeNativeRuntimeImpl typeRt;
    
    /**
     * Creates a new instance of VarTypeNativeRuntimeImpl
     */
    public VarTypeNativeRuntimeImpl(VarTypeNativeImpl varTypeDec,TypeNativeRuntimeImpl typeDecRt)
    {
        this.varType = varTypeDec;
        this.typeRt = typeDecRt;
    }

    public VarTypeNativeImpl getVarTypeNative()
    {
        return varType;
    }
    
    public TypeNative getType()
    {
        return typeRt;
    }
    
    public TypeNativeRuntimeImpl getTypeNativeRuntime()
    {
        return typeRt;
    }
    
    public NativeManagerImpl getNativeManager()
    {
        return (NativeManagerImpl)typeRt.getNativeManager();
    }
    
    public int getVarConv()
    {
        return varType.getVarConv();
    }
    
    public void setVarConv(int varConv)
    {
        varType.setVarConv(varConv);
    }    
    
    public boolean byValue()
    {
        return varType.byValue();        
    }

    public boolean byPointer()
    {
        return varType.byPointer();        
    }
    
    public boolean equals(Object obj)
    {    
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        VarTypeNativeRuntimeImpl obj2 = (VarTypeNativeRuntimeImpl)obj;

        if (!getVarTypeNative().equals(obj2.getVarTypeNative()))
            return false;
        return true;
    }        

    public int hashCode()
    {
        return getVarTypeNative().hashCode();
    }
            
    public static VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        VarTypeNativeImpl varTypeDec = VarTypeNativeImpl.newVarTypeNative(typeDecRt.getTypeNative());        
        return varTypeDec.newVarTypeNativeRuntime(typeDecRt,ctx);
    }
    
    public static VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(Class declaredClass,RuntimeContext ctx)    
    {    
        TypeNativeRuntimeImpl typeDecRt = TypeNativeRuntimeImpl.newTypeNativeRuntime(declaredClass,ctx);
        return newVarTypeNativeRuntime(typeDecRt,ctx);
    }
    
    public static VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(Class clasz,VarTypeNativeImpl varTypeDec,RuntimeContext ctx)
    {
        TypeNativeRuntimeImpl typeDecRt = TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,varTypeDec.getTypeNative(),ctx);        
        return varTypeDec.newVarTypeNativeRuntime(typeDecRt,ctx);
    }     
    
    public static VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(String decClassExpr,RuntimeContextUsingImports ctx)
    {    
        VarTypeNativeImpl varTypeDec = VarTypeNativeParserImpl.newVarTypeNative(new SourceCode(decClassExpr),ctx);

        Class clasz = TypeNativeRuntimeImpl.getClassImpl(varTypeDec.getTypeNative());
        return newVarTypeNativeRuntime(clasz,varTypeDec,ctx);        
    }
    
    public static VarTypeNativeRuntimeImpl convert(Object varTypeDec,NativeVarTypeManagerRuntimeImpl varTypeMgr)    
    {
        if (varTypeDec instanceof VarTypeNativeRuntimeImpl)
            return (VarTypeNativeRuntimeImpl)varTypeDec;
        else if (varTypeDec instanceof Class)
            return (VarTypeNativeRuntimeImpl)varTypeMgr.dec((Class)varTypeDec);
        else if (varTypeDec instanceof String)
            return (VarTypeNativeRuntimeImpl)varTypeMgr.dec((String)varTypeDec);
        else
            throw new JNIEasyException("Declaration type must be an object of type Class, String or derived from " + VarTypeNative.class.getName());
    }

    public void checkValue(Object value)
    {
        if ((value == null) && (getVarConv() == VarTypeNative.BY_VALUE))
             throw new JNIEasyException("Value cannot be null, is declared by value");

        typeRt.checkValue(value);
    }     
    
    public long stackSize()
    {
        if (byValue())
            return typeRt.stackSizeByValue();
        else
            return TypeSizes.getADDRESS();
    }    
   
    public NativeTypeManager getTypeManager()    
    {
        return getTypeNativeRuntime().getTypeManagerRuntime();
    }
    
    public NativeVarTypeManager getVarTypeManager()
    {
        return getTypeNativeRuntime().getRuntimeManager().getVarTypeManagerRuntime();
    }
    
    public TypeNativeArray decArray(int[] dims)
    {
        return getTypeManager().decArray(dims,this);
    }

    public TypeNativeArray decArray(int length)
    {
        return getTypeManager().decArray(length,this);
    }    
    
    public TypeNativePointer decPointer()
    {
        return getTypeManager().decPointer(this);
    }

    public NativeParameterDec decParameter()
    {
        return new ParameterDecRuntimeImpl(this);
    }
    
    public NativeParameterDec decParameter(boolean varargs)
    {
        ParameterDecRuntimeImpl param = new ParameterDecRuntimeImpl(this);
        param.setVarArgs(varargs);
        return param;
    }            
    
    public long size()
    {
        if (getVarConv() == VarTypeNative.BY_PTR)
            return TypeSizes.getADDRESS();
        else            
            return typeRt.size();        
    }    
    
    public long preferredAlignSize()
    {
        if (getVarConv() == VarTypeNative.BY_PTR)
            return TypeSizes.getADDRESS();
        else     
            return typeRt.preferredAlignSize();
    }   
    
    public String getDeclarationString()
    {
        return varType.getDeclarationString();
    }
        
    public static VarTypeNativeRuntimeImpl getDefaultAssociatedType(Object value,boolean primitiveByValue,RuntimeContext ctx)
    {
        TypeNativeRuntimeImpl typeDec = TypeNativeObjectRuntimeImpl.getDefaultAssociatedType(value,primitiveByValue,ctx);
        return VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(typeDec,ctx);
    }    
    
    public abstract Object push(Object value,NativeBufferIteratorImpl memIt);   
    public abstract Object pop(NativeBufferIteratorImpl memIt);
    public abstract Object pushVarArgs(Object value,NativeBufferIteratorImpl memIt);    

    public abstract Object unwrap(Object argUsed);
    public abstract void unwrapVarArgs(Object arg,Object argUsed);
  
}
