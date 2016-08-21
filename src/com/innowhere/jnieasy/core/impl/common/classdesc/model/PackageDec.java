/*
 * Package.java
 *
 * Created on 30 de marzo de 2005, 19:06
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

/**
 *
 * @author  jmarranz
 */
public class PackageDec
{
    protected String pkgName;
    
    /** Creates a new instance of Package */
    public PackageDec()
    {
    }
    
    public String getName()
    {
        return pkgName;
    }
    
    public void setName(String pkgName)
    {
        this.pkgName = pkgName;
    }
}
