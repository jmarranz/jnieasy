/*
 * TypeNativePrimitiveWrapperRender.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativePrimitiveRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;

public class TypeNativePrimitiveWrapperRender extends TypeNativeSingleFieldContainerRender
{
    protected TypeNativePrimitiveRender compTypeDecRender;
    
    /**
     * Creates a new instance of TypeNativePrimitiveWrapperRender
     */
    public TypeNativePrimitiveWrapperRender(TypeNativePrimitiveWrapperImpl typeDec)
    {
        super(typeDec);
        
        TypeNativePrimitiveImpl compTypeDec = typeDec.getTypeNativePrimitive();        
        this.compTypeDecRender = (TypeNativePrimitiveRender)TypeNativeRender.newTypeNativeRender(compTypeDec);
    }

    public TypeNativePrimitiveWrapperImpl getTypeNativePrimitiveWrapper()
    {
        return (TypeNativePrimitiveWrapperImpl)typeDec;
    }
    
    public String getDecOtherParams(boolean enhancer)
    {
        return "";
    }
    
    public String getDeclareTypeMethodName()
    {
        if (compTypeDecRender.isCustomPrimitiveSize())
            return "decObjectWrapper";
        else
            return "dec";
    }    
            
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        if (compTypeDecRender.isCustomPrimitiveSize())
            return compTypeDecRender.getDeclareTypeCallString(enhancer).toString();
        else
            return "";
    }       
}

