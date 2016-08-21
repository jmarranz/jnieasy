/*
 * VarTypeNativePrimitiveObjectWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 13:32
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativePrimitiveObjectWrapperRuntimeImpl;

public class VarTypeNativePrimitiveObjectWrapperImpl extends VarTypeCanBeNativeCapableWrapperImpl
{
    
    /**
     * Creates a new instance of VarTypeNativePrimitiveObjectWrapperImpl
     */
    public VarTypeNativePrimitiveObjectWrapperImpl(TypeNativePrimitiveObjectWrapperImpl typeDec,VarTypeNativePrimitiveObjectImpl wrappedVarType)
    {
        super(typeDec,wrappedVarType);
    }    
    
    public VarTypeNativePrimitiveObjectWrapperImpl(TypeNativePrimitiveObjectWrapperImpl typeDec)
    {
        super(typeDec);
    }       
    
    public VarTypeNativePrimitiveObjectImpl getVarTypeNativePrimitiveObject()
    {
        return (VarTypeNativePrimitiveObjectImpl)getVarTypeCanBeNativeCapable();
    }

    public String getDeclarationString()
    {
        // No incluimos el * pues solo es por referencia
        return typeDec.getDeclarationString();
    }
    
    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativePrimitiveObjectWrapperRuntimeImpl(this,(TypeNativePrimitiveObjectWrapperRuntimeImpl)typeDecRt);
    }
    
    public VarTypeCanBeNativeCapableImpl newVarTypeCanBeNativeCapable()
    {
        TypeNativePrimitiveObjectWrapperImpl typeDec = (TypeNativePrimitiveObjectWrapperImpl)getTypeNative();
        return new VarTypeNativePrimitiveObjectImpl(typeDec.getTypeNativePrimitiveObject(),this);
    }    
}
