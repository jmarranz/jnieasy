/*
 * ParameterDecListXML.java
 *
 * Created on 21 de febrero de 2005, 17:28
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import java.util.*;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;


public class ParameterDecListXML
{
    protected ArrayList paramList = new ArrayList();
    
    /** Creates a new instance of ParameterDecListXML */
    public ParameterDecListXML()
    {
    }
 
    public static ParameterDecListXML newParameterDecListXML()
    {
        return new ParameterDecListXML();
    }
    
    public ArrayList getParameterDecList()
    {
        return paramList;
    }

    public void parse(Element paramsNode,TreeWalker walker,final TaskContext ctx)
    {
        try
        {
            XMLTask paramTask = new XMLTask()
            {
                public void doTask(Element paramNode,TreeWalker walker,int counter)
                {
                    // <param ...
                    final ParameterDecXML paramXML = ParameterDecXML.newParameterDecXML( counter + 1); // se cuenta desde 1
                    paramXML.parse(paramNode,walker,null,ctx);
                    paramList.add(paramXML.getParameterDec());
                }
            };
            
            TreeWalkerUtil.processChildElements(walker, paramTask,"param");
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,paramsNode);
        }        
    }    
    
    public static ArrayList parseParameterDecListTree(Element paramsNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            ParameterDecListXML paramDecListXML = ParameterDecListXML.newParameterDecListXML();
            paramDecListXML.parse(paramsNode, walker,ctx);
            return paramDecListXML.getParameterDecList();
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,paramsNode);
        }        
    }      
    
    public static ArrayList parseParameterDecListAttribute(Element constrMethodOrParamsElem,TaskContext ctx)
    {
        // Caso: params="type, type,...,type"
        Attr paramsAttr = constrMethodOrParamsElem.getAttributeNode("params");
        if (paramsAttr == null)
            return null;
        
        ArrayList paramDecList = new ArrayList();
        
        String paramsStr = paramsAttr.getValue();

        // Esperamos: type, type,...,type
        String[] classNames = paramsStr.split(",");
        for(int i = 0; i < classNames.length; i++)
        {
            String className = classNames[i];
            className = className.trim(); // Espacios sobrantes
            if ((classNames.length == 1)&& (className.length() == 0))
                break; // Caso params=" " 
            VarTypeNativeImpl type = VarTypeNativeImpl.newVarTypeNative(ctx.getClassType(className));
            ParameterDecImpl param = new ParameterDecImpl(type);
            paramDecList.add(param);
        }              
        
        return paramDecList;
    }
}
