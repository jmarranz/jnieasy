/*
 * EnhancerUtil.java
 *
 * Created on 14 de julio de 2005, 18:34
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import javassist.CannotCompileException;
import javassist.CtClass;

/**
 *
 * @author jmarranz
 */
public class EnhancerUtil
{
   
    /** Creates a new instance of EnhancerUtil */
    public EnhancerUtil()
    {
    }
        
    public static String[] extractClassNames(CtClass[] ctArray)
    {
        String[] array = new String[ctArray.length];
        for(int i = 0; i < ctArray.length; i++)
        {
            array[i] = ctArray[i].getName();
        }
        return array;
    }
       

    public static Class loadClass(CtClass ctClass,ClassLoader loader,JNIEasyImpl jniEasy)
    {
        JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)jniEasy.getJNIEasyLib();
        dll.checkLicense(3 /* ENHANCE_CLASS_ONLOAD */,0); 
       
        Class clasz = null;
        if (loader instanceof EnhancerClassLoaderImpl)
        {
            clasz = ((EnhancerClassLoaderImpl)loader).loadClass(ctClass);
        }
        else
        {
            try
            {
                clasz = ctClass.toClass(loader,null);
            }
            catch(CannotCompileException ex2)
            {
                // Puede ocurrir que el CtClass por ejemplo sea una clase generada con package java.lang 
                // en ese caso es algo esperado, y clasz queda como null
                if (!java.lang.SecurityException.class.equals(ex2.getCause().getClass()))               
                    throw new JNIEasyException(ex2);
            }
            catch(Exception ex2)
            {
                throw new JNIEasyException("Probably cause: a private method of current ClassLoader must be called using reflection, the caller must have permissions to invoke, or enable the on load enhancer of JNIEasy",ex2);                
            }            
        }

        if (clasz == null) return null; // Ocurre si el CtClass por ejemplo es una clase generada con package java.lang (puede ocurrir)
        
        // El método Class.defineClass() que es llamado indirectamente en ambos casos
        // no inicializa la clase por tanto su código estático no se ejecuta 
        // (necesario para que se registre si es una clase custom)
        // la siguiente llamada hace uso de Class.forName() con initialize a true
        ClassTypeNativeRuntimeImpl.getClassFromVMClassName(clasz.getName(), loader, true);
        return clasz;
    }
}
