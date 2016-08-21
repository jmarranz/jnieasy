/*
 * NativeBehaviorSignatureParserImpl.java
 *
 * Created on 2 de junio de 2005, 21:39
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.util.CurlyBracketBlock;
import com.innowhere.jnieasy.core.impl.util.ParenthesisBlock;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.util.Space;
import com.innowhere.jnieasy.core.impl.util.Token;
import com.innowhere.jnieasy.core.impl.util.Word;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;
import com.innowhere.jnieasy.core.typedec.CallConv;
import java.util.ArrayList;



/**
 *
 * @author jmarranz
 */
public abstract class NativeBehaviorSignatureParserImpl
{
    protected TaskContext ctx;
    protected NativeBehaviorSignatureImpl signature;
    
    /**
     * Creates a new instance of NativeBehaviorSignatureParserImpl
     */
    public NativeBehaviorSignatureParserImpl(TaskContext ctx)
    {
        this.ctx = ctx;
        this.signature = newBehaviorSignature();
    }
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
    
    public VarTypeNativeImpl getReturnType()
    {
        return this.signature.getReturnDeclaration().getVarTypeNative();
    }
    
    public void setReturnType(SourceCode returnPart)
    {
        try
        {
            this.signature.setReturnVarType(VarTypeNativeParserImpl.newVarTypeNative(returnPart, ctx));
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method signature declaration:" + returnPart, ex);
        }          
    }
    
    public void setCallConv(int callConv)
    {    
        this.signature.setCallConv( callConv );         
    }
    
    public static int getDefaultCallConv(TaskContext ctx)
    {
        return ctx.getJNIEasy().getSignatureManagerImpl().getDefaultCallConv();
    }
    
    public void setDefaultCallConv()
    {
        this.signature.setCallConv( getDefaultCallConv(ctx) );
    }    

    public void setParamList(ArrayList params)
    {
        this.signature.addParameterDecList( params );    
    }
        
    public static NativeBehaviorSignatureImpl parseBehaviorSignature(String sigDec,TaskContext ctx)
    {
        return parseBehaviorSignature(new SourceCode(sigDec),ctx);
    }      
    
    public static boolean isCallConv(String code)
    {
        return (code.equals("__stdcall") || code.equals("__cdecl"));
    }
            
    public static int parseCallConv(String code)
    {
        //code = code.trim();
        if (code.equals("__stdcall"))
            return CallConv.STD_CALL;
        else if (code.equals("__cdecl"))
            return CallConv.C_CALL;
        else 
            throw new JNIEasyException("Expected __stdcall or __cdecl :" + code);
    }
    
    public static NativeBehaviorSignatureImpl parseBehaviorSignature(SourceCode sigCode,TaskContext ctx)
    {
        // [static] [ReturnType] [__stdcall | __cdecl] [ClassName] (...)
        // Hay que distinguir tres casos: estático, no estático y constructor
        // Estático:    static ReturnType [callConv] (...        
        // Constructor: [callConv] ClassName (...         
        // No Estático: ReturnType [callConv] ClassName (...       
        // Se admiten espacios entre medias excepto en los nombres de las clases claro
        // Si no hay parámetros suponemos que es una declaración de un método basado en field :
        // "ReturnType [__stdcall|__cdecl] [ClassName]" o 
        // "ReturnType [__stdcall|__cdecl]"
        // Se admiten espacios tras el ClassName en este caso     
        // Recuerda que ReturnType puede no ser una simple clase (un Word) por ser la declaración de un array etc
        
        try
        {
            sigCode.trim();
            
            if (sigCode.getLastToken() instanceof ParenthesisBlock)
            {
                // Caso general
                // Esperamos al menos dos partes: el comienzo y el bloque de parámetros
                int numParts = sigCode.getNumTokens();
                if (numParts < 2)
                    throw new JNIEasyException("Syntax error");
                ParenthesisBlock params = (ParenthesisBlock)sigCode.getLastToken();            
                // Procesamos la parte izquierda antes de los params
                SourceCode leftPart = sigCode.getRange(0,numParts - 1);
                NativeBehaviorSignatureParserImpl sigParser = parseBehaviorSignaturePreParams(leftPart,false,ctx);
                sigParser.setParamList(ParameterDecListParserImpl.parse(params, ctx));
                return sigParser.getBehaviorSignature();
            }
            else
            {
                // No hay parámetros, caso de Field
                NativeBehaviorSignatureParserImpl sigParser = parseBehaviorSignaturePreParams(sigCode,true,ctx);
                return sigParser.getBehaviorSignature();
            }            
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method signature declaration:" + sigCode, ex);
        }       
    }      

