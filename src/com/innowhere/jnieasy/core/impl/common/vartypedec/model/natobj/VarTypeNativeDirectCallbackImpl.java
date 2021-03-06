/*
 * VarTypeNativeDirectCallbackImpl.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativeDirectCallbackImpl extends VarTypeNativeCapableImpl
{
    /**
     * Creates a new instance of VarTypeNativeDirectCallbackImpl
     */
    public VarTypeNativeDirectCallbackImpl(TypeNativeDirectCallbackImpl typeDec)
    {
        super(typeDec);
    }

    public boolean isFixedVarConv()
    {
        // El paso por valor supone hacer una copia del contenido de la funci�n
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
        return new VarTypeNativeDirectCallbackRuntimeImpl(this,(TypeNativeDirectCallbackRuntimeImpl)typeDecRt);
    }

}
