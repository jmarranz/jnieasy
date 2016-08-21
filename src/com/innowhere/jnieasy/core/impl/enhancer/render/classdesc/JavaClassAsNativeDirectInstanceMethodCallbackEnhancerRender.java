/*
 * JavaClassAsNativeDirectInstanceMethodCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 19:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectInstanceMethodCallbackEnhancer;
import com.innowhere.jnieasy.core.typedec.NativeDirectInstanceMethodCallbackDescriptor;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeDirectInstanceMethodCallbackImpl;
import javassist.CtClass;
import javassist.Modifier;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectInstanceMethodCallbackEnhancerRender extends JavaClassAsNativeDirectMethodCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectInstanceMethodCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectInstanceMethodCallbackEnhancerRender(JavaClassAsNativeDirectInstanceMethodCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public String getDescriptorClassName()
    {
        return NativeDirectInstanceMethodCallbackDescriptor.class.getName();
    }

    public String getNativeInterfaceName()
    {
        return NativeDirectInstanceMethodCallback.class.getName();
    }    

    public String getNativeDirectCallbackSuperClass()
    {
        return NativeDirectInstanceMethodCallbackImpl.class.getName();
    }
    
    public void addMethodDispatcher(EnhancerSourceFileContext ctx)
    {
        /*
            public Object jnieasyOnCall(Object obj,Object[] args)
            {
                ...
            }
         */   
        
        MethodOfClassEnhancerRender behaviorEnhRender = getMethodOfClassEnhancerRender();
        String containerClass = behaviorEnhRender.getContainerClassName();
        String methodName = behaviorEnhRender.getMethodOfClassEnhancer().getMethodOfClass().getName();

        NativeBehaviorSignatureRender sigRender = behaviorEnhRender.getBehaviorSignatureRender();

        String callCode = "((" + containerClass + ")$1)." + methodName + sigRender.renderPassObjectArrayParams("$2");
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  " + sigRender.returnCastToObject(callCode) + "; \n" );
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyOnCall", 
            new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports("java.lang.Object[]")},
                null, body.toString());             
    }    

}
