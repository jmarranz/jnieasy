/*
 * ReturnDeclarationGenRender.java
 *
 * Created on 1 de noviembre de 2004, 13:55
 */

package com.innowhere.jnieasy.core.impl.codegen.render.signat;
import com.innowhere.jnieasy.core.impl.common.signat.render.ReturnDeclarationRender;



public class ReturnDeclarationGenRender extends MethodHeaderDeclarationGenRender
{
    /** Creates a new instance of ReturnDeclarationGenRender */
    public ReturnDeclarationGenRender(ReturnDeclarationRender returnTypeRender)
    {
        super(returnTypeRender); 
    }
    
    public static ReturnDeclarationGenRender newReturnDeclarationGenRender(ReturnDeclarationRender returnDecRender)
    {
        return new ReturnDeclarationGenRender(returnDecRender);
    }        
    
    public ReturnDeclarationRender getReturnDeclarationRender()
    {
        return (ReturnDeclarationRender)methodHeaderRender;
    }
    
    public String getHeaderReturnClassName()
    {        
        return getReturnDeclarationRender().getReturnDeclaration().getVarTypeNative().getTypeNative().getClassName();
    }
    
    public String getReturnTypeClassExp()
    {
        return getReturnDeclarationRender().getVarTypeCode(false)  + ",";
    }
 
}
