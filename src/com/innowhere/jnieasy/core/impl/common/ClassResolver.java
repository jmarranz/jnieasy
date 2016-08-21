/*
 * ClassResolver.java
 *
 * Created on 30 de marzo de 2005, 19:36
 */

package com.innowhere.jnieasy.core.impl.common;

/**
 *
 * @author  jmarranz
 */
import java.util.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportList;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.PackageDec;



public class ClassResolver
{
    // Nombres de paquetes de clases públicas que puede usar el usuario
    // y que no necesita importar
    private static final String[] jnieasyPkgNames = 
        {
            "java.lang" // para el caso de String, Integer etc
        };
    
    protected PackageDec pkg;
    protected ImportList importList;    
    protected ClassInfoFinder finder;
    
    /** Creates a new instance of ClassResolver */
    public ClassResolver(PackageDec pkg,ImportList importList,ClassInfoFinder finder)
    {
        this.pkg = pkg;
        this.importList = importList;
        this.finder = finder;
    }
    
    public Object findClassInfo(String className)
    {
        Object classInfo = finder.find(className);
        if (classInfo != null) return classInfo;
        
        if (className.indexOf(".") != -1) // Vemos si ya es absoluto el nombre
            return null;

        // Formamos un nombre absoluto (si podemos)

        // Probamos con el package del archivo destino
        
        if (pkg != null)
        {
            String pkgName = pkg.getName();
            if ((pkgName != null) && !pkgName.equals(""))
            {
                String absClassName = pkgName + "." + className; 
                classInfo = finder.find(absClassName);
                if (classInfo != null) return classInfo;             
            }
        }
        
        // Probamos con los imports del usuario
        for(Iterator it = importList.getImports().iterator(); it.hasNext(); )
        {
            ImportDec impDec = (ImportDec)it.next();
            if (!impDec.isMultiple())
            {
                if (className.equals(impDec.getClassNamePart()))
                {
                    String absClassName = impDec.getClassImport();
                    classInfo = finder.find(absClassName);
                    if (classInfo != null) return classInfo;                     
                }
            }
            else // múltiple
            {
                String absClassName = impDec.getAbsClassName(className);
                classInfo = finder.find(absClassName);
                if (classInfo != null) return classInfo;                
            }
        }

        // Por último con los packages "por defecto"
        // lo hacemos al final para asegurar que el usuario
        // pueda usar nombres ya usados por JNIEasy, pensando
        // más bien en el futuro cuando se coja un .h y se 
        // procese, es posible que ocurrieran duplicidades,
        // prima así el significado del usuario
        for(int i = 0; i < jnieasyPkgNames.length; i++)
        {
            String absClassName = jnieasyPkgNames[i] + "." + className; 
            classInfo = finder.find(absClassName);
            if (classInfo != null) return classInfo;            
        }        

        return null;
    }                   
}
