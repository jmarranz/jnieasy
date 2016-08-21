/*
 * JavaClassAsNativeMultipleFieldContainerUnknownEnhancer.java
 *
 * Created on 1 de abril de 2004, 13:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerUnknownImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerUnknownImpl;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeCapableEnhancerXML;
import javassist.CtClass;



public class JavaClassAsNativeMultipleFieldContainerUnknownEnhancer extends JavaClassAsNativeMultipleFieldContainerEnhancer
{
   
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerUnknownEnhancer
     */
    public JavaClassAsNativeMultipleFieldContainerUnknownEnhancer(JavaClassAsNativeMultipleFieldContainerUnknownImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }

    public static JavaClassAsNativeMultipleFieldContainerUnknownEnhancer newJavaClassAsMultipleFieldContainerUnknownEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        ClassTypeNativeMultipleFieldContainerUnknownImpl classType = ClassTypeNativeMultipleFieldContainerUnknownImpl.newClassTypeMultipleFieldContainerUnknown(ctClass.getName(), ctx.getJNIEasy());
        JavaClassAsNativeMultipleFieldContainerUnknownEnhancer javaClassEnh = (JavaClassAsNativeMultipleFieldContainerUnknownEnhancer)newJavaClassAsNativeCapableEnhancer(classType, ctClass, ctx);
        return javaClassEnh;
    }   
    
    public ClassTypeNativeMultipleFieldContainerUnknownImpl getMultipleFieldContainerUnknownType()
    {
        return (ClassTypeNativeMultipleFieldContainerUnknownImpl)getClassTypeNativeCapable();
    }
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
}
