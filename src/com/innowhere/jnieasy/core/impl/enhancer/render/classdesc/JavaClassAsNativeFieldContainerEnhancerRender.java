/*
 * JavaClassAsNativeFieldContainerEnhancerRender.java
 *
 * Created on 14 de septiembre de 2005, 12:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeFieldContainerEnhancer;
import java.util.ArrayList;
import javassist.CodeConverter;
import javassist.CtBehavior;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeFieldContainerEnhancerRender extends JavaClassAsNativeCapableEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeFieldContainerEnhancerRender
     */
    public JavaClassAsNativeFieldContainerEnhancerRender(JavaClassAsNativeFieldContainerEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public JavaClassAsNativeFieldContainerEnhancer getJavaClassAsFieldContainerEnhancer()
    {
        return (JavaClassAsNativeFieldContainerEnhancer)classEnhancer;
    }
    
    public abstract void enhanceFields(CodeConverter converter,EnhancerSourceFileContext ctx);
    
    public void enhanceAccessOfFields(ArrayList methods,EnhancerSourceFileContext ctx)
    {
        //JavaClassAsNativeFieldContainerEnhancer classEnhancer = getJavaClassAsFieldContainerEnhancer();

        CodeConverter converter = new CodeConverter();
        enhanceFields(converter, ctx);

        try
        {
            for (int i = 0; i < methods.size(); i++)
            {
                CtBehavior methodOrConst = (CtBehavior)methods.get(i);
                methodOrConst.instrument(converter);
            }
        }
        catch(javassist.CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }        
}
