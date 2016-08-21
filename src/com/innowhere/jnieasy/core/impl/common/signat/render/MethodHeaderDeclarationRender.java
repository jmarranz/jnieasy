/*
 * MethodHeaderDeclarationRender.java
 *
 * Created on 28 de marzo de 2005, 18:22
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;
import com.innowhere.jnieasy.core.impl.common.signat.model.MethodHeaderDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.*;

public class MethodHeaderDeclarationRender
{
    protected MethodHeaderDeclarationImpl methodHeader;
    protected VarTypeNativeRender varTypeRender;
    
    /**
     * Creates a new instance of MethodHeaderDeclarationRender
     */
    public MethodHeaderDeclarationRender(MethodHeaderDeclarationImpl methodHeader)
    {
        this.methodHeader = methodHeader;
        this.varTypeRender = VarTypeNativeRender.newVarTypeNativeRender(methodHeader.getVarTypeNative());
    }
    
    public String getVarTypeCode(boolean enhancer)
    {
        return varTypeRender.getDeclareVarTypeCallString(enhancer);
    }
    
    public VarTypeNativeRender getVarTypeNativeRender()
    {
        return varTypeRender;
    }

    public String asString()
    {
        return methodHeader.getVarTypeNative().getDeclarationString();
    }    
}
