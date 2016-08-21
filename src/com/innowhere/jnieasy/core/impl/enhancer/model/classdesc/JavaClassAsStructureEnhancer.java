/*
 * JavaClassAsStructureEnhancer.java
 *
 * Created on 25 de marzo de 2004, 18:23
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsStructureImpl;
import javassist.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeStructureCustomImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsStructureEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;



public class JavaClassAsStructureEnhancer extends JavaClassAsNativeSeparatedFieldContainerEnhancer
{
    /** Creates a new instance of JavaClassAsStructureEnhancer */
    public JavaClassAsStructureEnhancer(JavaClassAsStructureImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }
    
    public static JavaClassAsStructureEnhancer newJavaClassAsStructureEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        String className = ctClass.getName();              
        ClassTypeStructureCustomImpl classType = ClassTypeStructureCustomImpl.registerClassTypeStructureCustom(className,ctx.getJNIEasy());
        return (JavaClassAsStructureEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass,ctx);
    }

    public ClassTypeStructureCustomImpl getClassTypeStructureCustom()
    {
        return (ClassTypeStructureCustomImpl)getClassTypeNativeCapable();
    }

    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsStructureEnhancerRender(this);
    }    

}
