/*
 * ClassTypeXML.java
 *
 * Created on 1 de julio de 2005, 22:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.xml;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeXML
{
    protected ClassTypeNativeImpl classType;
            
    /** Creates a new instance of ClassTypeXML */
    public ClassTypeXML(ClassTypeNativeImpl classType)
    {
        this.classType = classType;
    }
    
    public ClassTypeNativeImpl getClassType()
    {
        return classType;
    }
    
    public static ClassTypeXML newClassTypeXML(ClassTypeNativeImpl classType)
    {      
        return classType.newClassTypeXML();
    }
    
    public static String getClassNameAttr(Element node)
    {
        return XMLUtil.getAttribute(node,"class");
    }
    
    public static ClassTypeXML newClassTypeXML(Element node,ClassTypeNativeImpl classType,TaskContext ctx)
    {    
        try
        {
            // Ej. <param/return/field [class="int"] [...] />  
            if (classType == null)
            {    
                String className = getClassNameAttr(node);
                classType = ctx.getClassType(className);  
            }
            return newClassTypeXML(classType);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,node);
        }  
    }
    
    public void parse(Element node,TreeWalker walker,TaskContext ctx)
    {        
        // Nada que hacer por ahora
    }
}
