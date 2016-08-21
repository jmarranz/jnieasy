/*
 * VarTypeNativePointerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativePointerImpl extends VarTypeNativeObjectFieldContainerImpl
{
   
    /**
     * Creates a new instance of VarTypeNativePointerImpl
     */
    public VarTypeNativePointerImpl(TypeNativePointerImpl typeDec)
    {
        super(typeDec);
    }

    public boolean isFixedVarConv()
    {
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
        return new VarTypeNativePointerRuntimeImpl(this,(TypeNativePointerRuntimeImpl)typeDecRt);
    }
}
