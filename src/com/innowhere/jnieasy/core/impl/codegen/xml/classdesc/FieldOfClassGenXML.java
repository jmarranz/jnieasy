/*
 * FieldOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:55
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldOfClassGen;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldOfClassXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;


/**
 *
 * @author  jmarranz
 */



public class FieldOfClassGenXML extends MemberOfClassGenXML
{
    /** Creates a new instance of FieldOfClassXML */
    public FieldOfClassGenXML(FieldOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObjOfClassXML,classGen);
    }

    public FieldOfClassGen getFieldOfClassGen()
    {
        return (FieldOfClassGen)memberOfClassGen;
    }
    
    public void setFieldOfClassGen(FieldOfClassGen memberOfClassGen)
    {
        setMemberOfClassGen(memberOfClassGen);
    }    
    
    public FieldOfClassXML getFieldOfClassXML()
    {
        return (FieldOfClassXML)memberOfClassXML;
    }
    
    public void parse(Element fieldNode,TreeWalker walker,CodeGenContext ctx)
    {    
        try
        {
            // <field name="fieldName" ... />
            
            FieldOfClassXML fieldXML = getFieldOfClassXML();
            fieldXML.parse(fieldNode,walker,null, ctx);

            //String name = fieldXML.getName(fieldNode);
            FieldOfClassGen fieldGen = new FieldOfClassGen(fieldXML.getFieldOfClass(), javaClassGen);
            setFieldOfClassGen(fieldGen);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,fieldNode);
        }   
        
        super.parse(fieldNode, walker, ctx);        
    }        
}
