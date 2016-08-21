/*
 * ClassTypeNativeArrayInfo.java
 *
 * Created on 16 de mayo de 2005, 19:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;

import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeArrayInfo
{
    protected ClassTypeNativeArrayImpl classType;
            
    /**
     * Creates a new instance of ClassTypeNativeArrayInfo
     */
    public ClassTypeNativeArrayInfo(ClassTypeNativeArrayImpl classType)
    {
        this.classType = classType;
    }
    
    public int getDimensions()
    {
        ClassTypeNativeImpl compType = classType.getComponentType();
        int dimIndex = 1;
        while(compType instanceof ClassTypeNativeArrayImpl)
        {
            compType = ((ClassTypeNativeArrayImpl)compType).getComponentType();            
            dimIndex++;
        }        
        return dimIndex;
    }    
    
    public ClassTypeNativeImpl getComponentType()
    {
        return classType.getComponentType();
    }
}
