/*
 * NativeFieldMethodSignatureRender.java
 *
 * Created on 2 de septiembre de 2005, 18:26
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.render;

import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;

/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodSignatureRender extends NativeBehaviorSignatureRender
{
    
    /**
     * Creates a new instance of NativeFieldMethodSignatureRender
     */
    public NativeFieldMethodSignatureRender(NativeFieldMethodSignatureImpl signature)
    {
        super(signature);
    }
    
    public String generateCallParams(boolean enhancer)
    {
        // Sólo se da el caso estático

        ParameterDecListRender paramList = getParameterDecListRender();
        
        ParameterDecRender paramCode = paramList.getParameterDecRender(0);
        ParameterDecRender paramValue = paramList.getParameterDecRender(1);
        
        StringBuffer code = new StringBuffer();
        code.append( paramCode.getParameterDec().getName() + "," );
        code.append( paramValue.getParameterDec().getName() );

        return code.toString();
    }    

}
