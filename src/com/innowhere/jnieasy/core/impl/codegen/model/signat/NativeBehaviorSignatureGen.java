/*
 * NativeBehaviorSignatureGen.java
 *
 * Created on 30 de junio de 2005, 12:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.model.signat;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;

/**
 *
 * @author jmarranz
 */
public class NativeBehaviorSignatureGen
{
    protected NativeBehaviorSignatureImpl signature;
    
    /**
     * Creates a new instance of NativeBehaviorSignatureGen
     */
    public NativeBehaviorSignatureGen(NativeBehaviorSignatureImpl signature)
    {
        this.signature = signature;
    }
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
    
}
