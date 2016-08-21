package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;
/*
 * JavaClassAsNativeDirectCallbackEnhancerXML.java
 *
 * Created on 7 de julio de 2005, 12:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ThisClassSignatureUtilXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticMethodCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import javassist.CtClass;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;



/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectCallbackEnhancerXML extends JavaClassAsNativeCapableEnhancerXML
{
    /**
     * Creates a new instance of JavaClassAsNativeDirectCallbackEnhancerXML
     */
    public JavaClassAsNativeDirectCallbackEnhancerXML(JavaClassAsNativeDirectCallbackEnhancer javaClassEnh)
    {
        super(javaClassEnh);
    } 
    
    public JavaClassAsNativeDirectCallbackEnhancer getJavaClassAsNativeDirectCallbackEnhancer()
    {
        return (JavaClassAsNativeDirectCallbackEnhancer)javaClassEnh;
    }

    public static JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancerXML(Element classNode,TreeWalker walker,CtClass ctClass,EnhancerSourceFileContext ctx)
    {
        try
        {                
            Element behaviorNode = (Element)TreeWalkerUtil.firstChildElement(walker,false);  
            if (behaviorNode == null) throw new JNIEasyException("Expected a <constructor> or <method> or <fieldMethod> child node");            

            BehaviorOfClassEnhancer behaviorEnh;
            JavaClassAsNativeDirectCallbackEnhancer javaClassDirectEnh;
            
            Attr containerClassNameAtt = behaviorNode.getAttributeNode(ThisClassSignatureUtilXML.getThisClassAttName());
            if (containerClassNameAtt != null)
            {
                String containerClassName = containerClassNameAtt.getValue();
                JavaClassAsNativeMultipleFieldContainerEnhancer javaClassContainerEnh = JavaClassAsNativeDirectCallbackEnhancer.getMethodContainerJavaClass(containerClassName,ctx); // La clase que verdaderamente alberga el método
               
                BehaviorOfClassEnhancerXML behaviorEnhXML = BehaviorOfClassEnhancerXML.newBehaviorOfClassEnhancerXML(behaviorNode,ctx,javaClassContainerEnh);         
                behaviorEnhXML.parse(behaviorNode,walker,ctx);
                behaviorEnh = behaviorEnhXML.getBehaviorOfClassEnhancer();
                javaClassDirectEnh = behaviorEnh.newJavaClassAsNativeDirectCallbackEnhancer(ctClass,ctx.getParentContext());
            }
            else
            {
                // El método suponemos que está en la propia clase Callback
                // Sólo es válido el caso estático aunque el método sea no estático (válido para permitir herencia)
                // no tiene sentido que se albergue un constructor 
                
                javaClassDirectEnh = JavaClassAsNativeDirectStaticMethodCallbackEnhancer.newJavaClassAsNativeDirectStaticMethodCallbackEnhancer(ctClass,ctx.getParentContext());                
                 
                BehaviorOfClassEnhancerXML behaviorEnhXML = BehaviorOfClassEnhancerXML.newBehaviorOfClassEnhancerXML(behaviorNode,ctx,javaClassDirectEnh);         
                behaviorEnhXML.parse(behaviorNode,walker,ctx);
                behaviorEnh = behaviorEnhXML.getBehaviorOfClassEnhancer();                
            }

            javaClassDirectEnh.setBehaviorOfClassEnhancer(behaviorEnh); 
            
            TreeWalkerUtil.parentElement(walker);
        
            return javaClassDirectEnh;
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,classNode);
        } 
    }    
    
    public FieldOfClassEnhancerXML newFieldOfClassEnhancerXML()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public void parseFieldsAndMethods(Element classNode,TreeWalker walker, EnhancerSourceFileContext ctx)
    {
        // Ya fue parseado

    }
  

}
