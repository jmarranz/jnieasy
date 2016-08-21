/*
 * TypeNativeFieldMethodRuntime.java
 *
 * Created on 13 de enero de 2005, 11:04
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.typedec.*;

public interface TypeNativeFieldMethodRuntime extends TypeNativeBehaviorRuntime,TypeNativeFieldMethod
{
    public void setFieldMethodSignature(NativeFieldMethodSignature signature);  
}
