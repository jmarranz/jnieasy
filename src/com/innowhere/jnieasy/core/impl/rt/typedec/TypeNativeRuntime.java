/*
 * TypeNativeRuntime.java
 *
 * Created on 5 de enero de 2005, 17:26
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public interface TypeNativeRuntime extends TypeNative
{
    public TypeNativeImpl getTypeNative();
    public void checkValue(Object value);
    public void check();
}
