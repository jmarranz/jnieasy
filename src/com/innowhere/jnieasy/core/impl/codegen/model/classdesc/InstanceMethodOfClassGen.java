/*
 * InstanceMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:52
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.InstanceMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.MemberOfClassGenRender;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.InstanceMethodOfClassGenRender;


public class InstanceMethodOfClassGen extends MethodOfClassGen
{
    
    /**
     * Creates a new instance of InstanceMethodOfClassImpl
     */
    public InstanceMethodOfClassGen(InstanceMethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
    }    
    
    public MemberOfClassGenRender newMemberOfClassGenRender()
    {
        return new InstanceMethodOfClassGenRender(this);
    }
    
}
