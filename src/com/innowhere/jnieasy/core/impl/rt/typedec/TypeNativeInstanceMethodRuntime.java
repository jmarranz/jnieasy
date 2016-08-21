/*
 * TypeNativeMethodRuntime.java
 *
 * Created on 13 de enero de 2005, 11:04
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.method.*;

public interface TypeNativeInstanceMethodRuntime extends TypeNativeMethodRuntime, TypeNativeInstanceMethod
{
    public void setInstanceMethodSignature(NativeInstanceMethodSignature signature);        
}
