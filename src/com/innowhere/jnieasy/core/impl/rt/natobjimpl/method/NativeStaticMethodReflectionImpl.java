/*
 * MethodReflectionWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.enhancer.render.EnhancerRenderUtil;
import com.innowhere.jnieasy.core.impl.rt.RuntimeUtil;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticMethodCallbackStateManagerImpl;
import javassist.CtClass;

public class NativeStaticMethodReflectionImpl extends NativeMethodReflectionImpl implements NativeStaticMethodReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of MethodReflectionWrapperImpl */
    public NativeStaticMethodReflectionImpl()
    {
    }

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new StaticMethodCallbackStateManagerImpl();
    }       

    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)getBehaviorSignature();
    }    

    public NativeStaticMethodSignatureRuntimeImpl getStaticMethodSignatureRuntime()
    {
        return (NativeStaticMethodSignatureRuntimeImpl)getBehaviorSignature();
    }        

    public String getProxyMethodName()
    {
        return "jnieasyCall";
    }        
    
    public Class getReflectionProxyTemplateClass()
    {
        return NativeStaticMethodReflectionProxyTemplateImpl.class;        
    }
    
    public String formReflectionProxyUniqueClassName(String templateName,String addressPositiveStr,Class[] params)
    {
        NativeStaticMethodSignatureRuntimeImpl sig = getStaticMethodSignatureRuntime();
        return sig.getMethodSignature().formNativeDirectCallbackUniqueClassName(templateName,addressPositiveStr,RuntimeUtil.extractClassNames(params));        
    }
    
    public void addNewMethodReflectionProxy(EnhancerSharedContext esctx,CtClass proxyUtilCtClass,CtClass ctClassRet,CtClass[] ctClassParams,String body)
    {
        EnhancerRenderUtil.addNewMethod(Modifier.PUBLIC | Modifier.STATIC,
            ctClassRet,getProxyMethodName(),ctClassParams,
            null, body,proxyUtilCtClass);        
    }
    
    public Member getReflectionValueProxy(Class proxyUtilClass,Class[] params)
    {
        try
        {
            return proxyUtilClass.getDeclaredMethod(getProxyMethodName(),params);
        }
        catch(NoSuchMethodException ex)
        {
            throw new JNIEasyException(ex);
        }         
    }
    
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        if (this.value != null)
            return this.value;
        
        this.value = (Method)generateOnTheFlyProxy(stateMgr);
        
        return value;        
    }    
    
    public Object onCall(Object[] args)
    {
        try
        {
            Method method = getMethod();
            return method.invoke(null,args);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public Object call(Object[] args)
    {
        return getStaticMethodSignatureRuntime().call(this,jnieasyGetAddress(),args);
    }
    
    public void callVoid(Object[] args)
    {
        getStaticMethodSignatureRuntime().callVoid(this,jnieasyGetAddress(),args);
    }

    public boolean callBoolean(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callBoolean(this,jnieasyGetAddress(),args);
    }
    
    public byte callByte(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callByte(this,jnieasyGetAddress(),args);
    }
    
    public char callChar(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callChar(this,jnieasyGetAddress(),args);
    }
    
    public short callShort(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callShort(this,jnieasyGetAddress(),args);
    }

    public int callInt(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callInt(this,jnieasyGetAddress(),args);
    }    
 
    public long callLong(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callLong(this,jnieasyGetAddress(),args);
    }    
 
    public float callFloat(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callFloat(this,jnieasyGetAddress(),args);
    }    
    
    public double callDouble(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callDouble(this,jnieasyGetAddress(),args);
    }    
    
    public Object callObject(Object[] args)
    {
        return getStaticMethodSignatureRuntime().callObject(this,jnieasyGetAddress(),args);
    }   
   
    public Object jnieasyNewInstance()
    {
        return new NativeStaticMethodReflectionImpl();
    }   
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStaticMethodReflectionImpl[len];
    }     
        
}
