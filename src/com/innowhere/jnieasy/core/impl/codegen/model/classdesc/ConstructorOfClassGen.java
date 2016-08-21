/*
 * ConstructorDec.java
 *
 * Created on 28 de febrero de 2005, 20:33
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.MemberOfClassGenRender;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.ConstructorOfClassGenRender;

public class ConstructorOfClassGen extends BehaviorOfClassGen
{
    
    /** Creates a new instance of ConstructorDec */
    public ConstructorOfClassGen(ConstructorOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
    }
    
    public ConstructorOfClassImpl getConstructorOfClass()
    {
        return (ConstructorOfClassImpl)accessObject;
    }    
    
    public MemberOfClassGenRender newMemberOfClassGenRender()
    {
        return new ConstructorOfClassGenRender(this);
    }
    
}
