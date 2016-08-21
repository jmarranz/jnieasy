/*
 * ClassFinder.java
 *
 * Created on 30 de marzo de 2005, 19:26
 */

package com.innowhere.jnieasy.core.impl.enhancer;

/**
 *
 * @author  jmarranz
 */
import javassist.*;
import com.innowhere.jnieasy.core.impl.common.ClassInfoFinder;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;

public class CtClassFinder extends ClassInfoFinder
{
    protected ClassPool classPool;
    
    /** Creates a new instance of ClassFinder */
    public CtClassFinder(ClassPool classPool)
    {
        this.classPool = classPool;
    }
    
    public Object find(String className)
    {
        try
        {
            className = ClassTypeNativeImpl.normalizeClassName(className);
            return classPool.get(className);
        }
        catch(javassist.NotFoundException ex)
        {
            return null; // No se encuentra la clase
        }
    }
    
}
