/*
 * StringBasedWrapperType.java
 *
 * Created on 11 de febrero de 2005, 11:54
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBasedWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeStringBasedWrapperRuntimeImpl;

public class VarTypeNativeStringBasedWrapperImpl extends VarTypeCanBeNativeCapableWrapperImpl
{
    /** Creates a new instance of StringBasedWrapperType */
    public VarTypeNativeStringBasedWrapperImpl(TypeNativeStringBasedWrapperImpl typeDec,VarTypeNativeStringBasedImpl wrappedVarType)
    {
        super(typeDec,wrappedVarType);
    }
    
    public VarTypeNativeStringBasedWrapperImpl(TypeNativeStringBasedWrapperImpl typeDec)
    {
        super(typeDec);
    }    
    
    public VarTypeNativeStringBasedImpl getVarTypeNativeStringBased()
    {
        return (VarTypeNativeStringBasedImpl)getVarTypeCanBeNativeCapable();
    }
    
    public String getDeclarationString()
    {
        // No incluimos el * pues solo es por referencia
        return typeDec.getDeclarationString();
    }

    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeStringBasedWrapperRuntimeImpl(this,(TypeNativeStringBasedWrapperRuntimeImpl)typeDecRt);
    }
    
    public VarTypeCanBeNativeCapableImpl newVarTypeCanBeNativeCapable()
    {
        TypeNativeStringBasedWrapperImpl typeDec = (TypeNativeStringBasedWrapperImpl)getTypeNative();
        return new VarTypeNativeStringBasedImpl(typeDec.getTypeNativeStringBased(),this);
    }   
}
