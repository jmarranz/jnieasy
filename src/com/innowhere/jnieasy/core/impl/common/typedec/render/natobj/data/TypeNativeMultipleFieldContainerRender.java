/*
 * TypeNativeMultipleFieldContainerRender.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeMultipleFieldContainerImpl;

public class TypeNativeMultipleFieldContainerRender extends TypeNativeFieldContainerRender
{
    /**
     * Creates a new instance of TypeNativeMultipleFieldContainerRender
     */
    public TypeNativeMultipleFieldContainerRender(TypeNativeMultipleFieldContainerImpl typeDec)
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
