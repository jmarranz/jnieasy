/*
 * Platform.java
 *
 * Created on 10 de enero de 2004, 12:15
 */

package com.innowhere.jnieasy.core.impl.mem;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.jni.JNIEasyNative;

/**
 *
 * @author  jmarranz
 */
/*
 Tipos declarados en: jni.h
    typedef unsigned char	jboolean;
    typedef unsigned short	jchar;
    typedef short		jshort;
    typedef float		jfloat;
    typedef double		jdouble;

    typedef jint            jsize;

 Tipos declarados en:  win32/jni_md.h
    typedef long jint;
    typedef __int64 jlong;
    typedef signed char jbyte;
*/

public class TypeSizes
{
    private TypeSizes()
    {
    }

    private static long WCHAR_T_SIZE = JNIEasyNative.getWideCharTSize(); // Puede cambiarse


    protected static final long UNKNOWN_SIZE = -1;
    protected static final long ADDRESS = JNIEasyNative.getPlatformAddressSize(); // El tipo de procesador (4 bytes = 32 bits), el tamaño de la palabra (word) de la plataforma

    // Tamaños de los tipos Java
    protected static final long BOOLEAN = 1;
    protected static final long BYTE    = 1;
    protected static final long CHAR    = 2;
    protected static final long SHORT   = 2;
    protected static final long INT     = 4;
    protected static final long LONG    = 8;
    protected static final long FLOAT   = 4;
    protected static final long DOUBLE  = 8;

    // Los tamaños de los tipos de datos Java están claros pero los alineamientos podrían ser diferentes
    protected static final long BOOLEAN_ALIGN = JNIEasyNative.getJBooleanAlignSize();
    protected static final long BYTE_ALIGN    = JNIEasyNative.getJByteAlignSize();
    protected static final long CHAR_ALIGN    = JNIEasyNative.getJCharAlignSize();
    protected static final long SHORT_ALIGN   = JNIEasyNative.getJShortAlignSize();
    protected static final long INT_ALIGN     = JNIEasyNative.getJIntAlignSize();
    protected static final long LONG_ALIGN    = JNIEasyNative.getJLongAlignSize();
    protected static final long FLOAT_ALIGN   = JNIEasyNative.getJFloatAlignSize();
    protected static final long DOUBLE_ALIGN  = JNIEasyNative.getJDoubleAlignSize();

    protected static final long STACK_ALIGN = (ADDRESS == 8) || JNIEasyNative.isMacOSX() ? 16 : 4;

    public static long getUNKNOWN_SIZE()
    {
        return UNKNOWN_SIZE;
    }

    public static long getADDRESS()
    {
        return ADDRESS;
    }

    public static long getWCharTSize()
    {
        return WCHAR_T_SIZE;
    }

    public static void setWCharTSize(long value)
    {
        if ((value != 2)&&(value != 4))
            throw new JNIEasyException("Only 2 and 4 bytes are valid values to the wchar_t memory size");

        WCHAR_T_SIZE = value;
    }

    public static long getBooleanSize()
    {
        return BOOLEAN;
    }

    public static long getByteSize()
    {
        return BYTE;
    }

    public static long getCharSize()
    {
        return CHAR;
    }

    public static long getShortSize()
    {
        return SHORT;
    }

    public static long getIntSize()
    {
        return INT;
    }

    public static long getLongSize()
    {
        return LONG;
    }

    public static long getFloatSize()
    {
        return FLOAT;
    }

    public static long getDoubleSize()
    {
        return DOUBLE;
    }

    public static long getBooleanAlignSize()
    {
        return BOOLEAN_ALIGN;
    }

    public static long getByteAlignSize()
    {
        return BYTE_ALIGN;
    }

    public static long getCharAlignSize()
    {
        return CHAR_ALIGN;
    }

    public static long getShortAlignSize()
    {
        return SHORT_ALIGN;
    }

    public static long getIntAlignSize()
    {
        return INT_ALIGN;
    }

    public static long getLongAlignSize()
    {
        return LONG_ALIGN;
    }

    public static long getFloatAlignSize()
    {
        return FLOAT_ALIGN;
    }

    public static long getDoubleAlignSize()
    {
        return DOUBLE_ALIGN;
    }

    public static long getStackAlign()
    {
        return STACK_ALIGN;
    }
}
