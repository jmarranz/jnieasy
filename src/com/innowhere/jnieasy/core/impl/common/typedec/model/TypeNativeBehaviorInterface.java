/*
 * TypeNativeBehaviorInterface.java
 *
 * Created on 4 de junio de 2005, 15:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;

/**
 *
 * @author jmarranz
 */
public interface TypeNativeBehaviorInterface
{
    public NativeBehaviorSignatureImpl getBehaviorSignature();
    public void setBehaviorSignature(NativeBehaviorSignatureImpl signature);
}
