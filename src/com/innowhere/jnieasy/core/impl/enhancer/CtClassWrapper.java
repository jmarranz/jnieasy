/*
 * CtClassWrapper.java
 *
 * Created on 7 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.enhancer;

/**
 *
 * @author  jmarranz
 */
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativePointerEnhancer;

public class CtClassWrapper extends MetaClassWrapper
{
    protected CtClass ctClass;
    
    /** Creates a new instance of CtClassWrapper */
    public CtClassWrapper(CtClass ctClass)
    {
        this.ctClass = ctClass;
    }
    
    public String getName()
    {
        return ctClass.getName();
    }
    
    public Object getInternalClass()
    {
        return ctClass;
    }        

    public CtClass getCtClass()
    {
        return ctClass;
    }
    
    public boolean isArray()
    {
        return ctClass.isArray();
    }

    public boolean isPrimitive()
    {
        return ctClass.isPrimitive();
    }    
    
    public boolean isInterface()
    {
        return ctClass.isInterface();
    }    
    
    public MetaClassWrapper getComponentType()
    {
        try
        {
            return new CtClassWrapper(ctClass.getComponentType());
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }

    public boolean isAssignableTo(Class classToAssign)
    {
        return isAssignableFrom(classToAssign,ctClass);
    }
    
    public static boolean isAssignableFrom(Class classToAssign,CtClass ctClass)
    {
        // La misma operación que Class.isAssignable() pero sin 
        // usar Class, averigua si un objeto de ctClass es asignable
        // a una referencia de tipo classToAssign
        // No es válido para arrays por usar nombres tipo JNI
        try
        {
            String name = ctClass.getName();
            if (classToAssign.getName().equals(name))
                return true;
            
            if (classToAssign.isInterface())
            {
                CtClass[] interf = ctClass.getInterfaces(); // En el caso de una interface devuelve las interfaces base
                for (int i = 0; i < interf.length; i++)
                {
                    if (isAssignableFrom(classToAssign,interf[i]))
                        return true;
                }
                CtClass superClass = ctClass.getSuperclass();
                if (superClass == null) return false;
                return isAssignableFrom(classToAssign,superClass);  
            }
            else if (ctClass.isInterface())
                return false; // No se puede asignar una interface a una clase
            else // Son ambos clases
            {
                CtClass superClass = ctClass.getSuperclass();
                if (superClass == null) return false;
                return isAssignableFrom(classToAssign,superClass);
            }
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }                

    public MetaFieldWrapper[] getDeclaredFields()
    {
        CtField[] fields = ctClass.getDeclaredFields();
        MetaFieldWrapper[] res = new MetaFieldWrapper[fields.length];
        for(int i = 0; i < res.length; i++)
        {
            res[i] = new CtFieldWrapper(fields[i]);
        }
        return res;
    }
}
