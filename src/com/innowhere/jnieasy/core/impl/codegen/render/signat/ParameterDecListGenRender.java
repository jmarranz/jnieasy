/*
 * ParameterDecListGenRender.java
 *
 * Created on 21 de febrero de 2005, 17:28
 */

package com.innowhere.jnieasy.core.impl.codegen.render.signat;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.ParameterDecListRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.ParameterDecRender;


public class ParameterDecListGenRender
{
    protected ParameterDecGenRender[] paramListGenRender;
    protected ParameterDecListRender paramListRender;    
    
    /** Creates a new instance of ParameterDecListGenRender */
    public ParameterDecListGenRender(ParameterDecListRender paramListRender)
    {
        this.paramListRender = paramListRender;
                
        ParameterDecRender[] params = paramListRender.getParameterDecListRenderArray();
        this.paramListGenRender = new ParameterDecGenRender[params.length];
        for (int i = 0; i < params.length; i++)
        {
            ParameterDecRender param = params[i];
            this.paramListGenRender[i] = ParameterDecGenRender.newParameterDecGenRender(param);
        }
    }
 
    public static ParameterDecListGenRender newParameterDecListGenRender(ParameterDecListRender paramListRender)
    {
        return new ParameterDecListGenRender(paramListRender);
    }

    public StringBuffer getParameterDecArgList(int first)
    {
        StringBuffer code = paramListRender.getParameterDecListCode(first,false);
        code.append( ", \n" );        
        return code;
    }    
    
    public ParameterDecGenRender getParameterDecGenRender(int index)
    {
        return paramListGenRender[index];
    }    
  
    public StringBuffer generateParamDeclarations(int first)
    {
        StringBuffer source = new StringBuffer();
        for(int i= first; i < paramListGenRender.length; i++)
        {
            ParameterDecGenRender paramDecGenRender = paramListGenRender[i];
           
            source.append( paramDecGenRender.generateDeclaration() );
            if (i + 1 < paramListGenRender.length) 
                source.append( "," );
        }        
        return source;
    }    
}
