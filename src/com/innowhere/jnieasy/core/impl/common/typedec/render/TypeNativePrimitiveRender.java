/*
 * TypeNativePrimitiveRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;


public abstract class TypeNativePrimitiveRender extends TypeNativeRender
{
    
    /** Creates a new instance of TypeNativePrimitiveRender */
    public TypeNativePrimitiveRender(TypeNativePrimitiveImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
        return (TypeNativePrimitiveImpl)typeDec;
    }
    
    public boolean isCustomPrimitiveSize()
    {
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();        
        return ((typeDec.getMemSizeExpr() != null) || (typeDec.getPreferredAlignSizeExpr() != null));        
    }

    public String getDeclareTypeMethodName()
    {
        if (isCustomPrimitiveSize())
            return "decPrimitive";
        else
            return "dec"; // más rápido
    }         

    public String getDecOtherParams(boolean enhancer)
    {
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();        
        if (isCustomPrimitiveSize())
        {
            StringBuffer res = new StringBuffer();
            res.append( "," ); // Pues hay un parámetro antes (el Class)
            
            String memSizeExpr = typeDec.getMemSizeExpr();
            if (memSizeExpr == null)
                res.append( "(String)null" );
            else
                res.append( "\"" + memSizeExpr + "\"" );
            
            res.append( "," );
            
            String prefAlignSizeExpr = typeDec.getPreferredAlignSizeExpr();
            if (prefAlignSizeExpr == null)
                res.append( "(String)null" );
            else
                res.append( "\"" + prefAlignSizeExpr + "\"" );
            
            return res.toString();
        }
        else
            return ""; // Caso "dec()"
    }        
    
    public String returnCastToObject(String code)    
    {
        return "return " + castToObject(code);
    }    
    
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return "";
    }
}
