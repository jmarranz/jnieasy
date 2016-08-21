/*
 * TypeNativeCapableDefaultRender.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableDefaultImpl;

public class TypeNativeCapableDefaultRender extends TypeNativeCapableRender
{
    /**
     * Creates a new instance of TypeNativeCapableDefaultRender
     */
    public TypeNativeCapableDefaultRender(TypeNativeCapableDefaultImpl typeDec)
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
