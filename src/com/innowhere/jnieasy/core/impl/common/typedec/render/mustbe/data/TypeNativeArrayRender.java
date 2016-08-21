/*
 * TypeNativeArrayRender.java
 *
 * Created on 25 de marzo de 2004, 13:42
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeArrayInfoRender;



public class TypeNativeArrayRender extends TypeCanBeNativeCapableRender
{
    protected TypeNativeArrayInfoRender arrayInfoRender;

    /**
     * Creates a new instance of TypeNativeArrayRender
     */
    public TypeNativeArrayRender(TypeNativeArrayImpl typeDec)
    {
        super(typeDec);
        
        arrayInfoRender = new TypeNativeArrayInfoRender(typeDec);
    }
     
    public String getDecOtherParams(boolean enhancer)
    {
        return arrayInfoRender.getDecOtherParams(enhancer);
    }    
    
    public String getDeclareTypeMethodName()
    {
        return arrayInfoRender.getDeclareTypeMethodName();
    }   
             
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return arrayInfoRender.getDeclareComponentTypeCall(enhancer);
    }       
}
