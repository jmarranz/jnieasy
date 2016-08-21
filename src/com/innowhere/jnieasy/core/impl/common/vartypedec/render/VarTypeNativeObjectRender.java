/*
 * VarTypeNativeObjectRender.java
 *
 * Created on 18 de marzo de 2004, 17:23
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.render;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;

public class VarTypeNativeObjectRender extends VarTypeNativeRender
{
    /** Creates a new instance of VarTypeNativeObjectRender */
    public VarTypeNativeObjectRender(VarTypeNativeObjectImpl varTypeDec)
    {
        super(varTypeDec);
    }

    public VarTypeNativeObjectImpl getVarTypeNativeObject()
    {
        return (VarTypeNativeObjectImpl)varType;
    }
    
    public String getReturnAndCast()
    {
        String type = varType.getTypeNative().getClassName();
        return "return (" + type + ")";
    } 
        
    public String generateCallName()
    {
        return "callObject";
    }      

    public String generateParamArg(String paramName)
    {
        return paramName; // Aunque necesite ser "wrapped", lo será dentro de la llamada 
    }     
}
