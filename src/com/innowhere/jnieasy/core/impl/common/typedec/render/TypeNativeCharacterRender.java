/*
 * TypeNativeCharacterRender.java
 *
 * Created on 8 de julio de 2005, 19:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeCharacterImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeCharacterRender extends TypeNativePrimitiveRender
{
    
    /**
     * Creates a new instance of TypeNativeCharacterRender
     */
    public TypeNativeCharacterRender(TypeNativeCharacterImpl typeDec)
    {
        super(typeDec);
    }

    public String convertFromObject(String paramName)
    {
        return "((Character)" + paramName + ").charValue()";
    }    
    
    public String castToObject(String code)    
    {
        return "new Character(" + code + ")";
    }        
}
