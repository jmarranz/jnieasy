/*
 * VarTypeNativeArrayWrapperImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;

/**
 *
 * @author  jmarranz
 */

public class VarTypeNativeArrayWrapperImpl extends VarTypeCanBeNativeCapableWrapperImpl implements VarTypeNativeArrayInterface
{

    /** Creates a new instance of VarTypeNativeArrayWrapperImpl */
    public VarTypeNativeArrayWrapperImpl(TypeNativeArrayWrapperImpl typeDec,VarTypeNativeArrayImpl wrappedVarType)
    {
        super(typeDec,wrappedVarType);
    }
    
    public VarTypeNativeArrayWrapperImpl(TypeNativeArrayWrapperImpl typeDec)
    {
        super(typeDec);
    }    
    
    public VarTypeNativeArrayImpl getVarTypeNativeArray()
    {
        return (VarTypeNativeArrayImpl)getVarTypeCanBeNativeCapable();
    }
   
    public void checkReturnDecByValue()
    {
        getVarTypeNativeArray().checkReturnDecByValue();
    }    
            
   
    public String getDeclarationString()
    {
        String dec = typeDec.getDeclarationString();
        if (getVarConv() == VarTypeNative.BY_PTR) 
            dec += "*";
        return dec;
    }
    
    public int getVarConvIfNotAsterisk()
    {
        // Redefinimos en el caso de arrays
        // Tenemos claro que es por valor
        return VarTypeNative.BY_VALUE; 
    }     
    
    public TypeNativeArrayInterface getTypeNativeArrayInterface()
    {
        return (TypeNativeArrayInterface)typeDec;
    }
    
    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeArrayWrapperRuntimeImpl(this,(TypeNativeArrayWrapperRuntimeImpl)typeDecRt);
    }

    public VarTypeCanBeNativeCapableImpl newVarTypeCanBeNativeCapable()
    {
        TypeNativeArrayWrapperImpl typeDec = (TypeNativeArrayWrapperImpl)getTypeNative();
        return new VarTypeNativeArrayImpl(typeDec.getTypeNativeArray(),this);
    }       
}
