/*
 * FieldOfClassAsNativeMultipleFieldContainerEnhancerXML.java
 *
 * Created on 29 de junio de 2005, 14:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeSeparatedFieldContainerEnhancer;
import javassist.CtField;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeMultipleFieldContainerEnhancerXML extends FieldOfClassEnhancerXML
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeMultipleFieldContainerEnhancerXML
     */
    public FieldOfClassAsNativeMultipleFieldContainerEnhancerXML(FieldOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }
    
    public FieldOfClassAsNativeMultipleFieldContainerEnhancer getFieldOfClassAsMultipleFieldContainerEnhancer()
    {
        return (FieldOfClassAsNativeMultipleFieldContainerEnhancer)memberOfClassEnh;
    }    
    
    public void parse(Element fieldNode,TreeWalker walker,CtField ctField,EnhancerSourceFileContext ctx)
    {    
        super.parse(fieldNode,walker,ctField,ctx);
        
        try
        {
            // <field ... [alignSize="size"] [union="begin|end" >
         
            FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnh = getFieldOfClassAsMultipleFieldContainerEnhancer();            
            
            Attr alignSizeNode = fieldNode.getAttributeNode("alignSize");
            if (alignSizeNode != null)
                fieldEnh.setDesiredAlignSizeExpr(alignSizeNode.getValue());

            if (fieldEnh.getJavaClassAsMultipleFieldContainerEnhancer() instanceof JavaClassAsNativeSeparatedFieldContainerEnhancer)
            {
                Attr unionNode = fieldNode.getAttributeNode("union");
                if (unionNode != null)
                {
                    FieldOfClassAsNativeMultipleFieldContainerImpl field = fieldEnh.getFieldOfClassAsMultipleFieldContainer();
                    String value = unionNode.getValue();
                    if ("begin".equals(value))
                        field.setBeginUnion(true);
                    else if ("end".equals(value))
                        field.setEndUnion(true);
                    else
                        throw new JNIEasyXMLException("Bad value of union attribute: " + value + " must be begin or end", fieldNode);
                }
            }
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,fieldNode);
        }   

    }        
}
