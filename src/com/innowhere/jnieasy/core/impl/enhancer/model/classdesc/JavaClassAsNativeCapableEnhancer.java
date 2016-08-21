/*
 * EnhancedClass.java
 *
 * Created on 18 de marzo de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.io.*;
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeCapableEnhancerXML;



public abstract class JavaClassAsNativeCapableEnhancer
{
    public static final String jnieasyFormatVersion_value = "1.0";
    public static final String jnieasyFormatVersion_name = "jnieasyFormatVersion";

    protected EnhancerSharedContext ctx;
    protected PackageEnhancer pkgEnh = PackageEnhancer.getDefaultPackageEnhancer();
    protected boolean enhanced = false;
    protected boolean writtenToFile = false;
    protected CtClass ctClass;
    protected JavaClassAsNativeCapableImpl javaClass;

    
    /** Creates a new instance of EnhancedClass */
    public JavaClassAsNativeCapableEnhancer(JavaClassAsNativeCapableImpl javaClass,EnhancerSharedContext ctx)
    {
        this.javaClass = javaClass;        
        this.ctx = ctx;        
    }
    
    public static JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(ClassTypeNativeCapableImpl classType,CtClass ctClass,EnhancerSharedContext ctx)
    {
        JavaClassAsNativeCapableImpl javaClass = classType.getJavaClassAsNativeCapable();
        JavaClassAsNativeCapableEnhancer javaClassEnh = javaClass.newJavaClassAsNativeCapableEnhancer(ctx);
        // Registramos cuanto antes de la búsqueda de la clase padre y el parseo de los fields y métodos pues estos pueden tener
        // como tipo de alguna forma el propio ClassAsTypeXXX y así lo encontrarán en la caché y no habrá
        // problemas de creación cíclica infinita.        
        ctx.putTypeEnhancer(ctClass, javaClassEnh); // hay que registrar antes del setCtClass() pues la clase base (si tiene) puede necesitar encontrar la hija  
        javaClassEnh.setCtClass(ctClass);
        return javaClassEnh;
    }        

    public ClassTypeNativeCapableImpl getClassTypeNativeCapable()
    {
        return javaClass.getClassTypeNativeCapable();
    }
    
    public PackageEnhancer getPackageEnhancer()
    {
        return pkgEnh;
    }
    
    public void setPackageEnhancer(PackageEnhancer pkgEnh)
    {
        this.pkgEnh = pkgEnh;
    }
    
    public JavaClassAsNativeCapableImpl getJavaClassAsNativeCapable()
    {
        return javaClass;
    }
    
    public EnhancerSharedContext getEnhancerSharedContext()
    {
        return ctx;
    }
    
    /**
     * Getter for property ctClass.
     * @return Value of property ctClass.
     */
    public CtClass getCtClass()
    {
        return ctClass;
    }
    
    /**
     * Setter for property ctClass.
     * @param ctClass New value of property ctClass.
     */
    public void setCtClass(CtClass ctClass)
    {
        this.ctClass = ctClass;
        
        if (isEnhanced(ctClass))
        {
            this.enhanced = true;
            this.writtenToFile = true; // Se entiende que se ha cargado ya desde fichero enhanced, así evitamos hacer writeFile() (da un error de EOFException o algo así y el .class queda corrupto)
        }
        else
        {
            this.enhanced = false;            
            this.writtenToFile = false;
        }
    }    

    public String getSimpleName()
    {
        return ctClass.getSimpleName();
    }
    
    public String getName()
    {
        return ctClass.getName();
    }    
   
    public static boolean isEnhanced(CtClass valueClass)
    {
        // Ojo, esto no funciona (da un erróneo false) si la clase ha sido prunned (vaciada) y no ha sido obtenida de nuevo via ClassPool (previamente detached)
        // lo cual ocurre cuando se ejecuta toBytecode() y writeFile()
        // tras estas operaciones la clase queda congelada y de esa manera podemos saber que no es seguro
        // el hecho de estar congelada nos dice que ha sido enhanced

        if (valueClass.isFrozen()) return true; //throw new JNIEasyException("INTERNAL ERROR");
         
        String versionStr = getVersion(valueClass);
        if (versionStr == null) return false;
        
        int[] version = JNIEasyImpl.parseVersion(versionStr);
        if (version[0] < 1) throw new JNIEasyException("Bad version number, must be >= 1");
        
        return true;
    }

    public boolean isEnhanced()
    {
        // Ha de llamarse sólo si mustBeEnhanced() devuelve true
        if (enhanced) return true; // Lo sabemos con certeza.        

        // Podríamos poner la siguiente línea:
        // return (CtClassWrapper.isAssignableFrom(NativeCapable.class,ctClass));
        // y creer que es suficiente, pero no es válido, en el caso de herencia
        // la clase base puede estar enhanced y la derivada no y el conjunto
        // implementa el NativeCapable.class
        // asi que averiguamos que *esta* clase ha sido realmente enhanced

        return isEnhanced(ctClass);
    }

    public void setEnhanced(boolean enhanced)
    {
        this.enhanced = enhanced;
    }    
    
    public static String getVersion(CtClass valueClass)
    {
        byte[] versionData = valueClass.getAttribute(jnieasyFormatVersion_name);
        if (versionData == null) return null;
        return new String(versionData);
    }    
    
    public String getVersion()
    {
        return getVersion(ctClass);
    }    
    
    public boolean isWrittenToFile()
    {
        return writtenToFile;
    }
    
    public boolean writeFile(String outputDir)
    {
        if (writtenToFile) return false; // Ya guardado, sólo se puede salvar una vez, creo que da error al hacerlo de nuevo pues hace prune creo
        
        try
        {
            ctClass.writeFile(outputDir);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }     
        //reload(); 
        
        this.writtenToFile = true;    
        
        return true;
    }

    public byte[] toBytecode()
    {
        byte[] byteCode;
        try
        {
             byteCode = ctClass.toBytecode();
        }
        catch(CannotCompileException ex)
        {
             throw new JNIEasyException(ex);
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }        
        
        //reload(); // idem writeFile
        return byteCode;
    }    
    
    public int getCurrentLicenseUsedByEnhancer()
    {
        // La licencia actual será la licencia usada para el enhancement de la clase
        JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)ctx.getJNIEasy().getJNIEasyLib();
        return dll.getLicense();    
    }
    
    public abstract JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender();
    public abstract JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML();
}
