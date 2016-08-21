/*
 * DynamicLibraryNative.java
 *
 * Created on 13 de enero de 2006, 9:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.jni;

/**
 *
 * @author jmarranz
 */
public class DynamicLibraryNative
{
    public static native long load(String dllName,String platformDLLName);
    public static native boolean free(long handle);
}
