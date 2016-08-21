/*
 * TypeNativeFloatRender.java
 *
 * Created on 8 de julio de 2005, 19:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeFloatImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeFloatRender extends TypeNativeNumberRender
{
    
    /**
     * Creates a new instance of TypeNativeFloatRender
     */
    public TypeNativeFloatRender(TypeNativeFloatImpl typeDec)
    {
        super(typeDec);
    }

    public String convertFromObject(String paramName)
    {
        return "((Float)" + paramName + ").floatValue()";
    }    
    
    public String castToObject(String code)    
    {
        return "new Float(" + code + ")";
    }    
}
