/*
 * VarTypeNativeRender.java
 *
 * Created on 18 de marzo de 2004, 17:23
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.render;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.typedec.*;



public abstract class VarTypeNativeRender
{
    protected VarTypeNativeImpl varType;
    protected TypeNativeRender typeDecRender;
    
    /** Creates a new instance of VarTypeNativeRender */
    public VarTypeNativeRender(VarTypeNativeImpl varTypeDec)
    {
        this.varType = varTypeDec;
        this.typeDecRender = TypeNativeRender.newTypeNativeRender(varTypeDec.getTypeNative());
    }

    public static VarTypeNativeRender newVarTypeNativeRender(VarTypeNativeImpl varTypeDec)
    {
        return varTypeDec.newVarTypeNativeRender();
    }
    
    public VarTypeNativeImpl getVarTypeNative()
    {
        return varType;
    }
    
    public TypeNativeRender getTypeNativeRender()
    {
        return typeDecRender;
    }
    
    public String getDeclareVarTypeCallString(boolean enhancer) 
    {
        StringBuffer code = new StringBuffer();
        code.append( "jnieasyRoot.getTypeManager()." );
        code.append( typeDecRender.getDeclareTypeCallString(enhancer) );
        code.append( ".decVarType(" + getVarConvExpr() + ")" );
        
        return code.toString();
    }

    public String getVarConvExpr()
    {
        // Podríamos poner "TypeDec.BY_VALUE" etc en el código
        // pero el comportamiento del compilador es el de
        // sustituir la expresión por el valor concreto
        // en el código compilado
        // (pues las constantes son estáticas finales, se supone que no
        // cambian, es por tanto una optimización).
       
        boolean isFixedVarConv = varType.isFixedVarConv();
        if (!isFixedVarConv)
        {
            String expr;             
            int varConv = varType.getVarConv();
            if (varConv == VarTypeNative.BY_PTR)
                expr = "BY_PTR";            
            else if (varConv == VarTypeNative.BY_VALUE)
                expr = "BY_VALUE";            
            else
                throw new JNIEasyException("INTERNAL ERROR");
            
            return VarTypeNative.class.getName() + "." + expr;
        }
        else return ""; // El valor por defecto es el bueno
    }    
        
    public abstract String getReturnAndCast();    
    public abstract String generateCallName();
    public abstract String generateParamArg(String paramName);    
}
