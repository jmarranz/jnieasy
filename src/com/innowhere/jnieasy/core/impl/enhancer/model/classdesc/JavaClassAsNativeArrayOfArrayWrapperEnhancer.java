/*
 * JavaClassAsNativeArrayOfArrayWrapperEnhancer.java
 *
 * Created on 6 de febrero de 2005, 18:41
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeArrayOfArrayWrapperEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;

public class JavaClassAsNativeArrayOfArrayWrapperEnhancer extends JavaClassAsNativeObjectArrayWrapperEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeArrayOfArrayWrapperEnhancer
     */
    public JavaClassAsNativeArrayOfArrayWrapperEnhancer(JavaClassAsNativeArrayOfArrayWrapperImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }

    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeArrayOfArrayWrapperEnhancerRender(this);
    }
} 
