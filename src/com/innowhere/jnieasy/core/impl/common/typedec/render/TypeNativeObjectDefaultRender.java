/*
 * TypeNativeObjectDefaultRender.java
 *
 * Created on 7 de marzo de 2005, 14:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectDefaultImpl;

/**
 *
 * @author  jmarranz
 */


public class TypeNativeObjectDefaultRender extends TypeNativeObjectRender
{
    
    /**
     * Creates a new instance of TypeNativeObjectDefaultRender
     */
    public TypeNativeObjectDefaultRender(TypeNativeObjectDefaultImpl typeDec)
    {
        super(typeDec);
    }

    public String getDecOtherParams(boolean enhancer)
    {
        return "";
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
