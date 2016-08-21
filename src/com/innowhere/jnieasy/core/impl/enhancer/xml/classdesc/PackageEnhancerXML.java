/*
 * EnhPackage.java
 *
 * Created on 18 de marzo de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;



/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.PackageDec;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.ImportListXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.JavaClassAsNativeCapableEnhancerRender;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;


public class PackageEnhancerXML
{
    protected PackageEnhancer pkgEnhancer;
    protected PackageListEnhancerXML pkgListXML;
    
    /** Creates a new instance of EnhPackage */
    public PackageEnhancerXML(PackageEnhancer pkgEnhancer)
    {
        this.pkgEnhancer = pkgEnhancer;
    }

    public static PackageEnhancerXML newPackageEnhancerXML()
    {
        return new PackageEnhancerXML(new PackageEnhancer());
    }
    
    public static String getName(Element pkgNode)
    {
        return XMLUtil.getAttribute(pkgNode,"name");
    }

    public void parse(Element packageNode,TreeWalker walker,final String outputDir,final EnhancerSharedContext ctx)
    {
        try
        {
            // <package name="test.com.innowhere.jnieasy.core" />
            final PackageDec pkgDec = pkgEnhancer.getPackageDec();
            pkgDec.setName(XMLUtil.getAttribute(packageNode,"name"));

            parseImportsAndClasses(packageNode,walker,pkgDec,outputDir,ctx);

        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,packageNode);
        }        
    }
    
    public void parseImportsAndClasses(Element packageNode,TreeWalker walker,final PackageDec pkgDec,final String outputDir,final EnhancerSharedContext ctx)
    {
            
        // <imports> ... </imports>
        Element importsNode = TreeWalkerUtil.firstChildElement(walker,"imports",true);
        ImportListXML importListXML = ImportListXML.newImportListXML(pkgEnhancer.getImportList());
        importListXML.parse(importsNode,walker);

        parseClasses(walker,pkgDec,outputDir,ctx);  // elementos <class /> seguidos

        TreeWalkerUtil.parentElement(walker);
    }
    
    public void parseClasses(TreeWalker walker,final PackageDec pkgDec,final String outputDir,final EnhancerSharedContext ctx)
    {
        final EnhancerSourceFileContext ctxFile = ctx.newEnhancerSourceFileContext(pkgEnhancer);
        
        XMLTask classTask = new XMLTask()
        {
            public void doTask(Element classNode,TreeWalker walker,int counter)
            {
                try
                {
                    // <class name="ToEnhanceClass" ...>
                    String classNameSimple = JavaClassAsNativeCapableEnhancerXML.getSimpleClassName(classNode);
                    String className = pkgDec.getName() + "." + classNameSimple;

                    // Es posible que ya fuera cargado indirectamente, pues la carga de una clase puede suponer la carga via su XML de otras declaradas 
                    // dentro de la misma. De esta manera nos ahorramos un nuevo parseo de fields etc

                    JavaClassAsNativeCapableEnhancer classEnh = (JavaClassAsNativeCapableEnhancer)ctx.findTypeEnhancer(className);
                    if (classEnh == null)
                        classEnh = JavaClassAsNativeCapableEnhancerXML.newJavaClassAsNativeCapableEnhancer(className,classNode,walker, ctxFile);

                    if (outputDir != null) 
                    {
                        JavaClassAsNativeCapableEnhancerRender.enhance(classEnh,ctxFile);                            
                        classEnh.writeFile(outputDir);
                    }

                    // Tenemos que asociar al pkg en todos los casos pues en caso de carga indirecta el package usado fue temporal
                    pkgEnhancer.addJavaClassAsNativeCapableEnhancer(classEnh);                    
                }
                catch(JNIEasyXMLException ex)
                {
                    throw ex;
                }        
                catch(Exception ex)
                {
                    throw new JNIEasyXMLException(ex,classNode);
                }                        
            }
        };

        TreeWalkerUtil.processElementsToEnd(walker, classTask,"class");        
    }
    
    
    /**
     * Getter for property pkgListXML.
     * @return Value of property pkgListXML.
     */
    public PackageListEnhancerXML getPkgListXML()
    {
        return pkgListXML;
    }
    
    /**
     * Setter for property pkgListXML.
     * @param pkgListXML New value of property pkgListXML.
     */
    public void setPkgListXML(PackageListEnhancerXML pkgListXML)
    {
        this.pkgListXML = pkgListXML;
    }
    
    /**
     * Getter for property pkgEnhancer.
     * @return Value of property pkgEnhancer.
     */
    public PackageEnhancer getPkgEnhancer()
    {
        return pkgEnhancer;
    }
    
    /**
     * Setter for property pkgEnhancer.
     * @param pkgEnhancer New value of property pkgEnhancer.
     */
    public void setPkgEnhancer(PackageEnhancer pkgEnhancer)
    {
        this.pkgEnhancer = pkgEnhancer;
    }
    
}
