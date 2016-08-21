/*
 * TypeNativeStaticMethodRuntime.java
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

public interface TypeNativeStaticMethodRuntime extends TypeNativeMethodRuntime, TypeNativeStaticMethod
{
    public void setStaticMethodSignature(NativeStaticMethodSignature signature);        
}
