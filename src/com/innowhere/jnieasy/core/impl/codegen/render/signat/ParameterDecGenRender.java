/*
 * ParameterDecGen.java
 *
 * Created on 26 de marzo de 2004, 19:12
 */

package com.innowhere.jnieasy.core.impl.codegen.render.signat;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.ParameterDecRender;


public class ParameterDecGenRender extends MethodHeaderDeclarationGenRender
{
       
    /** Creates a new instance of ParameterDecGen */
    public ParameterDecGenRender(ParameterDecRender paramDecRender)
    {
        super(paramDecRender); 
    }
    
    public static ParameterDecGenRender newParameterDecGenRender(ParameterDecRender paramDecRender)
    {
        return new ParameterDecGenRender(paramDecRender);
    }
    
    public ParameterDecRender getParameterDecRender()
    {
        return (ParameterDecRender)methodHeaderRender;
    }
    
    public String generateDeclaration()
    {
        ParameterDecImpl paramDec = getParameterDecRender().getParameterDec();
        return paramDec.getVarTypeNative().getTypeNative().getClassName() + " " + paramDec.getName();
    }    

}
