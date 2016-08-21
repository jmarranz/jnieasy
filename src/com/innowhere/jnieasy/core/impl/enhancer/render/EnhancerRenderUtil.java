/*
 * EnhancerRenderUtil.java
 *
 * Created on 14 de marzo de 2005, 21:56
 */

package com.innowhere.jnieasy.core.impl.enhancer.render;

/**
 *
 * @author  jmarranz
 */
import javassist.*;

import com.innowhere.jnieasy.core.*;



public class EnhancerRenderUtil
{
    
    /** Creates a new instance of EnhancerRenderUtil */
    public EnhancerRenderUtil()
    {
    }
    
    
    public static CtField addNewField(int modifiers,CtClass ctFieldType,
        String name,String exprInit,CtClass declaring)
    {
        try
        {
            CtField field = new CtField(ctFieldType,name,declaring);
            field.setModifiers(modifiers);
            declaring.addField(field,CtField.Initializer.byExpr(exprInit));
            return field;
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
    
    public static CtMethod addNewMethod(int modifiers,
        CtClass ctReturnTypeDec,String mname,CtClass[] ctParameters,
        CtClass[] ctExceptions,String body, CtClass declaring)
    {
        try
        {
            if (ctParameters == null)
                ctParameters = new CtClass[0];
            if (ctExceptions == null)
                ctExceptions = new CtClass[0];

            CtMethod method = CtNewMethod.make(modifiers,ctReturnTypeDec,mname, 
                ctParameters,ctExceptions,body,declaring);
            declaring.addMethod(method);
            
            return method;
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }
    
    public static CtConstructor addNewConstructor(int modifiers,
        CtClass[] ctParameters,CtClass[] ctExceptions,String body, CtClass declaring)
    {
        try
        {
            if (ctParameters == null)
                ctParameters = new CtClass[0];
            if (ctExceptions == null)
                ctExceptions = new CtClass[0];
            
            CtConstructor constructor =	CtNewConstructor.make(ctParameters,ctExceptions,body,declaring);
            constructor.setModifiers(modifiers);
            declaring.addConstructor(constructor);           
            return constructor;
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }    
}
