/*
 * VarTypeNativeMemberReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeMemberReflectionWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeMemberReflectionWrapperRuntimeImpl;

public class VarTypeNativeMemberReflectionWrapperImpl extends VarTypeCanBeNativeCapableWrapperImpl
{
    /**
     * Creates a new instance of VarTypeNativeMemberReflectionWrapperImpl
     */
    public VarTypeNativeMemberReflectionWrapperImpl(TypeNativeMemberReflectionWrapperImpl typeDec,VarTypeNativeMemberReflectionImpl wrappedVarType)
    {
        super(typeDec,wrappedVarType);
    }
    
    public VarTypeNativeMemberReflectionWrapperImpl(TypeNativeMemberReflectionWrapperImpl typeDec)
    {
        super(typeDec);
    }   
    
    public VarTypeNativeMemberReflectionImpl getVarTypeNativeMemberReflection()
    {
        return (VarTypeNativeMemberReflectionImpl)getVarTypeCanBeNativeCapable();
    }
    
    public String getDeclarationString()
    {
        // No incluimos el * pues solo es por referencia
        return typeDec.getDeclarationString();
    }

    
    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeMemberReflectionWrapperRuntimeImpl(this,(TypeNativeMemberReflectionWrapperRuntimeImpl)typeDecRt);
    }
    
    public VarTypeCanBeNativeCapableImpl newVarTypeCanBeNativeCapable()
    {
        TypeNativeMemberReflectionWrapperImpl typeDec = (TypeNativeMemberReflectionWrapperImpl)getTypeNative();
        return new VarTypeNativeMemberReflectionImpl(typeDec.getTypeNativeMemberReflection(),this);
    }    
}
