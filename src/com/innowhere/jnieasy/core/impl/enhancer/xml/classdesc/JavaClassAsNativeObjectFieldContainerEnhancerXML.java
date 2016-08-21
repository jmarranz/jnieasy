/*
 * JavaClassAsNativeObjectFieldContainerEnhancerXML.java
 *
 * Created on 29 de septiembre de 2005, 14:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeObjectFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import java.util.LinkedHashMap;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeObjectFieldContainerEnhancerXML extends JavaClassAsNativeFieldContainerEnhancerXML
{
    
    /**
     * Creates a new instance of JavaClassAsNativeObjectFieldContainerEnhancerXML
     */
    public JavaClassAsNativeObjectFieldContainerEnhancerXML(JavaClassAsNativeObjectFieldContainerEnhancer javaClassEnh)
    {
        super(javaClassEnh); 
    }
    
    public JavaClassAsNativeObjectFieldContainerEnhancer getJavaClassAsObjectFieldContainerEnhancer()
    {
        return (JavaClassAsNativeObjectFieldContainerEnhancer)javaClassEnh;
    }
    
    public void setField(FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnhancer)
    {
        JavaClassAsNativeObjectFieldContainerEnhancer classEnhancer = getJavaClassAsObjectFieldContainerEnhancer();
        classEnhancer.setField(fieldEnhancer);
    }            

    public static CtField getCtFieldFromXMLDirectly(Element classNode,CtClass ctClass)
    {
        TreeWalker walker = TreeWalkerUtil.createTreeWalker(classNode);
        Element fieldNode = TreeWalkerUtil.firstChildElement(walker, FieldOfClassXML.fieldTagName(), true);
        String fieldName = FieldOfClassXML.getName(fieldNode);  
        try
        {
            return ctClass.getDeclaredField(fieldName);
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public void parseFieldsAndMethods(Element classNode,TreeWalker walker, EnhancerSourceFileContext ctx)
    {
        try
        {        
            Element fieldNode = TreeWalkerUtil.firstChildElement(walker, FieldOfClassXML.fieldTagName(), true);

            parseField(fieldNode,walker,ctx);            

            TreeWalkerUtil.parentElement(walker);
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
    
    
    public void parseField(Element fieldNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {
        try
        {
            String fieldName = FieldOfClassXML.getName(fieldNode);

            JavaClassAsNativeObjectFieldContainerEnhancer classEnhancer = getJavaClassAsObjectFieldContainerEnhancer();
            LinkedHashMap fields = classEnhancer.getEnhanceableFields();
            CtField ctField = (CtField)fields.get(fieldName);
            if (ctField == null)
                throw new JNIEasyException("Java class " + classEnhancer.getName() + " has not a enhanceable field with name : \"" + fieldName + "\"");
            
            FieldOfClassAsNativeObjectFieldContainerEnhancerXML fieldEnhXML = (FieldOfClassAsNativeObjectFieldContainerEnhancerXML)FieldOfClassEnhancerXML.newFieldOfClassEnhancerXML(this);
            fieldEnhXML.parse(fieldNode,walker,ctField,ctx);
            FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnhancer = fieldEnhXML.getFieldOfClassAsObjectFieldContainerEnhancer();
            setField(fieldEnhancer);
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

    public FieldOfClassEnhancerXML newFieldOfClassEnhancerXML()
    {
        JavaClassAsNativeObjectFieldContainerEnhancer classEnh = getJavaClassAsObjectFieldContainerEnhancer();
        FieldOfClassXML fieldOfClassXML = FieldOfClassXML.newFieldOfClassXML(classEnh.getJavaClassAsNativeCapable());
        return new FieldOfClassAsNativeObjectFieldContainerEnhancerXML(fieldOfClassXML,classEnh);
    }     
}
