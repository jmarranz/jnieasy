/*
 * ImportGen.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.render;

/**
 *
 * @author  jmarranz
 */
import java.io.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;

public class ImportDecRender
{
    protected ImportDec importDec;
    
    /** Creates a new instance of ImportGen */
    public ImportDecRender(ImportDec importDec)
    {
        this.importDec = importDec;
    }
    
    public static ImportDecRender newImportDecRender(ImportDec importGen)
    {
        return new ImportDecRender(importGen);
    }

    public ImportDec getImportDec()
    {
        return importDec;
    }
    
    public String generate()
    {
        // Se podría prescindir de poner los import pues los nombres
        // de las clases se resuelven de forma absoluta.
        return "import " + importDec.getClassImport() + "; \n";
    }    
}
