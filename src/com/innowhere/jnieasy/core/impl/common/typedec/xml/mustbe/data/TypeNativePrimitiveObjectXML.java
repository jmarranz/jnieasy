/*
 * TypeNativePrimitiveObjectXML.java
 *
 * Created on 4 de abril de 2005, 14:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveXML;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author  jmarranz
 */


public class TypeNativePrimitiveObjectXML extends TypeCanBeNativeCapableXML
{
    
    /**
     * Creates a new instance of TypeNativePrimitiveObjectXML
     */
    public TypeNativePrimitiveObjectXML(TypeNativePrimitiveObjectImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativePrimitiveObjectImpl getTypeNativePrimitiveObject()
    {
        return (TypeNativePrimitiveObjectImpl)typeDec;
    }
     
    public static Element getComponentChildNode(TreeWalker walker,boolean mustExist)
    {
        // <component ... >
        return TreeWalkerUtil.firstChildElement(walker, "component", mustExist);
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        try
        {
            // <component ... >
            Element compNode = getComponentChildNode(walker,false);
            if (compNode != null)
            {              
                TypeNativePrimitiveObjectImpl typeDec = getTypeNativePrimitiveObject();
                TypeNativePrimitiveImpl typeDecComp = typeDec.getTypeNativePrimitive();
                
                TypeNativePrimitiveXML typeDecCompXML = (TypeNativePrimitiveXML)TypeNativePrimitiveXML.newTypeNativeXML(typeDecComp);
                typeDecCompXML.parse(compNode,walker,ctx);
                
                TreeWalkerUtil.parentElement(walker);
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
