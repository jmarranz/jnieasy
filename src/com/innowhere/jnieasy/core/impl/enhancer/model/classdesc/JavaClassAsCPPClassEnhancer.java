/*
 * JavaClassAsCPPClassEnhancer.java
 *
 * Created on 1 de abril de 2004, 13:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import javassist.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCPPClassCustomImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsCPPClassImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsCPPClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;





public class JavaClassAsCPPClassEnhancer extends JavaClassAsNativeSeparatedFieldContainerEnhancer
{
   
    /** Creates a new instance of JavaClassAsCPPClassEnhancer */
    public JavaClassAsCPPClassEnhancer(JavaClassAsCPPClassImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }

    public static JavaClassAsCPPClassEnhancer newJavaClassAsCPPClassEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        String className = ctClass.getName();       
        ClassTypeCPPClassCustomImpl classType = ClassTypeCPPClassCustomImpl.registerClassTypeCPPClassCustom(className,ctx.getJNIEasy());
        return (JavaClassAsCPPClassEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass, ctx);
    }   
    
    public ClassTypeCPPClassCustomImpl getClassTypeCPPClassCustom()
    {
        return (ClassTypeCPPClassCustomImpl)getClassTypeNativeCapable();
    }
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsCPPClassEnhancerRender(this);
    }

}
