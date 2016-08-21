/*
 * NativeFieldMethodSignatureXML.java
 *
 * Created on 18 de julio de 2005, 15:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodSignatureXML extends NativeBehaviorSignatureXML
{
    /**
     * Creates a new instance of NativeFieldMethodSignatureXML
     */
    public NativeFieldMethodSignatureXML()
    {
    }
    
    public NativeFieldMethodSignatureImpl getFieldMethodSignature()
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }

    public void parseTree(Element methodNode,TreeWalker walker,TaskContext ctx)
    {    
        try
        {
            // <fieldType ...>
            Element fieldTypeNode = TreeWalkerUtil.firstChildElement(walker,"fieldType",true);        

            ReturnDeclarationImpl returnType = ReturnDeclarationXML.parseReturnDeclaration(fieldTypeNode,walker,null,ctx);

            TreeWalkerUtil.parentElement(walker);

            NativeFieldMethodSignatureImpl sig = (NativeFieldMethodSignatureImpl)newBehaviorSignature(ctx.getJNIEasy());
            sig.setFieldDeclaration(returnType);
            
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
