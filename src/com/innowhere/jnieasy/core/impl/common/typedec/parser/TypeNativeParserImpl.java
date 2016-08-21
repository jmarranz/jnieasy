/*
 * TypeNativeParserImpl.java
 *
 * Created on 3 de junio de 2005, 19:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe.TypeNativeArrayParserImpl;
import com.innowhere.jnieasy.core.impl.util.CurlyBracketBlock;
import com.innowhere.jnieasy.core.impl.util.Token;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.util.SquareBracketBlock;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe.TypeCanBeNativeCapableParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj.TypeNativeCapableParserImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.util.Word;


/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeParserImpl
{
    protected TypeNativeImpl typeDec;
    
    /**
     * Creates a new instance of TypeNativeParserImpl
     */
    public TypeNativeParserImpl(TypeNativeImpl typeDec)
    {
        this.typeDec = typeDec;
    }
    
    public static TypeNativeParserImpl newTypeNativeParser(TypeNativeImpl typeDec)
    {
        return typeDec.newTypeNativeParser();
    }
    
    public static TypeNativeImpl newTypeNative(String decClass,TaskContext ctx)
    {
        return newTypeNative(new SourceCode(decClass), ctx);
    }   
    
    public static TypeNativeImpl newTypeNative(SourceCode decClassCode,TaskContext ctx)
    {
        // Suponemos que NO hay asterisco al final, aquí no se evalúa, debería dar error
        try
        {
            decClassCode.trim();

            int numParts = decClassCode.getNumTokens();            
            Token lastPart = decClassCode.getLastToken();
            if (lastPart instanceof SquareBracketBlock) // [] es array, única posibilidad
            {
                return TypeNativeArrayParserImpl.parseArray(decClassCode,ctx);
            }
            else if (lastPart instanceof CurlyBracketBlock) // {} es un método o array wrapper o String (wrapper o no)
            {
                SourceCode classDec = decClassCode.getRange(0, numParts - 1); // Debe devolver realmente una única parte tipo Text
                SourceCode blockContent = ((CurlyBracketBlock)lastPart).getSourceCode();
                TypeNativeImpl typeDec = newTypeNative(classDec,ctx);
                TypeNativeParserImpl typeDecParser = newTypeNativeParser(typeDec);
                if (typeDecParser == null)
                    throw new JNIEasyException("Syntax error on type declaration, declared data type must not have a { } block  :" + decClassCode.getContent(true));

                typeDecParser.parse(blockContent,ctx);

                return typeDec;
            }
            else if (lastPart instanceof Word)
            {
                // decClassExpr aquí es una declaración normal de clase (no array, no método) según Java
                // Si no existe dará error (excepción)
                // el único tipo que no funciona es NativeArrayOfArray
                String className = decClassCode.getContent();  
                return TypeNativeImpl.newTypeNative(ctx.getClassType(className));
            }
            else
                throw new JNIEasyException("Syntax error on type declaration :" + decClassCode.getContent(true));
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on type declaration :" + decClassCode.getContent(true), ex);
        }        
    }    

    public abstract void parse(SourceCode blockContent,TaskContext ctx);   
    
}
