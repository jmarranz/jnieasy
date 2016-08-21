/*
 * NativeEnhancerImpl.java
 *
 * Created on 28 de enero de 2005, 20:22
 */

package com.innowhere.jnieasy.core.impl.enhancer;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.enh.NativeEnhancer;
import com.innowhere.jnieasy.core.impl.*;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.PackageListEnhancerXML;
import java.net.URL;


public class NativeEnhancerImpl implements NativeEnhancer
{
    protected JNIEasyImpl jnieasy;
    protected EnhancerSharedContext defaultContext;
            
    /**
     * Creates a new instance of NativeEnhancerImpl
     */
    public NativeEnhancerImpl(JNIEasyImpl jnieasy)
    {
        this.jnieasy = jnieasy;
    }
    
    public JNIEasy getJNIEasy()
    {
        return jnieasy;
    }
    
    public ClassLoader enableOnLoad(String[] includeImports,String[] excludeImports,ClassLoader parent)
    {
        JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)getJNIEasy().getJNIEasyLib();
        dll.checkLicense(1 /* ENABLE_ONLOAD_ENHANCER */,0);
        
        ClassLoader loader = new EnhancerClassLoaderImpl(includeImports,excludeImports,parent,this);
        jnieasy.getTypeManagerRuntime().setClassLoader(loader);
        return loader;
    }
    
    public ClassLoader enableOnLoad(String[] includeImports,String[] excludeImports)
    {
        ClassLoader parent = getJNIEasy().getTypeManager().getClassLoader();
        return enableOnLoad(includeImports,excludeImports,parent);
    }
    
    public EnhancerSharedContext getEnhancerSharedContext(ClassLoader loader)
    {
        EnhancerSharedContext defaultContext = getCurrentEnhancerSharedContext();
        if (defaultContext.getClassLoader() == loader)
            return defaultContext;
        else
            return new EnhancerSharedContext(loader,this); // caso raro, no aconsejable
    }    
   
    public EnhancerSharedContext getCurrentEnhancerSharedContext()
    {
        ClassLoader loader = jnieasy.getTypeManagerRuntime().getClassLoader();
        if ((defaultContext == null)||(defaultContext.getClassLoader() != loader))
        {
            this.defaultContext = new EnhancerSharedContext(loader,this);
        }
        return defaultContext;
    }
        
    public void enhance(URL filePath,String outputDir)
    {
        EnhancerSharedContext ctx = getCurrentEnhancerSharedContext();
        JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)getJNIEasy().getJNIEasyLib();
        dll.checkLicense(2 /* ENHANCE_CLASS_FILES */,0);
        
        PackageListEnhancerXML pkgEnhXML = PackageListEnhancerXML.newPackageListEnhancerXML();
        pkgEnhXML.parse(filePath,outputDir,ctx);
        
//        PackageListEnhancer pkgEnh = pkgEnhXML.getPackageListEnhancer();
//        PackageListEnhancerRender pkgEnhRender = PackageListEnhancerRender.newPackageListEnhancerRender(pkgEnh);
//        pkgEnhRender.enhance(outputDir,ctx);
    }
}
