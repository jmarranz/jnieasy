/*
 * ImportGen.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.util.*;

public class ImportDec
{
    protected String classes;
    protected boolean isMultiple;
    protected boolean isMultipleRecursive;    
    
    /** Creates a new instance of ImportGen */
    public ImportDec()
    {
    }
    
    public ImportDec(String classes)
    {
        setClassImport(classes);
    }    
    
    public String getClassImport()
    {
        return classes;
    }
    
    public void setClassImport(String cls)
    {
        cls = cls.replaceAll(" ","");  // Eliminamos los espacios    
        this.classes = cls;
        
        this.isMultiple = (classes.lastIndexOf('*') != -1);
        // Si termina en .** es todo el �rbol de paquetes y clases,
        // esta es una extensi�n a la sintaxis del import Java
        this.isMultipleRecursive = (isMultiple && classes.charAt(classes.length() - 2) == '*');
    }

    public boolean isMultiple()
    {
        return isMultiple;
    }   
    
    public boolean isMultipleRecursive()
    {
        return isMultipleRecursive;
    }    
    
    public String getClassNamePart()
    {
        // S�lo conviene llamarse en caso de NO m�ltiple        
        int pos = classes.lastIndexOf('.');
        if (pos == -1) return classes; // No tiene package, extra�o pero bueno
        return classes.substring(pos + 1,classes.length());        
    }
    
    public boolean match(String className)
    {
        if (!isMultiple())
        {
            return (className.equals(classes));
        }
        else
        {
            String pkg = getPackagePart();
            pkg += "."; // le volvemos a a�adir el punto para que quede claro que el nombre del paquete finaliza            
            if (!className.startsWith(pkg))
                return false;          
            className = className.substring(pkg.length());
            if (className.indexOf('.') == -1)
                return true; // Queda �nicamente un nombre de clase sin m�s paquetes
            // Tiene alg�n punto, por tanto puede ser algo as� como
            // paquete.NombreClase
            // Si es multiple recursive (.**) el input entonces ser� true, 
            // caso contrario est� la clase en un subpackage pero el import 
            // es tipo .* y dicho subpackage no est� incluido
            return isMultipleRecursive();
        }   
    }

    public String getPackagePart()
    {
        return Util.getPackagePart(classes);        
    }
    
    public String getAbsClassName(String className)
    {
        String pkgName = getPackagePart();
        if (pkgName == null)
            return className;
        else
            return pkgName + "." + className;
    }
}
