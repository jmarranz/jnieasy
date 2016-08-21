/*
 * JNIEasy.java
 *
 * Created on 23 de diciembre de 2003, 22:03
 */

package com.innowhere.jnieasy.core.impl;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.cgen.NativeJavaCodeGenerator;
import com.innowhere.jnieasy.core.enh.NativeEnhancer;
import com.innowhere.jnieasy.core.util.NativeCapableFactory;
import com.innowhere.jnieasy.core.impl.codegen.NativeJavaCodeGeneratorImpl;
import com.innowhere.jnieasy.core.mem.DLLManager;
import com.innowhere.jnieasy.core.mem.JNIEasyLibrary;
import com.innowhere.jnieasy.core.mem.LockedRegistry;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeSignatureManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeTypeNativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.LockedRegistryImpl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



public class JNIEasyImpl extends JNIEasy
{
    protected static final Map features = Collections.synchronizedMap(new HashMap());
    
    protected static final String DLLNAME = "JNIEasy";
    protected static String packageRoot = Util.getPackagePart(JNIEasy.class.getName());
    
    protected boolean loaded = false;

    protected ClassTypeManagerImpl classTypeMgr = new ClassTypeManagerImpl(this);    
    protected NativeTypeNativeManagerImpl typeDecMgr = new NativeTypeNativeManagerImpl();
    protected NativeSignatureManagerImpl sigDecMgr = new NativeSignatureManagerImpl();
    protected RuntimeManagerImpl rtMgr = new RuntimeManagerImpl(this,classTypeMgr,typeDecMgr,sigDecMgr);    
    protected NativeEnhancerImpl enhancer = new NativeEnhancerImpl(this);       
    protected NativeJavaCodeGeneratorImpl codeGen = new NativeJavaCodeGeneratorImpl(this);    
    protected LockedRegistryImpl lockObjectRegistry = new LockedRegistryImpl();
    protected JNIEasyLibraryImpl jnieasyLibrary;
    
   
    /** Creates a new instance of JNIEasy */
    public JNIEasyImpl()
    {
    }
    
    public static boolean hasFeature(String name)
    {
        return features.containsKey(name);
    }        
    
    public static Object getFeature(String name)
    {
        return features.get(name);
    }    
    
    public static void setFeature(String name,Object value)
    {
        features.put(name,value);
    }           
        
    public int[] getVersion()
    {
        // Cuando se cambie de versión "grande", cambiar también en la DLL en donde está a pelo también
        // pero no pasamos esta a la DLL para evitar un crackeo fácil
        return new int[] { 1, 2, 1, 0 };
    }

    public void load()
    {
        if (loaded) return;
        //System.loadLibrary(DLLNAME);
        jnieasyLibrary = (JNIEasyLibraryImpl)getDLLManager().get(getJNIEasyLibName());        
        loaded = true;
    }
    
    public boolean isLoaded()
    {
        return loaded;
    }
    
    public static String getJNIEasyLibName()
    {
        return DLLNAME;
    }
    
    public JNIEasyLibrary getJNIEasyLib()
    {
        return jnieasyLibrary;
    }
    
    public NativeManager getNativeManager()
    {
        return rtMgr.getNativeManager();        
    }

    public DLLManager getDLLManager()
    {
        return rtMgr.getDLLManager();
    }
    
    public NativeEnhancer getEnhancer()
    {
        return enhancer;
    }
    
    public NativeJavaCodeGenerator getJavaCodeGenerator()
    {
        return codeGen;
    }
    
    
    public ClassTypeManagerImpl getClassTypeManager()
    {
        return classTypeMgr;
    }
    
    public NativeTypeNativeManagerImpl getTypeManagerImpl()
    {
        return typeDecMgr;
    }
    
    public NativeSignatureManagerImpl getSignatureManagerImpl()
    {
        return sigDecMgr;
    }
    
    public ClassTypeManagerRuntimeImpl getClassTypeManagerRuntime()
    {
        return rtMgr.getClassTypeManagerRuntime();
    }
    
    public NativeTypeManagerRuntimeImpl getTypeManagerRuntime()
    {
        return rtMgr.getTypeManagerRuntime();
    }    
    
    public NativeTypeManager getTypeManager()
    {
        return rtMgr.getTypeManagerRuntime();
    }
    
    public NativeSignatureManager getSignatureManager()
    {
        return rtMgr.getSignatureManagerRuntime();
    }
    
    public NativeVarTypeManager getVarTypeManager()
    {
        return rtMgr.getVarTypeManagerRuntime();
    }    
    
    public NativeCapableFactory getNativeCapableFactory()
    {
        return rtMgr.getNativeCapableFactory();
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {
        return rtMgr;
    }    

    public LockedRegistry getLockedRegistry()
    {
        return lockObjectRegistry;
    }

    public static int[] parseVersion(String version)
    {
        int[] values = new int[2];        
        int pos = version.indexOf('.');
        if (pos == -1) throw new JNIEasyException("Bad version number format");
        String mainNumberStr = version.substring(0, pos);
        values[0] = Integer.parseInt(mainNumberStr);
        String minorNumberStr = version.substring(pos + 1, version.length());
        values[1] = Integer.parseInt(minorNumberStr);         
        return values;
    }        
    
    public static boolean isWindows()
    {
        // Lista completa de símbolos en: "Java System Properties Repository" 
        // http://tolstoy.com/samizdat/sysprops.html
        String soName = System.getProperty("os.name");
        return soName.startsWith("Windows"); // Ej. Windows XP
    }
}
