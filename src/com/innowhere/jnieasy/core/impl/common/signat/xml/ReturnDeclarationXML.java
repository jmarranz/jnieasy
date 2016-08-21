/*
 * ParameterDec.java
 *
 * Created on 26 de marzo de 2004, 19:12
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;
/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.MethodHeaderDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;



public class ReturnDeclarationXML extends MethodHeaderDeclarationXML
{
       
    /** Creates a new instance of ParameterDec */
    public ReturnDeclarationXML()
    {
    }
    
    public static ReturnDeclarationXML newReturnDeclarationXML()
    {
        return new ReturnDeclarationXML();
    }
    
    public ReturnDeclarationImpl getReturnDeclaration()
    {
        return (ReturnDeclarationImpl)type;
    }

    public MethodHeaderDeclarationImpl newMethodHeaderDeclaration(VarTypeNativeImpl varType)
    {
        return new ReturnDeclarationImpl(varType);
    }    
    
    public static ReturnDeclarationImpl parseReturnDeclaration(Element returnNode,ClassTypeNativeImpl returnType,TaskContext ctx)
    {
        TreeWalker walker = TreeWalkerUtil.createTreeWalker(returnNode);
        return parseReturnDeclaration(returnNode,walker,returnType,ctx);
    }  
    
    public static ReturnDeclarationImpl parseReturnDeclaration(Element returnNode,TreeWalker walker,ClassTypeNativeImpl returnType,TaskContext ctx)
    {
        try
        {
            ReturnDeclarationXML retTypeXML = new ReturnDeclarationXML();
            retTypeXML.parse(returnNode,walker,returnType,ctx);
            return retTypeXML.getReturnDeclaration();
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,returnNode);
        }        
    }    
}
