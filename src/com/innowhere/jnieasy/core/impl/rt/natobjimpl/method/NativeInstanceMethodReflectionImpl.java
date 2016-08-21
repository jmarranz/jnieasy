/*
 * NativeInstanceMethodReflectionImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

/**
 *
 * @author  jmarranz
 */
import java.lang.reflect.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceMethodCallbackStateManagerImpl;
import javassist.CtClass;

public class NativeInstanceMethodReflectionImpl extends NativeMethodReflectionImpl implements NativeInstanceMethodReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of MethodReflectionWrapperImpl */
    public NativeInstanceMethodReflectionImpl()
    {
    }
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new InstanceMethodCallbackStateManagerImpl();
    }        

    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)getBehaviorSignature();
    }    

    public NativeInstanceMethodSignatureRuntimeImpl getInstanceMethodSignatureRuntime()
    {
        return (NativeInstanceMethodSignatureRuntimeImpl)getBehaviorSignature();
    }
    
    public static Method getReflectionMethodAsProxy(NativeStaticMethodSignatureRuntimeImpl sig,NativeStateManager stateMgr)
    {
        TypeNativeStaticMethod type = sig.decStaticMethod(NativeStaticMethodReflection.class);
        NativeStaticMethodReflectionImpl natMethod = (NativeStaticMethodReflectionImpl)type.newValue();
        stateMgr.getNativeManager().attach(natMethod,stateMgr.getBuffer(),0);
        // No importa que se pierda la referencia natMethod porque el objeto está apuntado de forma 
        // estática por el field estático de la clase generada        
        return natMethod.getMethod();    
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        if (this.value != null)
            return this.value;

        NativeInstanceMethodSignatureRuntimeImpl sig = getInstanceMethodSignatureRuntime();        
        this.value = getReflectionMethodAsProxy(sig.getStaticVersionSignature(),stateMgr);
        
        return value;
    }
    
    public Object onCall(Object obj, Object[] args)
    {
        try
        {
            Method method = getMethod();
            return method.invoke(obj,args);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
    
    public Object call(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().call(this,jnieasyGetAddress(),obj,args);
    }
    
    public void callVoid(Object obj,Object[] args)
    {
        getInstanceMethodSignatureRuntime().callVoid(this,jnieasyGetAddress(),obj,args);
    }    

    public boolean callBoolean(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callBoolean(this,jnieasyGetAddress(),obj,args);
    }        
    
    public byte callByte(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callByte(this,jnieasyGetAddress(),obj,args);
    }        
    
    public char callChar(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callChar(this,jnieasyGetAddress(),obj,args);
    }        
    
    public short callShort(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callShort(this,jnieasyGetAddress(),obj,args);
    }        

    public int callInt(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callInt(this,jnieasyGetAddress(),obj,args);
    }        
 
    public long callLong(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callLong(this,jnieasyGetAddress(),obj,args);
    }        
 
    public float callFloat(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callFloat(this,jnieasyGetAddress(),obj,args);
    }        
    
    public double callDouble(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callDouble(this,jnieasyGetAddress(),obj,args);
    }        
    
    public Object callObject(Object obj,Object[] args)
    {
        return getInstanceMethodSignatureRuntime().callObject(this,jnieasyGetAddress(),obj,args);
    }        
   
    public Object jnieasyNewInstance()
    {
        return new NativeInstanceMethodReflectionImpl();
    }      
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeInstanceMethodReflectionImpl[len];
    }     
        
    public Member getReflectionValueProxy(Class proxyUtilClass, Class[] params)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public String formReflectionProxyUniqueClassName(String templateName, String addressPositiveStr, Class[] params)
    {
        throw new JNIEasyException("INTERNAL ERROR");        
    }

    public void addNewMethodReflectionProxy(EnhancerSharedContext esctx, CtClass proxyUtilCtClass, CtClass ctClassRet, CtClass[] ctClassParams, String body)
    {
        throw new JNIEasyException("INTERNAL ERROR");           
    }

    public Class getReflectionProxyTemplateClass()
    {
        throw new JNIEasyException("INTERNAL ERROR");           
    }    
}
