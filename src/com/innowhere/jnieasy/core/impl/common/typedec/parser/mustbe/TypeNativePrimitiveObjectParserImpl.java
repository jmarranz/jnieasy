/*
 * TypeNativePrimitiveWrapperParserImpl.java
 *
 * Created on 24 de agosto de 2006, 20:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativePrimitiveParserImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;

/**
 *
 * @author jmarranz
 */
public class TypeNativePrimitiveObjectParserImpl extends TypeCanBeNativeCapableParserImpl
{
    
    /** Creates a new instance of TypeNativePrimitiveWrapperParserImpl */
    public TypeNativePrimitiveObjectParserImpl(TypeNativePrimitiveObjectImpl typeDec)
    {
        super(typeDec);
    }

    public static TypeNativePrimitiveObjectParserImpl newTypeNativePrimitiveObjectParser(TypeNativePrimitiveObjectImpl typeDec)
    {
        return new TypeNativePrimitiveObjectParserImpl(typeDec);
    }
    
    public TypeNativePrimitiveObjectImpl getTypeNativePrimitiveObjectImpl()
    {
        return (TypeNativePrimitiveObjectImpl)typeDec;
    }
    
    public void parse(SourceCode blockContent, TaskContext ctx)
    {
        TypeNativePrimitiveObjectImpl typeDec = getTypeNativePrimitiveObjectImpl();
        TypeNativePrimitiveParserImpl parserComp = (TypeNativePrimitiveParserImpl)TypeNativePrimitiveParserImpl.newTypeNativePrimitiveParser(typeDec.getTypeNativePrimitive());
        parserComp.parse(blockContent,ctx);
    }
    
}
