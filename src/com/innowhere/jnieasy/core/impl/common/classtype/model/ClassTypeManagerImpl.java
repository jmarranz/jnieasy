/*
 * ClassTypeManagerImpl.java
 *
 * Created on 4 de abril de 2005, 17:35
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;

/**
 *
 * @author  jmarranz
 */

import java.util.*;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;



public class ClassTypeManagerImpl
{
    protected Map classNames = new HashMap();
    protected ClassTypeFinder classTypeFinder;
    protected JNIEasyImpl jniEasy;
    
    /**
     * Creates a new instance of ClassTypeManagerImpl 
     */
    public ClassTypeManagerImpl(JNIEasyImpl jniEasy)
    {
        this.jniEasy = jniEasy;
        this.classTypeFinder = new ClassTypeFinder(this);
        
        ClassTypeNativeImpl.registerAllClassTypes(this); // He calculado que tarda algo más de un segundo, pero yo creo que vale la pena
    }    
   
    public synchronized void registerType(String className,ClassTypeNativeImpl type,boolean overwrite)
    {
        String normalized = ClassTypeNativeImpl.normalizeClassName(className);
        Object res = classNames.put(normalized,type);
        if ((res != null) && !overwrite)  throw new JNIEasyException("INTERNAL ERROR was already registered :" + res);
    }
    
    public JNIEasyImpl getJNIEasy()
    {
        return jniEasy;
    }
    
    public ClassTypeFinder getClassTypeFinder()
    {
        return classTypeFinder;
    }
            
    public synchronized ClassTypeNativeImpl findClassType(String className)
    {
        return (ClassTypeNativeImpl)classNames.get(ClassTypeNativeImpl.normalizeClassName(className));        
    }

    public synchronized ClassTypeNativeImpl getClassType(MetaClassWrapper valueClass,TaskContext ctx,boolean autoRegister,boolean throwError)
    {    
        ClassTypeNativeImpl classType = (ClassTypeNativeImpl)findClassType(valueClass.getName());
        if (classType != null) return classType; // A la primera, es un tipo conocido

        classType = ClassTypeNativeImpl.newCustomClassType(valueClass,ctx);     
        if (classType == null)
        {
            if (throwError)
                throw new JNIEasyException("Not valid or not enhanced class : " + valueClass.getName());
            else
                return null;
        }
            
        if (autoRegister)
        {
            // Registramos la clase que con toda probabilidad será
            // una clase definida por el usuario
            //registerAllClassTypes(classType);
            classType.registerClassType();
        }

        return classType;
    }    
    
    
}
