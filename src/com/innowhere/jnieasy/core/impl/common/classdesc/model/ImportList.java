/*
 * ImportList.java
 *
 * Created on 30 de marzo de 2005, 18:11
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

/**
 *
 * @author  jmarranz
 */
import java.util.*;

public class ImportList
{
    protected List imports = new LinkedList();
    
    /** Creates a new instance of ImportList */
    public ImportList()
    {
        addImport("java.lang.*");        
    }
    
    public ImportList(String[] importList)
    {
        addImport("java.lang.*");
        if (importList != null)
        {
            for(int i = 0; i < importList.length; i++)
            {
                addImport(importList[i]);
            }
        }
    }    
    
    public ImportDec addImport(String importStr)
    {
        ImportDec importDec = new ImportDec(importStr);
        imports.add(importDec);
        return importDec;
    }
    
    public void addImport(ImportDec importDec)
    {
        imports.add(importDec);
    }
    
    public List getImports()
    {
        return imports;
    }    
}
