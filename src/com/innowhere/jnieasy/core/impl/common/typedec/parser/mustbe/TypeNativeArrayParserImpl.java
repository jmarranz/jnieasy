/*
 * TypeNativeArrayParserImpl.java
 *
 * Created on 3 de junio de 2005, 19:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.util.Token;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.util.Space;
import com.innowhere.jnieasy.core.impl.util.SquareBracketBlock;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jmarranz
 */
public class TypeNativeArrayParserImpl extends TypeNativeParserImpl
{
    
    /**
     * Creates a new instance of TypeNativeArrayParserImpl
     */
    public TypeNativeArrayParserImpl(TypeNativeArrayImpl typeDec)
    {
        super(typeDec);
    }
    
    public static TypeNativeArrayImpl parseArray(SourceCode decClassCode,TaskContext ctx)
    {
        // Parseamos el []
        
        int numParts = decClassCode.getNumTokens();
            
        int firstDimIndex = numParts - 1;
        for(int i = numParts - 2; i >= 0; i--)
        {
            Token part = decClassCode.getToken(i);
            if (!(part instanceof Space) && 
                !(part instanceof SquareBracketBlock))
            {
                firstDimIndex = i + 1;
                break;
            }
        }
        SourceCode dimsCode = decClassCode.getRange(firstDimIndex, numParts);
        int[] dims = parseDims(dimsCode); 
        SourceCode compDecCode = decClassCode.getRange(0, firstDimIndex);
        VarTypeNativeImpl lastCompVarType = VarTypeNativeParserImpl.newVarTypeNative(compDecCode,ctx);  
        return TypeNativeArrayImpl.newTypeNativeArray(dims, lastCompVarType, ctx);                
    }
    
    public static int[] parseDims(SourceCode decDims)
    {
        // Esperamos este formato "[dim]...[dim]"
        // sin espacios inicial y final pero posibles espacios internos,
        // con al menos una dimensión
        // en donde el valor de la dim puede ser opcional
        List dimBlocks = new LinkedList();
        int numParts = decDims.getNumTokens();
        for(int i = 0; i < numParts; i++)
        {
            Token part = decDims.getToken(i);
            if (part instanceof SquareBracketBlock)
            {
                dimBlocks.add(part);
            }
            else // espacios separadores entre dimensiones
            {
                String spaces = part.getContent();
                spaces = spaces.trim();
                if (!spaces.equals(""))
                    throw new JNIEasyException("Unexpected text parsing array dimensions :" + spaces);
            }
        }        

        int[] dims = new int[dimBlocks.size()];        
        for(int i = 0; i < dims.length; i++)
        {
            SquareBracketBlock dimBlock = (SquareBracketBlock)dimBlocks.get(i);
            String dimValue = dimBlock.getSourceCode().getContent();
            dimValue = dimValue.trim();
            int dim;
            if (dimValue.equals(""))
                dim = -1; // no hay valor concreto
            else
            {
                try
                {
                    dim = Integer.parseInt(dimValue);
                }
                catch(NumberFormatException ex)
                {
                    throw new JNIEasyException("Array dimension value invalid: " + dimValue,ex);
                }                    
            }
            dims[i] = dim;
        }
        return dims;        
    }

    public void parse(SourceCode blockContent, TaskContext ctx)
    {
        // NO SE USA
        throw new JNIEasyException("INTERNAL ERROR");
    }
}
