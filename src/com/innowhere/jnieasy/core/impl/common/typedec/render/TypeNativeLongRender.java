/*
 * TypeNativeLongRender.java
 *
 * Created on 8 de julio de 2005, 19:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeLongImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeLongRender extends TypeNativeNumberRender
{
    
    /**
     * Creates a new instance of TypeNativeLongRender
     */
    public TypeNativeLongRender(TypeNativeLongImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativeLongImpl getTypeNativeLong()
    {
        return (TypeNativeLongImpl)typeDec;
    }

    public String convertFromObject(String paramName)
    {
        return "((Long)" + paramName + ").longValue()";
    }
    
    public String castToObject(String code)    
    {
        return "new Long(" + code + ")";
    }    
}
