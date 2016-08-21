/*
 * NativeMethodSignatureRender.java
 *
 * Created on 28 de marzo de 2005, 18:03
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.*;

/**
 *
 * @author  jmarranz
 */


public abstract class NativeMethodSignatureRender extends NativeBehaviorSignatureRender
{

    /**
     * Creates a new instance of NativeMethodSignatureRender
     */
    public NativeMethodSignatureRender(NativeMethodSignatureImpl signature)
    {
        super(signature);
    }

}
