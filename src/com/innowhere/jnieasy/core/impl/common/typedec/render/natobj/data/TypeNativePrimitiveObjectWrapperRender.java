/*
 * TypeNativePrimitiveObjectWrapperImpl.java
 *
 * Created on 3 de febrero de 2005, 13:32
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data.TypeNativePrimitiveObjectRender;

public class TypeNativePrimitiveObjectWrapperRender extends TypeCanBeNativeCapableWrapperRender
{
    protected TypeNativePrimitiveObjectRender fieldRender;
            
    /**
     * Creates a new instance of TypeNativePrimitiveObjectWrapperImpl
     */
    public TypeNativePrimitiveObjectWrapperRender(TypeNativePrimitiveObjectWrapperImpl typeDec)
    {
        super(typeDec);
        
        this.fieldRender = (TypeNativePrimitiveObjectRender)TypeNativeRender.newTypeNativeRender(typeDec.getTypeNativePrimitiveObject());
    }

    public TypeNativePrimitiveObjectRender getTypeNativePrimitiveObjectRender()
    {
        return fieldRender;
    }
    
    public String getDecOtherParams(boolean enhancer)
    {
        return fieldRender.getDecOtherParams(enhancer);
    }
  
    public String getDeclareTypeMethodName()
    {
        return fieldRender.getDeclareTypeMethodName();
    }    
    
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return fieldRender.getDeclareComponentTypeCall(enhancer);
    }     
}
