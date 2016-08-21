/*
 * ParameterDecRender.java
 *
 * Created on 28 de marzo de 2005, 18:20
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;


/**
 *
 * @author  jmarranz
 */


public class ReturnDeclarationRender extends MethodHeaderDeclarationRender
{
    /** Creates a new instance of ParameterDecRender */
    public ReturnDeclarationRender(ReturnDeclarationImpl retDec)
    {
        super(retDec);
    }

    public static ReturnDeclarationRender newReturnDeclarationRender(ReturnDeclarationImpl retDec)
    {
        return new ReturnDeclarationRender(retDec);
    }
    
    public ReturnDeclarationImpl getReturnDeclaration()
    {
        return (ReturnDeclarationImpl)methodHeader;
    }
  
    public String getReturnAndCast()
    {
        return varTypeRender.getReturnAndCast();
    }    
    
    public String generateCallName()
    {
        return varTypeRender.generateCallName();
    }     
}
