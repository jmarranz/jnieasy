/*
 * JNIEasyNative.java
 *
 * Created on 22 de septiembre de 2004, 19:40
 */

package com.innowhere.jnieasy.core.impl.jni;

/**
 *
 * @author  jmarranz
 */
public class JNIEasyNative
{
    /** Creates a new instance of JNIEasyNative */
    public JNIEasyNative()
    {
    }
   
    public static native int getPlatformAddressSize();  
    public static native int getWideCharTSize();
    public static native boolean compiledWithMSVC();
    public static native boolean isMacOSX();        
    public static native boolean isWindows();

    
    // Los tamaños de los tipos Java son fijos pero los alineamientos no
    public static native int getJBooleanAlignSize();
    public static native int getJByteAlignSize();
    public static native int getJCharAlignSize();    
    public static native int getJShortAlignSize();    
    public static native int getJIntAlignSize();    
    public static native int getJLongAlignSize();    
    public static native int getJFloatAlignSize();    
    public static native int getJDoubleAlignSize(); 
    
    public static native int testFunc(int param); // Para testear la diferencia de rendimiento via JNI y con JNIEasy
}
