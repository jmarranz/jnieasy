/*
 * TypeNativePrimitiveXML.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;


public abstract class TypeNativePrimitiveXML extends TypeNativeXML
{
    
    /** Creates a new instance of TypeNativePrimitiveXML */
    public TypeNativePrimitiveXML(TypeNativePrimitiveImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
        return (TypeNativePrimitiveImpl)typeDec;
    }    
    
    public void parse(Element typeNode, TreeWalker walker, TaskContext ctx)
    {
        super.parse(typeNode, walker, ctx);
        
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();
        parseAttMemSize(typeNode,typeDec);
    }    
   
    public static void parseAttMemSize(Element typeNode,TypeNativePrimitiveImpl typeDec)
    {
        try
        {
            Attr attMemSize = typeNode.getAttributeNode("memSize");
            if (attMemSize != null)
                typeDec.setMemSizeExpr(attMemSize.getValue());
            
            Attr attPrefAlignSize = typeNode.getAttributeNode("prefAlignSize");
            if (attPrefAlignSize != null)
                typeDec.setPreferredAlignSizeExpr(attPrefAlignSize.getValue());            
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
