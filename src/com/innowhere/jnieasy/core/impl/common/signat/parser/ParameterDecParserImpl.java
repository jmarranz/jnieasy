/*
 * ParameterDecParserImpl.java
 *
 * Created on 8 de junio de 2005, 20:38
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.util.Token;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.util.Space;
import com.innowhere.jnieasy.core.impl.util.Word;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;

/**
 *
 * @author jmarranz
 */
public class ParameterDecParserImpl
{
    
    /** Creates a new instance of ParameterDecParserImpl */
    public ParameterDecParserImpl()
    {
    }
    
    public static ParameterDecImpl parse(SourceCode paramCode,TaskContext ctx)
    {
        // VarType[...] [paramName]

        paramCode.trim();
        String paramName = null;
        // Para que exista nombre de parámetro deben existir como mínimo
        // tres tokens: el tipo (si es un simple Word), el espacio del medio y el nombre del param.
        if (paramCode.getNumTokens() >= 3)
        {
            Token space = paramCode.getToken(paramCode.getNumTokens() - 2);            
            if (space instanceof Space) // ciertamente hay un espacio entre medias
            {
                Token lastToken = paramCode.getLastToken(); // recordar que se hizo un trim() antes
                if (lastToken instanceof Word)
                {
                    Word nameToken = (Word)lastToken;
                    if (nameToken.canBeJavaIdentifier())
                    {
                        paramName = nameToken.getContent();
                        paramCode.removeLast();                       
                    }                    
                }
            }
        }

        VarTypeNativeImpl varType = VarTypeNativeParserImpl.newVarTypeNative(paramCode, ctx);
        ParameterDecImpl paramDec = new ParameterDecImpl(varType);
        paramDec.setName(paramName); // puede ser null
        return paramDec;
    }          
}
