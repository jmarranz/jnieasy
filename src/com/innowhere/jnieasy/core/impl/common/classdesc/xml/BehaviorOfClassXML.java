/*
 * BehaviorOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:54
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

public abstract class BehaviorOfClassXML extends MemberOfClassXML
{
    
    /** Creates a new instance of BehaviorOfClassXML */
    public BehaviorOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        super(javaClass);
    }
    
    public static BehaviorOfClassXML newBehaviorOfClassXML(String tagName,JavaClassAsNativeCapableImpl javaClass)
    {
        if (ConstructorOfClassXML.isConstructor(tagName))
            return ConstructorOfClassXML.newConstructorOfClassXML(javaClass); 
        else if (MethodOfClassXML.isMethod(tagName))
            return MethodOfClassXML.newMethodOfClassXML(javaClass);
        else if (FieldMethodOfClassXML.isFieldMethod(tagName))
            return FieldMethodOfClassXML.newFieldMethodOfClassXML(javaClass); 
        else
            throw new JNIEasyException("Expected a node <constructor> or <method> or <fieldMethod>");
    }
    
    public static boolean isBehaviorNode(String tagName)
    {
        return ("constructor".equals(tagName) ||
                "method".equals(tagName) ||
                "fieldMethod".equals(tagName));        
    }
    
    public BehaviorOfClassImpl getBehaviorOfClass()
    {
        return (BehaviorOfClassImpl)memberOfClass;
    }        
    
    public void parseNativeName(Element methodNode)
    {     
        BehaviorOfClassImpl behavior = getBehaviorOfClass();
        parseNativeName(methodNode,behavior);
    }
    
    public static void parseNativeName(Element methodNode,BehaviorOfClassImpl behavior)
    {    
        // [nativeName="DLLMethodName"]  >

        Attr nativeNameAtt = methodNode.getAttributeNode("nativeName");
        if (nativeNameAtt != null)
        {
            behavior.setNativeNameExpr(nativeNameAtt.getValue());        
        }
    }    
}
