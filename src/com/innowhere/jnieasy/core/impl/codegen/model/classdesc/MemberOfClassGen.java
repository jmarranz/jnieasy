/*
 * MemberOfClassGen.java
 *
 * Created on 28 de febrero de 2005, 20:33
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MemberOfClassImpl;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.MemberOfClassGenRender;


public abstract class MemberOfClassGen
{
    protected JavaClassAsNativeMultipleFieldContainerGen classGen;
    protected MemberOfClassImpl accessObject;
    
    /** Creates a new instance of MemberOfClassGen */
    public MemberOfClassGen(MemberOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        this.accessObject = accessObject;
        this.classGen = classGen;
    }
    
    public MemberOfClassImpl getMemberOfClass()
    {
        return accessObject;
    }

    public JavaClassAsNativeMultipleFieldContainerGen getJavaClassAsMultipleFieldContainerGen()
    {
        return classGen;
    }
    
    public abstract MemberOfClassGenRender newMemberOfClassGenRender();   
}
