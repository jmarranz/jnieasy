/*
 * FieldMethodOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:58
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.MemberOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.FieldMethodOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.MemberOfClassGenXML;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.FieldMethodOfClassGenXML;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;
import org.w3c.dom.*;

public class FieldMethodOfClassXML extends BehaviorOfClassXML
{
  
    /**
     * Creates a new instance of FieldMethodOfClassXML
     */
    public FieldMethodOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        super(javaClass);
    }
    
    public static FieldMethodOfClassXML newFieldMethodOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        return new FieldMethodOfClassXML(javaClass);
    }
    
    public static boolean isFieldMethod(String tagName)
    {
        return "fieldMethod".equals(tagName);
    }
    
    public static String getFieldName(Element methodNode)
    {
        // <fieldMethod ... name="fieldName"  >

        return XMLUtil.getAttribute(methodNode,"name");
    }
    
   
    public FieldMethodOfClassImpl getFieldMethodOfClass()
    {
        return (FieldMethodOfClassImpl)memberOfClass;
    }    
    
    public void setFieldMethodOfClass(FieldMethodOfClassImpl memberOfClass)
    {
        setMemberOfClass(memberOfClass);
    }
    
    public MemberOfClassGenXML newMemberOfClassGenXML(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new FieldMethodOfClassGenXML(this,classGen);
    }  
    
    public MemberOfClassEnhancerXML newMemberOfClassEnhancerXML(JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return new FieldMethodOfClassEnhancerXML(this, classEnhancer);
    }        
}
