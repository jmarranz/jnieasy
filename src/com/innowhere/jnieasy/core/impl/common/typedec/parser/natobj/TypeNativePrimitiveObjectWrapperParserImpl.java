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
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativePrimitiveParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe.TypeNativePrimitiveObjectParserImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;

/**
 *
 * @author jmarranz
 */
public class TypeNativePrimitiveObjectWrapperParserImpl extends TypeNativeCapableParserImpl
{
    
    /** Creates a new instance of TypeNativePrimitiveWrapperParserImpl */
    public TypeNativePrimitiveObjectWrapperParserImpl(TypeNativePrimitiveObjectWrapperImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativePrimitiveObjectWrapperImpl getTypeNativePrimitiveWrapper()
    {
        return (TypeNativePrimitiveObjectWrapperImpl)typeDec;
    }
    
    public void parse(SourceCode blockContent, TaskContext ctx)
    {
        TypeNativePrimitiveObjectWrapperImpl typeDec = getTypeNativePrimitiveWrapper();
        TypeNativePrimitiveObjectParserImpl parserComp = (TypeNativePrimitiveObjectParserImpl)TypeNativePrimitiveObjectParserImpl.newTypeNativePrimitiveObjectParser(typeDec.getTypeNativePrimitiveObject());
        parserComp.parse(blockContent,ctx);
    }    
}
