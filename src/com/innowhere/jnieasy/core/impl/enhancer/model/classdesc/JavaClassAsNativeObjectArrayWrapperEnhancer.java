/*
 * ClassArrayEnhancer.java
 *
 * Created on 25 de marzo de 2004, 18:23
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;



public abstract class JavaClassAsNativeObjectArrayWrapperEnhancer extends JavaClassAsNativeObjectFieldContainerEnhancer
{
    /** Creates a new instance of ClassArrayEnhancer */
    public JavaClassAsNativeObjectArrayWrapperEnhancer(JavaClassAsNativeObjectArrayWrapperImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }
    
    public static JavaClassAsNativeObjectArrayWrapperEnhancer newJavaClassAsNativeObjectArrayEnhancer(CtClass ctClass,CtField ctField,EnhancerSourceFileContext ctx)
    {
        ClassTypeNativeObjectArrayWrapperImpl classType = registerCustomObjectArrayWrapperType(ctClass,ctField,ctx);
        return (JavaClassAsNativeObjectArrayWrapperEnhancer)newJavaClassAsNativeCapableEnhancer(classType,ctClass, ctx.getParentContext());
    }    
    
    public static ClassTypeNativeObjectArrayWrapperImpl registerCustomObjectArrayWrapperType(CtClass ctClass,CtField ctField,EnhancerSourceFileContext ctx)
    {
         // Una vez registrado otras declaraciones podrán usar el registrado
        
        String containerClassName = ctClass.getName();            
        ClassTypeManagerImpl mgr = ctx.getJNIEasy().getClassTypeManager();
        ClassTypeNativeObjectArrayWrapperImpl classType = (ClassTypeNativeObjectArrayWrapperImpl)mgr.findClassType(containerClassName);
        if (classType != null) return classType; // Ya registrado
        
        try
        {
            CtClass arrayFieldClass = ctField.getType();
            CtClass compArrayClass = arrayFieldClass.getComponentType();
            String arrayClassName = arrayFieldClass.getName();            

            ClassTypeNativeImpl compType = ctx.getClassType(compArrayClass);

            if (compArrayClass.isArray())
                return ClassTypeNativeArrayOfArrayWrapperCustomImpl.registerClassTypeNativeArrayOfArrayWrapperCustom(containerClassName,arrayClassName,(ClassTypeNativeArrayImpl)compType,ctx.getJNIEasy());
            else
                return ClassTypeNativeCapableArrayWrapperCustomImpl.registerClassTypeNativeCapableArrayWrapperCustom(containerClassName,arrayClassName,(ClassTypeNativeCapableImpl)compType,ctx.getJNIEasy());
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }        
    
    public ClassTypeNativeObjectArrayWrapperImpl getObjectArrayWrapperType()
    {
        return (ClassTypeNativeObjectArrayWrapperImpl)getClassTypeNativeCapable();
    }
    
    public void setField(FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnh)
    {
        VarTypeNativeImpl fieldVarType = fieldEnh.getFieldOfClass().getVarTypeNative();
        if (!(fieldVarType instanceof VarTypeNativeArrayImpl))
            throw new JNIEasyException("Field must be an array, class: " + getName());

        fieldVarType.setVarConv(VarTypeNative.BY_VALUE);
        
//        if (!fieldVarType.byValue()) 
//            throw new JNIEasyException("Array field must be by value");
        
        super.setField(fieldEnh);  
    }    
    
    public static MetaFieldWrapper getCandidateArrayField(MetaClassWrapper clasz)
    {
        // útil en arrays custom
        MetaFieldWrapper[] decFields = clasz.getDeclaredFields();
        for(int i=0; i < decFields.length; i++)
        {
            MetaFieldWrapper decField = decFields[i];
            if (decField.getType().isArray() && 
                  FieldOfClassEnhancer.canBeEnhanced(decField))
               return decField;
        }

        throw new JNIEasyException("Custom array class " + clasz.getName() + " must have one enhanceable array field");
    }    

}
