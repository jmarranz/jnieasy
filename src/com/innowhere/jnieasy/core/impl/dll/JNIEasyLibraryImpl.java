/*
 * JNIEasyLibraryImpl.java
 *
 * Created on 1 de octubre de 2004, 13:38
 */

package com.innowhere.jnieasy.core.impl.dll;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.mem.JNIEasyLibrary;
import java.lang.reflect.*;
import java.util.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeSignatureManagerRuntimeImpl;

public class JNIEasyLibraryImpl extends DynamicLibraryImpl implements JNIEasyLibrary
{
    protected NativeSignatureManagerRuntimeImpl sigDecMgr;    
    protected JNIEasyLibraryNative jniPort = new JNIEasyLibraryNative(this);
    protected String[] onCallNames = new String[11];    
    protected long[] onCallAddresses = new long[11];
    
    
    /** Creates a new instance of JNIEasyLibraryImpl */
    public JNIEasyLibraryImpl(String dllName,RuntimeManagerImpl rtMgr,DLLManagerImpl dllMgr)
    {
        super(dllName,rtMgr,dllMgr);
        
        this.sigDecMgr = rtMgr.getSignatureManagerRuntime();
        String licenseDir = (String)JNIEasyImpl.getFeature("jnieasy.license.dir"); // Puede ser null
        this.jniPort.registerSelf(licenseDir);       
     
        //boolean isMSVC = JNIEasyNative.compiledWithMSVC();
        
        onCallNames[ClassTypeNativeRuntimeImpl.VOID_RETURN]     = "onCallVoid";
        onCallNames[ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN]  = "onCallBoolean";        
        onCallNames[ClassTypeNativeRuntimeImpl.BYTE_RETURN]     = "onCallByte";
        onCallNames[ClassTypeNativeRuntimeImpl.CHAR_RETURN]     = "onCallChar";        
        onCallNames[ClassTypeNativeRuntimeImpl.SHORT_RETURN]    = "onCallShort";
        onCallNames[ClassTypeNativeRuntimeImpl.INT_RETURN]      = "onCallInt";
        onCallNames[ClassTypeNativeRuntimeImpl.LONG_RETURN]     = "onCallLong";
        onCallNames[ClassTypeNativeRuntimeImpl.FLOAT_RETURN]    = "onCallFloat";
        onCallNames[ClassTypeNativeRuntimeImpl.DOUBLE_RETURN]   = "onCallDouble";
        onCallNames[ClassTypeNativeRuntimeImpl.POINTER_RETURN]  = "onCallPointer";                         


        onCallAddresses[ClassTypeNativeRuntimeImpl.VOID_RETURN]     = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.VOID_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN]  = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.BYTE_RETURN]     = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.BYTE_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.CHAR_RETURN]     = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.CHAR_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.SHORT_RETURN]    = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.SHORT_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.INT_RETURN]      = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.INT_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.LONG_RETURN]     = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.LONG_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.FLOAT_RETURN]    = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.FLOAT_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.DOUBLE_RETURN]   = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.DOUBLE_RETURN]);
        onCallAddresses[ClassTypeNativeRuntimeImpl.POINTER_RETURN]  = MethodNative.find(handle,onCallNames[ClassTypeNativeRuntimeImpl.POINTER_RETURN]);         
    }
    
    public void free()
    {
        jniPort.unregisterSelf();
        super.free();
    }
   
    public long getOnCallAddress(int returnType)
    {
        return onCallAddresses[returnType];
    }
    
    public NativeBehavior findExportedMethodAddress(String signature)
    {
        // Formato: [DLLName:]signatura
        DynamicLibraryImpl dll;
        int pos = signature.indexOf(':');
        if (pos != -1)
        {
            String dllName = signature.substring(0, pos);           
            dll = (DynamicLibraryImpl)dllMgr.find(dllName);
            if (dll == null) return null;
            signature = signature.substring(pos+1,signature.length());            
        }
        else dll = this;
        
        return dll.findBehaviorBySignature(signature);
    }        
    
    public static String getNameToExport(Member memberRef,NativeBehavior method)
    {
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)method.getBehaviorSignature();
        return sig.getNameToExport(memberRef);
    }
    
    public boolean exportBehavior(Member memberRef,NativeBehavior method)
    {    
        String nativeName = getNameToExport(memberRef,method);      
        return exportBehavior(nativeName,method);
    }
    
    public boolean exportBehavior(String nativeNameExpr,NativeBehavior method)
    {      
        String nativeName = getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);        
        rtMgr.getNativeManager().makeNative(method); // si ya es native no hace nada
        return methods.addBehavior(nativeName,method);       
    }
    
    public Map exportClassBehaviorsByDefault(Class cls, int callConv,boolean useReflection,boolean upperClasses, boolean skipNotValid)
    {
        Map callbacks = new HashMap();
        
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++)
        {
            Constructor constructor = constructors[i];
            try
            {
                NativeConstructorSignature sig = sigDecMgr.decConstructor(constructor,callConv);
                NativeBehavior callback;
                if (useReflection)
                    callback = sig.newConstructorReflection();
                else
                    callback = sig.newDirectConstructorCallback();
                String nativeName = getNameToExport(constructor,callback);
                exportBehavior(nativeName,callback);
                callbacks.put(nativeName,callback);
            }
            catch(JNIEasyException ex)
            {                
                // Es normal que haya métodos que no puedan exportarse,
                // aquellos por ejemplo que tienen tipos de datos no conocidos
               // y no enhanced
                if (!skipNotValid) throw ex;
            }
        }
        
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];
            try
            {
                NativeMethodSignature sig = sigDecMgr.decMethod(method,callConv);
                NativeBehavior callback;
                if (useReflection)
                    callback = sig.newMethodReflection(method);
                else
                    callback = sig.newDirectMethodCallback(method);                
                String nativeName = getNameToExport(method,callback);
                exportBehavior(nativeName,callback);
                callbacks.put(nativeName,callback);               
            }
            catch(JNIEasyException ex)
            {                
                // Idem constructores
                if (!skipNotValid) throw ex;
            }            
        }
        
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            Field field = fields[i];
            try
            {
                NativeFieldMethodSignature sig = sigDecMgr.decFieldMethod(field,callConv);
                NativeBehavior callback;
                if (useReflection)
                    callback = sig.newFieldMethodReflection(field);
                else
                    callback = sig.newDirectFieldCallback(field);                
                String nativeName = getNameToExport(field,callback);
                exportBehavior(nativeName,callback);
                callbacks.put(nativeName,callback);               
            }
            catch(JNIEasyException ex)
            {                
                // Idem fields
                if (!skipNotValid) throw ex;
            }            
        }        
        
        if (upperClasses)
        {
            Class clsSuper = cls.getSuperclass();            
            if ((clsSuper != null)&& !clsSuper.equals(Object.class))
            {
                Map callbacksSuper = exportClassBehaviorsByDefault(clsSuper,callConv,useReflection,true,skipNotValid);
                callbacks.putAll(callbacksSuper);
            }
        }

        return callbacks;
    }
    
    public Map unexportClassBehaviorsByDefault(Class cls, boolean upperClasses)
    {
        Map callbacks = new HashMap();
        
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++)
        {
            Constructor constructor = constructors[i];
            try
            {
                NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)sigDecMgr.decConstructor(constructor);
                String name = sig.getNameToExport(constructor);                
                NativeBehavior callback = removeBehaviorByName(name,sig);
                if (callback != null)
                    callbacks.put(name,callback); 
            }
            catch(JNIEasyException ex)
            {                
                // Hay métodos que pueden ser no compatibles
            }            
        }
        
        Method[] methods = cls.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            Method method = methods[i];
            try
            {
                NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)sigDecMgr.decMethod(method);
                String name = sig.getNameToExport(method);                 
                NativeBehavior callback = removeBehaviorByName(name,sig);
                if (callback != null)
                    callbacks.put(name,callback);
            }
            catch(JNIEasyException ex)
            {                
                // Hay métodos que pueden ser no compatibles
            }            
        }
        
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            Field field = fields[i];
            try
            {
                NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)sigDecMgr.decFieldMethod(field);
                String name = sig.getNameToExport(field);                
                NativeBehavior callback = removeBehaviorByName(name,sig);
                if (callback != null)
                    callbacks.put(name,callback);
            }
            catch(JNIEasyException ex)
            {                
                // Hay fields que pueden ser no compatibles
            }            
        }        
        
        if (upperClasses)
        {
            Class clsSuper = cls.getSuperclass();
            // Exportamos java.lang.Object inclusive pues ¿por qué no exportar si se quiere sus métodos?
            if ((clsSuper != null)&& !clsSuper.equals(Object.class))
            {
                Map callbacksSuper = unexportClassBehaviorsByDefault(clsSuper,true);
                callbacks.putAll(callbacksSuper);
            }
        }

        return callbacks;
    }

    // El nombre del método será ofuscado y no se verá tan claramente
    public void checkLicense(int action,int context)
    {
        // Los códigos están definidos en C++ en la clase
        // LicenseValidator
        JNIEasyLibraryNative.prepare(action,context);
    }
    
    // El nombre del método será ofuscado y no se verá tan claramente    
    public int getLicense()
    {
        return JNIEasyLibraryNative.getCode();
    }
    
    public String getLicenseId()    
    {
        return JNIEasyLibraryNative.getLicenseId();
    }

    public String getPlatformDLLName(String dllName)
    {
        // Añade .DLL, .so o .jnilib
        return System.mapLibraryName(dllName);         
    }
}
