/*
 * CallConv.java
 *
 * Created on 27 de enero de 2004, 22:01
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>CallConv</code> interface holds the constants 
 * defining the native method calling conventionalisms.
 * These constants are used when declaring native signatures of methods.
 *
 * @author  Jose M. Arranz Santamaria
 * @see NativeSignatureManager
 * @see NativeBehaviorSignature
 */

public interface CallConv
{
    /**
     * Constant used to specify the standard C calling-convention.
     * The C conventionalism is usually used in the standard C methods.
     * <p>
     * In MSVC methods with C calling-convention are declared with __cdecl.
     */    
    public int C_CALL = 0; // el propio de msvcrt.dll, y en general la API C

    /**
     * Constant used to specify the standard Win32 API calling-convention.
     * The standard conventionalism is usually used in the Win32 API methods.
     * <p>
     * In MSVC methods with standard calling-convention are declared with __stdcall.
     */    
    public int STD_CALL = 1; // Es el del propio JNI y de Win32
}
