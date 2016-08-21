/*
 * TypeNativeArrayWrapperRender.java
 *
 * Created on 25 de marzo de 2004, 13:42
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeArrayInfoRender;

public class TypeNativeArrayWrapperRender extends TypeCanBeNativeCapableWrapperRender
{
    protected TypeNativeArrayInfoRender arrayInfoRender;
    
    /**
     * Creates a new instance of TypeNativeArrayWrapperRender
     */
    public TypeNativeArrayWrapperRender(TypeNativeArrayWrapperImpl typeDec)
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
