/*
 * FreeCodeGen.java
 *
 * Created on 9 de septiembre de 2005, 12:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;

/**
 *
 * @author jmarranz
 */
public class FreeCodeGen
{
    protected String code;
    
    /**
     * Creates a new instance of FreeCodeGen 
     */
    public FreeCodeGen(String code)
    {
        this.code = code;
    }
    
    public String getCode()
    {
        return code;
    }
}
