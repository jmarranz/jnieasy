/*
 * MetaFieldWrapper.java
 *
 * Created on 19 de marzo de 2006, 16:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common;

/**
 *
 * @author jmarranz
 */
public abstract class MetaFieldWrapper
{
    
    /** Creates a new instance of MetaFieldWrapper */
    public MetaFieldWrapper()
    {
    }
    
    public abstract Object getInternalField();
    public abstract boolean isStatic();
    public abstract boolean isTransient();    
    public abstract boolean isFinal();     
    
    public abstract MetaClassWrapper getType();
    
}
