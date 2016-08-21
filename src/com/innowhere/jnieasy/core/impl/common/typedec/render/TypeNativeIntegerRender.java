/*
 * TypeNativeIntegerRender.java
 *
 * Created on 8 de julio de 2005, 19:46
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeIntegerImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeIntegerRender extends TypeNativeNumberRender
{
    
    /**
     * Creates a new instance of TypeNativeIntegerRender
     */
    public TypeNativeIntegerRender(TypeNativeIntegerImpl typeDec)
    {
        super(typeDec);
    }

    public String convertFromObject(String paramName)
    {
        return "((Integer)" + paramName + ").intValue()";
    }    
    
    public String castToObject(String code)    
    {
        return "new Integer(" + code + ")";
    }    
}
