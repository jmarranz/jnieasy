/*
 * StringEncodingUtilImpl.java
 *
 * Created on 6 de enero de 2005, 20:36
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.StringEncoding;


public class StringEncodingImpl
{
    public static final String ANSI_STR = "ansi";
    public static final String UNICODE_STR = "unicode";
    
    /** Creates a new instance of StringEncodingUtilImpl */
    public StringEncodingImpl()
    {
    }

    public static void checkEncoding(int encoding)
    {
        if ((encoding != StringEncoding.ANSI) &&
            (encoding != StringEncoding.UNICODE))
            throw new JNIEasyException("Not valid character encoding");
    }
    
    public static String asString(int encoding)
    {
        if (encoding == StringEncoding.ANSI)
            return "ansi";
        else
            return "unicode";
    }
}
