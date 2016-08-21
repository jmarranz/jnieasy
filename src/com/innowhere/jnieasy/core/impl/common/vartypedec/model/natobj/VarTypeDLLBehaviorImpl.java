/*
 * VarTypeDLLBehaviorImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeDLLBehaviorImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeDLLBehaviorRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeDLLBehaviorRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeDLLBehaviorImpl extends VarTypeNativeCapableImpl
{
    /**
     * Creates a new instance of VarTypeDLLBehaviorImpl
     */
    public VarTypeDLLBehaviorImpl(TypeDLLBehaviorImpl typeDec)
    {
        super(typeDec);
    }
    
    public boolean isFixedVarConv()
    {
        // El paso por valor supone hacer una copia del contenido de la función
        // no tiene sentido
        
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
        return new VarTypeDLLBehaviorRuntimeImpl(this,(TypeDLLBehaviorRuntimeImpl)typeDecRt);
    }
}
