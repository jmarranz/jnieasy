/*
 * FieldMethodOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:41
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldMethodOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.render.signat.ParameterDecGenRender;
import com.innowhere.jnieasy.core.impl.codegen.render.signat.ParameterDecListGenRender;


public abstract class FieldMethodOfClassGenRender extends BehaviorOfClassGenRender
{
    
    /**
     * Creates a new instance of FieldMethodOfClassGenRender
     */
    public FieldMethodOfClassGenRender(FieldMethodOfClassGen accessObject)
    {
        super(accessObject);
    }
    
    public FieldMethodOfClassGen getFieldMethodOfClassGen()
    {
        return (FieldMethodOfClassGen)accessObject;
    }
    
    public String getMethodName()
    {
        return getFieldMethodOfClassGen().getFieldMethodOfClass().getName();
    }

    public String getReturnTypeClassExp()
    {
        return signatureGenRender.getReturnDeclarationGenRender().getReturnTypeClassExp();
    }    
    
    public StringBuffer getParameterDecArgList()
    {
        // Con el retorno es suficiente
        return new StringBuffer();
    }    
    
}
