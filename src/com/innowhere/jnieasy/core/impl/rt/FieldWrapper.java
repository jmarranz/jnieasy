/*
 * FieldWrapper.java
 *
 * Created on 19 de marzo de 2006, 16:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 *
 * @author jmarranz
 */
public class FieldWrapper extends MetaFieldWrapper
{
    protected Field field;
            
    /**
     * Creates a new instance of FieldWrapper
     */
    public FieldWrapper(Field field)
    {
        this.field = field;
    }

    public Object getInternalField()
    {
        return field;
    }
    
    public boolean isStatic()
    {
        return Modifier.isStatic(field.getModifiers());
    }
    
    public boolean isTransient()
    {
        return Modifier.isTransient(field.getModifiers());
    }        
    
    public boolean isFinal()
    {
        return Modifier.isTransient(field.getModifiers());
    } 
    
    public MetaClassWrapper getType()
    {
        return new ClassWrapper(field.getType());
    }    
}
