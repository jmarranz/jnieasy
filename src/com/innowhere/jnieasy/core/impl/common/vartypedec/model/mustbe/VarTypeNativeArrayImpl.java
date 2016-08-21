/*
 * VarTypeNativeArrayImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;


public class VarTypeNativeArrayImpl extends VarTypeCanBeNativeCapableImpl implements VarTypeNativeArrayInterface
{
    protected VarTypeNativeVarConvInfo varConvInfo = new VarTypeNativeVarConvInfo(this);
    protected boolean varArgs = false;   // Usado únicamente como tipo de parámetro de método
    
    /**
     * Creates a new instance of VarTypeNativeArrayImpl
     */
    public VarTypeNativeArrayImpl(TypeNativeArrayImpl typeDec,VarTypeNativeArrayWrapperImpl wrapperVarType)
    {
        super(typeDec,wrapperVarType);
    }   
    
    public VarTypeNativeArrayImpl(TypeNativeArrayImpl typeDec)
    {
        super(typeDec,null);
    }
    
    public VarTypeNativeArrayWrapperImpl getVarTypeNativeArrayWrapper()
    {
        return (VarTypeNativeArrayWrapperImpl)getVarTypeCanBeNativeCapableWrapper();
    }
    
    public TypeNativeArrayInterface getTypeNativeArrayInterface()
    {
        return (TypeNativeArrayInterface)typeDec;
    }
    
    public TypeNativeArrayImpl getTypeNativeArray()
    {
        return (TypeNativeArrayImpl)typeDec;
    }    
    
    public void checkReturnDecByValue()
    {
        // Ver comentarios a este método en VarTypeMultipleFieldContainerImpl
        throw new JNIEasyException("Arrays cannot be returned by value");
    }      
        
    public int getDefaultVarConv()
    {
        return VarTypeNative.BY_PTR;
    }        

    public boolean isFixedVarConv()
    {
        // Se admiten los dos modos,
        // el "por valor" sólo será usado en arrays embebidas en estructuras        
        return false;
    }        
    
    public int getVarConv()
    {
        return varConvInfo.getVarConv();
    }
    
    public void setVarConv(int varConv)
    {
        varConvInfo.setVarConv(varConv);
    }    
    
    public void checkShared()
    {
        super.checkShared();
        boolean lengthKnown = getTypeNativeArray().getTypeNativeArrayInfo().lengthKnown();
        if (!lengthKnown && (getVarConv() == VarTypeNative.BY_VALUE))
            throw new JNIEasyException("Must specify the length attribute of an embedded array");
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
        // Tenemos claro que es por valor (idem que en VarTypeNativeArrayWrapperImpl)
        return VarTypeNative.BY_VALUE; 
    }
    
    public boolean isVarArgs()
    {
        // Redefine
        return varArgs;
    }

    public void setVarArgs(boolean varArgs)
    {
        // Redefine
        this.varArgs = varArgs;
    }        
    
    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeArrayRuntimeImpl(this,(TypeNativeArrayRuntimeImpl)typeDecRt);
    }    

    public VarTypeCanBeNativeCapableWrapperImpl newVarTypeCanBeNativeCapableWrapper()
    {
        TypeNativeArrayImpl typeDec = (TypeNativeArrayImpl)getTypeNative();
        return new VarTypeNativeArrayWrapperImpl(typeDec.getTypeNativeArrayWrapper(),this);
    }        
}
