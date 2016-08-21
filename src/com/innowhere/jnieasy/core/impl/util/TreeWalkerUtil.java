/*
 * TreeWalkerUtil.java
 *
 * Created on 17 de enero de 2008, 12:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.util;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class TreeWalkerUtil
{
    
    /** Creates a new instance of TreeWalkerUtil */
    public TreeWalkerUtil()
    {
    }
    
    public static TreeWalker createTreeWalker(Element node)
    {
        //DocumentTraversal doc = (DocumentTraversal)node.getOwnerDocument();
        //return doc.createTreeWalker(node,NodeFilter.SHOW_ELEMENT,null,true);        

        return new TreeWalkerImpl(node,NodeFilter.SHOW_ELEMENT,null,true);
    }     
    
    public static Element parentElement(TreeWalker walker)
    {
        return (Element)walker.parentNode();    
    }
    
    public static boolean hasChildElement(TreeWalker walker)
    {
        Node current = walker.getCurrentNode();
        Node child = walker.firstChild();
        if (child != null)
        {
            walker.setCurrentNode(current);
            return true;
        }
        return false;
    }    
    
    public static Element firstChildElement(TreeWalker walker,boolean mustExist)
    {
        Element childNode = (Element)walker.firstChild();
        checkElement(childNode,walker, mustExist, "child");
        return childNode;
    }    
    
    public static Element firstChildElement(TreeWalker walker,String tagName,boolean mustExist)
    {
        Element childNode = (Element)walker.firstChild();
        checkElement(childNode,walker, tagName, mustExist, "child");
        return childNode;
    }    
    
    public static Element nextSiblingElement(TreeWalker walker,String tagName,boolean mustExist)
    {
        Element siblingNode = (Element)walker.nextSibling();
        checkElement(siblingNode,walker, tagName, mustExist, "sibling");
        return siblingNode;        
    }        
    
    public static void processChildElements(TreeWalker walker,XMLTask task)
    {    
        processChildElements(walker,task,null);
    }
    
    public static void processChildElements(TreeWalker walker,XMLTask task,String tagName)
    {
        Element childNode = firstChildElement(walker, tagName, false);
        if (childNode != null)
        {
            int counter = 0;
            do
            {
                try
                {
                    task.doTask(childNode,walker,counter);
                }
                catch(JNIEasyXMLException ex)
                {
                    throw ex;
                }        
                catch(Exception ex)
                {
                    throw new JNIEasyXMLException(ex,childNode);
                }
        
                childNode = nextSiblingElement(walker, tagName, false);
                counter++;
            }
            while (childNode != null);

            TreeWalkerUtil.parentElement(walker);
        }    
    } 
    
    public static void processElementsToEnd(TreeWalker walker,XMLTask task,String tagName)
    {
        Element childNode = nextSiblingElement(walker, tagName, false);
        while (childNode != null)
        {
            int counter = 0;
            try
            {
                task.doTask(childNode,walker,counter);
            }
            catch(JNIEasyXMLException ex)
            {
                throw ex;
            }        
            catch(Exception ex)
            {
                throw new JNIEasyXMLException(ex,childNode);
            }

            childNode = nextSiblingElement(walker, tagName, false);
            counter++;
        }    
        // NO subimos, es responsabilidad del que bajó
        // TreeWalkerUtil.parentElement(walker);  
    }        
    
    private static void checkElement(Element childNode,TreeWalker walker,String tagName,boolean mustExist,String type)
    {
        if (childNode == null)
        {
            if (mustExist)
                throw new JNIEasyXMLException("Expected a " + type + " element (<" + tagName + ">)",walker.getCurrentNode());
        }
        else if ((tagName != null) && !childNode.getTagName().equals(tagName))
                throw new JNIEasyXMLException("Expected element with tag name: \"" + tagName + "\"",childNode);
    }     
    
    private static void checkElement(Element childNode,TreeWalker walker,boolean mustExist,String type)
    {
        if (childNode == null)
        {
            if (mustExist)
                throw new JNIEasyXMLException("Expected a " + type + " element",walker.getCurrentNode());
        }
    }    
}
