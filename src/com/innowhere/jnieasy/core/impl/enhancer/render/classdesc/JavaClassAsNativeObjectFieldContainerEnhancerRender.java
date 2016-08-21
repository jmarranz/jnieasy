/*
 * JavaClassAsNativeObjectFieldContainerEnhancerRender.java
 *
 * Created on 29 de septiembre de 2005, 17:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectFieldContainerEnhancer;
import java.util.ArrayList;
import javassist.CannotCompileException;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.Modifier;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeObjectFieldContainerEnhancerRender extends JavaClassAsNativeFieldContainerEnhancerRender
{
    protected FieldOfClassEnhancerRender fieldEnhRender;
    
    /**
     * Creates a new instance of JavaClassAsNativeObjectFieldContainerEnhancerRender
     */
    public JavaClassAsNativeObjectFieldContainerEnhancerRender(JavaClassAsNativeObjectFieldContainerEnhancer classEnhancer)
    {
        super(classEnhancer);
        
        FieldOfClassEnhancer fieldEnh = classEnhancer.getField();
        this.fieldEnhRender = FieldOfClassEnhancerRender.newFieldOfClassEnhancerRender(fieldEnh);        
    }
       
    public void enhanceDynamic(EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnhSuper)
    {
        // Ignoramos classEnhSuper es siempre null  
        JavaClassAsNativeObjectFieldContainerEnhancer classEnhancer = getJavaClassAsObjectFieldContainerEnhancer();
        ArrayList methods = classEnhancer.getEnhanceableBehaviors();  // Los obtenemos antes de añadir los nuevos
        
        CtClass valueClass = classEnhancer.getCtClass();        
        try
        {
            valueClass.setSuperclass(ctx.getCtClassNotUsingImports(getSuperClassName()));
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }
              
        super.enhanceDynamic(ctx, classEnhSuper);        
        
        addInternalGetDefaultTypeMethod(ctx);               
        
        addGetInternalValueMethod(ctx);
        addSetInternalValueMethod(ctx);
        
        enhanceAccessOfFields(methods, ctx);
    }
    
    public JavaClassAsNativeObjectFieldContainerEnhancer getJavaClassAsObjectFieldContainerEnhancer()
    {
        return (JavaClassAsNativeObjectFieldContainerEnhancer)classEnhancer;
    }
  
    public JavaClassAsNativeCapableEnhancer enhanceSuperClass(EnhancerSourceFileContext ctx)
    {
        return null;
    }    
    
    public abstract String getSuperClassName();
    
    public String getFieldsAndMethodsStaticCodeInitializer()
    {       
        return fieldEnhRender.getStaticCodeInitializer();
    }        
    
    public void enhanceFields(CodeConverter converter,EnhancerSourceFileContext ctx)
    {
        fieldEnhRender.enhance(converter, ctx);
    } 
    
    public String getRegisterDLLCode()
    {
        return "";
    }    
    
    public void addGetInternalValueMethod(EnhancerSourceFileContext ctx)
    {
        /*
            public Object jnieasyGetInternalValue();
        */
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer();        
        String name = fieldEnh.getFieldOfClass().getName();
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return this." + name + "; \n" );
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyGetInternalValue",
            null, null, body.toString());
    }   
    
    public void addSetInternalValueMethod(EnhancerSourceFileContext ctx)
    {
        /*
            public void jnieasySetInternalValue(Object newValue);
        */
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer();        
        FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
        String decClass = fieldOfClass.getVarTypeNative().getTypeNative().getClassName();
                
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  this." + fieldOfClass.getName() + " = (" + decClass + ") $1; \n" );
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType, "jnieasySetInternalValue",
            new CtClass[]{ ctx.getCtClassNotUsingImports("java.lang.Object") },
            null, body.toString());
    }     
}
