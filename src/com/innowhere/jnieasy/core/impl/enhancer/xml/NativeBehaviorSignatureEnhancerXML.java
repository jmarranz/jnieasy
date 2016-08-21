/*
 * NativeBehaviorSignatureEnhancerXML.java
 *
 * Created on 27 de junio de 2005, 11:48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.common.classtype.xml.ClassTypeXML;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;

import java.util.ArrayList;
import javassist.CtClass;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class NativeBehaviorSignatureEnhancerXML
{
    
    /**
     * Creates a new instance of NativeBehaviorSignatureEnhancerXML
     */
    public NativeBehaviorSignatureEnhancerXML()
    {
    }
    
    public static CtClass[] parseParams(Element methodNode,TreeWalker walker,final EnhancerSourceFileContext ctx)
    {
        // No es necesario un nodo <params> padre
        try
        {
            final ArrayList params = new ArrayList();

            XMLTask paramTask = new XMLTask()
            {
                public void doTask(Element paramNode,TreeWalker walker,int counter)
                {
                    // <param class="JavaClass" />
                    String className = ClassTypeXML.getClassNameAttr(paramNode);
                    // De esta manera aseguramos que se usan los imports y que el className será absoluto
                    params.add(ctx.getCtClass(className));
                }
            };
            
            TreeWalkerUtil.processChildElements(walker, paramTask,"param");

            CtClass[] paramList = new CtClass[params.size()];
            paramList = (CtClass[])params.toArray(paramList);
            return paramList;
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
        
}
