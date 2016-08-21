/*
 * JavaClassAsTypeNativeCapableArrayWrapperEnhancer.java
 *
 * Created on 6 de febrero de 2005, 18:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableArrayWrapperEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;


public class JavaClassAsNativeCapableArrayWrapperEnhancer extends JavaClassAsNativeObjectArrayWrapperEnhancer
{
    
    /** Creates a new instance of JavaClassTypeNativeCapableArrayWrapperEnhancer */
    public JavaClassAsNativeCapableArrayWrapperEnhancer(JavaClassAsNativeCapableArrayWrapperImpl classJava,EnhancerSharedContext ctx)
    {
        super(classJava,ctx);
    }

    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativeCapableArrayWrapperEnhancerRender(this);
    }

}
