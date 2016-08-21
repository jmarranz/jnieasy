/*
 * MethodDec.java
 *
 * Created on 28 de febrero de 2005, 20:31
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MethodOfClassImpl;



public abstract class MethodOfClassGen extends BehaviorOfClassGen
{

    /** Creates a new instance of MethodDec */
    public MethodOfClassGen(MethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
    }
    
    public static MethodOfClassGen newMethodOfClassGen(MethodOfClassImpl method,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return (MethodOfClassGen)method.newMemberOfClassGen(classGen);
    }
    
    public MethodOfClassImpl getMethodOfClass()
    {
        return (MethodOfClassImpl)accessObject;
    }
}
