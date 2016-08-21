/*
 * CallbackUtil.java
 *
 * Created on 23 de septiembre de 2004, 20:58
 */

package com.innowhere.jnieasy.core.impl.rt.signat;

/**
 *
 * @author  jmarranz
 */
import java.lang.reflect.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.parser.NativeBehaviorSignatureParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeSignatureManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextUsingImports;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.NativeVarTypeManagerRuntimeImpl;


public class NativeSignatureManagerRuntimeImpl implements NativeSignatureManager
{
    protected RuntimeManagerImpl rtMgr;
    protected NativeSignatureManagerImpl sigDecMgr;
    
    /** Creates a new instance of CallbackUtil */
    public NativeSignatureManagerRuntimeImpl(RuntimeManagerImpl rtMgr,NativeSignatureManagerImpl sigDecMgr)
    {
        this.rtMgr = rtMgr;
        this.sigDecMgr = sigDecMgr;
    }
        
    public NativeSignatureManagerImpl getSignatureManager()
    {
        return sigDecMgr;
    }
    
    public int getDefaultCallConv()
    {
        return sigDecMgr.getDefaultCallConv();
    }

    public void setDefaultCallConv(int callConv)
    {
        sigDecMgr.setDefaultCallConv(callConv);
    }
    
    public NativeParameterDec decParameter(VarTypeNative paramVarType)
    {
        return paramVarType.decParameter();
    }
    
    public NativeParameterDec decParameter(VarTypeNative paramVarType,boolean varargs)
    {
        return paramVarType.decParameter(varargs);
    }    
    
    public NativeTypeManagerRuntimeImpl getTypeManagerRuntime()
    {
        return (NativeTypeManagerRuntimeImpl)rtMgr.getTypeManagerRuntime();
    }

    public NativeVarTypeManagerRuntimeImpl getVarTypeManagerRuntime()
    {
        return (NativeVarTypeManagerRuntimeImpl)rtMgr.getVarTypeManagerRuntime();
    }   
    
    public RuntimeContextUsingImports getDefaultRuntimeContextUsingImports()
    {
        return rtMgr.getDefaultRuntimeContextUsingImports();
    }    
    
    public RuntimeContextUsingImports getRuntimeContext(String[] importList)
    {
        return rtMgr.getRuntimeContext(importList);
    }        
    
    public NativeBehaviorSignature decBehavior(String sigDecExpr)    
    {
        return decBehavior(sigDecExpr,null);
    }
     
    public NativeBehaviorSignature decBehavior(String sigDecExpr,String[] importList)    
    {
        RuntimeContext ctx = getRuntimeContext(importList);
        NativeBehaviorSignatureImpl sig = NativeBehaviorSignatureParserImpl.parseBehaviorSignature(sigDecExpr,ctx);
        //sig.check();
        Class classRet = NativeBehaviorSignatureRuntimeImpl.getClassReturn(sig);
        Class[] classParams = NativeBehaviorSignatureRuntimeImpl.getClassParams(sig);       
        NativeBehaviorSignatureRuntimeImpl sigRt = NativeBehaviorSignatureRuntimeImpl.newBehaviorSignatureRuntime(sig,classRet,classParams,ctx); 
        return sigRt;
    }    
    
    public NativeMethodSignature decMethod(Class classObj,Object returnType,Object[] params)
    {
        return decMethod(classObj,returnType,params,getDefaultCallConv());
    }
    
    public NativeMethodSignature decMethod(Class classObj,Object returnType,Object[] params,int callConv)
    {
        if (classObj == null)
            return decStaticMethod(returnType,params,callConv);
        else
            return decInstanceMethod(classObj,returnType,params,callConv);
    }
    
    public NativeMethodSignature decMethod(Method method)
    {
         if (Modifier.isStatic(method.getModifiers()))
             return decStaticMethod(method);
         else 
             return decInstanceMethod(method);             
    }     
    
