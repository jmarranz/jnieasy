/*
 * MethodHeaderDeclarationRuntimeImpl.java
 *
 * Created on 20 de febrero de 2004, 13:01
 */

package com.innowhere.jnieasy.core.impl.rt.signat;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.MethodHeaderDeclarationImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.*;



public class MethodHeaderDeclarationRuntimeImpl
{
    protected MethodHeaderDeclarationImpl methodHeaderType;
    protected VarTypeNativeRuntimeImpl varTypeRt;
    
    /**
     * Creates a new instance of MethodHeaderDeclarationRuntimeImpl
     */
    public MethodHeaderDeclarationRuntimeImpl(VarTypeNativeRuntimeImpl typeDecRt,MethodHeaderDeclarationImpl typeDec)
    {
        this.varTypeRt = typeDecRt;
        this.methodHeaderType = typeDec;
    }
    
    public MethodHeaderDeclarationRuntimeImpl(Class clasz,MethodHeaderDeclarationImpl typeDec,RuntimeContext ctx)
    {
        this.varTypeRt = VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(clasz,typeDec.getVarTypeNative(), ctx);
        this.methodHeaderType = typeDec;
    }    
    
    public MethodHeaderDeclarationImpl getMethodHeaderDeclaration()
    {
        return methodHeaderType;
    }
    
    public VarTypeNativeRuntimeImpl getVarTypeNativeRuntime()
    {
        return varTypeRt;
    }

    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        // Son objetos distintos, pero si la clase esperada 
        // y el tipo de paso son los mismos
        // los consideraremos iguales
        
        MethodHeaderDeclarationRuntimeImpl obj2 = (MethodHeaderDeclarationRuntimeImpl)obj;
        
        if (!methodHeaderType.equals(obj2.getMethodHeaderDeclaration()))
            return false;
        if (!varTypeRt.equals(obj2.getVarTypeNativeRuntime()))
            return false;        
        return true;
    }
    
    public void checkValue(Object value)
    {
        if (varTypeRt.getNativeManager().isRuntimeChecking())
        {      
            try
            {
                varTypeRt.checkValue(value);
            }
            catch(Exception ex)
            {
                throw new JNIEasyException(methodHeaderType.getErrorPrefix() + " error " + ex,ex);
            }
        }
    }    

}
