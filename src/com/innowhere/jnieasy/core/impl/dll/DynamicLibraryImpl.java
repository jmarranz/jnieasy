/*
 * DynamicLibrary.java
 *
 * Created on 21 de noviembre de 2003, 12:26
 */

package com.innowhere.jnieasy.core.impl.dll;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.mem.DynamicLibrary;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import java.util.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeDLLBehaviorRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.CallConvImpl;
import com.innowhere.jnieasy.core.mem.DLLManager;
import java.io.File;
import java.io.IOException;

public abstract class DynamicLibraryImpl implements DynamicLibrary
{
    protected long handle;
    protected String dllName;
    protected DLLManagerImpl dllMgr;
    protected int defaultCallConv; // Por defecto
    protected DLLBehaviorList methods = new DLLBehaviorList();
    protected RuntimeManagerImpl rtMgr;
    protected NativeTypeManager typeMgr;
    protected NativeSignatureManager sigDecMgr;
    
    /** Creates a new instance of DynamicLibrary */
    public DynamicLibraryImpl(String dllName,RuntimeManagerImpl rtMgr,DLLManagerImpl dllMgr)
    {
        // Esta carga asegura que la búsqueda se realiza a través de java.library.path
        // lo cual hace más portables los programas (se hace innecesario quizás el LD_LIBRARY_PATH de Linux)
        // El LoadLibrary/dlopen nativo posterior encontrará ya la DLL en memoria (excepto en Mac)
        // notar que las DLLs no podrán descargarse aunque el DynamicLibraryImpl se pierda via GC
        
        String platformDLLName = getPlatformDLLName(dllName); 
        String dllPath = platformDLLName;
        boolean success = loadLibrary(dllPath); // Por si es path absoluto
        if (!success)
        {
            String[] paths = dllMgr.getJavaLibraryPathArray();
            for(int i = 0; i < paths.length; i++)
            {
                dllPath = paths[i] + "/" + platformDLLName;
                File file = new File(dllPath);
                try
                {
                    dllPath = file.getCanonicalPath();
                }
                catch(IOException ex) // raro
                {
                    throw new JNIEasyException(ex);
                }
               
                if (loadLibrary(dllPath))
                {
                    success = true;
                    break;
                }                            
            }
        }
        if (!success) throw new JNIEasyException("Failed to load DLL:" + platformDLLName);
        this.handle = DynamicLibraryNative.load(dllPath,platformDLLName);
        if (handle == 0) throw new JNIEasyException("Failed to load DLL:" + platformDLLName);
     
        this.dllMgr = dllMgr;   
        this.rtMgr = rtMgr;
        this.typeMgr = rtMgr.getTypeManagerRuntime();
        this.sigDecMgr = rtMgr.getSignatureManagerRuntime();
        this.dllName = dllName;
        this.defaultCallConv = sigDecMgr.getDefaultCallConv();        
    }

    protected void finalize() throws Throwable
    {
        free();
        super.finalize();
    }

    private static boolean loadLibrary(String dllPath)
    {
        try
        {         
            System.load(dllPath);  
            return true;
        }
        catch(UnsatisfiedLinkError ex)
        {
            return false;            
        }     
    }
    
    public abstract String getPlatformDLLName(String dllName);
    
    public DLLManager getDLLManager()
    {
        return dllMgr;
    }
    
    public DLLManagerImpl getDLLManagerImpl()
    {
        return dllMgr;
    }    
    
