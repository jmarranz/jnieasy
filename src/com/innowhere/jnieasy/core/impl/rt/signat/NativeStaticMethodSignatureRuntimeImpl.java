/*
 * NativeStaticMethodSignature.java
 *
 * Created on 25 de febrero de 2004, 19:25
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeStaticMethodReflection;
import java.lang.reflect.Method;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback;
import com.innowhere.jnieasy.core.method.NativeStaticMethod;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class NativeStaticMethodSignatureRuntimeImpl extends NativeMethodSignatureRuntimeImpl implements NativeStaticMethodSignature
{
    /**
     * Creates a new instance of NativeStaticMethodSignature
     */
    public NativeStaticMethodSignatureRuntimeImpl(NativeStaticMethodSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams,ctx);
    }
    
    public NativeStaticMethodSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
    }       
    
    public static NativeStaticMethodSignatureRuntimeImpl newStaticMethodSignatureRuntime(VarTypeNativeRuntimeImpl returnType,ArrayList params,RuntimeContext ctx)
    {
        NativeStaticMethodSignatureRuntimeImpl sig = new NativeStaticMethodSignatureRuntimeImpl(ctx);
        fillBehaviorSignatureRuntime(sig,returnType,params,ctx);        
        return sig;
    }    
    
    public NativeStaticMethodSignatureImpl getStaticMethodSignature()
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }
    
    public TypeNativeStaticMethod decStaticMethod(Class methodClass)
    {
        return getTypeManager().decStaticMethod(methodClass,this);
    }
        
    public void checkReflectionObject(Member member)
    {    
        Method method = (Method)member;
        Method methodValid = getMethod(method.getDeclaringClass(),method.getName());        
        if (!methodValid.equals(method)) throw new JNIEasyException("Not valid method " + method);        
    }
    
    public String getNameToExport(Member member)
    {
        return member.getDeclaringClass().getName() + "." + member.getName();
    }    
    
    public NativeStaticMethodReflection newStaticMethodReflection(Class containerClass,String methodName) 
    {
        Method method = getMethod(containerClass,methodName);        
        return (NativeStaticMethodReflection)newBehaviorReflectionInternal(method,false);        
    }    

    public NativeDirectStaticMethodCallback newDirectStaticMethodCallback(Class classOfMethod,String methodName) 
    {    
        Method method = getMethod(classOfMethod,methodName);        
        return (NativeDirectStaticMethodCallback)newDirectCallbackInternal(method,false);
    }

    public Method getMethod(Class clasz,String methodName)
    {    
        Method method = super.getMethod(clasz,methodName);        
        if (!Modifier.isStatic(method.getModifiers()))
            throw new JNIEasyException("Real Java method must be static: " + method);
        return method;
    }
    
    public Method getMethodNoCheck(Class clasz,String methodName)    
    {
        // No chequeamos si es estático, es el caso 
        // en donde se permite que un método sea no estáctico en una
        // callback estática permitiendo la herencia.
        return super.getMethod(clasz,methodName);
    }
    
    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeStaticMethodSignatureImpl(jniEasy);
    }
    
    public Class getNativeBehaviorDefaultInterface()    
    {
        return NativeStaticMethod.class;
    }    

}
