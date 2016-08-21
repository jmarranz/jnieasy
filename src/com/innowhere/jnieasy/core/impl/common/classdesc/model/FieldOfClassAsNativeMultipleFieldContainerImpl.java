/*
 * FieldOfClassAsNativeMultipleFieldContainerImpl.java
 *
 * Created on 29 de junio de 2005, 12:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeMultipleFieldContainerRuntimeImpl;
import java.lang.reflect.Field;
import javassist.CtField;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeMultipleFieldContainerImpl extends FieldOfClassImpl
{
    protected int index;
    protected int absIndex; // Posición absoluta desde la clase más base
    protected boolean beginUnion = false;
    protected boolean endUnion = false;
    
    /**
     * Creates a new instance of FieldOfClassAsNativeMultipleFieldContainerImpl
     */
    public FieldOfClassAsNativeMultipleFieldContainerImpl(JavaClassAsNativeMultipleFieldContainerImpl javaClass,VarTypeNativeImpl fieldVarType)
    {
        super(javaClass,fieldVarType);
    }
    
    public void setIndex(int index)
    {
        this.index = index;
    }    

    public int getIndex()
    {
        return index;
    }    
        
    public void setAbsIndex(int absIndex)
    {
        this.absIndex = absIndex;
    }        
    
    public int getAbsIndex()
    {
        return absIndex;
    }
    
    public boolean isBeginUnion()
    {
        return beginUnion;
    }
    
    public void setBeginUnion(boolean beginUnion)
    {
        this.beginUnion = beginUnion;
    }
    
    public boolean isEndUnion()
    {
        return endUnion;
    }
    
    public void setEndUnion(boolean endUnion)
    {
        this.endUnion = endUnion;
    }    
    
    public FieldOfClassRuntimeImpl newFieldOfClassRuntime(Field field,JavaClassAsNativeCapableRuntimeImpl javaClass)
    {
        return new FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl(this,field,(JavaClassAsNativeMultipleFieldContainerRuntimeImpl)javaClass);
    }
    
    public FieldOfClassEnhancer newFieldOfClassEnhancer(CtField field,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return new FieldOfClassAsNativeMultipleFieldContainerEnhancer(field,this,(JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer);
    }    
}
