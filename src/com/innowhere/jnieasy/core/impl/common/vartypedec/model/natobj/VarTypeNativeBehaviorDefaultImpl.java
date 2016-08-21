/*
 * VarTypeNativeBehaviorDefaultImpl.java
 *
 * Created on 21 de septiembre de 2005, 13:23
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeBehaviorDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeBehaviorDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

/**
 *
 * @author jmarranz
 */
public class VarTypeNativeBehaviorDefaultImpl extends VarTypeNativeCapableImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeBehaviorDefaultImpl
     */
    public VarTypeNativeBehaviorDefaultImpl(TypeNativeBehaviorDefaultImpl typeDec)
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
        return new VarTypeNativeBehaviorDefaultRuntimeImpl(this,(TypeNativeBehaviorDefaultRuntimeImpl)typeDecRt);
    }   
}
