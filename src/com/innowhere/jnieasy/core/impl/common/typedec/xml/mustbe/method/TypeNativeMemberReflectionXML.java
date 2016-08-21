/*
 * TypeNativeMemberReflectionXML.java
 *
 * Created on 7 de diciembre de 2004, 14:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method;

import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data.TypeCanBeNativeCapableXML;

/**
 *
 * @author  jmarranz
 */


public abstract class TypeNativeMemberReflectionXML extends TypeCanBeNativeCapableXML
{
    
    /**
     * Creates a new instance of TypeNativeMemberReflectionXML
     */
    public TypeNativeMemberReflectionXML(TypeNativeMemberReflectionImpl typeDec)
    {
        super(typeDec);
    }
}
