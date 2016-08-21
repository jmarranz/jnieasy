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
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceMethodCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticMethodCallbackStateManagerImpl;
import javassist.CtClass;


public class NativeMethodReflectionDefaultImpl extends NativeMethodReflectionImpl implements NativeStaticMethodReflection,NativeInstanceMethodReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of MethodReflectionWrapperImpl */
    public NativeMethodReflectionDefaultImpl()
    {
    }
    
    public static NativeMethodReflectionDefaultImpl newMethodReflectionDefaultImpl()
    {
        return new NativeMethodReflectionDefaultImpl();
    }  
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        NativeBehaviorSignature sig = getBehaviorSignature();        
        if (sig instanceof NativeStaticMethodSignature)
            return new StaticMethodCallbackStateManagerImpl();            
        else        
            return new InstanceMethodCallbackStateManagerImpl();
    }      

    public NativeStaticMethodSignature getStaticMethodSignature()
    {
        return (NativeStaticMethodSignature)getBehaviorSignature();
    }    

    public NativeStaticMethodSignatureRuntimeImpl getStaticMethodSignatureRuntime()
    {
        return (NativeStaticMethodSignatureRuntimeImpl)getBehaviorSignature();
    }        
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        if (this.value != null)
            return this.value;        

        // Quizás no se use nunca pero por si acaso
        NativeBehaviorSignature sig = getBehaviorSignature();             
        if (sig instanceof NativeStaticMethodSignatureRuntimeImpl)
        {
            NativeStaticMethodSignatureRuntimeImpl sigStatic = (NativeStaticMethodSignatureRuntimeImpl)sig;
            this.value = NativeInstanceMethodReflectionImpl.getReflectionMethodAsProxy(sigStatic,stateMgr);          
        }
        else          
        {
            NativeStaticMethodSignatureRuntimeImpl sigStatic = ((NativeInstanceMethodSignatureRuntimeImpl)sig).getStaticVersionSignature();
            this.value = NativeInstanceMethodReflectionImpl.getReflectionMethodAsProxy(sigStatic,stateMgr); 
        }
        return value;
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

    public NativeInstanceMethodSignature getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignature)getBehaviorSignature();
    }    

    public NativeInstanceMethodSignatureRuntimeImpl getInstanceMethodSignatureRuntime()
    {
        return (NativeInstanceMethodSignatureRuntimeImpl)getBehaviorSignature();
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
        return new NativeMethodReflectionDefaultImpl();
    }       
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeMethodReflectionDefaultImpl[len];
    }     
        

}
