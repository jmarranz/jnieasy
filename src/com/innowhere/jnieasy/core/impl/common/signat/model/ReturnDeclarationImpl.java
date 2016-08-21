/*
 * ReturnDeclarationImpl.java
 *
 * Created on 4 de noviembre de 2004, 17:42
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


public class ReturnDeclarationImpl extends MethodHeaderDeclarationImpl
{
    
    /**
     * Creates a new instance of ReturnDeclarationImpl
     */
    public ReturnDeclarationImpl(VarTypeNativeImpl varType)
    {
        super(varType);
        
        if (varType.byValue())
        {
            varType.checkReturnDecByValue(); // No siempre podemos devolver por valor (sólo tipos simples)
        }
    }
    
    public ReturnDeclarationImpl(ClassTypeNativeImpl dataType)
    {
        this(VarTypeNativeImpl.newVarTypeNative(dataType));
    }

}
