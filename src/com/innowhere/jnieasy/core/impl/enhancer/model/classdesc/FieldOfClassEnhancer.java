/*
 * FieldDec.java
 *
 * Created on 28 de febrero de 2005, 20:27
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;

public abstract class FieldOfClassEnhancer extends MemberOfClassEnhancer
{

    /** Creates a new instance of FieldDec */
    public FieldOfClassEnhancer(CtField field,FieldOfClassImpl accessObject,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(field,accessObject,classEnhancer);
    }    
    
    public static FieldOfClassEnhancer newFieldOfClassEnhancer(FieldOfClassImpl fieldOfClass,CtField ctField,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return fieldOfClass.newFieldOfClassEnhancer(ctField,classEnhancer);
    }
    
    public static FieldOfClassEnhancer newFieldOfClassEnhancer(JavaClassAsNativeCapableEnhancer javaClassEnh,CtField ctField,EnhancerSourceFileContext ctx)
    {
        CtClass fieldCtClass = getFieldCtClass(ctField);
        
        ClassTypeNativeImpl fieldType = ctx.getClassType(fieldCtClass);

        VarTypeNativeImpl varType = VarTypeNativeImpl.newVarTypeNative(fieldType);
        FieldOfClassImpl fieldOfClass = FieldOfClassImpl.newFieldOfClass(javaClassEnh.getJavaClassAsNativeCapable(),varType);
        return fieldOfClass.newFieldOfClassEnhancer(ctField,javaClassEnh);
    }   
    
    public void init()    
    {
        getFieldOfClass().setName(getCtField().getName());
    }    
    
    public FieldOfClassImpl getFieldOfClass()
    {
        return (FieldOfClassImpl)memberOfClass;
    }
    
    public CtField getCtField()
    {
        return (CtField)ctMember;
    }        
    
    public CtClass getFieldCtClass()
    {
        try
        {
            return getCtField().getType(); 
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    

    public String getFieldClassName()
    {
        return getFieldCtClass().getName(); 
    }
    
    public static CtField getDeclaredField(CtClass ctClass,String fieldName)
    {
        try
        {
            return ctClass.getDeclaredField(fieldName);
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public static CtClass getFieldCtClass(CtField field)
    {
        try
        {
            return field.getType(); 
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }        
    
    public static boolean canBeEnhanced(MetaFieldWrapper field)
    {
        if (!field.isStatic() && !field.isTransient()
            && !field.isFinal())
            return true;
        // En el caso de final no es enhanceable porque al hacer un 
        // get supone que la memoria nativa se copia al atributo
        // (violación de final) y en el caso de set obviamente
        // tiende a modificarlo. En definitiva no podría ni leerse
        // que es lo que en teoría admite el final
        // Un atributo privado sí es enhanceable 
        return false;
    }    
    
    public static boolean canBeEnhanced(CtField field)
    {
        return canBeEnhanced(new CtFieldWrapper(field));
    }

    public boolean isEmbedded()
    {
        return (getFieldOfClass().getVarTypeNative().getVarConv() == VarTypeNative.BY_VALUE);
    }           

    public abstract FieldOfClassEnhancerRender newFieldOfClassEnhancerRender();
   
}
