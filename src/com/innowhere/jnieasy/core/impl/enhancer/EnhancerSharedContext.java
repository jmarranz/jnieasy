/*
 * EnhancerSharedContext.java
 *
 * Created on 25 de enero de 2005, 8:29
 */

package com.innowhere.jnieasy.core.impl.enhancer;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeCapableEnhancerXML;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.*;
import java.net.*;
import javassist.*;



public class EnhancerSharedContext
{
    protected Map types = new HashMap();
    protected ClassPool classPool = new ClassPool();
    protected NativeEnhancerImpl enhancer;
    protected ClassLoader classLoader;
    protected CtClassFinder ctClassFinder;
    
    /** Creates a new instance of EnhancerSharedContext */
   public EnhancerSharedContext(ClassLoader classLoader,NativeEnhancerImpl enhancer)
   {
        this.classPool.appendClassPath(new LoaderClassPath(classLoader));
        this.enhancer = enhancer;
        this.classLoader = classLoader;
        this.ctClassFinder = new CtClassFinder(classPool);        
   }    

    public NativeEnhancerImpl getEnhancer()
    {
        return enhancer;
    }

    public JNIEasyImpl getJNIEasy()
    {
        return (JNIEasyImpl)enhancer.getJNIEasy();
    }
    
    public CtClassFinder getCtClassFinder()
    {
        return ctClassFinder;
    }
     
    public CtClass findCtClass(String className)
    {
        return (CtClass)ctClassFinder.find(className);
    }
    
    public CtClass getCtClass(String className)
    {
        return getCtClass(className,true);
    }    
    
    public CtClass getCtClass(String className,boolean throwError)
    {
        CtClass ctClass = (CtClass)ctClassFinder.find(className);
        if ((ctClass == null) && throwError)
            throw new JNIEasyException("Not found class: " + className);
        return ctClass;
    }        
    
    /**
     * Getter for property classEnhancing.
     * @return Value of property classEnhancing.
     */
    public synchronized JavaClassAsNativeCapableEnhancer findTypeEnhancer(String className)
    {
        return (JavaClassAsNativeCapableEnhancer)types.get(className);
    }
    
    /**
     * Setter for property classEnhancing.
     * @param classEnhancing New value of property classEnhancing.
     */
    public synchronized void putTypeEnhancer(CtClass ctClass,JavaClassAsNativeCapableEnhancer classEnhancing)
    {
        types.put(ctClass.getName(),classEnhancing);
    }
    
    public synchronized JavaClassAsNativeCapableEnhancer removeEnhancer(CtClass ctClass)
    {
        return (JavaClassAsNativeCapableEnhancer)types.remove(ctClass.getName());
    }
    
    private JavaClassAsNativeCapableEnhancer newTypeEnhancer(String className)
    {
        CtClass ctClass = getCtClass(className,false);
        if (ctClass == null) return null;
        return newTypeEnhancer(ctClass);
    }
    
    private JavaClassAsNativeCapableEnhancer newTypeEnhancer(CtClass ctClass)
    {
        URL xmlURL = canBeEnhanced(ctClass);
        if (xmlURL == null) return null; // No enhanceable    

        return JavaClassAsNativeCapableEnhancerXML.newJavaClassAsNativeCapableEnhancer(xmlURL,ctClass,this);
        // Puede devolver null (la clase no es enhanceable)
        // No hacemos enhanced hasta que sea necesario (cuando se quiera el Class)
        // No hace falta llamar a putTypeEnhancer() en este caso pues dentro del método se hace ya (para evitar referencias cíclicas de los fields)        
    }
        
    
    public JavaClassAsNativeCapableEnhancer getTypeEnhancer(String className)
    {
        // Puede devolver null (la clase no es enhanceable)        
        JavaClassAsNativeCapableEnhancer typeEnh = findTypeEnhancer(className);
        if (typeEnh != null) return typeEnh;
        return newTypeEnhancer(className);
    }    

    public JavaClassAsNativeCapableEnhancer getTypeEnhancer(CtClass ctClass)
    {
        // Puede devolver null (la clase no es enhanceable)        
        JavaClassAsNativeCapableEnhancer typeEnh = findTypeEnhancer(ctClass.getName());  
        if (typeEnh != null) return typeEnh;
        return newTypeEnhancer(ctClass);
    }        
    
    /**
     * Getter for property classPool.
     * @return Value of property classPool.
     */
    public ClassPool getClassPool()
    {
        return classPool;
    }
    
    /**
     * Getter for property classLoader.
     * @return Value of property classLoader.
     */
    public ClassLoader getClassLoader()
    {
        return classLoader;
    }

    public URL canBeEnhanced(CtClass ctClass)
    {
        String className = ctClass.getName();
        String nameBasedPath = className.replace('.','/');
/*
        String classPath = nameBasedPath + ".class";
        if (getClassLoader().getResource(classPath) == null)
            return null; // No existe el .class, puede que estemos en generación de código con el onload enhancer activado
*/            
        String xmlResPath = nameBasedPath + ".jnieasy.enh.xml";
        URL xmlURL = getClassLoader().getResource(xmlResPath);
        if (xmlURL == null) return null; // No enhanceable        
    
        return xmlURL;
    }    

    public EnhancerSourceFileContext newEnhancerSourceFileContext(PackageEnhancer pkgEnh)
    {
        return new EnhancerSourceFileContext(this,pkgEnh);
    }
    
    public CtClass createClassFromScratch(Class originalClass,String newClassName)
    {           
        try
        {
            return getClassPool().getAndRename(originalClass.getName(),newClassName);
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }         
    }    
    
    public CtClass toCtClass(Class clasz)
    {
        return getCtClass(clasz.getName());
    }    
    
    public CtClass[] toCtClass(Class[] classParams)
    {
        CtClass[] ctParameters = new CtClass[classParams.length];
        for(int i = 0; i < classParams.length; i++)
            ctParameters[i] = toCtClass(classParams[i]);
        return ctParameters;
    }
    
    public CtMember toCtMember(Member member)
    {
        if (member instanceof Field)
            return toCtField((Field)member);
        else if (member instanceof Constructor)
            return toCtConstructor((Constructor)member);
        else
            return toCtMethod((Method)member);
    }
    
    public CtMethod toCtMethod(Method method)
    {
        String methodName = method.getName();
        CtClass ctClassContainer = toCtClass(method.getDeclaringClass());
        CtClass[] ctParameters = toCtClass(method.getParameterTypes());
        try
        {
            return ctClassContainer.getDeclaredMethod(methodName, ctParameters);        
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public CtConstructor toCtConstructor(Constructor construc)
    {
        CtClass ctClassContainer = toCtClass(construc.getDeclaringClass());
        CtClass[] ctParameters = toCtClass(construc.getParameterTypes());
        try
        {
            return ctClassContainer.getDeclaredConstructor(ctParameters);        
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }       
    
    public CtField toCtField(Field field)
    {
        String fieldName = field.getName();
        CtClass ctClassContainer = toCtClass(field.getDeclaringClass());
        try
        {
            return ctClassContainer.getDeclaredField(fieldName);        
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
}
