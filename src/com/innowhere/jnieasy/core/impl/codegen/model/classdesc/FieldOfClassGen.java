/*
 * FieldDec.java
 *
 * Created on 28 de febrero de 2005, 20:27
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.MemberOfClassGenRender;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.FieldOfClassGenRender;


public class FieldOfClassGen extends MemberOfClassGen
{
    /** Creates a new instance of FieldDec */
    public FieldOfClassGen(FieldOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
    }   
    
    public FieldOfClassImpl getFieldOfClass()
    {
        return (FieldOfClassImpl)accessObject;
    }
    
    public MemberOfClassGenRender newMemberOfClassGenRender()
    {
        return new FieldOfClassGenRender(this);
    }
}
