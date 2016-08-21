/*
 * JavaClassAsNativeDirectCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 17:34
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeDirectCallbackEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.Modifier;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectCallbackEnhancerRender extends JavaClassAsNativeCapableEnhancerRender
{
    protected BehaviorOfClassEnhancerRender behaviorEnhRender;
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectCallbackEnhancerRender(JavaClassAsNativeDirectCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
        
        BehaviorOfClassEnhancer behaviorEnh = classEnhancer.getBehaviorOfClassEnhancer();
        this.behaviorEnhRender = BehaviorOfClassEnhancerRender.newBehaviorOfClassEnhancerRender(behaviorEnh);
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer getJavaClassAsNativeDirectCallbackEnhancer()
    {
        return (JavaClassAsNativeDirectCallbackEnhancer)classEnhancer;
    }
    
    public abstract String getRuntimeClassUtil();
    
    public String getFieldsAndMethodsStaticCodeInitializer()
    {
        return getRuntimeClassUtil() + "." + behaviorEnhRender.getAddMethodCall(true);        
    }    

    public String getInitRegistrationTypeCode()
    {
        int licenseUsedByEnhancer = classEnhancer.getCurrentLicenseUsedByEnhancer();
        return "(" + getDescriptorClassName() + ")" + NativeDirectCallbackEnhancerImpl.class.getName() + ".initRegistrationNativeDirectCallbackType(this," + licenseUsedByEnhancer + ",jnieasyRoot); \n";
    }

    public JavaClassAsNativeCapableEnhancer enhanceSuperClass(EnhancerSourceFileContext ctx)
    {
        // No hay clase base
        return null;
    }    
    
    public void enhanceDynamic(EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnhSuper)
    {
        // Ignoramos classEnhSuper es siempre null        
        CtClass valueClass = classEnhancer.getCtClass();
        //CtBehavior[] methods = valueClass.getDeclaredBehaviors();  // Los obtenemos antes de añadir los nuevos
        
        try
        {
            valueClass.setSuperclass(ctx.getCtClassNotUsingImports(getNativeDirectCallbackSuperClass()));
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }
              
        super.enhanceDynamic(ctx, classEnhSuper);        
        
        addInternalGetDefaultTypeMethod(ctx);               
        addGetBehaviorSignature(ctx);
        
        //enhanceAccessOfFields(methods, ctx);
        
        addMethodDispatcher(ctx);
    }
       
    public void addGetBehaviorSignature(EnhancerSourceFileContext ctx)
    {
        /* 
        public NativeBehaviorSignature getBehaviorSignature() 
        */
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return jnieasyClassInfo.getBehaviorSignature(); \n" );
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports(NativeBehaviorSignature.class.getName()), "getBehaviorSignature", 
            null, null, body.toString());        
    }    
 
    public String getInternalNativeInterfaceName()    
    {
        return NativeCapableInternal.class.getName();
    }
    
    public String getRegisterDLLCode()
    {
        return "";
    }
    
    public abstract String getNativeDirectCallbackSuperClass(); 
    public abstract void addMethodDispatcher(EnhancerSourceFileContext ctx);
}
