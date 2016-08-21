/*
 * PackageListEnhancer.java
 *
 * Created on 27 de septiembre de 2004, 19:54
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.util.*;

public class PackageListEnhancer
{
    private LinkedList packageList = new LinkedList();
    
    /** Creates a new instance of PackageListEnhancer */
    public PackageListEnhancer()
    {
    }
    
    public LinkedList getPackages()
    {
        return packageList;
    }

    public void addPackage(PackageEnhancer pkg)
    {
        packageList.add(pkg);        
    }

    public void addPackageList(PackageListEnhancer pkgListEnh)
    {
        packageList.add(pkgListEnh);
    }
    
    
}
