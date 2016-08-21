/*
 * PackageListEnhancer.java
 *
 * Created on 27 de septiembre de 2004, 19:54
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.TreeWalker;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageListEnhancer;

import java.net.URL;



public class PackageListEnhancerXML
{
    protected PackageListEnhancer packageList;
    
    /** Creates a new instance of PackageListEnhancer */
    protected PackageListEnhancerXML(PackageListEnhancer packageList)
    {
        this.packageList = packageList;
    }

    public static PackageListEnhancerXML newPackageListEnhancerXML()
    {
        return new PackageListEnhancerXML(new PackageListEnhancer());
    }
    
    public PackageListEnhancer getPackageListEnhancer()
    {
        return packageList;
    }
    
    public void parse(final URL filePath,final String outputDir,final EnhancerSharedContext ctx)
    {
        try
        {
            Document doc = XMLUtil.parse(filePath.toString());

            // <jniEasyEnhancer version="x.y">
            Element jniEasyEnhancerNode = XMLUtil.getDocumentElement(doc,"jniEasyEnhancer");
            
            int[] version = JNIEasyImpl.parseVersion(XMLUtil.getAttribute(jniEasyEnhancerNode,"version"));
            if (version[0] < 1) throw new JNIEasyException("Bad version number, must be >= 1");
            
            TreeWalker walker = TreeWalkerUtil.createTreeWalker(jniEasyEnhancerNode);

            final PackageListEnhancerXML thisObj = this;
            
            XMLTask pkgOrIncludeTask = new XMLTask()
            {
                public void doTask(Element pkgOrIncludeNode,TreeWalker walker,int counter)
                {
                    try
                    {
                        // <package> o <include>
                        String tagName = pkgOrIncludeNode.getTagName();
                        if (tagName.equals("package"))
                        {
                            // <package ...>
                            PackageEnhancerXML pkgEnhXML = PackageEnhancerXML.newPackageEnhancerXML();
                            PackageEnhancer pkgEnh = pkgEnhXML.getPkgEnhancer();
                            pkgEnhXML.setPkgListXML(thisObj);
                            pkgEnhXML.parse(pkgOrIncludeNode,walker,outputDir,ctx);
                            packageList.addPackage(pkgEnh);                        
                        }
                        else if (tagName.equals("include"))
                        {
                            // <include file="incFile" />
                            String incFile = XMLUtil.getAttribute(pkgOrIncludeNode,"file");
                            URL absIncPath = Util.formAbsoluteURLPath(filePath,incFile);
                            PackageListEnhancerXML pkgListIncXML = PackageListEnhancerXML.newPackageListEnhancerXML();
                            pkgListIncXML.parse(absIncPath,outputDir,ctx);
                            PackageListEnhancer pkgListEnhInc = pkgListIncXML.getPackageListEnhancer();
                            packageList.addPackageList(pkgListEnhInc);
                        }
                        else throw new JNIEasyXMLException("Tag name must be <package> or <include>",pkgOrIncludeNode);
                    }
                    catch(JNIEasyXMLException ex)
                    {
                        throw ex;
                    }        
                    catch(Exception ex)
                    {
                        throw new JNIEasyXMLException(ex,pkgOrIncludeNode);
                    }                     
                }
            };

            TreeWalkerUtil.processChildElements(walker, pkgOrIncludeTask);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Processing XML file: " + filePath,ex);
        }
    }

    
}
