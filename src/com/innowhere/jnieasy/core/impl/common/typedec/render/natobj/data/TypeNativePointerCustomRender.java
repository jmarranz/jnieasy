/*
 * TypeNativePointerCustomRender.java
 *
 * Created on 30 de septiembre de 2005, 12:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerCustomImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativePointerCustomRender extends TypeNativePointerRender
{
    
    /**
     * Creates a new instance of TypeNativePointerCustomRender
     */
    public TypeNativePointerCustomRender(TypeNativePointerCustomImpl typeDec)
    {
        super(typeDec);
    }
    
    public String getDecOtherParams(boolean enhancer)
    {
        return ""; // No hay más
    }
  
    public String getDeclareTypeMethodName()
    {
        return "dec";
    }        
        
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return "";
    }       
}
