/*
 * FreeCodeGenRender.java
 *
 * Created on 9 de septiembre de 2005, 12:25
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FreeCodeGen;
import java.io.PrintWriter;

/**
 *
 * @author jmarranz
 */
public class FreeCodeGenRender
{
    protected FreeCodeGen freeCode;
    
    /** Creates a new instance of FreeCodeGenRender */
    public FreeCodeGenRender(FreeCodeGen freeCode)
    {
        this.freeCode = freeCode;
    }
    
    public static FreeCodeGenRender newFreeCodeGenRender(FreeCodeGen freeCode)
    {
        return new FreeCodeGenRender(freeCode);
    }
    
    public String generate()
    {
        return freeCode.getCode() + "\n";
    }    
}

