/*
 * JavaClassAsUnionEnhancer.java
 *
 * Created on 1 de abril de 2004, 13:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import javassist.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeUnionCustomImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsUnionImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsUnionEnhancerRender;


public class JavaClassAsUnionEnhancer extends JavaClassAsNativeMultipleFieldContainerEnhancer
{
   
    /** Creates a new instance of JavaClassAsUnionEnhancer */
    public JavaClassAsUnionEnhancer(JavaClassAsUnionImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }

    public static JavaClassAsUnionEnhancer newJavaClassAsUnionEnhancer(CtClass ctClass,EnhancerSharedContext ctx)
    {
        // Una vez registrado otras declaraciones podrán usar el registrado
        String className = ctClass.getName();       
        ClassTypeUnionCustomImpl classType = ClassTypeUnionCustomImpl.registerClassTypeUnionCustom(className,ctx.getJNIEasy());
        return (JavaClassAsUnionEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass, ctx);
    }   
    
    public void addField(FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnh)
    {    
        super.addField(fieldEnh);

        FieldOfClassAsNativeMultipleFieldContainerImpl field = fieldEnh.getFieldOfClassAsMultipleFieldContainer();
        int count = fields.size();
        if (count == 1) // Ha sido el primero (y por ahora el último)
        {
            field.setBeginUnion(true);
            field.setEndUnion(true);
        }
        else // 2 en adelante
        {
            field.setEndUnion(true);
            // El previo ya no es el último
            FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnhPrev = (FieldOfClassAsNativeMultipleFieldContainerEnhancer)fields.get(count - 2);
            FieldOfClassAsNativeMultipleFieldContainerImpl fieldPrev = fieldEnhPrev.getFieldOfClassAsMultipleFieldContainer();            
            fieldPrev.setEndUnion(false);            
        }
    }    
    
    public ClassTypeUnionCustomImpl getClassTypeUnionCustom()
    {
        return (ClassTypeUnionCustomImpl)getClassTypeNativeCapable();
    }
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsUnionEnhancerRender(this);
    }

}
