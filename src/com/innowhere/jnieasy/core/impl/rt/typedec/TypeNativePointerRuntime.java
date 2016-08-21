/*
 * TypeNativePointerRuntime.java
 *
 * Created on 30 de septiembre de 2005, 12:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNativePointer;

/**
 *
 * @author jmarranz
 */
public interface TypeNativePointerRuntime extends TypeNativePointer,TypeNativeCapableRuntime
{
    public void setAddressedVarTypeNativeObjectRuntime(VarTypeNativeObjectRuntimeImpl addressedVarType);
}
