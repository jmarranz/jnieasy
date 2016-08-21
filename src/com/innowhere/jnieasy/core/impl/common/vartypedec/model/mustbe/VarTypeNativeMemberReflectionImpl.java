/*
 * VarTypeNativeMemberReflectionImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeMemberReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeNativeMemberReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

public class VarTypeNativeMemberReflectionImpl extends VarTypeCanBeNativeCapableImpl
{
    /**
     * Creates a new instance of VarTypeNativeMemberReflectionImpl
     */
    public VarTypeNativeMemberReflectionImpl(TypeNativeMemberReflectionImpl typeDec,VarTypeNativeMemberReflectionWrapperImpl wrapperVarType)
    {
        super(typeDec,wrapperVarType);
    }
        
    public VarTypeNativeMemberReflectionImpl(TypeNativeMemberReflectionImpl typeDec)
    {
        super(typeDec,null);
    }       
    
    public VarTypeNativeMemberReflectionWrapperImpl getVarTypeNativeMemberReflectionWrapper()
    {
        return (VarTypeNativeMemberReflectionWrapperImpl)getVarTypeCanBeNativeCapableWrapper();
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
        return new VarTypeNativeMemberReflectionRuntimeImpl(this,(TypeNativeMemberReflectionRuntimeImpl)typeDecRt);
    }

    public VarTypeCanBeNativeCapableWrapperImpl newVarTypeCanBeNativeCapableWrapper()
    {
        TypeNativeMemberReflectionImpl typeDec = (TypeNativeMemberReflectionImpl)getTypeNative();
        return new VarTypeNativeMemberReflectionWrapperImpl(typeDec.getTypeNativeMemberReflectionWrapper(),this);
    }    
}
