/*
 * JavaClassAsNativeArrayOfArrayWrapperImpl.java
 *
 * Created on 17 de junio de 2005, 9:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeArrayOfArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;


/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeArrayOfArrayWrapperImpl extends JavaClassAsNativeObjectArrayWrapperImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeArrayOfArrayWrapperImpl
     */
    public JavaClassAsNativeArrayOfArrayWrapperImpl(ClassTypeNativeArrayOfArrayWrapperCustomImpl classType)
    {
        super(classType); 
    }
    
    public JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(EnhancerSharedContext ctx)    
    {
        return new JavaClassAsNativeArrayOfArrayWrapperEnhancer(this,ctx);
    }

}
