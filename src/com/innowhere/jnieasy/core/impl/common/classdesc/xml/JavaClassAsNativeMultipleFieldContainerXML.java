/*
 * JavaClassAsNativeMultipleFieldContainerXML.java
 *
 * Created on 16 de septiembre de 2005, 13:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeMultipleFieldContainerXML extends JavaClassAsNativeFieldContainerXML
{
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerXML
     */
    public JavaClassAsNativeMultipleFieldContainerXML(JavaClassAsNativeMultipleFieldContainerImpl javaClass)
    {
        super(javaClass);
    }

    public JavaClassAsNativeMultipleFieldContainerImpl getJavaClassAsMultipleFieldContainer()
    {
        return (JavaClassAsNativeMultipleFieldContainerImpl)javaClass;
    }
    
    public void parse(Element classNode,TreeWalker walker)
    {
        // Ej. <class name="SimpleClassName" libraryPath="User32.dll">
        
        JavaClassAsNativeMultipleFieldContainerImpl javaClass = getJavaClassAsMultipleFieldContainer();

        Attr libPathAtt = classNode.getAttributeNode("libraryPath");
        if (libPathAtt != null)
        {
            String libraryPath = libPathAtt.getValue();        
            javaClass.setLibraryPath(libraryPath);        
        }
    }
}
