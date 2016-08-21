/*
 * TypeNativeShortRender.java
 *
 * Created on 8 de julio de 2005, 19:46
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeNumberImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeShortRender extends TypeNativeNumberRender
{
    
    /**
     * Creates a new instance of TypeNativeShortRender
     */
    public TypeNativeShortRender(TypeNativeNumberImpl typeDec)
    {
        super(typeDec);
    }

    public String convertFromObject(String paramName)
    {
        return "((Short)" + paramName + ").shortValue()";
    }    
    
    public String castToObject(String code)    
    {
        return "new Short(" + code + ")";
    }    
}
