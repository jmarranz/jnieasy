/*
 * JNIEasyXMLException.java
 *
 * Created on 27 de enero de 2005, 15:08
 */

package com.innowhere.jnieasy.core;

import com.innowhere.jnieasy.core.impl.util.XMLUtil;
import org.w3c.dom.*;

/**
 * <code>JNIEasyXMLException</code> is the {@link JNIEasyException} 
 * derived class that can be thrown processing XML. 
 * 
 * @author  Jose M. Arranz Santamaria
 */

public class JNIEasyXMLException extends JNIEasyException
{
    private Node node;
    
    public JNIEasyXMLException(Throwable cause,Node node)
    {
        super(cause);
        this.node = node;        
    }    
    
    public JNIEasyXMLException(String message,Node node)
    {
        super(message);
        this.node = node;        
    }    
 /*
    public Node getNode()
    {
        return this.node;
    }
*/    
    /**
     * Returns the detail message string of this exception showing the 
     * path from the offender XML node to the root node. 
     * It helps to localize in the XML file the node cause of error.
     *
     * @return the detail message string of this exception.
     */    
    public String getMessage()
    {
        String msgNode = "";
        if (node != null)
            msgNode = XMLUtil.nodeTreeToString(node);
        return super.getMessage() + " " + msgNode;
    }
}
