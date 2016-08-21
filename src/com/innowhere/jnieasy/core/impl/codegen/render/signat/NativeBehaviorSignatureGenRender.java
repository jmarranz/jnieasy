/*
 * NativeBehaviorSignatureGenRender.java
 *
 * Created on 30 de junio de 2005, 12:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.render.signat;

import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;



/**
 *
 * @author jmarranz
 */
public class NativeBehaviorSignatureGenRender
{
    protected NativeBehaviorSignatureRender signatureRender;
    protected ReturnDeclarationGenRender retTypeRender;
    protected ParameterDecListGenRender paramListGenRender;
    
    /**
     * Creates a new instance of NativeBehaviorSignatureGenRender
     */
    public NativeBehaviorSignatureGenRender(NativeBehaviorSignatureRender signatureRender)
    {
        this.signatureRender = signatureRender;
        this.retTypeRender = ReturnDeclarationGenRender.newReturnDeclarationGenRender(signatureRender.getReturnDeclarationRender());
        this.paramListGenRender = ParameterDecListGenRender.newParameterDecListGenRender(signatureRender.getParameterDecListRender());
    }
    
    public NativeBehaviorSignatureRender getBehaviorSignatureRender()
    {
        return (NativeBehaviorSignatureRender)signatureRender;
    }
    
    public ReturnDeclarationGenRender getReturnDeclarationGenRender()
    {
        return retTypeRender;
    }
    
    public ParameterDecListGenRender getParameterDecListGenRender()
    {
        return paramListGenRender;
    }
    
    public String getCallConvExpr()
    {
        return signatureRender.getCallConvConstantExpr();
    }
    
    public String getHeaderReturnClassName()
    {
        return retTypeRender.getHeaderReturnClassName();
    }    
    
    public int getFirstParamIndex()
    {
        return signatureRender.getFirstParamIndex();
    }    
    
    public String getCallAndReturnSentence(String methodRef)
    {
        return signatureRender.getNativeBehaviorCallAndReturnSentence(methodRef,false);
    }    
    
    public StringBuffer generateParamDeclarations()
    {
        int index = getFirstParamIndex();
        return getParameterDecListGenRender().generateParamDeclarations( index );    
    }    
    
    public StringBuffer getParameterDecArgList()
    {
        int index = getFirstParamIndex();
        return getParameterDecListGenRender().getParameterDecArgList( index );
    }    
}
