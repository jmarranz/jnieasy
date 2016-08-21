/*
 * NativeInstanceMethodSignature.java
 *
 * Created on 11 de febrero de 2004, 21:56
 */

package com.innowhere.jnieasy.core.impl.rt.signat;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeInstanceMethodReflection;
import java.lang.reflect.Method;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback;
import com.innowhere.jnieasy.core.method.NativeInstanceMethod;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class NativeInstanceMethodSignatureRuntimeImpl extends NativeMethodSignatureRuntimeImpl implements NativeInstanceMethodSignature
{
    protected NativeStaticMethodSignatureRuntimeImpl staticVersionSig;
            
    /**
     * Creates a new instance of NativeInstanceMethodSignature
     */
    public NativeInstanceMethodSignatureRuntimeImpl(NativeInstanceMethodSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams, ctx);
    }    
    
    public NativeInstanceMethodSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
    }        
    
    public static NativeInstanceMethodSignatureRuntimeImpl newInstanceMethodSignatureRuntime(VarTypeNativeRuntimeImpl returnType,Class classObj,ArrayList params,RuntimeContext ctx)
    {
        NativeInstanceMethodSignatureRuntimeImpl sig = new NativeInstanceMethodSignatureRuntimeImpl(ctx);
        sig.setThisClassType(classObj,ctx);        
        fillBehaviorSignatureRuntime(sig,returnType,params,ctx);
        return sig;
    }
    
    public void setThisClassType(Class classObj,RuntimeContext ctx)
    {
        VarTypeNativeRuntimeImpl varTypeThis = ThisClassSignatureRuntimeUtil.decThisType(classObj,ctx);
        addParameterDec(new ParameterDecRuntimeImpl(varTypeThis));        
    }
    
    public NativeInstanceMethodSignatureImpl getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignatureImpl)signature;
    }
   
    public ParameterDecRuntimeImpl getParameterDec(int index)
    {
        // Sumamos +1 porque el primer parámetro es del objeto (this), pero no 
        // es el primer parámetro desde el punto de vista de la función C++
        return super.getParameterDec(index + 1);
    }
    
    public int getParameterCount()
    {
        return super.getParameterCount() - 1;
    }    
    
    public Class getThisClass()
    {
        return getThisClassTypeNativeRuntime().getDeclaredClass();
    }
    
    public TypeNativeCapableRuntimeImpl getThisClassTypeNativeRuntime()
    {
        // -1 porque se suma +1 (-1 + 1 = 0 que es el verdadero)         
        return (TypeNativeCapableRuntimeImpl)getParameterDec(-1).getVarTypeNativeRuntime().getTypeNativeRuntime();
    }    
       
    public TypeNativeInstanceMethod decInstanceMethod(Class methodClass)
    {
        return getTypeManager().decInstanceMethod(methodClass,this);
    }
    
    public void checkReflectionObject(Member member)
    {    
        Method method = (Method)member;
        Method methodValid = getMethod(method.getName());        
        if (!methodValid.equals(method)) throw new JNIEasyException("Not valid method " + method);        
    }
    
    public String getNameToExport(Member member)
    {
        return member.getName();
    }    
    
    public Method getMethod(String methodName)
    {
        //NativeInstanceMethodSignatureImpl sig = getInstanceMethodSignature();
        Class clasz = getThisClass();        
        Method method = super.getMethod(clasz,methodName);
        if (Modifier.isStatic(method.getModifiers()))
            throw new JNIEasyException("Real Java method must not be static: " + method);
        return method;
    }       
    
    public NativeInstanceMethodReflection newInstanceMethodReflection(String methodName)
    {
        Method method = getMethod(methodName);
        return (NativeInstanceMethodReflection)newBehaviorReflectionInternal(method,false);
    }

    public NativeDirectInstanceMethodCallback newDirectInstanceMethodCallback(String methodName) 
    {    
        Method method = getMethod(methodName);        
        return (NativeDirectInstanceMethodCallback)newDirectCallbackInternal(method,false);
    }    
    
    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeInstanceMethodSignatureImpl(jniEasy);
    }
    
    public Class getNativeBehaviorDefaultInterface()    
    {
        return NativeInstanceMethod.class;
    }    
    
    public NativeStaticMethodSignatureRuntimeImpl getStaticVersionSignature()
    {
        if (staticVersionSig == null)
        {      
            VarTypeNative returnVarType = getReturnVarType();
            VarTypeNative[] params = getParameterDecList().getParameterVarTypeList();
            int callConv = getCallConv();
            this.staticVersionSig = (NativeStaticMethodSignatureRuntimeImpl)rtMgr.getSignatureManagerRuntime().decStaticMethod(returnVarType,params,callConv);
        }

        return staticVersionSig;
    }
    
    public Object call(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.call(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public void callVoid(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        super.callVoid(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
   
    public boolean callBoolean(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callBoolean(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public byte callByte(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callByte(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public char callChar(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callChar(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public short callShort(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callShort(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }

    public int callInt(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callInt(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
 
    public long callLong(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callLong(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
 
    public float callFloat(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callFloat(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public double callDouble(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callDouble(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public Object callObject(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callObject(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }     

}
