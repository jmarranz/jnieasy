/*
 * FieldOfClassAsNativeMultipleFieldContainerEnhancer.java
 *
 * Created on 29 de junio de 2005, 13:57
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import javassist.CtField;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeMultipleFieldContainerEnhancer extends FieldOfClassEnhancer
{
    protected String desiredAlignSizeExpr = Long.toString(TypeSizes.getUNKNOWN_SIZE());   
        
    /**
     * Creates a new instance of FieldOfClassAsNativeMultipleFieldContainerEnhancer
     */
    public FieldOfClassAsNativeMultipleFieldContainerEnhancer(CtField field,FieldOfClassAsNativeMultipleFieldContainerImpl accessObject,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(field,accessObject, classEnhancer);
    }
    
    public JavaClassAsNativeMultipleFieldContainerEnhancer getJavaClassAsMultipleFieldContainerEnhancer()
    {
        return (JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer;
    }
    
    public FieldOfClassAsNativeMultipleFieldContainerImpl getFieldOfClassAsMultipleFieldContainer()
    {
        return (FieldOfClassAsNativeMultipleFieldContainerImpl)memberOfClass;
    }
    
    public String getDesiredAlignSizeExpr()
    {
        return desiredAlignSizeExpr;
    }

    public void setDesiredAlignSizeExpr(String desiredAlignSizeExpr)
    {         
        this.desiredAlignSizeExpr = desiredAlignSizeExpr;
    }        
    
    public FieldOfClassEnhancerRender newFieldOfClassEnhancerRender()
    {
        return new FieldOfClassAsNativeMultipleFieldContainerEnhancerRender(this);
    }
 
        
}
