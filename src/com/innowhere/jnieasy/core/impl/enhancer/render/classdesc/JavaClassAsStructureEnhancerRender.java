/*
 * JavaClassAsStructureEnhancerRender.java
 *
 * Created on 25 de marzo de 2004, 18:23
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsStructureEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.StructureEnhancerImpl;
import com.innowhere.jnieasy.core.typedec.StructureDescriptor;


public class JavaClassAsStructureEnhancerRender extends JavaClassAsNativeSeparatedFieldContainerEnhancerRender
{
    
    /** Creates a new instance of JavaClassAsStructureEnhancerRender */
    public JavaClassAsStructureEnhancerRender(JavaClassAsStructureEnhancer classEnhancer)
    {
        super(classEnhancer);
    }

    public String getNativeInterfaceName()
    {
        return Structure.class.getName();
    }    

    public String getDescriptorClassName()
    {
        return StructureDescriptor.class.getName();
    }

    public String getRegisterClassTypeCall()    
    {
        return StructureEnhancerImpl.class.getName() + ".initRegistrationStructureType";
    }
}
