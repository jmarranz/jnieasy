/*
 * VarTypeNativeParserImpl.java
 *
 * Created on 3 de junio de 2005, 19:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.parser;

import com.innowhere.jnieasy.core.data.NativePointer;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.util.Token;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.util.Word;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

/**
 *
 * @author jmarranz
 */
public class VarTypeNativeParserImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeParserImpl
     */
    private VarTypeNativeParserImpl()
    {
    }
    
    public static VarTypeNativeImpl newVarTypeNative(String decClass,TaskContext ctx)
    {    
        return newVarTypeNative(new SourceCode(decClass),ctx);
    }
    
    public static VarTypeNativeImpl newVarTypeNative(SourceCode decClassCode,TaskContext ctx)
    {    
        return newVarTypeNative(decClassCode,false,ctx);
    }
    
    public static VarTypeNativeImpl newVarTypeNative(SourceCode decClassCode,boolean hasPrevAsterisk,TaskContext ctx)
    {
        decClassCode.trim();
        Token lastPart = decClassCode.getLastToken();
        
        boolean hasAsterisk = false;
        if (lastPart instanceof Word)
        {
            Word lastPartWord = (Word)lastPart;
            String lastPartStr = lastPartWord.getContent();
            hasAsterisk = ('*' == lastPartStr.charAt(lastPartStr.length() - 1));
            
            if (hasAsterisk)
            {
                // Quitamos el asterisco          
                lastPartStr = lastPartStr.substring(0,lastPartStr.length() - 1);
                if (!lastPartStr.equals("")) // está pegado a un nombre 
                    lastPartWord.setContent(lastPartStr);
                else
                    decClassCode.removeLast(); // estaba solitario (entre espacios)
            }
        }

        if (hasAsterisk)
        {
            // Hemos quitado el asterisco
            // Parseamos lo que queda
            if (hasPrevAsterisk)  // Caso ** 
            {
                TypeNativePointerImpl typeDecPtrToPtr = (TypeNativePointerImpl)TypeNativeImpl.newTypeNative(ctx.getClassType(NativePointer.class.getName()));
                VarTypeNativeObjectImpl varTypePtr = (VarTypeNativeObjectImpl)newVarTypeNative(decClassCode,true,ctx); // El true es por el hasAsterisk (podría ser *** o más)
                typeDecPtrToPtr.setAddressedVarTypeNativeObject(varTypePtr);
                return VarTypeNativeImpl.newVarTypeNative(typeDecPtrToPtr);
            }
            else // Caso * (uno al menos por ahora) 
            {
                return newVarTypeNative(decClassCode,true,ctx);
            }
        }
        else if (hasPrevAsterisk)  // Caso * y no hay más
        {
            VarTypeNativeImpl varType = newVarTypeNative(decClassCode,false,ctx);
            if (varType.getTypeNative() instanceof TypeNativePrimitiveImpl)
            {
                // Caso de int * por ejemplo
                // Usamos el tipo puntero relacionado
                // Reutilizamos el TypeNativePrimitiveImpl porque en el caso de
                // long puede haber sido definido como "address" o bien en todos los primitivos un tamaño (memSize) y alineamiento (prefAlignSize) específicos.
                TypeNativePrimitiveImpl primTypeDec = (TypeNativePrimitiveImpl)varType.getTypeNative();
                TypeNativePrimitiveWrapperImpl newTypeDec = primTypeDec.newRelatedTypeNativePrimitiveWrapper();
                varType = VarTypeNativeImpl.newVarTypeNative(newTypeDec);
            }
            varType.setVarConv(VarTypeNative.BY_PTR);
            return varType;
        }
        else // Caso sin * alguno
        {
            if (lastPart instanceof Word)
            {
                // Estudiamos si termina en "...""
                
                Word lastPartWord = (Word)lastPart;
                String lastPartContent = lastPartWord.getContent();                
                if (lastPartContent.endsWith("...")) // no hay espacios al final (hubo un trim)
                {
                    // Puede ser por ejemplo: int... o int{2}... etcetera
                    // Quitamos los "..."
                    String lastPartContentNoVarArg = lastPartContent.substring(0,lastPartContent.length() - 3);
                    lastPartWord.setContent(lastPartContentNoVarArg);
                    VarTypeNativeImpl varTypeDecComp = newVarTypeNative(decClassCode,ctx);
                    TypeNativeArrayImpl typeDec = TypeNativeArrayImpl.newTypeNativeArray(varTypeDecComp,ctx);
                    VarTypeNativeArrayImpl varTypeDec = (VarTypeNativeArrayImpl)VarTypeNativeArrayImpl.newVarTypeNative(typeDec);
                    varTypeDec.setVarArgs(true);
                    return varTypeDec;
                }
            }
            
            TypeNativeImpl typeDec = TypeNativeParserImpl.newTypeNative(decClassCode, ctx);
            VarTypeNativeImpl varTypeDec = VarTypeNativeImpl.newVarTypeNative(typeDec);
            varTypeDec.setVarConv(varTypeDec.getVarConvIfNotAsterisk()); 
            return varTypeDec;
        }
    }            
}
