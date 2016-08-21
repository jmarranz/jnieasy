/*
 * VarTypeNativeEnhancerRender.java
 *
 * Created on 18 de marzo de 2004, 17:23
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;

/**
 *
 * @author  jmarranz
 */


public abstract class VarTypeNativeEnhancerRender
{
    protected VarTypeNativeImpl varType;
    protected VarTypeNativeRender varTypeRender;
    
    /** Creates a new instance of VarTypeNativeEnhancerRender */
    public VarTypeNativeEnhancerRender(VarTypeNativeImpl varTypeDec)
    {
        this.varType = varTypeDec;
        this.varTypeRender = varTypeDec.newVarTypeNativeRender();
    }

    public VarTypeNativeImpl getVarTypeNative()
    {
        return varType;
    }
    
    public VarTypeNativeRender getVarTypeNativeRender()
    {
        return varTypeRender;
    }
    
    public static VarTypeNativeEnhancerRender newVarTypeNativeEnhancerRender(VarTypeNativeImpl varTypeDec)
    {
        return varTypeDec.newVarTypeNativeEnhancerRender();
    }

    public String getDeclareTypeCallString() 
    {
        return varTypeRender.getDeclareVarTypeCallString(true);
    }
       
    public abstract String getFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String fetchMode);     
    public abstract String getFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String fetchMode,String fetchCtx,String stateMgr);    
    public abstract String getUnFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String newValue,String unFetchMode);     
    public abstract String getUnFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String newValue,String unFetchMode,String unfetchCtx,String attachCopyCtx,String stateMgr);    
}
