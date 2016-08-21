/*
 * TypeNativeStaticFieldMethodRuntime.java
 *
 * Created on 13 de enero de 2005, 11:04
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.typedec.*;


public interface TypeNativeStaticFieldMethodRuntime extends TypeNativeFieldMethodRuntime, TypeNativeStaticFieldMethod
{
    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignature signature);        
}
