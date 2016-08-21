/*
 * TypeNativeVoidRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeVoidImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeVoidRuntimeImpl extends TypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeVoidRuntimeImpl
     */
    public TypeNativeVoidRuntimeImpl(TypeNativeVoidImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public Object push(Object value,NativeBufferIteratorImpl memIt)
    {
       throw new JNIEasyException("Not valid void type");
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
       throw new JNIEasyException("Not valid void type");
    }        
    
    public void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt)
    {
        throw new JNIEasyException("Not valid void type");
    }    
    
    public static boolean checkPositiveSize(long size)
    {
        throw new JNIEasyException("Not supported void with size not 0");
    }    
    
    public void check()
    {        
        // Nada que chequear, redefinimos el chequeo por defecto que investiga sobre tamaños (aquí no tiene sentido)
    }    
}
