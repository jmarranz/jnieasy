/*
 * VarTypeNativePrimitiveObjectImpl.java
 *
 * Created on 2 de febrero de 2005, 14:03
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;


public class VarTypeNativePrimitiveObjectImpl extends VarTypeCanBeNativeCapableImpl
{
    
    /**
     * Creates a new instance of VarTypeNativePrimitiveObjectImpl
     */
    public VarTypeNativePrimitiveObjectImpl(TypeNativePrimitiveObjectImpl typeDec,VarTypeNativePrimitiveObjectWrapperImpl wrapperVarType)
    {
        super(typeDec,wrapperVarType);
    }
    
    public VarTypeNativePrimitiveObjectImpl(TypeNativePrimitiveObjectImpl typeDec)
    {
        super(typeDec,null);
    }    
    
    public VarTypeNativePrimitiveObjectWrapperImpl getVarTypeNativePrimitiveObjectWrapper()
    {
        return (VarTypeNativePrimitiveObjectWrapperImpl)getVarTypeCanBeNativeCapableWrapper();
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
        return new VarTypeNativePrimitiveObjectRuntimeImpl(this,(TypeNativePrimitiveObjectRuntimeImpl)typeDecRt);
    }

    public VarTypeCanBeNativeCapableWrapperImpl newVarTypeCanBeNativeCapableWrapper()
    {
        TypeNativePrimitiveObjectImpl typeDec = (TypeNativePrimitiveObjectImpl)getTypeNative();
        return new VarTypeNativePrimitiveObjectWrapperImpl(typeDec.getTypeNativePrimitiveObjectWrapper(),this);
    }
}
