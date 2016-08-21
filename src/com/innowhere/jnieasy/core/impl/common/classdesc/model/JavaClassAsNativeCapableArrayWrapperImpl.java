/*
 * JavaClassAsNativeCapableArrayWrapperImpl.java
 *
 * Created on 17 de junio de 2005, 9:17
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeCapableArrayWrapperImpl extends JavaClassAsNativeObjectArrayWrapperImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeCapableArrayWrapperImpl
     */
    public JavaClassAsNativeCapableArrayWrapperImpl(ClassTypeNativeCapableArrayWrapperCustomImpl classType)
    {
        super(classType);
    }
    
    public JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(EnhancerSharedContext ctx)    
    {
        return new JavaClassAsNativeCapableArrayWrapperEnhancer(this,ctx);
    }   
}
