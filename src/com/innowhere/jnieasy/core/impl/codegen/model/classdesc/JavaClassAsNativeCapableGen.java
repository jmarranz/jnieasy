/*
 * JavaClassAsNativeCapableGen.java
 *
 * Created on 29 de junio de 2005, 13:25
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeCapableGen
{
    protected JavaClassAsNativeCapableImpl javaClass;
    
    /**
     * Creates a new instance of JavaClassAsNativeCapableGen
     */
    public JavaClassAsNativeCapableGen(JavaClassAsNativeCapableImpl javaClass)
    {
        this.javaClass = javaClass;
    }
    
    public JavaClassAsNativeCapableImpl getJavaClassAsNativeCapable()
    {
        return javaClass;
    }    
}
