/*
 * CtFieldWrapper.java
 *
 * Created on 19 de marzo de 2006, 16:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 *
 * @author jmarranz
 */
public class CtFieldWrapper extends MetaFieldWrapper
{
    protected CtField field;
            
    /** Creates a new instance of CtFieldWrapper */
    public CtFieldWrapper(CtField field)
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
        try
        {
            return new CtClassWrapper(field.getType());
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }
}
