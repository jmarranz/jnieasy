/*
 * ParameterDecListRender.java
 *
 * Created on 28 de marzo de 2005, 18:17
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecList;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;
import java.util.List;


public class ParameterDecListRender
{
    protected ParameterDecList parameterDecList;
    protected ParameterDecRender[] paramDecListRender;
    
    /** Creates a new instance of ParameterDecListRender */
    public ParameterDecListRender(ParameterDecList parameterDecList)
    {
        this.parameterDecList = parameterDecList;
        List params = parameterDecList.getParameterDecList();
        int count = params.size();        
        this.paramDecListRender = new ParameterDecRender[count];
        for (int i = 0; i < count; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)params.get(i);
            this.paramDecListRender[i] = ParameterDecRender.newParameterDecRender(param);
        }        
    }
    
    public static ParameterDecListRender newParameterDecListRender(ParameterDecList parameterDecList)
    {
        return new ParameterDecListRender(parameterDecList);
    }
    
    public ParameterDecList getParameterDecList()
    {
        return parameterDecList;
    }
    
    public ParameterDecRender getParameterDecRender(int index)
    {
        return paramDecListRender[index];
    }    
    
    public ParameterDecRender[] getParameterDecListRenderArray()
    {
        return paramDecListRender;
    }
    
    public StringBuffer renderPassObjectArrayParams(int first,String paramsArray)
    {        
        StringBuffer code = new StringBuffer();            
        for(int i = first; i < paramDecListRender.length; i++)
        {
            ParameterDecRender paramDecRender = paramDecListRender[i];
            code.append( paramDecRender.renderPassParamFromObject(paramsArray + "[" + (i - first) + "]") );
            if (i + 1 < paramDecListRender.length) 
                code.append( "," );
        }
        return code;
    }
    
    public String renderPassParamFromObject(int index,String param)
    {    
        ParameterDecRender paramDecRender = paramDecListRender[index];
        return paramDecRender.renderPassParamFromObject(param);        
    }
    
    public StringBuffer getParameterDecListCode(int first,boolean enhancer)
    {
        if (enhancer)
        {
	    // La culpa la tiene el javassist que no sabe manejar la inicialización de arrays: new tipoArray[]{...}
            // aunque versiones recientes si admiten la sintaxis, el bytecode generado es erróneo (javassist v3.3)
            StringBuffer code = new StringBuffer();
            code.append( "new " + ObjectArrayInitializer.class.getName() + "(" );
            code.append( "new java.lang.Object[" + (paramDecListRender.length - first) + "]" );
            code.append( ")" );
            for(int i = first; i < paramDecListRender.length; i++)
            {
                ParameterDecRender paramDecRender = paramDecListRender[i];
                code.append( ".set(" + (i - first) + "," + paramDecRender.getParameterDecCode(enhancer) + ")" );
            }
            code.append( ".getArray()" );
            return code;
        }
        else
        {
            StringBuffer code = new StringBuffer();
            
            if ((paramDecListRender.length - first) == 0)
            {
                code.append( "new java.lang.Object[0]" );
            }
            else
            {
                code.append( "new java.lang.Object[] {" );            
                for(int i = first; i < paramDecListRender.length; i++)
                {
                    ParameterDecRender paramDecRender = paramDecListRender[i];
                    code.append( paramDecRender.getParameterDecCode(enhancer) );
                    if (i + 1 < paramDecListRender.length) 
                        code.append( "," );
                }
                code.append( "}" );
            }
            
            return code;
        }
    }
        
    public String getParamsAsString(int first)
    {
        StringBuffer code = new StringBuffer();
        int num = paramDecListRender.length;
        for(int i = first; i < num; i++)
        {
            ParameterDecRender paramDecRender = paramDecListRender[i];
            code.append( paramDecRender.asString() );
            if (i + 1 < paramDecListRender.length) 
                code.append( "," );            
        }
        // No incluimos el tipo retorno, pues no se usa para distinguir si una signatura es igual que otra
        return code.toString();
    }    
    
    public String generateCallParams(int first,boolean enhancer)
    {
        if (paramDecListRender.length == 0)
            return "null"; // Se admite el null en el caso de no haber parámetros, evitamos una instancia (y relacionadas)
        
        if (enhancer)
        {
	    // La culpa la tiene el javassist que no sabe manejar la inicialización de arrays: new tipoArray[]{...}
            StringBuffer code = new StringBuffer();
            code.append( "new " + ObjectArrayInitializer.class.getName() + "(" );
            code.append( "new java.lang.Object[" + (paramDecListRender.length - first) + "]" );
            code.append( ")" );
            for(int i = first; i < paramDecListRender.length; i++)
            {
                ParameterDecRender paramDecRender = paramDecListRender[i];
                String paramName = "$" + (i + 1 - first);
                code.append( ".set(" + (i - first) + "," + paramDecRender.generateParamArg(paramName) + ")" );
            }
            code.append( ".getArray()" );
            return code.toString();
        }
        else
        {
            StringBuffer code = new StringBuffer();
            code.append( "new java.lang.Object[] {" );            
            for(int i = first; i < paramDecListRender.length; i++)
            {
                ParameterDecRender paramDecRender = paramDecListRender[i];
                ParameterDecImpl paramDec = paramDecRender.getParameterDec();                                
                code.append( paramDecRender.generateParamArg(paramDec.getName()) );
                if (i + 1 < paramDecListRender.length) 
                    code.append( "," );
            }
            code.append( "}" );
            return code.toString();
        }        
    }    
    
    public static String[] extractClassNames(List params)
    {    
        int size = params.size();
        String[] names  = new String[size];
        for(int i=0; i < size; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)params.get(i);
            names[i] = param.getVarTypeNative().getTypeNative().getClassName();
        }        
        return names;
    }    
}
