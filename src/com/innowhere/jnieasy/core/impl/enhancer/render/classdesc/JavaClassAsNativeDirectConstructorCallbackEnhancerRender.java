/*
 * JavaClassAsNativeDirectConstructorCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 19:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectConstructorCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeDirectConstructorCallbackEnhancerImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectConstructorCallbackDescriptor;
import com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeDirectConstructorCallbackImpl;
import javassist.CtClass;
import javassist.Modifier;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectConstructorCallbackEnhancerRender extends JavaClassAsNativeDirectCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectConstructorCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectConstructorCallbackEnhancerRender(JavaClassAsNativeDirectConstructorCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }

    public String getDescriptorClassName()
    {
        return NativeDirectConstructorCallbackDescriptor.class.getName();
    }

    public String getNativeInterfaceName()
    {
        return NativeDirectConstructorCallback.class.getName();
    }    

    public String getNativeDirectCallbackSuperClass()
    {
        return NativeDirectConstructorCallbackImpl.class.getName();
    }

    public void addMethodDispatcher(EnhancerSourceFileContext ctx)
    {
        /*
        public Object jnieasyOnCall(Object[] params)
        {
            return new Clase(params);
        }     
         */   
        String containerClass = behaviorEnhRender.getContainerClassName();

        NativeBehaviorSignatureRender sigRender = behaviorEnhRender.getBehaviorSignatureRender();
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return new " + containerClass + sigRender.renderPassObjectArrayParams("$1") + "; \n" );
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyOnCall", 
            new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object[]")}, null, body.toString());             
    }
    
    public String getRuntimeClassUtil()    
    {
        return NativeDirectConstructorCallbackEnhancerImpl.class.getName();
    }   
}
