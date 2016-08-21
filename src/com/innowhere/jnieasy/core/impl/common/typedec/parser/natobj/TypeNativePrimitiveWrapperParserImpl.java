/*
 * TypeNativePrimitiveWrapperParserImpl.java
 *
 * Created on 24 de agosto de 2006, 20:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativePrimitiveParserImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;

/**
 *
 * @author jmarranz
 */
public class TypeNativePrimitiveWrapperParserImpl extends TypeNativeCapableParserImpl
{
    
    /** Creates a new instance of TypeNativePrimitiveWrapperParserImpl */
    public TypeNativePrimitiveWrapperParserImpl(TypeNativePrimitiveWrapperImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativePrimitiveWrapperImpl getTypeNativePrimitiveWrapper()
    {
        return (TypeNativePrimitiveWrapperImpl)typeDec;
    }
    
    public void parse(SourceCode blockContent, TaskContext ctx)
    {
        TypeNativePrimitiveWrapperImpl typeDec = getTypeNativePrimitiveWrapper();
        TypeNativePrimitiveParserImpl parserComp = (TypeNativePrimitiveParserImpl)TypeNativePrimitiveParserImpl.newTypeNativePrimitiveParser(typeDec.getTypeNativePrimitive());
        parserComp.parse(blockContent,ctx);
    }   
}
