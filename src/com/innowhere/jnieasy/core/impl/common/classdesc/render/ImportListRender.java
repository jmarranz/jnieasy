/*
 * ImportListXML.java
 *
 * Created on 30 de marzo de 2005, 18:56
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.render;

/**
 *
 * @author  jmarranz
 */
import java.io.*;
import java.util.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportList;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;

public class ImportListRender
{
    protected ImportList importList;
    
    /** Creates a new instance of ImportListXML */
    public ImportListRender(ImportList importList)
    {
        this.importList = importList;
    }
    
    public static ImportListRender newImportListRender(ImportList importList)
    {
        return new ImportListRender(importList);
    }
    
    public StringBuffer generate()
    {
        StringBuffer code = new StringBuffer();
        Iterator it = importList.getImports().iterator();
        it.next(); // Quitamos el java.lang.* pues no es necesario
        while(it.hasNext())
        {
            ImportDec imp = (ImportDec)it.next();
            ImportDecRender impRender = ImportDecRender.newImportDecRender(imp);
            code.append( impRender.generate() );
        }
        return code;
    }
}
