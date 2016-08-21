/*
 * TypeNativePrimitiveWrapperXML.java
 *
 * Created on 4 de abril de 2005, 14:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveXML;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

public class TypeNativePrimitiveWrapperXML extends TypeNativeSingleFieldContainerXML
{
    
    /**
     * Creates a new instance of TypeNativePrimitiveWrapperXML
     */
    public TypeNativePrimitiveWrapperXML(TypeNativePrimitiveWrapperImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativePrimitiveWrapperImpl getTypeNativePrimitiveWrapper()
    {
        return (TypeNativePrimitiveWrapperImpl)typeDec;
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
                TypeNativePrimitiveWrapperImpl typeDec = getTypeNativePrimitiveWrapper();
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
