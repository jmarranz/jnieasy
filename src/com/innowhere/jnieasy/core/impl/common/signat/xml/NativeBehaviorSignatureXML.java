/*
 * MethodSignature.java
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

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.parser.NativeBehaviorSignatureParserImpl;

public abstract class NativeBehaviorSignatureXML
{
    protected NativeBehaviorSignatureImpl signature;

    
    /** Creates a new instance of MethodSignature */
    public NativeBehaviorSignatureXML()
    {
    }    
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }

    public void setBehaviorSignature(NativeBehaviorSignatureImpl signature)
    {
        this.signature = signature;
    }    

    public static NativeBehaviorSignatureImpl getBehaviorSignatureStringDec(Element methodNode,TaskContext ctx)
    {
        Attr attSigNode = methodNode.getAttributeNode("decSignature");
        if (attSigNode != null)
            return NativeBehaviorSignatureParserImpl.parseBehaviorSignature(attSigNode.getValue(), ctx);
        else
            return null;
    }
    
    public void parse(Element methodNode,TreeWalker walker,TaskContext ctx)
    {    
        // <field/component/method ... [decSignature="..."] ... >    
        NativeBehaviorSignatureImpl sig = getBehaviorSignatureStringDec(methodNode,ctx);
        if (sig != null)            
            setBehaviorSignature(sig);
        else
            parseTree(methodNode, walker, ctx);
    }
    
    public void parseTree(Element methodNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            // Ej. <field/component/method ... [callConv="std_call|c_call"] >
           
            setCallConv(signature,methodNode);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }
    }    
    
    public static void setCallConv(NativeBehaviorSignatureImpl signature,Element methodNode)
    {
        // Ej. <field/component/method ... [callConv="std_call|c_call"] >

        Attr callConvAtt = methodNode.getAttributeNode("callConv");
        if (callConvAtt != null)
        {
            int callConv = callConvTranslate(callConvAtt.getValue());
            signature.setCallConv(callConv);
        }    
    }
    
    public static int callConvTranslate(String value)
    {
        if (value.equals("std_call"))
            return CallConv.STD_CALL;
        else if (value.equals("c_call"))
            return CallConv.C_CALL; 
        else 
            throw new JNIEasyException("Bad convention method call name: " + value);
    }
    
    public abstract NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy);
}
