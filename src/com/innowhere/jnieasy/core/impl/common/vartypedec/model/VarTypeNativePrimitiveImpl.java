/*
 * VarTypeNativePrimitiveImpl.java
 *
 * Created on 2 de febrero de 2005, 11:38
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model;
import com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec.VarTypeNativeEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec.VarTypeNativePrimitiveEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativePrimitiveRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativePrimitiveImpl extends VarTypeNativeImpl
{
   
    /**
     * Creates a new instance of VarTypeNativePrimitiveImpl
     */
    public VarTypeNativePrimitiveImpl(TypeNativePrimitiveImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
        return (TypeNativePrimitiveImpl)typeDec;
    }
    
    public void setVarConv(int varConv)
    {
        VarTypeNativeVarConvInfo.checkIsVarConvValid(varConv, this);
        // es por valor siempre, no guardamos
    }
    
    public int getVarConv()
    {
        return getDefaultVarConv();
    }

    public int getDefaultVarConv()
    {
        return VarTypeNative.BY_VALUE;
    }

    public boolean isFixedVarConv()
    {
        return true;
    }        
    
    public boolean needAuxNativeCapable()
    {
        return false;
    }
    
    public String getDeclarationString()
    {
        return typeDec.getDeclarationString();
    }
    
    public VarTypeNativeRender newVarTypeNativeRender()
    {
        return new VarTypeNativePrimitiveRender(this);
    }
    
    public VarTypeNativeEnhancerRender newVarTypeNativeEnhancerRender()
    {
        return new VarTypeNativePrimitiveEnhancerRender(this);
    }   
    
    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativePrimitiveRuntimeImpl(this,(TypeNativePrimitiveRuntimeImpl)typeDecRt);
    }
}
