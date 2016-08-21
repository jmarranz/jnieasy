/*
 * JavaClassAsNativeCapableArrayWrapperEnhancerRender.java
 *
 * Created on 7 de febrero de 2005, 19:25
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCapableArrayCustomImpl;



public class JavaClassAsNativeCapableArrayWrapperEnhancerRender extends JavaClassAsNativeObjectArrayWrapperEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeCapableArrayWrapperEnhancerRender
     */
    public JavaClassAsNativeCapableArrayWrapperEnhancerRender(JavaClassAsNativeCapableArrayWrapperEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public String getNativeInterfaceName()
    {
        return NativeCapableArray.class.getName();
    }      
    
    public String getSuperClassName()
    {
        return NativeCapableArrayCustomImpl.class.getName();
    }
}
