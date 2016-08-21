/*
 * VarTypeNativeRuntime.java
 *
 * Created on 5 de enero de 2005, 17:26
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.typedec.*;


public interface VarTypeNativeRuntime extends VarTypeNative
{
    public void setVarConv(int varConv);    
    public void checkValue(Object value);
}
