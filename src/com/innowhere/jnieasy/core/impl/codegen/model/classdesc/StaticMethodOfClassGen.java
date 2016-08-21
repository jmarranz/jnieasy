/*
 * StaticMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:51
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.StaticMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.MemberOfClassGenRender;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.StaticMethodOfClassGenRender;


public class StaticMethodOfClassGen extends MethodOfClassGen
{
    
    /**
     * Creates a new instance of StaticMethodOfClassImpl 
     */
    public StaticMethodOfClassGen(StaticMethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
    }
    
    public StaticMethodOfClassImpl getStaticMethodOfClass()
    {
        return (StaticMethodOfClassImpl)accessObject;
    }
    
    public MemberOfClassGenRender newMemberOfClassGenRender()
    {
        return new StaticMethodOfClassGenRender(this);
    }    
}
