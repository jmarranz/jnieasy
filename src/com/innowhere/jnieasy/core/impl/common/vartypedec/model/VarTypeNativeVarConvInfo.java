/*
 * VarTypeNativeVarConvInfo.java
 *
 * Created on 9 de febrero de 2005, 14:18
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;


public class VarTypeNativeVarConvInfo
{
    protected VarTypeNativeImpl varType;
    protected int varConv;
    
    /**
     * Creates a new instance of VarTypeNativeVarConvInfo
     */
    public VarTypeNativeVarConvInfo(VarTypeNativeImpl varTypeDec)
    {
        this.varType = varTypeDec;
        this.varConv = varTypeDec.getDefaultVarConv();
    }
    
    public int getVarConv()
    {
        return varConv;
    }
    
    public void setVarConv(int varConv)
    {
        checkVarConv(varConv);
        if (varConv != VarTypeNative.BY_DEFAULT)
        {
            if (!varType.isVarConvValid(varConv))
                throw new JNIEasyException("Conventionalism " + asString(varConv) + " is not valid to type: " + varType.getTypeNative().getClassName());
            this.varConv = varConv;            
        }
        else
            this.varConv = varType.getDefaultVarConv();
    }

    public static void checkIsVarConvValid(int varConv,VarTypeNativeImpl varTypeDec)
    {
        // Método pensado para aquellos tipos que no permiten cambiar el convencionalismo (sólo tienen uno)
        checkVarConv(varConv);
        if (varConv == VarTypeNative.BY_DEFAULT)        
            return;
        if (!varTypeDec.isVarConvValid(varConv)) // Notar que se admite como válido el otro tipo de varConv y seguramente el caso DEFAULT
            throw new JNIEasyException("Conventionalism " + asString(varConv) + " is not valid to type: " + varTypeDec.getTypeNative().getClassName());
    }
    
    public static void checkVarConv(int varConv)
    {
        if ((varConv != VarTypeNative.BY_PTR) && 
            (varConv != VarTypeNative.BY_VALUE) && 
            (varConv != VarTypeNative.BY_DEFAULT))
            throw new JNIEasyException("Wrong variable conventionalism");        
    }    
    
    public static String asString(int varConv)
    {
        if (varConv == VarTypeNative.BY_PTR)
            return "by pointer";
        else
            return "by value";
    }    
}
