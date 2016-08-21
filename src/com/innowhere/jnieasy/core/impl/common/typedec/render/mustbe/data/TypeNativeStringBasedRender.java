/*
 * TypeNativeStringBasedRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeStringInfoRender;



public abstract class TypeNativeStringBasedRender extends TypeCanBeNativeCapableRender
{
    protected TypeNativeStringInfoRender stringInfoRender;
    
    /** Creates a new instance of TypeNativeStringBasedRender */
    public TypeNativeStringBasedRender(TypeNativeStringBasedImpl typeDec)
    {
        super(typeDec);

        this.stringInfoRender = new TypeNativeStringInfoRender(typeDec);   
    }
  
    public String getDecOtherParams(boolean enhancer)
    {
	return stringInfoRender.getDecOtherParams();
    }
            
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return "";
    }       
}
