/*
 * BehaviorReflectionOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:54
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.BehaviorOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerUnknownEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;

import javassist.CtBehavior;

public abstract class BehaviorOfClassEnhancerXML extends MemberOfClassEnhancerXML
{
               
    /** Creates a new instance of BehaviorReflectionOfClassXML */
    public BehaviorOfClassEnhancerXML(BehaviorOfClassXML accessObjOfClassXML,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }
    
    public BehaviorOfClassEnhancer getBehaviorOfClassEnhancer()
    {
        return (BehaviorOfClassEnhancer)memberOfClassEnh;
    }
    
    public BehaviorOfClassXML getBehaviorOfClassXML()
    {
        return (BehaviorOfClassXML)accessObjOfClassXML;
    }   
    
    public static BehaviorOfClassEnhancerXML newBehaviorOfClassEnhancerXML(Element behaviorNode,EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnh)
    {
        String tagName = behaviorNode.getTagName();
        BehaviorOfClassXML behaviorOfClassXML = BehaviorOfClassXML.newBehaviorOfClassXML(tagName,classEnh.getJavaClassAsNativeCapable());
        return (BehaviorOfClassEnhancerXML)behaviorOfClassXML.newMemberOfClassEnhancerXML(classEnh);
    }        
    
    public void parse(Element methodNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {        
        try
        {
            // <method/constructor/fieldMethod  
            //     [exportMethod="true|false] 
            //     [onLibrary="true|false"] 
            //     [useReflection="true|false"] ...>
            
            BehaviorOfClassEnhancer behaviorEnh = getBehaviorOfClassEnhancer();            
         
            Attr onLibraryAttr = methodNode.getAttributeNode("onLibrary");
            if (onLibraryAttr != null)
                behaviorEnh.setOnLibrary(XMLUtil.getBooleanValue(onLibraryAttr));

            if (!behaviorEnh.isOnLibrary())
            {
                Attr useReflectionAttr = methodNode.getAttributeNode("useReflection");
                if (useReflectionAttr != null)
                    behaviorEnh.setUseReflection(XMLUtil.getBooleanValue(useReflectionAttr));
            }
            else
            {
                getBehaviorOfClassXML().parseNativeName(methodNode);                            
            }
            
            Attr exportAttr = methodNode.getAttributeNode("exportMethod");
            if (exportAttr != null) 
                behaviorEnh.setExportMethod(XMLUtil.getBooleanValue(exportAttr));
            
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }
       
        super.parse(methodNode, walker, ctx);
    }

    public static void checkBehaviorContainer(JavaClassAsNativeCapableEnhancer classEnh)
    {
        // Detectamos si puede ser un legítimo container, porque sino dará el error después en ejecución
        if (classEnh instanceof JavaClassAsNativeMultipleFieldContainerUnknownEnhancer)
            throw new JNIEasyException(classEnh.getName() + " is not a enhanceable class, can not contain a instance method callable from native");
    }
    
    public abstract CtBehavior parseParamsNotEnhance(Element constrNode,TreeWalker walker,EnhancerSourceFileContext ctx);
        
}
