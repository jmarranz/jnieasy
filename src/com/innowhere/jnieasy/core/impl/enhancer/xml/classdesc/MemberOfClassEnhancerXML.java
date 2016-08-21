/*
 * MemberOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:53
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.MemberOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.MemberOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;

import org.w3c.dom.*;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author  jmarranz
 */



public class MemberOfClassEnhancerXML
{
    protected MemberOfClassEnhancer memberOfClassEnh;
    protected MemberOfClassXML accessObjOfClassXML;
    protected JavaClassAsNativeCapableEnhancer classEnhancer;

    
    /**
     * Creates a new instance of MemberOfClassXML
     */
    public MemberOfClassEnhancerXML(MemberOfClassXML accessObjOfClassXML,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        this.accessObjOfClassXML = accessObjOfClassXML;
        this.classEnhancer = classEnhancer;
    }
    
    public MemberOfClassEnhancer getMemberOfClassEnhancer()
    {
        return memberOfClassEnh;
    }
    
    public void setMemberOfClassEnhancer(MemberOfClassEnhancer memberOfClassEnh)
    {
        this.memberOfClassEnh = memberOfClassEnh;
        accessObjOfClassXML.setMemberOfClass(memberOfClassEnh.getMemberOfClass());
    }    
    
    public JavaClassAsNativeCapableEnhancer getJavaClassAsNativeCapableEnhancer()
    {
        return (JavaClassAsNativeCapableEnhancer)classEnhancer;
    }
    
    public static boolean mustEnhance(Element itemClassNode)
    {
        // <field/method/constructor [enhance="true|false"] >
        
        Attr attrEnhance = itemClassNode.getAttributeNode("enhance");
        if (attrEnhance != null)
            return XMLUtil.getBooleanValue(attrEnhance);
        else
            return true;
    }           
    
    public void parse(Element itemClassNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {    
        try
        {
            // <field/method/constructor ... >

            // Por ahora nada que hacer
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,itemClassNode);
        }
    }
}
