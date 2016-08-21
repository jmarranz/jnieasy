/*
 * MemberOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:53
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MemberOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.MemberOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.MemberOfClassGenXML;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

public abstract class MemberOfClassXML
{
    protected MemberOfClassImpl memberOfClass;
    protected JavaClassAsNativeCapableImpl javaClass;    
    
    /**
     * Creates a new instance of MemberOfClassXML
     */
    public MemberOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        this.javaClass = javaClass;
    }    
    
    public MemberOfClassImpl getMemberOfClass()
    {
        return memberOfClass;
    }
    
    public void setMemberOfClass(MemberOfClassImpl memberOfClass)
    {
        this.memberOfClass = memberOfClass;
    }
    
    public JavaClassAsNativeCapableImpl getJavaClassAsNativeCapable()
    {
        return javaClass;
    }
    
    public static MemberOfClassXML newMemberOfClassXML(String tagName,JavaClassAsNativeCapableImpl javaClass)
    {
        if (FieldOfClassXML.isFieldNode(tagName))
            return FieldOfClassXML.newFieldOfClassXML(javaClass);
        else if (BehaviorOfClassXML.isBehaviorNode(tagName))
            return BehaviorOfClassXML.newBehaviorOfClassXML(tagName,javaClass);
        else
            throw new JNIEasyException("Expected a node <field> or <constructor> or <method> or <fieldMethod>");
    }
        
    public static String getName(Element node)
    {
        // <field/method/constructor/fieldMethod ... name="addStatic"  >
        // Si se llama debe ser obligatorio que exista el atributo
        return XMLUtil.getAttribute(node,"name");
    }
    
    public abstract MemberOfClassGenXML newMemberOfClassGenXML(JavaClassAsNativeMultipleFieldContainerGen classGen);
    public abstract MemberOfClassEnhancerXML newMemberOfClassEnhancerXML(JavaClassAsNativeCapableEnhancer classEnhancer);
        
}
