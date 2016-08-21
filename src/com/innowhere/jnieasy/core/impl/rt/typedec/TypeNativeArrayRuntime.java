/*
 * TypeNativeArrayRuntime.java
 *
 * Created on 5 de enero de 2005, 17:02
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;

public interface TypeNativeArrayRuntime extends TypeCanBeNativeCapableRuntime,TypeNativeArray
{
    public TypeNativeArrayInfoRuntime getTypeNativeArrayInfoRuntime();
    public int getLength(Object arrayValue);   
}
