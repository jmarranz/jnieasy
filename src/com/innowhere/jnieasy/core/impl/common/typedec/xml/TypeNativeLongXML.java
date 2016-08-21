/*
 * TypeNativeLongXML.java
 *
 * Created on 4 de marzo de 2006, 17:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeLongImpl;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class TypeNativeLongXML extends TypeNativePrimitiveXML
{
    
    /**
     * Creates a new instance of TypeNativeLongXML
     */
    public TypeNativeLongXML(TypeNativeLongImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativeLongImpl getTypeNativeLong()
    {
        return (TypeNativeLongImpl)typeDec;
    }
    
    public void parse(Element typeNode, TreeWalker walker, TaskContext ctx)
    {
        super.parse(typeNode, walker, ctx);
        
        try
        {
            TypeNativeLongImpl typeDec = getTypeNativeLong();
            Attr attAddress = typeNode.getAttributeNode("address");
            if (attAddress != null)
            {
                if (typeDec.getMemSizeExpr() != null)
                    throw new JNIEasyException("address and memSize attributes are not compatible");
                
                typeDec.setIsAddress(XMLUtil.getBooleanValue(attAddress));
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
