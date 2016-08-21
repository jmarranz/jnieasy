/*
 * ArrayEmbeddedInfoRender.java
 *
 * Created on 3 de enero de 2005, 21:51
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeObjectArrayEnhancerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;

public class TypeNativeArrayInfoRender
{
    protected TypeNativeArrayInterface typeDec;
    
    /** Creates a new instance of ArrayEmbeddedInfoRender */
    public TypeNativeArrayInfoRender(TypeNativeArrayInterface typeDec)
    {
        this.typeDec = typeDec;
    }

    
    public String getDimensions(boolean enhancer)
    {
        String code = typeDec.getTypeNativeArrayInfo().dimsToStringWithComas();
            
        if (enhancer)
            code = NativeObjectArrayEnhancerImpl.class.getName() + ".parseDims(\"" + code + "\")";
        else
            code = "new int[] {" + code + "}";

        return code;
    }
    
    public static String dimsToStringWithBrackets(int[] dims)
    {
        StringBuffer res = new StringBuffer();
        for(int i = 0; i < dims.length; i++)
        {
            int dim = dims[i];
            if (dim == -1)
                res.append( "[]" );
            else
                res.append( "[" + dim + "]" );                    
        }
        return res.toString();
    }
    
    public static String dimsToStringWithComas(int[] dims)
    {    
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < dims.length; i++)
        {
            code.append( Integer.toString(dims[i]) );
            if (i != (dims.length - 1)) 
                code.append( "," );
        }    
        return code.toString();
    }    
    
    public String getDecOtherParams(boolean enhancer)
    {
        String params = "," + getDimensions(enhancer);
        
        VarTypeNativeImpl lastCompVarType = typeDec.getTypeNativeArrayInfo().getLastComponentVarType();
        VarTypeNativeRender lastCompVarTypeRender = lastCompVarType.newVarTypeNativeRender();
        params += "," + lastCompVarTypeRender.getDeclareVarTypeCallString(enhancer);

        return params;
    }    
    
    public String getDeclareTypeMethodName()
    {
        return "decArray";
    }        
        
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return "";
    }       
}
