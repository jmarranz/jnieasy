/*
 * TypeNativeVoidRender.java
 *
 * Created on 8 de julio de 2005, 19:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeVoidImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeVoidRender extends TypeNativePrimitiveRender
{
    
    /**
     * Creates a new instance of TypeNativeVoidRender
     */
    public TypeNativeVoidRender(TypeNativeVoidImpl typeDec)
    {
        super(typeDec);
    }

    public String convertFromObject(String paramName)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
    
    public String returnCastToObject(String code)    
    {
        // redefinimos, caso especial
        return code + "; return null";
    }    
    
    public String castToObject(String code)    
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
}
