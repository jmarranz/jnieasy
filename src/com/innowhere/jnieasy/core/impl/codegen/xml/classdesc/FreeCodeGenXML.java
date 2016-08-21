/*
 * FreeCodeGenXML.java
 *
 * Created on 9 de septiembre de 2005, 12:09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FreeCodeGen;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;
import org.w3c.dom.Element;

/**
 *
 * @author jmarranz
 */
public class FreeCodeGenXML
{
    
    /**
     * Creates a new instance of FreeCodeGenXML 
     */
    public FreeCodeGenXML()
    {
    }
    
    public static boolean isFreeCodeNode(String tagName)
    {
        return tagName.equals("freeCode");
    }
    
    public static FreeCodeGen parse(Element freeCodeNode)
    {
        return new FreeCodeGen(XMLUtil.getTextContent(freeCodeNode));
    }
    
}
