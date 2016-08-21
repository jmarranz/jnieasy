/*
 * FieldOfClassAsNativeObjectFieldContainerImpl.java
 *
 * Created on 29 de septiembre de 2005, 14:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeObjectFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassAsNativeObjectFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectFieldContainerRuntimeImpl;
import java.lang.reflect.Field;
import javassist.CtField;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeObjectFieldContainerImpl extends FieldOfClassImpl
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeObjectFieldContainerImpl
     */
    public FieldOfClassAsNativeObjectFieldContainerImpl(JavaClassAsNativeObjectFieldContainerImpl javaClass,VarTypeNativeObjectImpl fieldVarType)
    {
        super(javaClass,fieldVarType);
    }
    
    public FieldOfClassRuntimeImpl newFieldOfClassRuntime(Field field,JavaClassAsNativeCapableRuntimeImpl javaClass)
    {
        return new FieldOfClassAsNativeObjectFieldContainerRuntimeImpl(this,field,(JavaClassAsNativeObjectFieldContainerRuntimeImpl)javaClass);
    } 
    
    public FieldOfClassEnhancer newFieldOfClassEnhancer(CtField field,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return new FieldOfClassAsNativeObjectFieldContainerEnhancer(field,this,(JavaClassAsNativeObjectFieldContainerEnhancer)classEnhancer);
    }    
}
