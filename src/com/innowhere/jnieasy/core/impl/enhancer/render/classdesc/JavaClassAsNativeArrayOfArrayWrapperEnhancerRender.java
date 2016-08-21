/*
 * JavaClassAsNativeArrayOfArrayWrapperEnhancerRender.java
 *
 * Created on 7 de febrero de 2005, 19:24
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeArrayOfArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeArrayOfArrayCustomImpl;

public class JavaClassAsNativeArrayOfArrayWrapperEnhancerRender extends JavaClassAsNativeObjectArrayWrapperEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeArrayOfArrayWrapperEnhancerRender
     */
    public JavaClassAsNativeArrayOfArrayWrapperEnhancerRender(JavaClassAsNativeArrayOfArrayWrapperEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public String getNativeInterfaceName()
    {
        return NativeArrayOfArray.class.getName();
    }       
    
    public String getSuperClassName()
    {
        return NativeArrayOfArrayCustomImpl.class.getName();
    }
}
