/*
 * DllManager.java
 *
 * Created on 26 de febrero de 2004, 12:59
 */

package com.innowhere.jnieasy.core.impl.dll;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.mem.DLLManager;
import com.innowhere.jnieasy.core.mem.DynamicLibrary;
import java.util.*;
import com.innowhere.jnieasy.core.impl.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import java.io.File;


public class DLLManagerImpl implements DLLManager
{
    protected Map dllListByName = new HashMap();
    protected Map dllListByHandle = new HashMap();    
    protected RuntimeManagerImpl rtMgr;
    protected String javaLibraryPath; // Recuerda el último estado
    protected String[] javaLibraryPathArray;
    
    /** Creates a new instance of DllManager */
    public DLLManagerImpl(RuntimeManagerImpl rtMgr)
    {
        this.rtMgr = rtMgr;
        
        this.javaLibraryPath = getCurrentJavaLibraryPath();
        this.javaLibraryPathArray = parsePaths(javaLibraryPath);
    }
    
    public static String getCurrentJavaLibraryPath()
    {
        String javaLibPath = "";         
        if (JNIEasyImpl.hasFeature("java.library.path"))
            javaLibPath = (String)JNIEasyImpl.getFeature("java.library.path");
        else
            javaLibPath = System.getProperty("java.library.path", "");       
        return javaLibPath;
    }
    
    public String[] getJavaLibraryPathArray()
    {
        String javaLibPath = getCurrentJavaLibraryPath(); // No es null
        if (this.javaLibraryPath.equals(javaLibPath))
            return javaLibraryPathArray; // No ha cambiado
        
        // Ha cambiado
        synchronized(this)
        {
            this.javaLibraryPath = javaLibPath;
            this.javaLibraryPathArray = parsePaths(javaLibPath);
            return javaLibraryPathArray;
        }
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {
        return rtMgr;
    }
    
    public synchronized DynamicLibrary find(String nativeNameExpr)
    {
        String name = parseNameWithMacros(nativeNameExpr);
        return (DynamicLibrary)dllListByName.get(name);       
    }

    public synchronized DynamicLibrary find(long handle)
    {
        return (DynamicLibrary)dllListByHandle.get(new Long(handle));
    }
    
    public synchronized DynamicLibrary get(String nativeNameExpr)
    {
        String name = parseNameWithMacros(nativeNameExpr);
        
        // Asegura que exista un sólo objeto en la lista que represente a la DLL
        // aunque el nombre cambie (por ejemplo usando path absoluto, cambio de mayúsculas etc) 
        DynamicLibrary dllByName = (DynamicLibrary)dllListByName.get(name);
        if (dllByName == null)
        {
            if (name.equals(JNIEasyImpl.getJNIEasyLibName()))
                dllByName = new JNIEasyLibraryImpl(name,rtMgr,this);
            else
                dllByName = new DynamicLibraryNormalImpl(name,rtMgr,this);
            long handle = dllByName.getHandle(); 
            DynamicLibrary dllByHandle = find(handle);
            if (dllByHandle != null) // Ya existe lo que pasa es que registró con una variante de nombre (usando path absoluto por ejemplo o cambiando mayúsculas)
            {
                dllByName.free(); // No nos vale, liberamos el objeto
                dllListByName.put(name,dllByHandle);  // Registramos el nuevo path
                return dllByHandle;
            }

            dllListByName.put(name,dllByName);
            dllListByHandle.put(new Long(handle),dllByName);
        }
        return dllByName;
    }
    
    public synchronized DynamicLibrary remove(String nativeNameExpr)
    {
        String name = parseNameWithMacros(nativeNameExpr);
        
        // NO es pública, para evitar problemas pues por ejemplo una clase custom puede mantener una referencia estática
        // a la librería, es decir quitarla de la lista no supone que se libere con el GC.
        DynamicLibrary dll = (DynamicLibrary)dllListByName.remove(name);
        if (dll != null)
            dllListByHandle.remove(new Long(dll.getHandle()));

        return dll;
    }
    
    public synchronized void remove(DynamicLibrary dll)
    {    
        dllListByHandle.remove(new Long(dll.getHandle())); 
        dllListByName.remove(dll.getName());
    }

    public String parseNameWithMacros(String nativeNameExpr)
    {
        NativeTypeManagerRuntimeImpl typeMgr = getRuntimeManager().getTypeManagerRuntime();
        return typeMgr.parseNameWithMacros(nativeNameExpr);
    }
    
    private static String[] parsePaths(String ldpath) 
    {
	String ps = File.pathSeparator;
	int ldlen = ldpath.length();
	int i, j, n;
	// Count the separators in the path
	i = ldpath.indexOf(ps);
	n = 0;
	while (i >= 0) {
	    n++;
	    i = ldpath.indexOf(ps, i + 1);
	}

	// allocate the array of paths - n :'s = n + 1 path elements
	String[] paths = new String[n + 1];

	// Fill the array with paths from the ldpath
	n = i = 0;
	j = ldpath.indexOf(ps);
	while (j >= 0) {
	    if (j - i > 0) {
	        paths[n++] = ldpath.substring(i, j);
	    } else if (j - i == 0) {
	        paths[n++] = ".";
	    }
	    i = j + 1;
	    j = ldpath.indexOf(ps, i);
	}
	paths[n] = ldpath.substring(i, ldlen);
	return paths;
    }
    
}
