/*
 * VarTypeNativeObjectImpl.java
 *
 * Created on 2 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec.VarTypeNativeEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec.VarTypeNativeObjectEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeObjectRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;



public abstract class VarTypeNativeObjectImpl extends VarTypeNativeImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeObjectImpl
     */
    public VarTypeNativeObjectImpl(TypeNativeObjectImpl typeDec)
    {
        super(typeDec);
    }
    
    
    public VarTypeNativeEnhancerRender newVarTypeNativeEnhancerRender()
    {
        return new VarTypeNativeObjectEnhancerRender(this);
    }

    public VarTypeNativeRender newVarTypeNativeRender()
    {
        return new VarTypeNativeObjectRender(this);
    }       
}
