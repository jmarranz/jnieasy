/*
 * FieldOfClassEnhancerRender.java
 *
 * Created on 16 de enero de 2005, 11:42
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.EnhancerRenderUtil;
import com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec.VarTypeNativeEnhancerRender;


public abstract class FieldOfClassEnhancerRender extends MemberOfClassEnhancerRender
{
    protected VarTypeNativeEnhancerRender varTypeEnhRender;
    
    /** Creates a new instance of FieldOfClassEnhancerRender */
    public FieldOfClassEnhancerRender(FieldOfClassEnhancer fieldEnh)
    {
        super(fieldEnh);
        
        this.varTypeEnhRender = VarTypeNativeEnhancerRender.newVarTypeNativeEnhancerRender(fieldEnh.getFieldOfClass().getVarTypeNative());          
    }
    
    public FieldOfClassEnhancer getFieldOfClassEnhancer()
    {
        return (FieldOfClassEnhancer)accessObjectEnh;
    }
    
    public VarTypeNativeEnhancerRender getVarTypeNativeEnhancerRender()
    {
        return varTypeEnhRender;
    }
    
    public void enhance(CodeConverter converter,EnhancerSourceFileContext ctx)
    {
        CtField field = getFieldOfClassEnhancer().getCtField();
        CtClass valueClass = field.getDeclaringClass();

        addInternalGet(ctx); 
        addInternalGetStatic(ctx); 
        addInternalSet(ctx); 
        addInternalSetStatic(ctx); 

        converter.replaceFieldRead(field,valueClass,getNameStaticGetMethod());
        converter.replaceFieldWrite(field,valueClass,getNameStaticSetMethod());                
    }    
    
    public abstract String getStaticCodeInitializer();    
 
    public abstract String getInternalGetCode();
    
    public void addInternalGet(EnhancerSourceFileContext ctx)
    {
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer(); 
        //FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
        CtClass declaringClass = fieldEnh.getJavaClassAsNativeCapableEnhancer().getCtClass();
        
        String body = getInternalGetCode();

        EnhancerRenderUtil.addNewMethod(Modifier.PUBLIC | Modifier.FINAL | Modifier.SYNCHRONIZED,
            fieldEnh.getFieldCtClass(), getNameGetMethod(),null,null, body, declaringClass);
    }    
    
    public void addInternalGetStatic(EnhancerSourceFileContext ctx)
    {
        /*  Ej.
            public static final int jnieasy_ClassName_getX(Object target)
            {
                return ((ClassNameFull)target).jnieasy_ClassName_getX();
            }
         */
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();

        //CtField field = fieldEnh.getCtField();
        CtClass fieldClass = fieldEnh.getFieldCtClass(); //field.getType();
        CtClass declaringClass = fieldEnh.getJavaClassAsNativeCapableEnhancer().getCtClass();

        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return ((" + declaringClass.getName() + ")$1)." + getNameGetMethod() + "();\n" );
        body.append( "}" );

        EnhancerRenderUtil.addNewMethod(Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL,
            fieldClass,getNameStaticGetMethod(), new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object")},
            null, body.toString(),declaringClass);
    }
    
    public abstract String getInternalSetCode();
    

    public void addInternalSet(EnhancerSourceFileContext ctx)
    {
        try
        {
            FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();
            CtField field = fieldEnh.getCtField();
            //String fieldClass = fieldEnh.getFieldClassName();
            CtClass decClass = field.getDeclaringClass();
            
            String body = getInternalSetCode();

            EnhancerRenderUtil.addNewMethod(Modifier.PUBLIC | Modifier.FINAL | Modifier.SYNCHRONIZED,
                CtClass.voidType,getNameSetMethod(),new CtClass[]{ fieldEnh.getFieldCtClass() },null, body, decClass);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }        
    }
    
    public void addInternalSetStatic(EnhancerSourceFileContext ctx)
    {
        /*  Ej.
            public static final void jnieasy_ClassName_setX(Object target,int value)
            {
                ((ClassNameFull)target).jnieasy_ClassName_setX(value);
            }
         */
        try
        {
            FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();
            CtField field = fieldEnh.getCtField();
            //String fieldClass = fieldEnh.getFieldClassName();
            CtClass decClass = field.getDeclaringClass();

            StringBuffer body = new StringBuffer();
            body.append( "{ \n" );
            body.append( "  ((" + decClass.getName() + ")$1)." + getNameSetMethod() + "($2);\n" );
            body.append( "}" );

            EnhancerRenderUtil.addNewMethod(Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL,
                CtClass.voidType,getNameStaticSetMethod(),new CtClass[]{ ctx.getCtClassNotUsingImports("java.lang.Object"),fieldEnh.getFieldCtClass() },
                null, body.toString(), decClass);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }        
    }    
    
    public String getNameStaticSetMethod()
    {
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();
        
        String fieldName = fieldEnh.getFieldOfClass().getName();
        JavaClassAsNativeCapableEnhancer classEnhancer = fieldEnh.getJavaClassAsNativeCapableEnhancer();
        
        return "jnieasy_" + classEnhancer.getSimpleName() + "_set" + Util.capitalizeFirst(fieldName);
    }

    public String getNameStaticGetMethod()
    {
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();
        
        String fieldName = fieldEnh.getFieldOfClass().getName();
        JavaClassAsNativeCapableEnhancer classEnhancer = fieldEnh.getJavaClassAsNativeCapableEnhancer();
        
        return "jnieasy_" + classEnhancer.getSimpleName() + "_get" + Util.capitalizeFirst(fieldName);
    }    
    
    public String getNameSetMethod()
    {
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();

        String fieldName = fieldEnh.getFieldOfClass().getName();
        JavaClassAsNativeCapableEnhancer classEnhancer = fieldEnh.getJavaClassAsNativeCapableEnhancer();
        
        return "jnieasy_" + classEnhancer.getSimpleName() + "_set" + Util.capitalizeFirst(fieldName);
    }

    public String getNameGetMethod()
    {
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer();
        
        String fieldName = fieldEnh.getFieldOfClass().getName();
        JavaClassAsNativeCapableEnhancer classEnhancer = fieldEnh.getJavaClassAsNativeCapableEnhancer();
        
        return "jnieasy_" + classEnhancer.getSimpleName() + "_get" + Util.capitalizeFirst(fieldName);
    } 

    public static FieldOfClassEnhancerRender newFieldOfClassEnhancerRender(FieldOfClassEnhancer fieldEnh)
    {
        return fieldEnh.newFieldOfClassEnhancerRender();
    }
}
