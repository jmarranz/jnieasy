/*
 * EnhPackage.java
 *
 * Created on 18 de marzo de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.util.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportList;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.PackageDec;

public class PackageEnhancer
{
    private PackageDec packageDec = new PackageDec();
    private ImportList importList = new ImportList();
    private LinkedList classes = new LinkedList();    
    
    private static final PackageEnhancer SINGLETON = new PackageEnhancer();
    
    /** Creates a new instance of EnhPackage */
    public PackageEnhancer()
    {
    }

    public static PackageEnhancer getDefaultPackageEnhancer()
    {
        return SINGLETON;
    }
    
    public void addJavaClassAsNativeCapableEnhancer(JavaClassAsNativeCapableEnhancer classEnh)
    {
        classEnh.setPackageEnhancer(this);
        classes.add(classEnh);
    }
    
    public LinkedList getClasses()
    {
        return classes;
    }

    public PackageDec getPackageDec()
    {
        return packageDec;
    }
    
    public ImportList getImportList()
    {
        return importList;
    }
}