    public void free()
    {
        dllMgr.remove(this);        
        DynamicLibraryNative.free(handle);
        handle = 0;
    }
    
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        // Son distintos objetos pero si el handle es el mismo se consideran iguales (evitamos duplicados con el mismo handle)
        // pues el LoadLibrary de Win32 devuelve el mismo número siempre (aunque el contador de cargas aumente), 
        // de hecho probablemente sea la dirección de memoria donde se cargó
        return (handle == ((DynamicLibraryImpl)obj).handle);        
    }    
   
    public int hashCode()
    {
        return (int)(handle ^ (handle >>> 32)); // Copiado de Long.hashCode();        
    }  
    
    public int getDefaultCallConv()
    {
        return defaultCallConv;
    }
    
    public void setDefaultCallConv(int callConv)
    {
        CallConvImpl.checkCallConvention(callConv);

        this.defaultCallConv = callConv;
    }
    
    public long getHandle()
    {
        return handle;
    }
    
    public String getName()
    {
        return dllName;
    }
    
    public NativeTypeManager getTypeManager()    
    {
        return typeMgr;
    }
    
    public NativeSignatureManager getSignatureManager()
    {
        return sigDecMgr;
    }
    
    public long getAddress(String nativeNameExpr)    
    {
        if (nativeNameExpr == null) // Si pasamos el null al método nativo casca la JVM
            throw new JNIEasyException("Native name must be not null");
        
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);
        
        return MethodNative.find(handle, nativeName); 
    }
    
    public synchronized DLLBehavior addDLLBehavior(String nativeNameExpr,Class nativeInterf,NativeBehaviorSignature sig)
    {
        if (nativeNameExpr == null) // Si pasamos el null al método nativo MethodNative.find() casca la JVM, aparte de que no nos sirve para nada un null
            throw new JNIEasyException("Native name must be not null");
        
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);        
        
        DLLBehavior method = (DLLBehavior)methods.findBehavior(nativeName,sig);
        if (method != null)
            return method;
               
        // Tenemos la garantía de que la DLL dado un nombre dado nos genera una dirección única, hay equivalencia nombre-dirección (para una DLL dada)
        long address = MethodNative.find(handle, nativeName);
        if (address == 0) throw new JNIEasyException("Not found method: " + nativeName + ", native library: " + dllName);
        
        TypeDLLBehaviorRuntimeImpl typeDec = (TypeDLLBehaviorRuntimeImpl)typeMgr.decBehavior(nativeInterf, sig);
        
        method = (DLLBehavior)typeDec.newProxyValue(new NativeAddressImpl(address), 0, false);
        if (!methods.addBehavior(nativeName,method))
            throw new JNIEasyException("INTERNAL ERROR");

        return method;
    }     
   
    public DLLBehavior addDLLBehavior(String nativeName,NativeBehaviorSignature sig)
    {    
        Class nativeInterf;
        if (sig instanceof NativeConstructorSignature)
            nativeInterf = CPPConstructor.class;        
        else if (sig instanceof NativeMethodSignature)
        {
            if (sig instanceof NativeStaticMethodSignature)
                nativeInterf = CMethod.class;
            else // (sig instanceof NativeInstanceMethodSignature)
                nativeInterf = CPPMethod.class;            
        }
        else // (sig instanceof FieldMethodSignature)
        {
            if (sig instanceof NativeStaticFieldMethodSignature)
                nativeInterf = CFieldMethod.class;
            else
                throw new JNIEasyException("Invalid signature, not exist C++ exported fields");
        }            
        return addDLLBehavior(nativeName,nativeInterf,sig);
    }
    
    public DLLMethod addDLLMethod(String nativeName,NativeMethodSignature sig)
    {    
        Class nativeInterf;
        if (sig instanceof NativeStaticMethodSignature)
            nativeInterf = CMethod.class;
        else // (sig instanceof NativeInstanceMethodSignature)
            nativeInterf = CPPMethod.class;            
        return (DLLMethod)addDLLBehavior(nativeName,nativeInterf,sig);
    }    
    
    public CMethod addCMethod(String name, Object returnType, Object[] params)
    {
        return addCMethod(name,returnType,params,getDefaultCallConv());
    }

    public CMethod addCMethod(String name, Object returnType, Object[] params, int callConv)
    {
        return addCMethod(name,getSignatureManager().decStaticMethod(returnType,params,callConv));
    } 
    
    public CMethod addCMethod(String name, NativeStaticMethodSignature sig)
    {
        return (CMethod)addDLLBehavior(name,CMethod.class,sig);
    }

    public CPPConstructor addCPPConstructor(String name, Class classObj, Object[] params)
    {
        return addCPPConstructor(name,classObj,params,getDefaultCallConv());
    }

    public CPPConstructor addCPPConstructor(String name, Class classObj, Object[] params, int callConv)
    {
        return addCPPConstructor(name,
                getSignatureManager().decConstructor(classObj,params,callConv) 
                );
    }    
    
    public CPPConstructor addCPPConstructor(String name, NativeConstructorSignature sig)
    {
        return (CPPConstructor)addDLLBehavior(name,CPPConstructor.class,sig);
    }
    
    public CPPMethod addCPPMethod(String name, Class classObj, Object returnType, Object[] params)
    {
        return addCPPMethod(name,classObj,returnType,params,getDefaultCallConv());
    }

    public CPPMethod addCPPMethod(String name, Class classObj, Object returnType, Object[] params, int callConv)
    {
        return addCPPMethod(name,getSignatureManager().decInstanceMethod(classObj,returnType,params,callConv));
    }
    
    public CPPMethod addCPPMethod(String name, NativeInstanceMethodSignature sig)
    {
        return (CPPMethod)addDLLBehavior(name,CPPMethod.class,sig);
    }    

    public CFieldMethod addCFieldMethod(String name, Object fieldType)
    {
        return addCFieldMethod(name,fieldType,getDefaultCallConv());
    }

    public CFieldMethod addCFieldMethod(String name, Object fieldType, int callConv)
    {
        return addCFieldMethod(name,getSignatureManager().decStaticFieldMethod(fieldType,callConv));
    } 
    
    public CFieldMethod addCFieldMethod(String name, NativeStaticFieldMethodSignature sig)
    {
        return (CFieldMethod)addDLLBehavior(name,CFieldMethod.class,sig);
    }    
   
    public Collection findBehaviorsByName(String nativeNameExpr)
    {
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);        
        return Collections.unmodifiableCollection(methods.findBehaviorsByName(nativeName));
    }    

    public NativeBehavior findBehaviorByName(String nativeNameExpr, NativeBehaviorSignature sig)
    {        
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);        
        return methods.findBehavior(nativeName,sig);
    }
    
    public NativeBehavior findBehaviorBySignature(String signature)
    {
        return methods.findBehaviorBySignature(signature);
    }
    
    public Collection removeBehaviorsByName(String nativeNameExpr)
    {        
        // No es necesario liberar los objetos método pues la obtención del handle
        // no supone reserva de recursos nativos.
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);        
        return methods.removeBehaviorsByName(nativeName);
    }
    
    public NativeBehavior removeBehaviorByName(String nativeNameExpr, NativeBehaviorSignature sig)
    {        
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);        
        return methods.removeBehavior(nativeName,sig);
    }    

    public void removeAllMethods()
    {
        methods.removeAllBehaviors();
    }
    
    public Map getBehaviorsByName()
    {
        return methods.getMethodsByNameReadOnly();
    }
    
    public Map getBehaviorsBySignature()
    {
        return methods.getMethodsBySignatureReadOnly();
    }
}
