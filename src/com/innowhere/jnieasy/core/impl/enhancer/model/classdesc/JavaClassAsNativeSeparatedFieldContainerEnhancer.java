/*
 * JavaClassAsNativeSeparatedFieldContainerEnhancer.java
 *
 * Created on 13 de octubre de 2005, 19:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeSeparatedFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeSeparatedFieldContainerEnhancer extends JavaClassAsNativeMultipleFieldContainerEnhancer
{
    protected JavaClassAsNativeSeparatedFieldContainerEnhancer classEnhSuper; // En uniones es siempre null
    
    /**
     * Creates a new instance of JavaClassAsNativeSeparatedFieldContainerEnhancer
     */
    public JavaClassAsNativeSeparatedFieldContainerEnhancer(JavaClassAsNativeSeparatedFieldContainerImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }
    
    public int getAbsFieldsCount()
    {
        int count = super.getAbsFieldsCount();
        if (classEnhSuper != null)
            count += classEnhSuper.getAbsFieldsCount();        
        return count;
    }    
    
    public JavaClassAsNativeSeparatedFieldContainerEnhancer getSuperClass()
    {
        return classEnhSuper;
    }    
    
    public static JavaClassAsNativeSeparatedFieldContainerEnhancer getSuperClass(CtClass ctClass,EnhancerSharedContext ctx)
    {
        try
        {
            JavaClassAsNativeSeparatedFieldContainerEnhancer classEnhSuper = null;
            CtClass ctClassTmp = ctClass.getSuperclass();
            while((ctClassTmp != null) && 
                  (classEnhSuper == null) && 
                  !Object.class.getName().equals(ctClassTmp.getName()))
            {
                classEnhSuper = (JavaClassAsNativeSeparatedFieldContainerEnhancer)ctx.getTypeEnhancer(ctClassTmp); // Se busca el XML si es necesario
                ctClassTmp = ctClassTmp.getSuperclass();
            }          
                
            return classEnhSuper; // Puede ser null            
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
    
    public void setCtClass(CtClass ctClass)
    {
        super.setCtClass(ctClass);
        
        // Buscamos el JavaClassAsXXX base y asociamos si existe.
        // Si es necesario se carga desde el XML buscado a través
        // del classpath del ClassLoader, si se cargó ya pues simplemente se obtiene
        // El uso del ClassLoader es imprescindible incluso en enhancement
        // por comando en el caso de clases que tienen atributos de tipo de clase
        // derivada.

        this.classEnhSuper = getSuperClass(ctClass,ctx);
    }            
}
