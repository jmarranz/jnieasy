/*
 * Type.java
 *
 * Created on 29 de marzo de 2004, 13:59
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.xml.VarTypeNativeXML;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.MethodHeaderDeclarationImpl;


/**
 *
 * @author  jmarranz
 */


public abstract class MethodHeaderDeclarationXML
{
    protected MethodHeaderDeclarationImpl type;
    
    /** Creates a new instance of Type */
    public MethodHeaderDeclarationXML()
    {
    }
    
    public void parse(Element node,TreeWalker walker,ClassTypeNativeImpl dataType,TaskContext ctx)
    {    
        try
        {
            // Ej. <param/return [...] />  
            VarTypeNativeXML varTypeXML = VarTypeNativeXML.newVarTypeNativeXML(node,walker,dataType,ctx);
            varTypeXML.parse(node,walker,ctx);
            VarTypeNativeImpl varType = varTypeXML.getVarTypeNative();
            varType.check();
            
            this.type = newMethodHeaderDeclaration(varType);  
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
    
    public abstract MethodHeaderDeclarationImpl newMethodHeaderDeclaration(VarTypeNativeImpl varTypeDec);
}
