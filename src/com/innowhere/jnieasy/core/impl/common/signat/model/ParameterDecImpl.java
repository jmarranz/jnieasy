/*
 * ParameterDecImpl.java
 *
 * Created on 16 de febrero de 2004, 9:46
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;

/**
 *
 * @author  jmarranz
 */



public class ParameterDecImpl extends MethodHeaderDeclarationImpl
{
    protected String name; // puede no ser usado (null)
    protected int number; // Debe empezar en 1
    
    /**
     * Creates a new instance of ParameterDecImpl
     */
    public ParameterDecImpl(VarTypeNativeImpl varType)
    {
        super(varType);
    }

    public ParameterDecImpl(VarTypeNativeImpl varType,String paramName)
    {
        super(varType);
        this.name = paramName;
    }    
    
    public String getErrorPrefix()
    {
        return "Parameter number " + number + " :";
    }

    /**
     * Getter for property paramNumber.
     * @return Value of property paramNumber.
     */
    public int getParamNumber()
    {
        return number;
    }

    public void setParamNumber(int number)
    {
        this.number = number;
    }    

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isVarArgs()
    {
        return varType.isVarArgs();
    }

    public void setVarArgs(boolean varArgs)
    {
        varType.setVarArgs(varArgs);
    }
    
}
