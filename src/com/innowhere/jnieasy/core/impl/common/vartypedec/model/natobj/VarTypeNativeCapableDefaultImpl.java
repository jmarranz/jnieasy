/*
 * VarTypeNativeCapableDefaultImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativeCapableDefaultImpl extends VarTypeNativeCapableImpl
{
    /**
     * Creates a new instance of TypeNativeCapableDefaultImpl
     */
    public VarTypeNativeCapableDefaultImpl(TypeNativeCapableDefaultImpl typeDec)
    {
        super(typeDec);
    }

    public boolean isFixedVarConv()
    {
        // Sólo por referencia porque no conocemos el tamaño del objeto pasado        
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

    public String getDeclarationString()
    {
        // Ponemos el * para indicar que es siempre por referencia
        return typeDec.getDeclarationString() + "*";
    }       
    
    public int getVarConv()
    {
        return getDefaultVarConv();
    }
    
    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeCapableDefaultRuntimeImpl(this,(TypeNativeCapableDefaultRuntimeImpl)typeDecRt);
    }



}
