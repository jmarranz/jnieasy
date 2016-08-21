/*
 * TypeNativeArrayInterface.java
 *
 * Created on 5 de enero de 2005, 17:02
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;

/**
 *
 * @author  jmarranz
 */


public interface TypeNativeArrayInterface extends TypeCanBeNativeCapableInterface
{
    public TypeNativeArrayInfo getTypeNativeArrayInfo();
}
