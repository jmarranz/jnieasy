/*
 * XMLUtil.java
 *
 * Created on 18 de marzo de 2004, 16:57
 */

package com.innowhere.jnieasy.core.impl.util;


import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLUtil
{
    
    /** Creates a new instance of XMLUtil */
    public XMLUtil()
    {
    }
 
    public static Document parse(String filePathURL)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            factory.setValidating(false);
            factory.setNamespaceAware(true);            
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse( filePathURL );        
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public static Document createDocument(String rootName)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation domImpl = builder.getDOMImplementation();
            Document doc = domImpl.createDocument(null,rootName,null);          
            //doc.setEncoding("iso-8859-1"); // DOM-3 puede cambiar
            return doc;
        }
        catch(ParserConfigurationException ex)
        {
            throw new JNIEasyException(ex);
        }
    }        
/*    
    public static void save(Document doc,String filePath)
    {
        OutputFormat format = new OutputFormat(doc,"iso-8859-1",true);
        OutputStream stream;
        try
        {
            stream = new BufferedOutputStream(new FileOutputStream(filePath));
        }
        catch(FileNotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
        
        XMLSerializer serializer = new XMLSerializer(stream,format);
        try
        {
            serializer.serialize(doc);
            stream.close();
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }        

    }    
*/    
    public static Element appendChildElement(Element parentNode,String nodeName)
    {
        Document doc = parentNode.getOwnerDocument();
        Element childNode = doc.createElement(nodeName);
        parentNode.appendChild(childNode);    
        return childNode;
    }    
    
    public static Element getDocumentElement(Document doc,String tagName)
    {
        Element docElement = doc.getDocumentElement();

        if (!docElement.getTagName().equals(tagName))
            throw new JNIEasyXMLException("Expected root element with tag name: " + tagName,docElement);
        return docElement;       
    }
    
    public static String getTextContent(Element elem)
    {
        NodeList list = elem.getChildNodes();
        int len = list.getLength();
        if (len == 0) return null;
        String content = "";
        for(int i = 0; i < len ; i++)
        {
            Node child = list.item(i);
            if (child instanceof CharacterData)
                content += ((CharacterData)child).getData();
            else
                throw new JNIEasyException("Element content must be text");
        }
        return content;
    }
    
    public static void setTextContent(Element elem,String content)
    {
        Document doc = elem.getOwnerDocument();
        if ((content != null) && !content.equals(""))
        {
            Text textNode = doc.createTextNode(content);
            elem.appendChild(textNode);
        }
    }         
  
    
    public static Element appendChildElementString(Element parentNode,String tagName,String content)
    {
        Element elem = appendChildElement(parentNode,tagName);
        setTextContent(elem,content);
        return elem;
    }
    
    public static Element appendChildElementBoolean(Element parentNode,String tagName,boolean content)
    {
        Element elem = appendChildElement(parentNode,tagName);
        setBooleanContent(elem,content);
        return elem;
    }    
    
    public static Element appendChildElementInt(Element parentNode,String tagName,int content)
    {
        Element elem = appendChildElement(parentNode,tagName);
        setIntContent(elem,content);
        return elem;
    }        
    
    public static Element appendChildElementLong(Element parentNode,String tagName,long content)
    {
        Element elem = appendChildElement(parentNode,tagName);
        setLongContent(elem,content);
        return elem;
    }    
    
    public static Element appendChildElementFloat(Element parentNode,String tagName,float content)
    {
        Element elem = appendChildElement(parentNode,tagName);
        setFloatContent(elem,content);
        return elem;
    }        
    
    public static boolean getBooleanContent(Element elem)
    {
        return toBoolean(getTextContent(elem));
    }    
    
    public static void setBooleanContent(Element elem,boolean value)
    {
        setTextContent(elem,value ? "true" : "false");
    }        
    
    public static int getIntContent(Element elem)
    {
        return Integer.parseInt(getTextContent(elem));
    }    
    
    public static void setIntContent(Element elem,int value)
    {
        setTextContent(elem,Integer.toString(value));
    }    
    
    public static long getLongContent(Element elem)
    {
        return Long.parseLong(getTextContent(elem));
    }    
    
    public static void setLongContent(Element elem,long value)
    {
        setTextContent(elem,Long.toString(value));
    }
    
    public static float getFloatContent(Element elem)
    {
        return Float.parseFloat(getTextContent(elem));
    }  
    
    public static void setFloatContent(Element elem,float value)
    {
        setTextContent(elem,Float.toString(value));
    }    
    
    public static String getAttribute(Element elem,String attName)
    {
        Attr attr = elem.getAttributeNode(attName);
        if (attr == null) 
            throw new JNIEasyXMLException("Attribute \"" + attName + "\" is mandatory in this context",elem);        
        return attr.getValue();
    }
    
    public static void setAttribute(Element elem,String attName,String value)
    {
        // Aunque no aporte nada aparte de la simetría con getAttribute()
        // podremos hacer algún tipo de comprobación, si values es null etc
        elem.setAttribute(attName,value);
    }

    public static boolean getBooleanAttr(Element node,String attName)
    {
        String value = getAttribute(node,attName);
        return toBoolean(value);
    }    
    
    public static void setBooleanAttr(Element node,String attName,boolean value)
    {
        node.setAttribute(attName,Boolean.toString(value));
    }    
    
    public static long getLongAttr(Element node,String attName)
    {
        String value = getAttribute(node,attName);
        return Long.parseLong(value);
    }

    public static void setLongAttr(Element node,String attName,long value)
    {
        node.setAttribute(attName,Long.toString(value));
    }      
            
    public static boolean toBoolean(String value)
    {
        if (value.equals("true"))
            return true;
        else if (value.equals("false"))
            return false;
        else
            throw new JNIEasyException("Bad boolean value," + value + ",must be true or false");            
    }
    
    public static boolean getBooleanValue(Attr attr)
    {
        String value = attr.getValue();
        return toBoolean(value);
    }    
    
    public static String getAttribute(Element node,String attName,String defaultValue)
    {
        Attr attValue = node.getAttributeNode(attName);
        if (attValue == null) return defaultValue;
        return attValue.getValue();
    }
    
/*    

    
    public static boolean getBooleanAttr(Element node,String attName,boolean defaultValue)
    {
        Attr attValue = node.getAttributeNode(attName);
        if (attValue == null) return defaultValue;
        return getBooleanValue(attValue);
    }    

*/    
    public static String nodeToString(Node node)
    {
        String strNode = "";
        Node nodeIt = node;

        if (nodeIt instanceof Element)
        {
            Element elem = (Element)nodeIt;
            String strElem = "";
            strElem += "<" + elem.getTagName();
            NamedNodeMap attribs = elem.getAttributes();
            int len = attribs.getLength();
            for (int i = 0; i < len; i++)
            {
                Attr attr = (Attr)attribs.item(i);
                strElem += " " + attr.getName() + "=\"" + attr.getValue() + "\"";
            }
            strElem += ">";
            strNode = strElem + strNode;
        }
        else if (nodeIt instanceof CharacterData)
        {
            CharacterData charNode = (CharacterData)nodeIt;
            strNode = charNode.getData() + strNode;
        }
        else if (nodeIt instanceof Document)
            strNode = strNode; // no hacemos nada
        else
            strNode = nodeIt.getNodeValue() + strNode;

        return strNode;
    }    
    
    public static String nodeTreeToString(Node node)
    {
        String strNode = "";
        Node nodeIt = node;
        while (nodeIt != null)
        {
            strNode = nodeToString(nodeIt) + strNode;

            nodeIt = nodeIt.getParentNode();
        }    
        return strNode;
    }
    
}
