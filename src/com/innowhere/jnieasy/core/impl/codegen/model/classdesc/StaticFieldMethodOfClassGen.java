/*
 * StaticFieldMethodOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:51
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.StaticFieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.MemberOfClassGenRender;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.StaticFieldMethodOfClassGenRender;


public class StaticFieldMethodOfClassGen extends FieldMethodOfClassGen
{
    
    /**
     * Creates a new instance of StaticFieldMethodOfClassImpl
     */
    public StaticFieldMethodOfClassGen(StaticFieldMethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
        
        NativeBehaviorSignatureImpl sig = getBehaviorSignatureGen().getBehaviorSignature();
        sig.getParameterDec(0).setName("opcode");
        sig.getParameterDec(1).setName("value");        
    }
    
    public StaticFieldMethodOfClassImpl getStaticFieldMethodOfClass()
    {
        return (StaticFieldMethodOfClassImpl)accessObject;
    }
    
    public MemberOfClassGenRender newMemberOfClassGenRender()
    {
        return new StaticFieldMethodOfClassGenRender(this);
    }    
}
