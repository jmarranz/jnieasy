/*
 * TypeNativePointerXML.java
 *
 * Created on 28 de febrero de 2005, 19:21
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;

public abstract class TypeNativePointerXML extends TypeNativeObjectFieldContainerXML
{
    
    /**
     * Creates a new instance of TypeNativePointerXML
     */
    public TypeNativePointerXML(TypeNativePointerImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativePointerImpl getTypeNativePointer()
    {
        return (TypeNativePointerImpl)typeDec;
    }
    

}
