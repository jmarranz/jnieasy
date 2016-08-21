/*
 * JNIEasyWin32Exception.java
 *
 * Created on 11 de enero de 2004, 13:31
 */

package com.innowhere.jnieasy.core;

/**
 * <code>JNIEasyWin32Exception</code> is the {@link JNIEasyNativeException} 
 * derived class thrown from native code on Win32. 
 * 
 * The native part of JNIEasy
 * catches any type of native exceptions (calling native methods or accessing
 * native memory), gets their exception code (using Win32's 
 * <code>GetExceptionCode()</code>) 
 * showing what type of error happened, and throws a JNIEasyWin32Exception 
 * exception, avoiding a JVM crash. 
 *
 * @author  Jose M. Arranz Santamaria
 */

public class JNIEasyWin32Exception extends JNIEasyNativeException
{
    // Algunas no aparecen en la documentación del SDK pero sí en el WinBase.h
    public static final int EXCEPTION_ACCESS_VIOLATION          = 0xC0000005;
    public static final int EXCEPTION_BREAKPOINT                = 0x80000003;
    public static final int EXCEPTION_DATATYPE_MISALIGNMENT     = 0x80000002;
    public static final int EXCEPTION_SINGLE_STEP               = 0x80000004;
    public static final int EXCEPTION_ARRAY_BOUNDS_EXCEEDED     = 0xC000008C;
    public static final int EXCEPTION_FLT_DENORMAL_OPERAND      = 0xC000008D;
    public static final int EXCEPTION_FLT_DIVIDE_BY_ZERO        = 0xC000008E;
    public static final int EXCEPTION_FLT_INEXACT_RESULT        = 0xC000008F;
    public static final int EXCEPTION_FLT_INVALID_OPERATION     = 0xC0000090;
    public static final int EXCEPTION_FLT_OVERFLOW              = 0xC0000091;
    public static final int EXCEPTION_FLT_STACK_CHECK           = 0xC0000092;
    public static final int EXCEPTION_FLT_UNDERFLOW             = 0xC0000093;
    public static final int EXCEPTION_INT_DIVIDE_BY_ZERO        = 0xC0000094;
    public static final int EXCEPTION_INT_OVERFLOW              = 0xC0000095;
    public static final int EXCEPTION_PRIV_INSTRUCTION          = 0xC0000096;
    public static final int EXCEPTION_IN_PAGE_ERROR             = 0xC0000006;
    public static final int EXCEPTION_ILLEGAL_INSTRUCTION       = 0xC000001D;
    public static final int EXCEPTION_NONCONTINUABLE_EXCEPTION  = 0xC0000025;
    public static final int EXCEPTION_STACK_OVERFLOW            = 0xC00000FD;
    public static final int EXCEPTION_INVALID_DISPOSITION       = 0xC0000026;
    public static final int EXCEPTION_GUARD_PAGE                = 0x80000001;
    public static final int EXCEPTION_INVALID_HANDLE            = 0xC0000008;
    //public static final int EXCEPTION_POSSIBLE_DEADLOCK         STATUS_POSSIBLE_DEADLOCK    No lo encuentro

    
    private int code;

    /**
     * Constructs a new exception with the specified detail message and 
     * native error code.
     * 
     * @param message the detail message.
     * @param code the native error code.
     */            
    public JNIEasyWin32Exception(String message, int code)
    {
        super(message);
        this.code = code;
    }    
    
    /**
     * Returns the native error code.
     * 
     * @return the native error code.
     */            
    public int getCode()
    {
        return code;
    }
    
    /**
     * Returns the detail message string of this exception showing the error code
     * value in hexadecimal format.
     *
     * @return the detail message string of this exception.
     */    
    public String getMessage()
    {
        if (code != 0)
            return super.getMessage() + " code: " + Integer.toHexString(code);
        else
            return super.getMessage();
    }
}