    public static NativeBehaviorSignatureParserImpl parseBehaviorSignaturePreParams(SourceCode leftPart,boolean isFieldSig,TaskContext ctx)
    {
        try
        {
            leftPart.trim(); // quitamos espacios al principio y antes de los parámetros

            // Eliminamos todos los espacios
            leftPart.removeTokensOfType(Space.class);
            
            String firstTokenStr = leftPart.getFirstToken().getContent();
            if ("static".equals(firstTokenStr))
            {
                // Caso estático
                leftPart.removeFirst(); // quitamos el token del static
                NativeBehaviorSignatureParserImpl sig;
                if (!isFieldSig)
                    sig = new NativeStaticMethodSignatureParserImpl(ctx);
                else
                    sig = new NativeStaticFieldMethodSignatureParserImpl(ctx);

                String preParamsStr = leftPart.getLastToken().getContent();                    
                int callConv;
                if (isCallConv(preParamsStr))
                {
                    callConv = parseCallConv(preParamsStr);                                          
                    leftPart.removeLast(); // quitamos el token del convencionalismo de llamada 
                }
                else callConv = getDefaultCallConv(ctx);

                sig.setCallConv(callConv);
                sig.setReturnType(leftPart);
                return sig;
            }
            else // Caso constructor y no estático
            {
                String className = leftPart.getLastToken().getContent();
                leftPart.removeLast(); // quitamos el token de la clase
                int callConv;                
                if (leftPart.getNumTokens() > 0)                
                {
                    // O hay convencionalismo de llamada o es instance
                    String preClassNameStr = leftPart.getLastToken().getContent();
                    if (isCallConv(preClassNameStr))                    
                    {
                        callConv = parseCallConv(preClassNameStr);
                        leftPart.removeLast(); // quitamos el token del convencionalismo
                    }
                    else
                    {
                        // No tiene convencionalismo, cogemos el de por defecto
                        callConv = getDefaultCallConv(ctx);
                    }
                }
                else callConv = getDefaultCallConv(ctx); 
                
                if (leftPart.getNumTokens() == 0)
                {
                    // Caso de constructor
                    ConstructorSignatureParserImpl sig = new ConstructorSignatureParserImpl(ctx);
                    sig.setClassType(className);                
                    sig.setCallConv(callConv);
                    return sig;                        
                }
                else
                {
                    // Caso no estático
                    NativeBehaviorSignatureParserImpl sig;
                    if (!isFieldSig)
                    {
                        sig = new NativeInstanceMethodSignatureParserImpl(ctx);
                        ((NativeInstanceMethodSignatureParserImpl)sig).setClassType(className);
                    }
                    else
                    {
                        sig = new NativeInstanceFieldMethodSignatureParserImpl(ctx);
                        ((NativeInstanceFieldMethodSignatureParserImpl)sig).setClassType(className);
                    }

                    sig.setCallConv(callConv);
                    sig.setReturnType(leftPart);                     
                    return sig;   
                }                
            }
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method signature declaration (pre-params):" + leftPart, ex);
        }         
    }
    
    public abstract NativeBehaviorSignatureImpl newBehaviorSignature();
    
}
