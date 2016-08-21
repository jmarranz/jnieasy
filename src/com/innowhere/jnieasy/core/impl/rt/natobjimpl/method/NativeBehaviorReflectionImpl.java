/*
 * NativeBehaviorReflectionImpl.java
 *
 * Created on 1 de diciembre de 2004, 22:00
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerUtil;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeBehaviorReflectionProxyTemplate;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeBehaviorReflectionWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import java.lang.reflect.Member;
import javassist.CtClass;

/**
 *
 * @author  jmarranz
 */


public abstract class NativeBehaviorReflectionImpl extends NativeMemberReflectionImpl implements NativeBehaviorReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeBehaviorReflectionImpl
     */
    public NativeBehaviorReflectionImpl()
    {
    }    

    public TypeNativeBehaviorReflectionWrapperRuntimeImpl getTypeNativeBehaviorReflection()
    {
        return (TypeNativeBehaviorReflectionWrapperRuntimeImpl)jnieasyGetType();
    }
    
    public NativeBehaviorSignature getBehaviorSignature()
    {
        return getTypeNativeBehaviorReflection().getBehaviorSignature();
    }    
    
    public NativeBehaviorSignatureRuntimeImpl getBehaviorSignatureRuntime()
    {
        return (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
    }        
    
    public long jnieasyCalcSize(Object newValue)
    {
        return jnieasyGetSize(); 
    }    
    
    public abstract Class getReflectionProxyTemplateClass();
    public abstract String formReflectionProxyUniqueClassName(String templateName,String addressPositiveStr,Class[] params);
    public abstract void addNewMethodReflectionProxy(EnhancerSharedContext esctx,CtClass proxyUtilCtClass,CtClass ctClassRet,CtClass[] ctClassParams,String body);
    public abstract Member getReflectionValueProxy(Class proxyUtilClass,Class[] params);
    
    public static String toStringPositive(long value)
    {
        String valuePositiveStr;
        if (value < 0)
        {
            value = -value; // Hacemos positivo
            valuePositiveStr = Long.toString(value);
            valuePositiveStr = "1" + valuePositiveStr; // Para recordar que fue negativo
        }
        else
        {
            valuePositiveStr = Long.toString(value);
            valuePositiveStr = "0" + valuePositiveStr; // Para recordar que fue positivo
        }    
        return valuePositiveStr;
    }
    
    public Member generateOnTheFlyProxy(NativeStateManager stateMgr)
    {
        // Hacemos que el objeto funcione como proxy:
        // generamos una clase "on the fly" y obtenemos el objeto reflection
        // que a su vez llamará al método call() de este objeto
        // de esta manera el usario tiene la sensación de estar llamando 
        // a un método nativo (en DLL por ejemplo) via reflection
        Member res;
                
        ClassLoader loader = this.getClass().getClassLoader();        
        Class originalClass = getReflectionProxyTemplateClass();
        
        NativeBehaviorSignatureRuntimeImpl sig = getBehaviorSignatureRuntime();
        Class[] params = sig.getParamClasses();

        String addressPositiveStr = toStringPositive(stateMgr.getBuffer().getValue()); // Tenemos la seguridad de que no tiene signo y a su ve distingue el valor positivo del negativo
             
        String newClassName = formReflectionProxyUniqueClassName(originalClass.getName(),addressPositiveStr,params);

        // Sincronizamos el loader para que no se hagan cargas en paralelo, porque es un caso de necesitar hacer enhancement en un entorno 
        // multihilo (en ejecución vamos) y que no hace el ClassLoader enhancer (que sí está sincronizado)        
        synchronized (loader)
        {              
            Class proxyUtilClass = ClassTypeNativeRuntimeImpl.getClassFromVMClassName(newClassName,loader,false);
            if (proxyUtilClass == null)
            {
                // Si se usan métodos creados dinámicamente (y que luego se destruyen)
                // por ejemplo los creados por JNIEasy
                // puede ocurrir memory leaks debido a la creación y carga de múltiples classes
                // Esto debe utilizarse para métodos fijos por ejemplo los métodos exportados por una DLL
               
                NativeManagerImpl natMgr = (NativeManagerImpl)stateMgr.getNativeManager();
                NativeEnhancerImpl enhancer = (NativeEnhancerImpl)natMgr.getJNIEasy().getEnhancer();
                EnhancerSharedContext esctx = enhancer.getEnhancerSharedContext(loader);        

                CtClass proxyUtilCtClass = esctx.createClassFromScratch(originalClass,newClassName);

                NativeBehaviorSignatureRender signatureRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(sig.getBehaviorSignature());

                String methodRef = "jnieasyProxy";
                String body = "";
                body += "{ \n";            
                body += signatureRender.getNativeBehaviorCallAndReturnSentence(methodRef,true) + " \n";    
                body += "}";             

                CtClass ctClassRet = esctx.toCtClass(sig.getReturnClass());
                CtClass[] ctClassParams = esctx.toCtClass(params);
                
                addNewMethodReflectionProxy(esctx,proxyUtilCtClass,ctClassRet,ctClassParams,body);                                

                proxyUtilClass = EnhancerUtil.loadClass(proxyUtilCtClass,loader,(JNIEasyImpl)enhancer.getJNIEasy());           
            }                

            NativeBehaviorReflectionProxyTemplate proxyObj;
            try
            {
                proxyObj = (NativeBehaviorReflectionProxyTemplate)proxyUtilClass.newInstance();            
            }
            catch(Exception ex)
            {
                throw new JNIEasyException(ex);
            }

            proxyObj.jnieasySetProxy(this);

            res = getReflectionValueProxy(proxyUtilClass,params);      
        }    
        
        return res;
    }
}
