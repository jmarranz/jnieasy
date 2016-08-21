/*
 * NativeMethodSignatureXML.java
 *
 * Created on 28 de febrero de 2005, 17:18
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import java.util.ArrayList;

public abstract class NativeMethodSignatureXML extends NativeBehaviorSignatureXML
{
   
    /**
     * Creates a new instance of NativeMethodSignatureXML
     */
    public NativeMethodSignatureXML()
    {
    }

    public NativeMethodSignatureImpl getMethodSignature()
    {
        return (NativeMethodSignatureImpl)signature;
    }

    public void parseTree(Element methodNode,TreeWalker walker,TaskContext ctx)
    {    
        try
        {
            // <return>
            Element returnNode = TreeWalkerUtil.firstChildElement(walker,"return",true); 
            ReturnDeclarationImpl returnType = ReturnDeclarationXML.parseReturnDeclaration(returnNode,walker,null,ctx);

            // <params>
            Element paramsNode = TreeWalkerUtil.nextSiblingElement(walker,"params",true);

            ArrayList params;            
            params = ParameterDecListXML.parseParameterDecListAttribute(paramsNode,ctx);
            if (params == null)        
                params = ParameterDecListXML.parseParameterDecListTree(paramsNode,walker,ctx);            
            
            TreeWalkerUtil.parentElement(walker);

            NativeMethodSignatureImpl sig = (NativeMethodSignatureImpl)newBehaviorSignature(ctx.getJNIEasy());
            sig.setReturnDeclaration(returnType);
            sig.addParameterDecList(params);
            
            setBehaviorSignature(sig);             
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }
        
        super.parseTree(methodNode, walker, ctx);
    }

}
