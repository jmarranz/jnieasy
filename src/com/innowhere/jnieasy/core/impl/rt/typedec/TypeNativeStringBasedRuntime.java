/*
 * TypeNativeStringBasedRuntime.java
 *
 * Created on 5 de enero de 2005, 20:17
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.*;


public interface TypeNativeStringBasedRuntime extends TypeCanBeNativeCapableRuntime,TypeNativeStringBased
{
    public boolean isFixedEncoding();
    public int getDefaultEncoding();
    public boolean isValidEncoding(int encoding);   
    public int getEncoding();
    public void setEncoding(int encoding);    
    public TypeNativeStringBasedInterface getTypeNativeStringBasedInterface();
    public RuntimeManagerImpl getRuntimeManager();
}
