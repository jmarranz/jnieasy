/*
 * StringInfoXML.java
 *
 * Created on 10 de enero de 2005, 19:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import org.w3c.dom.*;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeStringBasedParserImpl;



public class TypeNativeStringInfoXML
{
    protected TypeNativeStringBasedInterface typeDec;
    
    /** Creates a new instance of StringInfoXML */
    public TypeNativeStringInfoXML(TypeNativeStringBasedInterface typeDec)
    {
        this.typeDec = typeDec;
    }
    
    public void parse(Element typeNode)
    {
        try
        {
            //<field ... [encoding="ansi|unicode"] /> Admite macros

            Attr encodingAtt = typeNode.getAttributeNode("encoding");
            if (encodingAtt != null)
            {
                String encodingExpr = encodingAtt.getValue();
                typeDec.setEncodingExpr(encodingExpr);           
            }
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,typeNode);
        }        
    }    
}
