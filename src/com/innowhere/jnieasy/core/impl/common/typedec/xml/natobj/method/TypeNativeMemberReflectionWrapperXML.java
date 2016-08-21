/*
 * TypeNativeMemberReflectionWrapperXML.java
 *
 * Created on 30 de marzo de 2005, 12:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeCanBeNativeCapableWrapperXML;

public abstract class TypeNativeMemberReflectionWrapperXML extends TypeCanBeNativeCapableWrapperXML
{
    
    /**
     * Creates a new instance of TypeNativeMemberReflectionWrapperXML
     */
    public TypeNativeMemberReflectionWrapperXML(TypeNativeMemberReflectionWrapperImpl typeDec)
    {
        super(typeDec);
    }

}
