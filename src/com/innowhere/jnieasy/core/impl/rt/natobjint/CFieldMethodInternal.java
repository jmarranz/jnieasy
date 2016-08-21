/*
 * CFieldMethodInternal.java
 *
 * Created on 8 de marzo de 2006, 22:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjint;

import com.innowhere.jnieasy.core.method.CFieldMethod;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;

/**
 *
 * @author jmarranz
 */
public interface CFieldMethodInternal extends CFieldMethod
{
    public NativeDirectStaticFieldCallback jnieasyNewNativeDirectStaticFieldCallbackAuxiliar();
}
