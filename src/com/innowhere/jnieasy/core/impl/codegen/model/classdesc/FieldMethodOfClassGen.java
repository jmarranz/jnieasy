/*
 * MethodDec.java
 *
 * Created on 28 de febrero de 2005, 20:31
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldMethodOfClassImpl;



public abstract class FieldMethodOfClassGen extends BehaviorOfClassGen
{
    /** Creates a new instance of MethodDec */
    public FieldMethodOfClassGen(FieldMethodOfClassImpl accessObject,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObject,classGen);
    }
    
    public static FieldMethodOfClassGen newFieldMethodOfClassGen(FieldMethodOfClassImpl method,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return (FieldMethodOfClassGen)method.newMemberOfClassGen(classGen);
    }
    
    public FieldMethodOfClassImpl getFieldMethodOfClass()
    {
        return (FieldMethodOfClassImpl)accessObject;
    }
}
