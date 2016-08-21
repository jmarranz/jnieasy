/*
 * JNIEasyLibraryNative.java
 *
 * Created on 12 de febrero de 2004, 16:24
 */

package com.innowhere.jnieasy.core.impl.jni;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.method.NativeBehavior;

public class JNIEasyLibraryNative
{
    protected JNIEasyLibraryImpl parent;
    
    /** Creates a new instance of JNIEasyLibraryNative */
    public JNIEasyLibraryNative(JNIEasyLibraryImpl parent)
    {
        this.parent = parent;       
    }
 
    public native void registerSelf(String licenseDir); // licenseDir puede ser null
    public native void unregisterSelf();  
    public native static void prepare(int action,int context); // Falso nombre, lo que hace es chequear que la licencia es de desarrollo o de test
    public native static int getCode(); // Falso nombre, devuelve el tipo de licencia usado, debería ser más bien getLicense()
    public native static String getLicenseId();    
    
    // Es llamada desde código nativo de JNIEasy.dll
    public long findExportedMethodAddress(String signature)
    {
        NativeBehavior method = parent.findExportedMethodAddress(signature);
        if (method != null) 
        {
            synchronized(method)
            {            
                return method.jnieasyGetNativeStateManager().getBuffer().getValue();
            }
        }
        return 0;        
    }    
}
