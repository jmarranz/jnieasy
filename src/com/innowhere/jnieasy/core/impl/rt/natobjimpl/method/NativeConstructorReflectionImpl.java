/*
 * ConstructorWrapperImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.ConstructorCallbackStateManagerImpl;
import javassist.CannotCompileException;
import javassist.CtClass;



public class NativeConstructorReflectionImpl extends NativeBehaviorReflectionImpl implements NativeConstructorReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected transient Constructor value;
    
    /** Creates a new instance of ConstructorWrapperImpl */
    public NativeConstructorReflectionImpl()
    {
    }   
    
    public static NativeConstructorReflectionImpl newConstructorReflection()
    {
        return new NativeConstructorReflectionImpl();
    }      
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new ConstructorCallbackStateManagerImpl();
    }    
    
    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        // No hay que hacer nada por el lado nativo salvo el cast   
        super.jnieasySetValue((Constructor)newValue,stateMgr);
    }    
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        if (this.value != null)
            return this.value;
        
        this.value = (Constructor)generateOnTheFlyProxy(stateMgr);
        
        return value;        
    }        
    
    public Class getReflectionProxyTemplateClass()
    {
        return NativeConstructorReflectionProxyTemplateImpl.class;        
    }
    
    public String formReflectionProxyUniqueClassName(String templateName,String addressPositiveStr,Class[] params)
    {
        NativeConstructorSignatureRuntimeImpl sig = getConstructorSignatureRuntime();
        return sig.getConstructorSignature().formNativeDirectCallbackUniqueClassName(templateName + "_" + addressPositiveStr,RuntimeUtil.extractClassNames(params));
    }
    
    public void addNewMethodReflectionProxy(EnhancerSharedContext esctx,CtClass proxyUtilCtClass,CtClass ctClassRet,CtClass[] ctClassParams,String body)
    {
        NativeConstructorSignatureRuntimeImpl sig = getConstructorSignatureRuntime();        
        CtClass ctClassParent = esctx.toCtClass(sig.getThisClass());        
        try
        {
            proxyUtilCtClass.setSuperclass(ctClassParent);
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }                  
        
        EnhancerRenderUtil.addNewConstructor(Modifier.PUBLIC,
            ctClassParams, null, body,proxyUtilCtClass);          
    }
    
    public Member getReflectionValueProxy(Class proxyUtilClass,Class[] params)
    {
        try
        {
            return proxyUtilClass.getDeclaredConstructor(params);
        }
        catch(NoSuchMethodException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }    
    
    public void setConstructor(Constructor newValue)
    {
        setValue(newValue);
    }    
       
    public Constructor getConstructor()
    {
        return (Constructor)getValue();
    }
    
    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)getBehaviorSignature();
    }

    public NativeConstructorSignatureRuntimeImpl getConstructorSignatureRuntime()
    {
        return (NativeConstructorSignatureRuntimeImpl)getBehaviorSignature();
    }    
    
    public Object onCall(Object[] args)
    {
        try
        {
            Constructor constructor = getConstructor();
            return constructor.newInstance(args);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }      
    }
    
    public Object call(Object[] args)
    {
        return getConstructorSignatureRuntime().call(this,jnieasyGetAddress(),args);
    }
    
    public void call(Object proxy,Object[] args)
    {
        getConstructorSignatureRuntime().call(this,jnieasyGetAddress(),proxy,args);
    }    
   
    public Object jnieasyNewInstance()
    {
        return new NativeConstructorReflectionImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeConstructorReflectionImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Constructor)newValue;            
    }    

}
