/*
 * TypeNativePrimitiveParserImpl.java
 *
 * Created on 18 de agosto de 2006, 13:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;

/**
 *
 * @author jmarranz
 */
public class TypeNativePrimitiveParserImpl extends TypeNativeParserImpl
{
    
    /**
     * Creates a new instance of TypeNativePrimitiveParserImpl
     */
    public TypeNativePrimitiveParserImpl(TypeNativePrimitiveImpl typeDec)
    {
        super(typeDec);
    }
    
    public static TypeNativePrimitiveParserImpl newTypeNativePrimitiveParser(TypeNativePrimitiveImpl typeDec)
    {
        return new TypeNativePrimitiveParserImpl(typeDec);
    }
    
    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
        return (TypeNativePrimitiveImpl)typeDec;
    }
    
    public void parse(SourceCode blockContent,TaskContext ctx)
    {
        // Esperamos "memSizeExpr[,prefAlignSizeExpr]"
        
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();
            
        String content = blockContent.getContent();        
        
        int posComma = content.indexOf(',');
        if (posComma != -1)
        {
            String memSizeExpr = content.substring(0,posComma);
            String prefAlignSizeExpr = content.substring(posComma + 1); 
            typeDec.setMemSizeExpr(memSizeExpr);
            typeDec.setPreferredAlignSizeExpr(prefAlignSizeExpr);
        }
        else
        {
            typeDec.setMemSizeExpr(content);
        }
    }
}
