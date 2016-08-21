/*
 * JavaClassAsNativePointerEnhancer.java
 *
 * Created on 6 de febrero de 2005, 18:40
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerCustomImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativePointerEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;


public class JavaClassAsNativePointerEnhancer extends JavaClassAsNativeObjectFieldContainerEnhancer
{
   
    /**
     * Creates a new instance of JavaClassAsNativePointerEnhancer
     */
    public JavaClassAsNativePointerEnhancer(JavaClassAsNativePointerImpl classJava,EnhancerSharedContext ctx)
    {
        super(classJava,ctx);
    }

    public static JavaClassAsNativePointerEnhancer newJavaClassAsNativePointerEnhancer(CtClass ctClass,CtField ctField,EnhancerSourceFileContext ctx)
    {
        ClassTypeNativePointerCustomImpl classType = registerCustomPointerType(ctClass,ctField,ctx);
        return (JavaClassAsNativePointerEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass, ctx.getParentContext());
    }    
    
    public static ClassTypeNativePointerCustomImpl registerCustomPointerType(CtClass ctClass,CtField ctField,EnhancerSourceFileContext ctx)
    {
         // Una vez registrado otras declaraciones podrán usar el registrado
        
        String containerClassName = ctClass.getName();            
        ClassTypeManagerImpl mgr = ctx.getJNIEasy().getClassTypeManager();
        ClassTypeNativePointerCustomImpl classType = (ClassTypeNativePointerCustomImpl)mgr.findClassType(containerClassName);
        if (classType != null) return classType; // Ya registrado
        
        try
        {
            CtClass pointerFieldClass = ctField.getType();
            //String pointerClassName = pointerFieldClass.getName(); 
            ClassTypeNativeObjectImpl pointerClassType = (ClassTypeNativeObjectImpl)ctx.getClassType(pointerFieldClass);
            return ClassTypeNativePointerCustomImpl.registerClassTypeNativePointerCustom(containerClassName,pointerClassType,ctx.getJNIEasy());
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }        
    
    public ClassTypeNativePointerCustomImpl getClassTypeNativePointerCustom()
    {
        return (ClassTypeNativePointerCustomImpl)getClassTypeNativeCapable();
    }
    
    public void setField(FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnh)
    {
        VarTypeNativeImpl fieldVarType = fieldEnh.getFieldOfClass().getVarTypeNative();
        if (!(fieldVarType instanceof VarTypeNativeObjectImpl))
            throw new JNIEasyException("Field must inherit from Object, class: " + getName());

        if (!fieldVarType.byPointer()) 
            throw new JNIEasyException("Pointer field must be by pointer");
        
        super.setField(fieldEnh);     
    }    
    
    public static MetaFieldWrapper getCandidatePointerField(MetaClassWrapper clasz)
    {
        MetaFieldWrapper[] decFields = clasz.getDeclaredFields();
        for(int i=0; i < decFields.length; i++)
        {
            MetaFieldWrapper decField = decFields[i];
            MetaClassWrapper fieldClass = decField.getType();
            if (!fieldClass.isPrimitive() &&
                 FieldOfClassEnhancer.canBeEnhanced(decField))
               return decField;
        }
        
        throw new JNIEasyException("Custom array class " + clasz.getName() + " must have one enhanceable array field");
    }            
    
    public JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender()
    {
        return new JavaClassAsNativePointerEnhancerRender(this);
    }
  
}
