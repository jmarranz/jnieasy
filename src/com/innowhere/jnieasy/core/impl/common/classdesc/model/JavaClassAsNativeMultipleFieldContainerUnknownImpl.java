/*
 * JavaClassAsNativeMultipleFieldContainerUnknownImpl.java
 *
 * Created on 17 de junio de 2005, 9:17
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerUnknownImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerUnknownEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;


/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeMultipleFieldContainerUnknownImpl extends JavaClassAsNativeMultipleFieldContainerImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerUnknownImpl
     */
    public JavaClassAsNativeMultipleFieldContainerUnknownImpl(ClassTypeNativeMultipleFieldContainerUnknownImpl classType)
    {
        super(classType);
    }
    
    public JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(EnhancerSharedContext ctx)    
    {
        return new JavaClassAsNativeMultipleFieldContainerUnknownEnhancer(this,ctx);
    }   
 
}
