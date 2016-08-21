/*
 * ParameterDecRender.java
 *
 * Created on 28 de marzo de 2005, 18:20
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;

/**
 *
 * @author  jmarranz
 */


public class ParameterDecRender extends MethodHeaderDeclarationRender
{
    /** Creates a new instance of ParameterDecRender */
    public ParameterDecRender(ParameterDecImpl parameterDec)
    {
        super(parameterDec);
    }

    public static ParameterDecRender newParameterDecRender(ParameterDecImpl parameterDec)
    {
        return new ParameterDecRender(parameterDec);
    }
    
    public ParameterDecImpl getParameterDec()
    {
        return (ParameterDecImpl)methodHeader;
    }
    
    public String renderPassParamFromObject(String paramName)
    {
        return varTypeRender.getTypeNativeRender().convertFromObject(paramName);
    }
    
    public String generateParamArg(String paramName)
    {
        return varTypeRender.generateParamArg(paramName);
    } 
    
    public StringBuffer getParameterDecCode(boolean enhancer)
    {
        ParameterDecImpl paramDec = getParameterDec();
        StringBuffer code = new StringBuffer();
        code.append( getVarTypeCode(enhancer) + ".decParameter(" );
        if (paramDec.isVarArgs()) 
            code.append( "true" );
        code.append( ")" );
        return code;
    }
}
