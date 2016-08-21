/*
 * TypeNativePointerDefaultXML.java
 *
 * Created on 30 de septiembre de 2005, 13:13
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.xml.VarTypeNativeXML;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class TypeNativePointerDefaultXML extends TypeNativePointerXML
{
    
    /**
     * Creates a new instance of TypeNativePointerDefaultXML
     */
    public TypeNativePointerDefaultXML(TypeNativePointerDefaultImpl typeDec)
    {
        super(typeDec);
    }

    
    public void parse(Element typeNode, TreeWalker walker, TaskContext ctx)
    {
        super.parse(typeNode, walker, ctx);
        
        try
        {
            // <pointer ... >
            Element pointerNode = TreeWalkerUtil.firstChildElement(walker, "pointer", true);
            if (pointerNode != null)
            {
                TypeNativePointerImpl typeDec = getTypeNativePointer();
                
                // Se sustituye el tipo por defecto o se define por primera vez
                VarTypeNativeXML pointerVarTypeXML = VarTypeNativeXML.newVarTypeNativeXML(pointerNode,walker,null,ctx);
                pointerVarTypeXML.parse(typeNode,walker,ctx);
                typeDec.setAddressedVarTypeNativeObject((VarTypeNativeObjectImpl)pointerVarTypeXML.getVarTypeNative());                    

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
