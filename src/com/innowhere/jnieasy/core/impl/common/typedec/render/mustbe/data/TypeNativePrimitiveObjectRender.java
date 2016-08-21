/*
 * TypeNativePrimitiveObjectRender.java
 *
 * Created on 7 de diciembre de 2004, 14:41
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativePrimitiveRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;



public class TypeNativePrimitiveObjectRender extends TypeCanBeNativeCapableRender
{
    protected TypeNativePrimitiveRender fieldRender;
            
    /**
     * Creates a new instance of TypeNativePrimitiveObjectRender
     */
    public TypeNativePrimitiveObjectRender(TypeNativePrimitiveObjectImpl typeDec)
    {
        super(typeDec);
        
        this.fieldRender = (TypeNativePrimitiveRender)TypeNativeRender.newTypeNativeRender(typeDec.getTypeNativePrimitive());
    }
 
    public TypeNativePrimitiveRender getTypeNativePrimitiveRender()
    {
        return fieldRender;
    }
    
    public String getDecOtherParams(boolean enhancer)
    {
        return "";
    }    

    public String getDeclareTypeMethodName()
    {
        if (fieldRender.isCustomPrimitiveSize())
            return "decObjectWrapper"; // TypeNativePrimitive.decPointer
        else
            return "dec";
    }
    
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        if (fieldRender.isCustomPrimitiveSize())        
            return getTypeNativePrimitiveRender().getDeclareTypeCallString(enhancer).toString();
        else
            return "";
    }    
}
