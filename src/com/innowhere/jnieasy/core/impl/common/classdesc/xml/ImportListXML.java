/*
 * ImportListXML.java
 *
 * Created on 30 de marzo de 2005, 18:14
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;

/**
 *
 * @author  jmarranz
 */
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportList;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;


public class ImportListXML
{
    protected ImportList importList;
    
    /** Creates a new instance of ImportListXML */
    public ImportListXML(ImportList importList)
    {
        this.importList = importList;
    }
    
    public static ImportListXML newImportListXML(ImportList importList)
    {
        return new ImportListXML(importList);
    }
    
    public void parse(Element importsNode,TreeWalker walker)
    {
        XMLTask importTask = new XMLTask()
        {
            public void doTask(Element importNode,TreeWalker walker,int counter)
            {
                // <import ...>
                ImportDecXML importDecXML = ImportDecXML.newImportDecXML();
                ImportDec importDec = importDecXML.getImportDec();
                importList.addImport(importDec);
                importDecXML.parse(importNode);                
            }
        };
        
        TreeWalkerUtil.processChildElements(walker, importTask,"import");
    }    
}
