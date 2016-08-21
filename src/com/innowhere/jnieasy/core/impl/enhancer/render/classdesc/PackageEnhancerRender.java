/*
 * PackageEnhancerRender.java
 *
 * Created on 5 de noviembre de 2004, 10:12
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.util.*;


import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;

public class PackageEnhancerRender
{
    protected PackageEnhancer pkgEnhancer;
    
    /** Creates a new instance of PackageEnhancerRender */
    public PackageEnhancerRender(PackageEnhancer pkgEnhancer)
    {
        this.pkgEnhancer = pkgEnhancer;
    }

    public static PackageEnhancerRender newPackageEnhancerRender(PackageEnhancer pkgEnhancer)
    {
        return new PackageEnhancerRender(pkgEnhancer);
    }    
    
    public void enhance(String outputDir,EnhancerSharedContext ctx)
    {
        EnhancerSourceFileContext ctxFile = ctx.newEnhancerSourceFileContext(pkgEnhancer);
        
        for(Iterator it = pkgEnhancer.getClasses().iterator(); it.hasNext(); )
        {
            JavaClassAsNativeCapableEnhancer classEnh = (JavaClassAsNativeCapableEnhancer)it.next();
            JavaClassAsNativeCapableEnhancerRender.enhance(classEnh,ctxFile);
            if (outputDir != null)
                classEnh.writeFile(outputDir);
        }      
    }    
}
