/*
 * JavaClassAsNativeDirectStaticMethodCallbackEnhancerRender.java
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
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticMethodCallbackEnhancer;
import com.innowhere.jnieasy.core.typedec.NativeDirectStaticMethodCallbackDescriptor;
import com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeDirectStaticMethodCallbackImpl;
import javassist.CtClass;
import javassist.Modifier;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticMethodCallbackEnhancerRender extends JavaClassAsNativeDirectMethodCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectStaticMethodCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectStaticMethodCallbackEnhancerRender(JavaClassAsNativeDirectStaticMethodCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }

    public String getDescriptorClassName()
    {
        return NativeDirectStaticMethodCallbackDescriptor.class.getName();
    }

    public String getNativeInterfaceName()
    {
        return NativeDirectStaticMethodCallback.class.getName();
    }

    public String getNativeDirectCallbackSuperClass()
    {
        return NativeDirectStaticMethodCallbackImpl.class.getName();
    }
    
    public void addMethodDispatcher(EnhancerSourceFileContext ctx)
    {
        /*
            public Object jnieasyOnCall(Object[] args)
            {
                ...
            }
         */   
        MethodOfClassEnhancerRender behaviorEnhRender = getMethodOfClassEnhancerRender();
        String methodName = behaviorEnhRender.getMethodOfClassEnhancer().getMethodOfClass().getName();

        NativeBehaviorSignatureRender sigRender = behaviorEnhRender.getBehaviorSignatureRender();
        
        JavaClassAsNativeDirectCallbackEnhancer classEnh = getJavaClassAsNativeDirectCallbackEnhancer();
       
        StringBuffer callCode = new StringBuffer();
        if (classEnh == classEnh.getBehaviorOfClassEnhancer().getJavaClassAsNativeCapableEnhancer())
        {
            // La callback contiene al método no es necesario hacer "Clase." para llamar al método
            // y así además admitimos métodos Java no estáticos
        }
        else
        {
            String containerClass = behaviorEnhRender.getContainerClassName();            
            callCode.append( containerClass + "." );
        }
                
        callCode.append( methodName + sigRender.renderPassObjectArrayParams("$1") );
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  " + sigRender.returnCastToObject(callCode.toString()) + "; \n" );
        body.append( "}" );
       
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyOnCall", 
            new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object[]")}, null, body.toString());             
    }     
}
