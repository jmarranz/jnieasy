/*
 * TypeNativeBooleanRender.java
 *
 * Created on 8 de julio de 2005, 19:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBooleanImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeBooleanRender extends TypeNativePrimitiveRender
{
    
    /**
     * Creates a new instance of TypeNativeBooleanRender
     */
    public TypeNativeBooleanRender(TypeNativeBooleanImpl typeDec)
    {
        super(typeDec);
    }

    public String convertFromObject(String paramName)
    {
        return "((Boolean)" + paramName + ").booleanValue()";
    }    
    
    public String castToObject(String code)    
    {
        return "Boolean.valueOf(" + code + ")";
    }    
}
