/*
 * ImportGen.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;



public class ImportDecXML
{
    protected ImportDec importDec;
    
    /** Creates a new instance of ImportGen */
    public ImportDecXML(ImportDec importDec)
    {
        this.importDec = importDec;
    }
    
    public static ImportDecXML newImportDecXML()
    {
        return new ImportDecXML(new ImportDec());
    }

    public ImportDec getImportDec()
    {
        return importDec;
    }
    
    public void parse(Element importsNode)
    {    
        try
        {
            // Ej. <import class="com.innowhere.jnieasy.core.*" />
            String classImport = XMLUtil.getAttribute(importsNode,"class");
            importDec.setClassImport(classImport);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,importsNode);
        }          
    }
}
