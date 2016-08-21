/*
 * VarTypeNativePrimitiveRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.render;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.util.Util;

public class VarTypeNativePrimitiveRender extends VarTypeNativeRender
{
    
    /** Creates a new instance of VarTypeNativePrimitiveRender */
    public VarTypeNativePrimitiveRender(VarTypeNativePrimitiveImpl varTypeDec)
    {
        super(varTypeDec);
    }
    
    public static VarTypeNativePrimitiveRender newTypeNativePrimitiveRender(VarTypeNativePrimitiveImpl varTypeDec)
    {
        return (VarTypeNativePrimitiveRender)varTypeDec.newVarTypeNativeRender();
    }  

    public VarTypeNativePrimitiveImpl getVarTypeNativePrimitive()
    {
        return (VarTypeNativePrimitiveImpl)varType;
    }

    public String getReturnAndCast()
    {
        String type = varType.getTypeNative().getClassName();
        if (type.equals("void")) return "";
        return "return ";
    }    
        
    public String generateCallName()
    {        
        return "call" + Util.capitalizeFirst(varType.getTypeNative().getClassName());
    }      
    
    public String generateParamArg(String paramName)
    {
        VarTypeNativePrimitiveImpl varTypeDec = getVarTypeNativePrimitive();
        return "new " + varTypeDec.getTypeNativePrimitive().getClassTypeNativePrimitive().getWrapperClassName() + "(" + paramName + ")";
    }    
}
