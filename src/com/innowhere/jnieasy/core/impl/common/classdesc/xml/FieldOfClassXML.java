/*
 * FieldOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:55
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.xml.VarTypeNativeXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.MemberOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.MemberOfClassGenXML;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.FieldOfClassGenXML;

public class FieldOfClassXML extends MemberOfClassXML
{
   
    /** Creates a new instance of FieldOfClassXML */
    public FieldOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        super(javaClass);
    }
    
    public static FieldOfClassXML newFieldOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        return new FieldOfClassXML(javaClass);
    }
    
    public static String fieldTagName()
    {
        return "field";
    }
    
    public static boolean isFieldNode(String tagName)
    {
        return "field".equals(tagName);
    }
    
    public void parse(Element fieldNode,TreeWalker walker,ClassTypeNativeImpl dataType,TaskContext ctx)
    {
        //<field ... />
        
        VarTypeNativeXML varTypeXML = VarTypeNativeXML.newVarTypeNativeXML(fieldNode,walker,dataType,ctx);
        varTypeXML.parse(fieldNode,walker,ctx);
        VarTypeNativeImpl varType = varTypeXML.getVarTypeNative();
        varType.check();
        
        FieldOfClassImpl field = FieldOfClassImpl.newFieldOfClass(getJavaClassAsNativeCapable(),varType);
        setFieldOfClass(field);     
    }
    
    public FieldOfClassImpl getFieldOfClass()
    {
        return (FieldOfClassImpl)memberOfClass;
    }
    
    public void setFieldOfClass(FieldOfClassImpl memberOfClass)
    {
        setMemberOfClass(memberOfClass);
    }   
    
    public MemberOfClassGenXML newMemberOfClassGenXML(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new FieldOfClassGenXML(this,classGen);
    } 
    
    public MemberOfClassEnhancerXML newMemberOfClassEnhancerXML(JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
