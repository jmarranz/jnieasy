/*
 * StringBasedType.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringBasedRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativeStringBasedRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

public class VarTypeNativeStringBasedImpl extends VarTypeCanBeNativeCapableImpl
{
    
    /** Creates a new instance of StringBasedType */
    public VarTypeNativeStringBasedImpl(TypeNativeStringBasedImpl typeDec, VarTypeNativeStringBasedWrapperImpl wrapperVarType)
    {
        super(typeDec,wrapperVarType);
    }
    
    public VarTypeNativeStringBasedImpl(TypeNativeStringBasedImpl typeDec)
    {
        super(typeDec,null);
    }    
    
    public VarTypeNativeStringBasedWrapperImpl getVarTypeNativeStringBasedWrapper()
    {
        return (VarTypeNativeStringBasedWrapperImpl)getVarTypeCanBeNativeCapableWrapper();
    }

    public boolean isFixedVarConv()
    {
        // Necesariamente es sólo por referencia pues por definición es puntero        
        return true;
    }        
    
    public int getDefaultVarConv()
    {
        return VarTypeNative.BY_PTR;
    }    
    
    public void setVarConv(int varConv)
    {
        VarTypeNativeVarConvInfo.checkIsVarConvValid(varConv, this);
        // es por referencia siempre, no guardamos
    }

    public int getVarConv()
    {
        return getDefaultVarConv();
    }
    
    public String getDeclarationString()
    {
        // No incluimos el * pues solo es por referencia
        return typeDec.getDeclarationString();
    }

    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeStringBasedRuntimeImpl(this,(TypeNativeStringBasedRuntimeImpl)typeDecRt);
    }    

    public VarTypeCanBeNativeCapableWrapperImpl newVarTypeCanBeNativeCapableWrapper()
    {
        TypeNativeStringBasedImpl typeDec = (TypeNativeStringBasedImpl)getTypeNative();
        return new VarTypeNativeStringBasedWrapperImpl(typeDec.getTypeNativeStringBasedWrapper(),this);
    }    
}
