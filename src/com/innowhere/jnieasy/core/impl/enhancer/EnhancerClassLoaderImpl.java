/*
 * EnhancerClassLoaderImpl.java
 *
 * Created on 21 de diciembre de 2004, 20:21
 */

package com.innowhere.jnieasy.core.impl.enhancer;
import java.io.*;
import javassist.*;
 

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.enh.NativeEnhancerClassLoader;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.ClassLoaderEnhancerPackageMarker;

/**
 *
 * @author  jmarranz
 */



/* Este ClassLoader como tal no carga nada, es un wrapper del padre
 * para hacer que el padre cargue las clases pero previamente enhanced 
*/

public class EnhancerClassLoaderImpl extends ClassLoader implements NativeEnhancerClassLoader
{
    protected ImportDec[] enhanceableImports;
    protected ImportDec[] excludedImports;
    protected NativeEnhancerImpl enhancer;
    protected EnhancerSharedContext ctx;
    
    /**
     * Creates a new instance of EnhancerClassLoaderImpl 
     */
    public EnhancerClassLoaderImpl(String[] enhanceableImports,String[] excludedImports,ClassLoader parent,NativeEnhancerImpl enhancer)
    {
        super(parent);
        
        // La clase ClassLoaderEnhancerPackageMarker nos sirve para definir el paquete de las implementaciones
        // de valores para que sean cargadas con este ClassLoader junto a las del usuario
        String importImplClasses = ClassLoaderEnhancerPackageMarker.class.getPackage().getName() + ".**";       
        this.enhanceableImports = toImportDec(importImplClasses,enhanceableImports);
        this.excludedImports = toImportDec(excludedImports == null ? new String[0] : excludedImports); // excludedImports puede ser null

        this.enhancer = enhancer;
    }    
    
    public static ImportDec[] toImportDec(String importImplClasses,String[] importList)
    {
        ImportDec[] importList2 = new ImportDec[importList.length + 1];
        importList2[0] = new ImportDec(importImplClasses);
        for(int i = 0; i < importList.length; i++)
            importList2[i + 1] = new ImportDec(importList[i]);
        return importList2;
    }            
    
    public static ImportDec[] toImportDec(String[] importList)
    {
        ImportDec[] importList2 = new ImportDec[importList.length];
        for(int i = 0; i < importList.length; i++)
            importList2[i] = new ImportDec(importList[i]);
        return importList2;
    }                
    
    public EnhancerSharedContext getSharedContext()
    {
        if (ctx == null)
            ctx = enhancer.getEnhancerSharedContext(this);
        return ctx;
    }
    
    protected synchronized Class loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        // Basado en el estándar pero modificado de la forma adecuada
        // chequeamos si ya ha sido cargado por este ClassLoader
	Class cls = findLoadedClass(name);        
        if (cls == null)
        {
            if (name.startsWith("java.") || name.startsWith("javax."))
            {
                // para que vaya más rapidito
                cls = getParent().loadClass(name);
            }
            else
            {
                for(int i=0; i < excludedImports.length; i++ )
                {
                    ImportDec excludeImport = excludedImports[i];            
                    if (excludeImport.match(name))
                    {
                        cls = getParent().loadClass(name); 
                        break;
                    }
                }
                
                if (cls == null)
                {
                    for(int i=0; i < enhanceableImports.length; i++ )
                    {
                        ImportDec enhanceableImport = enhanceableImports[i];
                        if (enhanceableImport.match(name))
                        {
                            // La clase está bajo el paquete en donde están 
                            // las clases a hacer enhancer y las que operan con ellas
                            cls = defineClassEnhancing(name);
                            break;
                        }
                    }
                    if (cls == null)
                    {
                        // No está en la zona de enhanceables
                        // Cargamos de forma normal por delegación

                        cls = getParent().loadClass(name);
                    }     
                }
            }
        }
        
	if (resolve)
        {
	    // enlaza con este ClassLoader o no hace nada si ya está enlazado (a este o a otro)
            resolveClass(cls);
	}

        return cls;
    }
    
    protected Class defineClassEnhancing(String name) throws ClassNotFoundException
    {
        EnhancerSharedContext ctx = getSharedContext();
        CtClass ctClass = ctx.getCtClass(name,false);
        if (ctClass == null) throw new ClassNotFoundException(name);
        if (JavaClassAsNativeCapableEnhancer.isEnhanced(ctClass))
        {
            // Está preparada para ser convertida en Class
            return defineClass(ctClass);            
        }
        else
        {
            JavaClassAsNativeCapableEnhancer classEnh = ctx.getTypeEnhancer(ctClass); // Se carga del XML si es necesario

            if (classEnh != null)
            {
                if (!classEnh.isEnhanced())
                {                  
                    // Nuestra oportunidad de enhancear el CtClass antes de generar el Class
                    EnhancerSourceFileContext ctxFile = ctx.newEnhancerSourceFileContext(classEnh.getPackageEnhancer());
                    JavaClassAsNativeCapableEnhancerRender.enhance(classEnh,ctxFile); 
                }
                ctClass = classEnh.getCtClass();  // por si acaso pero no hace falta, es el mismo que el de antes (en el ClassPool está una vez)

                return defineClass(ctClass);
            }
            else // No es enhanceable
            {
                // Evitamos usar defineClass(ctClass) porque supone un prune del CtClass 
                // y dicho CtClass inutilizado sigue estando en el ClassPool 
                // y existe el caso de las NativeDirectCallbacks en el que se usa el CtClass después
                // de haber obtenido el Class por aquí. En el caso anterior el 
                // JavaClassAsNativeCapableEnhancer recuerda todo, en este caso no tenemos dicho recordatorio
                return defineNormalClass(name); 
            }
        }
    }
    
    protected Class defineNormalClass(String name) throws ClassNotFoundException
    {
        // La cargamos nosotros mismos, pues queremos tener la seguridad
        // que aunque sea una clase normal el ClassLoader sea este y no 
        // el parent, pues la clase normal a su vez es posible que contenga
        // a clases enhanceables que cargará con su ClassLoader, es decir, éste.
       
        String path = name.replace('.','/');
        path = path + ".class";
        InputStream streamClass = getResourceAsStream(path);
        if (streamClass == null)
            throw new ClassNotFoundException(name);
 
        byte[] byteCode = Util.load(streamClass);
        
        return defineClass(name,byteCode);
    }    
    
    protected Class defineClass(CtClass ctClass)
    {    
        String className = ctClass.getName();
        byte[] byteCode;
        try
        {
            byteCode = ctClass.toBytecode(); 
            // la clase queda pruned
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }    
        
        return defineClass(className,byteCode);
    }
    
    protected Class defineClass(String name,byte[] byteCode)
    {
        try
        {
            return defineClass(name, byteCode, 0, byteCode.length);
        }
        catch(SecurityException ex)
        {
            // Se da este error cuando la clase que cargamos es del sistema
            // por ejemplo una clase dentro del paquete java.lang
            // este ClassLoader no está autorizado hay que delegar
            return null;         
        }    
    }
    
    public Class loadClass(CtClass ctClass)
    {
        return loadClass(ctClass, true);
    }   
    
    public Class loadClass(CtClass ctClass,boolean resolve)
    {
        Class clasz = defineClass(ctClass);
        if (clasz == null) return null;
	if (resolve)
        {
	    // enlaza con este ClassLoader o no hace nada si ya está enlazado (a este o a otro)
            resolveClass(clasz);
	}
        return clasz;
    }
}
