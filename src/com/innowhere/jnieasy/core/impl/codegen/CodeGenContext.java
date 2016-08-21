/*
 * CodeGenContext.java
 *
 * Created on 26 de febrero de 2005, 16:46
 */

package com.innowhere.jnieasy.core.impl.codegen;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.*;
import com.innowhere.jnieasy.core.impl.common.ClassResolver;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FileCodeGen;
import com.innowhere.jnieasy.core.impl.rt.ClassWrapper;


/* No es global s�lo es v�lido para cada clase */

public class CodeGenContext extends TaskContext
{
    protected ClassResolver classTypeResolver;
    protected ClassResolver classResolver;
    
    /** Creates a new instance of CodeGenContext */
    public CodeGenContext(FileCodeGen fileGen,JNIEasyImpl jniEasy)
    {      
        super(jniEasy);
        
        this.classTypeResolver = new ClassResolver(fileGen.getPackage(),fileGen.getImportList(),classTypeMgr.getClassTypeFinder());
        this.classResolver = new ClassResolver(fileGen.getPackage(),fileGen.getImportList(),jniEasy.getTypeManagerRuntime().getClassFinder());        
    }

    protected ClassTypeNativeImpl getClassTypeNotFindInternal(MetaClassWrapper clasz,boolean throwError)
    {
        return classTypeMgr.getClassType(clasz,this,true,throwError);
    }
    
    public ClassTypeNativeImpl findClassType(String className)
    {
        return (ClassTypeNativeImpl)classTypeResolver.findClassInfo(className);
    }
    
    public MetaClassWrapper newMetaClassWrapper(String className)
    {
        // Devolvemos el ClassWrapper m�s adecuado
        // Independientemente de cual sea el elegido, al usarse junto
        // con CodeGenContext autoriza a devolverse un Type Unknown si 
        // no es encontrado. En el caso de array Java al menos podremos leer las dimensiones.
        
        // Se cargar� el Class usando el onload enhancer si est� activado
        Class clasz = (Class)classResolver.findClassInfo(className);
        if (clasz != null)
        {
            // ojo, el hecho de que tengamos el Class no supone est�
            // enhanced en el caso de Custom, pues puede no estar el onload
            // enhancer activado y la clase en el archivo no est� enhanced.
            // pero el CodeGenContext permitir� que se devuelva un Unknown Type
            return new ClassWrapper(clasz);
        }

        // no se ha encontrado, seguramente porque la clase que se necesita
        // es tambi�n generada y no compilada todav�a 
    
        // Establecemos otra estrategia sin necesitar cargar la clase, en el caso de que sea un 
        // array Java de la clase desconocida podremos saberlo y poder as� leer las dimensiones del XML
        return new ClassNameWrapper(className);
    }    
}
