/*
 * JavaClassAsNativeMultipleFieldContainerEnhancerXML.java
 *
 * Created on 11 de diciembre de 2004, 21:07
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.BehaviorOfClassXML;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldOfClassXML;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeMultipleFieldContainerXML;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javassist.CtField;
import javassist.CtMember;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

public class JavaClassAsNativeMultipleFieldContainerEnhancerXML extends JavaClassAsNativeFieldContainerEnhancerXML
{
    protected boolean allMethods;
    protected boolean allFields;
    
    /** Creates a new instance of JavaClassAsTypeMultipleFieldContainerEnhancerXML */
    public JavaClassAsNativeMultipleFieldContainerEnhancerXML(JavaClassAsNativeMultipleFieldContainerEnhancer javaClassEnh)
    {
        super(javaClassEnh); 
    }
    
    public JavaClassAsNativeMultipleFieldContainerEnhancer getJavaClassAsMultipleFieldContainerEnhancer()
    {
        return (JavaClassAsNativeMultipleFieldContainerEnhancer)javaClassEnh;
    }
    
    public void addField(FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnhancer)
    {
        JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer = getJavaClassAsMultipleFieldContainerEnhancer();
        classEnhancer.addField(fieldEnhancer);   
    }    
   
    public void parse(Element classNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {        
        try
        {
            // <class ... [allMethods="true|false"] [allFields="true|false"] [alignSize="size"]>

            JavaClassAsNativeMultipleFieldContainerXML javaClassXML = (JavaClassAsNativeMultipleFieldContainerXML)JavaClassAsNativeCapableXML.newJavaClassAsNativeCapableXML(javaClassEnh.getJavaClassAsNativeCapable());
            javaClassXML.parse(classNode, walker);

            JavaClassAsNativeMultipleFieldContainerEnhancer classEnh = getJavaClassAsMultipleFieldContainerEnhancer();

            Attr allFieldsAttr = classNode.getAttributeNode("allFields");
            if (allFieldsAttr != null)
                this.allFields = XMLUtil.getBooleanValue(allFieldsAttr);
            else
                this.allFields = classEnh.getDefaultAllFields();
            
            Attr allMethodsAttr = classNode.getAttributeNode("allMethods");
            if (allMethodsAttr != null)
                this.allMethods = XMLUtil.getBooleanValue(allMethodsAttr);
            else
                this.allMethods = classEnh.getDefaultAllMethods();
            
            Attr alignSizeNode = classNode.getAttributeNode("alignSize");
            if (alignSizeNode != null)
                classEnh.setDesiredAlignSize(alignSizeNode.getValue());
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,classNode);
        } 
        
        super.parse(classNode, walker,ctx);
    }
    
    public void parseFieldsAndMethods(Element classNode, TreeWalker walker, EnhancerSourceFileContext ctx)
    {
        try
        {
            final Map fieldNodes = new HashMap();
            final ArrayList behaviorNodes = new ArrayList(); // hay que recordar que puede haber varios métodos con el mismo nombre

            XMLTask memberTask = new XMLTask()
            {
                public void doTask(Element memberNode,TreeWalker walker,int counter)
                {
                    String tagName = memberNode.getTagName();
                    if (FieldOfClassXML.isFieldNode(tagName))
                    {
                        String name = FieldOfClassXML.getName(memberNode);
                        fieldNodes.put(name,memberNode);
                    }
                    else if (BehaviorOfClassXML.isBehaviorNode(tagName))                    
                        behaviorNodes.add(memberNode);
                    else 
                        throw new JNIEasyXMLException("Not valid tag name : " + tagName, memberNode);
                }
            };
            
            TreeWalkerUtil.processChildElements(walker,memberTask);

            parseFields(fieldNodes,ctx);
            parseBehaviors(behaviorNodes,ctx);      
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

    public void parseFields(Map fieldNodes,EnhancerSourceFileContext ctx)
    {
        JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer = getJavaClassAsMultipleFieldContainerEnhancer();
        LinkedHashMap fields = classEnhancer.getEnhanceableFields();
        
        for(Iterator it = fields.entrySet().iterator(); it.hasNext(); )
        {
            // El orden de los fields es el mismo que el de inserción y el mismo que en la clase (debe ser así)
            Map.Entry entry = (Map.Entry)it.next();
            CtField ctField = (CtField)entry.getValue();

            String fieldName = ctField.getName();
            try
            {   
                FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnhancer = null;
            
                Element fieldNode = (Element)fieldNodes.get(fieldName); // puede ser nulo
                if (fieldNode != null)
                {
                    try
                    {
                        FieldOfClassEnhancerXML fieldEnhXML = FieldOfClassEnhancerXML.newFieldOfClassEnhancerXML(this);
                        TreeWalker walker = TreeWalkerUtil.createTreeWalker(fieldNode);                
                        if (fieldEnhXML.mustEnhance(fieldNode))
                        {                
                            fieldEnhXML.parse(fieldNode,walker,ctField,ctx);
                            fieldEnhancer = (FieldOfClassAsNativeMultipleFieldContainerEnhancer)fieldEnhXML.getFieldOfClassEnhancer();
                        }
                        fieldNodes.remove(fieldName); // lo quitamos de la lista
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
                else if (allFields)
                {
                    fieldEnhancer = (FieldOfClassAsNativeMultipleFieldContainerEnhancer)FieldOfClassEnhancer.newFieldOfClassEnhancer(classEnhancer,ctField,ctx);
                    fieldEnhancer.getFieldOfClass().getVarTypeNative().check(); // chequea si el tipo por defecto está completo (caso de tipo Method o Constructor o similares)
                }

                if (fieldEnhancer != null)
                {
                    addField(fieldEnhancer);
                }
            }
            catch(Exception ex)
            {
                throw new JNIEasyException("Error processing field: \"" + fieldName + "\", class : " + classEnhancer.getName(),ex);
            }
            
            // Si no hay información sobre el atributo en el XML
            // el enhancement es del por defecto.
        }

        // Testeamos que en el XML no haya un ctField declarado que no exista en la clase (entre los fields enhanceables)        
        if (!fieldNodes.isEmpty())
        {
            Iterator it = fieldNodes.entrySet().iterator(); 
            Map.Entry entry = (Map.Entry)it.next();
            String fieldName = (String)entry.getKey();
            Element fieldNode = (Element)entry.getValue();            
            throw new JNIEasyXMLException("Field name defined in XML descriptor : " + fieldName + ", not exists or not enhanceable in class: " + classEnhancer.getName(),fieldNode );
        } 
    }    
    
    public void parseBehaviors(ArrayList behaviorNodes,EnhancerSourceFileContext ctx)
    {
        JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer = getJavaClassAsMultipleFieldContainerEnhancer();
        ArrayList ctBehaviorList = classEnhancer.getEnhanceableBehaviors();
        LinkedHashMap ctFieldMap = classEnhancer.getEnhanceableFields();
        // Los añadimos como si fueran métodos
        ctBehaviorList.addAll(ctFieldMap.values());
        
        for(int i = 0; i < behaviorNodes.size(); i++)
        {
            Element behaviorNode = (Element)behaviorNodes.get(i);
            try
            {
                String tagName = behaviorNode.getTagName();  
                TreeWalker walker = TreeWalkerUtil.createTreeWalker(behaviorNode);
                CtMember ctBehavior; // CtBehavior y derivados y CtField
                BehaviorOfClassEnhancerXML genMethodEnhXML = BehaviorOfClassEnhancerXML.newBehaviorOfClassEnhancerXML(behaviorNode,ctx,classEnhancer);
                if (genMethodEnhXML.mustEnhance(behaviorNode)) 
                {
                    genMethodEnhXML.parse(behaviorNode,walker,ctx);
                    BehaviorOfClassEnhancer behaviorEnhancer = genMethodEnhXML.getBehaviorOfClassEnhancer();
                    classEnhancer.addBehavior(behaviorEnhancer);
                    ctBehavior = behaviorEnhancer.getCtMember();
                }
                else
                {
                    ctBehavior = genMethodEnhXML.parseParamsNotEnhance(behaviorNode, walker, ctx);
                }
                // quitamos de la lista de métodos enhanceables
                if (!ctBehaviorList.remove(ctBehavior))
                    throw new JNIEasyXMLException("Declared method is not enhanceable",behaviorNode);
            }
            catch(JNIEasyXMLException ex)
            {
                throw ex;
            }        
            catch(Exception ex)
            {
                throw new JNIEasyXMLException(ex,behaviorNode);
            }            
        }
        
        if (allMethods)
        {
            // Los que quedan los añadimos tal que la signatura
            // que se genere sea la de por defecto.
            // Esto supone que sólo métodos sencillos tendrán sentido pues no hay información
            // alguna en el XML de correspondencia con el mundo nativo, por ejemplo en el caso de 
            // métodos con parámetros o retornos de tipo Method o Contructor o arrays de estos,
            // tipos que necesitan una signatura aparte en XML
            
            for (Iterator it = ctBehaviorList.iterator(); it.hasNext(); )
            {
                CtMember behavior = (CtMember)it.next();            
                BehaviorOfClassEnhancer behaviorEnhancer = BehaviorOfClassEnhancer.newDefaultBehaviorOfClassEnhancer(behavior,classEnhancer,ctx);
                
                try
                {
                behaviorEnhancer.getBehaviorOfClass().getBehaviorSignature().check(); // chequea si las declaraciones por defecto son completas (ej. caso de usar tipos como Method, Constructor, Field etc)
                }
                catch(Exception ex)
                {
                    throw new JNIEasyException("Error processing method: " + behavior.toString(),ex);
                }
 
                classEnhancer.addBehavior(behaviorEnhancer);  
            }
        }        
    }        
    
    public FieldOfClassEnhancerXML newFieldOfClassEnhancerXML()
    {
        JavaClassAsNativeMultipleFieldContainerEnhancer classEnh = getJavaClassAsMultipleFieldContainerEnhancer();
        FieldOfClassXML fieldOfClassXML = FieldOfClassXML.newFieldOfClassXML(classEnh.getJavaClassAsNativeCapable());        
        return new FieldOfClassAsNativeMultipleFieldContainerEnhancerXML(fieldOfClassXML,classEnh);
    }  
}
