/*
 * ClassWrapper.java
 *
 * Created on 7 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.rt;

/**
 *
 * @author  jmarranz
 */
import java.lang.reflect.*;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativePointerRuntimeImpl;


public class ClassWrapper extends MetaClassWrapper
{
    protected Class clasz;
    
    /** Creates a new instance of ClassWrapper */
    public ClassWrapper(Class clasz)
    {
        this.clasz = clasz;
    }
    
    public String getName()
    {
        return clasz.getName();
    }
    
    public Object getInternalClass()
    {
        return clasz;
    }
    
    public boolean isArray()
    {
        return clasz.isArray();
    }

    public boolean isPrimitive()
    {
        return clasz.isPrimitive();
    }    
    
    public boolean isInterface()    
    {
        return clasz.isInterface();
    }
    
    public MetaClassWrapper getComponentType()
    {
        return new ClassWrapper(clasz.getComponentType());
    }  
   
    public boolean isAssignableTo(Class classToAssign)
    {
        return classToAssign.isAssignableFrom(clasz);
    }
    
    public static boolean isAssignableFrom(Class classToAssign,Class clasz)
    {
        return classToAssign.isAssignableFrom(clasz);
    }
    
 
    public MetaFieldWrapper[] getDeclaredFields()
    {
        Field[] fields = clasz.getDeclaredFields();
        MetaFieldWrapper[] res = new MetaFieldWrapper[fields.length];
        for(int i = 0; i < res.length; i++)
        {
            res[i] = new FieldWrapper(fields[i]);
        }
        return res;
    }    
}
