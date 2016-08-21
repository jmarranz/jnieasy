/*
 * TypeNativeStringBasedWrapperRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeStringInfoRender;


public abstract class TypeNativeStringBasedWrapperRender extends TypeCanBeNativeCapableWrapperRender
{
    protected TypeNativeStringInfoRender stringInfoRender;
    
    /** Creates a new instance of TypeNativeStringBasedWrapperRender */
    public TypeNativeStringBasedWrapperRender(TypeNativeStringBasedWrapperImpl typeDec)
    {
        super(typeDec);

        this.stringInfoRender = new TypeNativeStringInfoRender(typeDec); 
    }

    public TypeNativeStringBasedWrapperImpl getTypeNativeStringBasedWrapper()
    {
        return (TypeNativeStringBasedWrapperImpl)typeDec;
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
