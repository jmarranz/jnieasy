/*
 * ParameterDecListParserImpl.java
 *
 * Created on 2 de junio de 2005, 21:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.util.Comma;
import com.innowhere.jnieasy.core.impl.util.ParenthesisBlock;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jmarranz
 */
public class ParameterDecListParserImpl
{
    
    /** Creates a new instance of ParameterDecListParserImpl */
    public ParameterDecListParserImpl()
    {
    }
    
    public static ArrayList parse(ParenthesisBlock paramsBlock,TaskContext ctx)
    {
        // Sintaxis: ([param[,param]...])
        
        try
        {
            ArrayList paramList = new ArrayList();
            
            SourceCode paramsCode = paramsBlock.getSourceCode();
            List paramListTokens = paramsCode.split(Comma.getComma());
            if (paramListTokens.size() == 1)
            {
                // Es el caso de ausencia de comas, es un caso especial que no vale en el caso general
                // Puede ser el caso vacío con espacios ( ) o el caso de un parámetro ej (int)
                SourceCode param = (SourceCode)paramListTokens.get(0);
                param.trim();
                if (param.getNumTokens() == 0)
                {
                    // era un espacio, no hay verdadero parámetro
                    return paramList;
                }
            }
            int i = 0;
            for (Iterator it = paramListTokens.iterator(); it.hasNext(); i++)
            {
                SourceCode param = (SourceCode)it.next();
                paramList.add( ParameterDecParserImpl.parse(param,ctx) );
            }
            return paramList;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method params declaration :" + paramsBlock.getContent(), ex);
        }        
    }
}