    public NativeMethodSignature decMethod(Method method,int callConv)
    {
         if (Modifier.isStatic(method.getModifiers()))
             return decStaticMethod(method,callConv);
         else 
             return decInstanceMethod(method,callConv);             
    }         
    
    public NativeStaticMethodSignature decStaticMethod(Object returnType,Object[] params)
    {
        return decStaticMethod(returnType,params,getDefaultCallConv());
    }    
    
    public NativeStaticMethodSignature decStaticMethod(Object returnType,Object[] params,int callConv)
    {
        RuntimeContextUsingImports ctx = getDefaultRuntimeContextUsingImports();
        NativeVarTypeManagerRuntimeImpl varTypeMgr = getVarTypeManagerRuntime();        
        NativeStaticMethodSignatureRuntimeImpl signature = NativeStaticMethodSignatureRuntimeImpl.newStaticMethodSignatureRuntime(VarTypeNativeRuntimeImpl.convert(returnType,varTypeMgr),ParameterDecRuntimeImpl.convert(params,varTypeMgr),ctx);
        signature.getBehaviorSignature().setCallConv(callConv);
        return signature;
    }
    
    public NativeStaticMethodSignature decStaticMethod(Method method)
    {
        return decStaticMethod(method,getDefaultCallConv());
    }
    
    public NativeStaticMethodSignature decStaticMethod(Method method,int callConv)
    {
         if (!Modifier.isStatic(method.getModifiers()))
             throw new JNIEasyException("Method is not static: " + method);

        return decStaticMethod(method.getReturnType(),method.getParameterTypes(),callConv);
    }
    
    public NativeInstanceMethodSignature decInstanceMethod(Class classObj,Object returnType, Object[] params)
    {
        return decInstanceMethod(classObj,returnType,params,getDefaultCallConv());
    }    
    
    public NativeInstanceMethodSignature decInstanceMethod(Class classObj,Object returnType,Object[] params, int callConv)
    {
        RuntimeContextUsingImports ctx = getDefaultRuntimeContextUsingImports();
        NativeVarTypeManagerRuntimeImpl varTypeMgr = getVarTypeManagerRuntime();  
        NativeInstanceMethodSignatureRuntimeImpl signature = NativeInstanceMethodSignatureRuntimeImpl.newInstanceMethodSignatureRuntime(VarTypeNativeRuntimeImpl.convert(returnType,varTypeMgr),classObj,ParameterDecRuntimeImpl.convert(params,varTypeMgr),ctx);
        signature.getBehaviorSignature().setCallConv(callConv);
        return signature;  
    }
    
    public NativeInstanceMethodSignature decInstanceMethod(Method method)
    {
        return decInstanceMethod(method,getDefaultCallConv());
    }
    
    public NativeInstanceMethodSignature decInstanceMethod(Method method,int callConv)
    {
         if (Modifier.isStatic(method.getModifiers()))
             throw new JNIEasyException("Method is static: " + method);

        return decInstanceMethod(method.getDeclaringClass(),method.getReturnType(),method.getParameterTypes(),callConv);
    }
    
    public NativeConstructorSignature decConstructor(Class returnClass,Object[] params)
    {
        return decConstructor(returnClass,params,getDefaultCallConv());
    }
    
    public NativeConstructorSignature decConstructor(Class returnClass,Object[] params,int callConv)
    {
        RuntimeContextUsingImports ctx = getDefaultRuntimeContextUsingImports();
        NativeVarTypeManagerRuntimeImpl varTypeMgr = getVarTypeManagerRuntime();  
        NativeConstructorSignatureRuntimeImpl signature = NativeConstructorSignatureRuntimeImpl.newConstructorSignatureRuntime(returnClass,ParameterDecRuntimeImpl.convert(params,varTypeMgr),ctx);
        signature.getBehaviorSignature().setCallConv(callConv);
        return signature;       
    }    
    
    public NativeConstructorSignature decConstructor(Constructor constructor)
    {
        return decConstructor(constructor,getDefaultCallConv());
    }
    
