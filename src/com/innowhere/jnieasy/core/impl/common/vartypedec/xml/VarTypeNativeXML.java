/*
 * VarTypeNativeXML.java
 *
 * Created on 14 de enero de 2005, 15:15
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;

public class VarTypeNativeXML
{
    protected VarTypeNativeImpl varType;
    protected TypeNativeXML typeXML;
    protected boolean needParse = true;
    
    /**
     * Creates a new instance of VarTypeNativeXML
     */
    public VarTypeNativeXML(VarTypeNativeImpl varTypeDec,TypeNativeXML typeDecXML)
    {
        this.varType = varTypeDec;        
        this.typeXML = typeDecXML;
    }
    
    public VarTypeNativeImpl getVarTypeNative()
    {
        return varType;
    }
    
    public static VarTypeNativeXML newVarTypeNativeXML(VarTypeNativeImpl varTypeDec)
    {
        TypeNativeXML typeDecXML = TypeNativeXML.newTypeNativeXML(varTypeDec.getTypeNative());
        return varTypeDec.newVarTypeNativeXML(typeDecXML);        
    }
    
    public static VarTypeNativeXML newVarTypeNativeXML(TypeNativeXML typeDecXML)
    {
        VarTypeNativeImpl varTypeDec = VarTypeNativeImpl.newVarTypeNative(typeDecXML.getTypeNative());        
        return varTypeDec.newVarTypeNativeXML(typeDecXML);
    }
    
    public static VarTypeNativeXML newVarTypeNativeXML(Element node,TreeWalker walker,ClassTypeNativeImpl dataType,TaskContext ctx)
    {   
        // Ej. <param/return/field/component [dec="..."] ... />  
        
        VarTypeNativeImpl varTypeDec;
        Attr decAtt = node.getAttributeNode("dec");
        if (decAtt != null)
        {
            varTypeDec = VarTypeNativeParserImpl.newVarTypeNative(decAtt.getValue(),ctx);
            if (dataType != null)         
            {
                // Ha de ser igual que el tipo de datos esperado
                if (!dataType.getClass().equals(varTypeDec.getTypeNative().getClassType().getClass()))
                    throw new JNIEasyException("Bad class, expected: " + dataType.getClassName());
            }
            VarTypeNativeXML varTypeDecXML = newVarTypeNativeXML(varTypeDec);
            varTypeDecXML.setNeedParse(false);
            return varTypeDecXML;
        }        
        else
        {
            TypeNativeXML typeDecXML = TypeNativeXML.newTypeNativeXML(node,walker,dataType,ctx);
            return newVarTypeNativeXML(typeDecXML);
        }
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        if (!needParse) return;
        parseTree(typeNode,walker, ctx);
    }
    
    public void parseTree(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            typeXML.parse(typeNode,walker, ctx);
            
            //<... [conv="ByPtr|ByValue|ByDefault"] /> 

            VarTypeNativeImpl varTypeDec = getVarTypeNative();

            Attr convAttr = typeNode.getAttributeNode("varConv");
            if (convAttr != null)
            {
                int varConv = convertVarConv(convAttr.getValue());
                varTypeDec.setVarConv(varConv);
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
    
    public static int convertVarConv(String str)
    {
        if (str.equals("byPtr"))
            return VarTypeNative.BY_PTR;
        else if (str.equals("byValue"))
            return VarTypeNative.BY_VALUE;
        else if (str.equals("byDefault"))
            return VarTypeNative.BY_DEFAULT;
        else
            throw new JNIEasyException("Bad conventionalism attribute value " + str + ", must be: ByPtr, ByValue or ByDefault");
    }    
    
    public boolean needParse()
    {
        return needParse;
    }

    public void setNeedParse(boolean needParse)
    {
        this.needParse = needParse;
    }    
}
