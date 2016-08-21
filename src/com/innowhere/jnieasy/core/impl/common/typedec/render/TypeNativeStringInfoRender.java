/*
 * StringInfoRender.java
 *
 * Created on 10 de enero de 2005, 19:54
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.typedec.*;


public class TypeNativeStringInfoRender
{
    protected TypeNativeStringBasedInterface typeDec;
    
    /** Creates a new instance of StringInfoRender */
    public TypeNativeStringInfoRender(TypeNativeStringBasedInterface typeDec)
    {
        this.typeDec = typeDec;
    }
   
    public boolean declaredEncoding()
    {
        return typeDec.getEncodingExpr() != null;
    }
    
    public String getDecOtherParams()
    {
        String encodingExpr = typeDec.getEncodingExpr();
        if (encodingExpr != null)
            return ",\"" + encodingExpr + "\"";
        else
            return "";
    }        
    
    public static String toString(int encoding)
    {
        if (encoding == StringEncoding.ANSI)
            return "ANSI";
        else
            return "UNICODE";         
    }
    
    public static String getDeclarationStringComplement(TypeNativeStringBasedInterface typeDec)
    {
        String encodingExpr = typeDec.getEncodingExpr();
        if (encodingExpr != null)
            return "{" + encodingExpr + "}";
        else
            return "";        
    }    
            
}
