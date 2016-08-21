/*
 * DynamicLibraryNormalImpl.java
 *
 * Created on 1 de octubre de 2004, 13:35
 */

package com.innowhere.jnieasy.core.impl.dll;
import com.innowhere.jnieasy.core.impl.jni.JNIEasyNative;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class DynamicLibraryNormalImpl extends DynamicLibraryImpl
{
    
    /**
     * Creates a new instance of DynamicLibraryNormalImpl
     */
    public DynamicLibraryNormalImpl(String dllName,RuntimeManagerImpl rtMgr,DLLManagerImpl dllMgr)
    {
        super(dllName,rtMgr,dllMgr);
    }

    public String getPlatformDLLName(String dllName)
    {
        int pos = dllName.lastIndexOf('.');
        if (pos < 0)
        {
            if (JNIEasyNative.isWindows())
                dllName = dllName + ".dll";
            else if (JNIEasyNative.isMacOSX())
                dllName = "lib" + dllName + ".dylib";
            else 
                dllName = "lib" + dllName + ".so";
        }
       
        return dllName;         
    }  
}
