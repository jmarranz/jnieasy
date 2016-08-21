/*
 * MetaClassWrapper.java
 *
 * Created on 7 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.common;

/**
 *
 * @author  jmarranz
 */
public abstract class MetaClassWrapper
{
    /** Creates a new instance of MetaClassWrapper */
    public MetaClassWrapper()
    {
    }
    
    public abstract String getName();
    
    public abstract Object getInternalClass();
    
    public abstract boolean isArray();
    
    public abstract boolean isPrimitive();
    
    public abstract boolean isInterface();
    
    public abstract MetaClassWrapper getComponentType();
    
   
    public abstract boolean isAssignableTo(Class classToAssign);
    
    public static boolean isAssignableFrom(Class classToAssign,MetaClassWrapper clasz)
    {
        return clasz.isAssignableTo(classToAssign);
    }
    
    public abstract MetaFieldWrapper[] getDeclaredFields();

}
