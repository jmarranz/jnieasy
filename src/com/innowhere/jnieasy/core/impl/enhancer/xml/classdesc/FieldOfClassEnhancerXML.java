/*
 * FieldOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:55
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;


public abstract class FieldOfClassEnhancerXML extends MemberOfClassEnhancerXML
{
    /** Creates a new instance of FieldOfClassXML */
    public FieldOfClassEnhancerXML(FieldOfClassXML accessObjOfClassXML,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }
    
    public FieldOfClassEnhancer getFieldOfClassEnhancer()
    {
        return (FieldOfClassEnhancer)memberOfClassEnh;
    }

    public void setFieldOfClassEnhancer(FieldOfClassEnhancer memberOfClassEnh)
    {
        setMemberOfClassEnhancer(memberOfClassEnh);
    }    
    
    public FieldOfClassXML getFieldOfClassXML()
    {
        return (FieldOfClassXML)accessObjOfClassXML;
    }
    
    public void parse(Element fieldNode,TreeWalker walker,CtField ctField,EnhancerSourceFileContext ctx)
    {    
        try
        {
            // <field ... >
            
            CtClass fieldCtClass = FieldOfClassEnhancer.getFieldCtClass(ctField);

            ClassTypeNativeImpl fieldType = ctx.getClassType(fieldCtClass);
        
            FieldOfClassXML fieldXML = getFieldOfClassXML();
            fieldXML.parse(fieldNode,walker,fieldType, ctx);            
            FieldOfClassImpl fieldOfClass = fieldXML.getFieldOfClass();
            
            FieldOfClassEnhancer fieldEnh = FieldOfClassEnhancer.newFieldOfClassEnhancer(fieldOfClass, ctField,classEnhancer);
            setFieldOfClassEnhancer(fieldEnh);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,fieldNode);
        }   
        
        super.parse(fieldNode,walker,ctx);
    }    

    public static FieldOfClassEnhancerXML newFieldOfClassEnhancerXML(JavaClassAsNativeCapableEnhancerXML classEnhXML)
    {
        return classEnhXML.newFieldOfClassEnhancerXML();
    }    
}
