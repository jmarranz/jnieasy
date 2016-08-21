/*
 * ReturnDeclarationImpl.java
 *
 * Created on 4 de noviembre de 2004, 17:42
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.*;

public class ReturnDeclarationRuntimeImpl extends MethodHeaderDeclarationRuntimeImpl
{
    
    /**
     * Creates a new instance of ReturnDeclarationImpl
     */
    public ReturnDeclarationRuntimeImpl(VarTypeNativeRuntimeImpl typeDecRt,ReturnDeclarationImpl typeDec)
    {
        super(typeDecRt,typeDec);
    }
    
    public ReturnDeclarationRuntimeImpl(Class clasz,ReturnDeclarationImpl typeDec,RuntimeContext ctx)
    {
        super(clasz,typeDec,ctx);
    }    
    
    public ReturnDeclarationImpl getReturnDeclaration()
    {
        return (ReturnDeclarationImpl)methodHeaderType;
    }
}