    public NativeConstructorSignature decConstructor(Constructor constructor,int callConv)
    {
        return decConstructor(constructor.getDeclaringClass(),constructor.getParameterTypes(),callConv);
    }

    public NativeFieldMethodSignature decFieldMethod(Class classObj,Object fieldType)
    {
        return decFieldMethod(classObj,fieldType,getDefaultCallConv());
    }
    
    public NativeFieldMethodSignature decFieldMethod(Class classObj,Object fieldType,int callConv)
    {
        if (classObj == null)
            return decStaticFieldMethod(fieldType,callConv);
        else
            return decInstanceFieldMethod(classObj,fieldType,callConv);
    }
    
    public NativeFieldMethodSignature decFieldMethod(Field field)
    {
        return decFieldMethod(field,getDefaultCallConv());          
    }
    
    public NativeFieldMethodSignature decFieldMethod(Field field,int callConv)
    {
         if (Modifier.isStatic(field.getModifiers()))
             return decStaticFieldMethod(field,callConv);
         else 
             return decInstanceFieldMethod(field,callConv);        
    }
        
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Object fieldType)
    {
        return decStaticFieldMethod(fieldType,getDefaultCallConv());        
    }
        
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Object fieldType,int callConv)
    {
        RuntimeContextUsingImports ctx = getDefaultRuntimeContextUsingImports();
        NativeVarTypeManagerRuntimeImpl varTypeMgr = getVarTypeManagerRuntime();  
        VarTypeNativeRuntimeImpl fieldTypeDec = VarTypeNativeRuntimeImpl.convert(fieldType,varTypeMgr);
        NativeStaticFieldMethodSignatureRuntimeImpl signature = NativeStaticFieldMethodSignatureRuntimeImpl.newStaticFieldMethodSignatureRuntime(fieldTypeDec,ctx);
        signature.getBehaviorSignature().setCallConv(callConv);
        
        // No hace falta comprobar el convencionalismo (BY_PTR o BY_VALUE) pues al chequear el tipo 
        // de retorno se chequea que sea por referencia siempre salvo los tipos primitivos. Esto 
        // es válido para el parámetro al ser compartida la declaración.
        return signature;
    }
    
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Field field)
    {
        return decStaticFieldMethod(field,getDefaultCallConv());        
    }
        
    public NativeStaticFieldMethodSignature decStaticFieldMethod(Field field,int callConv)
    {
        if (!Modifier.isStatic(field.getModifiers()))
            throw new JNIEasyException("Field is not static: " + field.toString());

        return decStaticFieldMethod(field.getType(),callConv);        
    }
        
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Class classObj,Object fieldType)
    {
        return decInstanceFieldMethod(classObj,fieldType,getDefaultCallConv());        
    }
        
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Class classObj,Object fieldType, int callConv)
    {
        RuntimeContextUsingImports ctx = getDefaultRuntimeContextUsingImports();
        NativeVarTypeManagerRuntimeImpl varTypeMgr = getVarTypeManagerRuntime();        
        VarTypeNativeRuntimeImpl fieldTypeDec = VarTypeNativeRuntimeImpl.convert(fieldType,varTypeMgr);       
        NativeInstanceFieldMethodSignatureRuntimeImpl signature = NativeInstanceFieldMethodSignatureRuntimeImpl.newInstanceFieldMethodSignatureRuntime(fieldTypeDec,classObj,ctx);
        signature.getBehaviorSignature().setCallConv(callConv);
        // Consideraciones sobre el convencionalismo idem que el caso estático
        return signature;
    }
        
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Field field)
    {
        return decInstanceFieldMethod(field,getDefaultCallConv());        
    }
        
    public NativeInstanceFieldMethodSignature decInstanceFieldMethod(Field field,int callConv)
    {
        if (Modifier.isStatic(field.getModifiers()))
            throw new JNIEasyException("Field is static: " + field.toString());

        return decInstanceFieldMethod(field.getDeclaringClass(),field.getType(),callConv);
    }
}
