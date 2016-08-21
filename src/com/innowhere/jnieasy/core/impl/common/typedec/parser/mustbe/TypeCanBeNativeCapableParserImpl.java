/*
 * TypeCanBeNativeCapableParserImpl.java
 *
 * Created on 24 de agosto de 2006, 20:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe;

import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeCanBeNativeCapableParserImpl extends TypeNativeParserImpl
{
    
    /** Creates a new instance of TypeCanBeNativeCapableParserImpl */
    public TypeCanBeNativeCapableParserImpl(TypeCanBeNativeCapableImpl typeDec)
    {
        super(typeDec);
    }
    
    public static TypeCanBeNativeCapableParserImpl newTypeCanBeNativeCapableParser(TypeCanBeNativeCapableImpl typeDec)
    {
        return TypeNativePrimitiveObjectParserImpl.newTypeNativePrimitiveObjectParser((TypeNativePrimitiveObjectImpl)typeDec);
    }
}
