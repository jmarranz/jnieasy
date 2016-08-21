/*
 * MethodHeaderDeclarationImpl.java
 *
 * Created on 20 de febrero de 2004, 13:01
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


public abstract class MethodHeaderDeclarationImpl
{
    protected VarTypeNativeImpl varType;

    
    /**
     * Creates a new instance of MethodHeaderDeclarationImpl
     */
    public MethodHeaderDeclarationImpl(VarTypeNativeImpl typeDec)
    {
        this.varType = typeDec;
    }    
    
    public String getErrorPrefix()
    {
        return "Method return :";
    }
    
    public VarTypeNativeImpl getVarTypeNative()
    {
        return varType;
    }
    
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto

        // Son objetos distintos, pero si la clase esperada 
        // y el tipo de paso son los mismos
        // los consideraremos iguales
        // dataType no cuenta pues se obtiene de la clase declarada
        VarTypeNativeImpl varType2 = ((MethodHeaderDeclarationImpl)obj).getVarTypeNative();
        return varType.equals(varType2);
    }  
    
    public void check()
    {
        varType.check();
    }    
}
