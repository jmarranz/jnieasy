/*
 * MethodOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:41
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MethodOfClassGen;


public abstract class MethodOfClassGenRender extends BehaviorOfClassGenRender
{
    
    /** Creates a new instance of MethodOfClassGenRender */
    public MethodOfClassGenRender(MethodOfClassGen accessObject)
    {
        super(accessObject);
    }
    
    public MethodOfClassGen getMethodOfClassGen()
    {
        return (MethodOfClassGen)accessObject;
    }
    
    public String getMethodName()
    {
        return getMethodOfClassGen().getMethodOfClass().getName();
    }
   
    public String getReturnTypeClassExp()
    {
        return signatureGenRender.getReturnDeclarationGenRender().getReturnTypeClassExp();
    }    
}
