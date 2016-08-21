/*
 * VarTypeNativePrimitiveWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativePrimitiveWrapperImpl extends VarTypeNativeSingleFieldContainerImpl
{
    /**
     * Creates a new instance of VarTypeNativePrimitiveWrapperImpl
     */
    public VarTypeNativePrimitiveWrapperImpl(TypeNativePrimitiveWrapperImpl typeDec)
    {
        super(typeDec);
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
        // No incluimos el * pues solo es por valor
        return typeDec.getDeclarationString();
    }

    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativePrimitiveWrapperRuntimeImpl(this,(TypeNativePrimitiveWrapperRuntimeImpl)typeDecRt);
    }
}

