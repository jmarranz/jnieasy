/*
 * ClassWrapper.java
 *
 * Created on 7 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.codegen;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;

public class ClassNameWrapper extends MetaClassWrapper
{
    protected String className;
    
    /** Creates a new instance of ClassWrapper */
    public ClassNameWrapper(String className)
    {
        this.className = className;
    }
    
    public String getName()
    {
        return className;
    }
    
    public Object getInternalClass()
    {
        return className;
    }
    
    public boolean isArray()
    {
        int pos = className.lastIndexOf(']');
        return pos != -1;
    }

    public boolean isInterface()    
    {
        throw new JNIEasyException("Unknown type");
    }    
    
    public boolean isPrimitive()
    {
        return ClassTypeNativePrimitiveImpl.isPrimitive(className);
    }    
    
    public MetaClassWrapper getComponentType()
    {
        int pos = className.lastIndexOf('[');
        return new ClassNameWrapper(className.substring(0,pos));
    }  
   
    public boolean isAssignableTo(Class classToAssign)
    {
        // No podemos saberlo
        return false;
    }
    
    public static boolean isAssignableFrom(Class classToAssign,Class clasz)
    {
        // No podemos saberlo
        return false;
    }
   
    public MetaClassWrapper getMetaClassFirstArrayField()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }        

    public MetaClassWrapper getMetaClassFirstPointerField()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
    
    public MetaFieldWrapper[] getDeclaredFields()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
