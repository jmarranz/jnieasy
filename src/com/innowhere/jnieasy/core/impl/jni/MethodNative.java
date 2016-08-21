/*
 * MethodNative.java
 *
 * Created on 12 de febrero de 2004, 16:13
 */

package com.innowhere.jnieasy.core.impl.jni;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;

/**
 *
 * @author  jmarranz
 */

public class MethodNative
{
    /** Creates a new instance of MethodNative */
    public MethodNative()
    {
    }
    
    public static native long find(long libHandle, String fname);
    
    public static native void callVoid(long address,int conv,long argsAddr,long stackParamSize);
    public static native boolean callBoolean(long address,int conv,long argsAddr,long stackParamSize);
    public static native byte callByte(long address,int conv,long argsAddr,long stackParamSize);
    public static native char callChar(long address,int conv,long argsAddr,long stackParamSize);
    public static native short callShort(long address,int conv,long argsAddr,long stackParamSize);
    public static native int callInt(long address,int conv,long argsAddr,long stackParamSize);
    public static native long callLong(long address,int conv,long argsAddr,long stackParamSize);    
    public static native float callFloat(long address,int conv,long argsAddr,long stackParamSize);      
    public static native double callDouble(long address,int conv,long argsAddr,long stackParamSize);
    public static long callPointer(long address,int conv,long argsAddr,long stackParamSize)
    {
        if (TypeSizes.getADDRESS() == 4) // 32 bits
            return callInt(address,conv,argsAddr,stackParamSize);
        else
            return callLong(address,conv,argsAddr,stackParamSize);   
    }
}
