/*
 * PackageListEnhancerRender_BORRAR_NO_SE_USA.java
 *
 * Created on 5 de noviembre de 2004, 10:09
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.util.*;

import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageListEnhancer;


public class PackageListEnhancerRender_BORRAR_NO_SE_USA
{
    protected PackageListEnhancer packageList;
    
    /**
     * Creates a new instance of PackageListEnhancerRender_BORRAR_NO_SE_USA
     */
    public PackageListEnhancerRender_BORRAR_NO_SE_USA(PackageListEnhancer packageList)
    {
        this.packageList = packageList;
    }
    
    public static PackageListEnhancerRender_BORRAR_NO_SE_USA newPackageListEnhancerRender(PackageListEnhancer packageList)
    {
        return new PackageListEnhancerRender_BORRAR_NO_SE_USA(packageList);
    }   
    
    public void enhance(String outputDir,EnhancerSharedContext ctx) 
    {    
        for(Iterator it = packageList.getPackages().iterator(); it.hasNext(); )
        {
            Object obj = it.next();
            if (obj instanceof PackageListEnhancer)
            {
                PackageListEnhancer pkgList = (PackageListEnhancer)obj;
                PackageListEnhancerRender_BORRAR_NO_SE_USA pkgListRender = PackageListEnhancerRender_BORRAR_NO_SE_USA.newPackageListEnhancerRender(pkgList);
                pkgListRender.enhance(outputDir,ctx);
            }
            else 
            {
                PackageEnhancer pkg = (PackageEnhancer)obj;
                PackageEnhancerRender pkgRender = PackageEnhancerRender.newPackageEnhancerRender(pkg);
                pkgRender.enhance(outputDir,ctx);
            }
        }        
    }    
}
