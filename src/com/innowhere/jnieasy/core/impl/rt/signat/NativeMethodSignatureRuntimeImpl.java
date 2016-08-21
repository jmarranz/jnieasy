/*
 * NativeMethodSignatureRuntimeImpl.java
 *
 * Created on 28 de febrero de 2005, 17:13
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.typedec.*;
import java.lang.reflect.Method;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeUtil;
import com.innowhere.jnieasy.core.method.NativeDirectMethodCallback;
import com.innowhere.jnieasy.core.method.NativeMethodReflection;
import java.lang.reflect.Member;

public abstract class NativeMethodSignatureRuntimeImpl extends NativeBehaviorSignatureRuntimeImpl implements NativeMethodSignature
{
    
    /**
     * Creates a new instance of NativeMethodSignatureRuntimeImpl
     */
    public NativeMethodSignatureRuntimeImpl(NativeMethodSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams,ctx);
    }
    
    public NativeMethodSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
    }        
    
    public NativeMethodSignatureImpl getMethodSignature()
    {
        return (NativeMethodSignatureImpl)signature;
    }
    
    public TypeNativeMethod decMethod(Class methodClass)
    {
        return getTypeManager().decMethod(methodClass,this);
    }
    
    public NativeMethodSignatureImpl getNativeMethodSignature()
    {
        return (NativeMethodSignatureImpl)signature;
    }    
    
    public String formNativeDirectCallbackUniqueClassName(Member behavior)
    {
        Method method = (Method)behavior;  
        NativeMethodSignatureImpl sig = getNativeMethodSignature();
        return sig.formNativeDirectCallbackUniqueClassName(method.getDeclaringClass().getName(),method.getName(),RuntimeUtil.extractClassNames(method.getParameterTypes()));
    }
      
    public Method getMethod(Class clasz,String methodName)
    {
        Class[] params = getParamClasses();

        Method method;
        try
        {
            method = clasz.getDeclaredMethod(methodName,params);
        }
        catch(NoSuchMethodException ex) 
        {
            throw new JNIEasyException(ex);
        }    
        
        Class returnClass = getReturnVarType().getType().getDeclaredClass();
        if (!returnClass.equals(method.getReturnType()))
            throw new JNIEasyException("Bad return type, " + method.getReturnType().getName() + ", expected: " + returnClass.getName());        
        return method;
    }
   
   
    public NativeMethodReflection newMethodReflection(Method method)    
    {
        return (NativeMethodReflection)newBehaviorReflection(method);      
    }        
    
    public NativeDirectMethodCallback newDirectMethodCallback(Method method) 
    {    
        return (NativeDirectMethodCallback)newDirectCallback(method);
    }    
}
