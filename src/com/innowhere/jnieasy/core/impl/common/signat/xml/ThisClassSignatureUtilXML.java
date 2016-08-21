/*
 * ThisClassSignatureUtilXML.java
 *
 * Created on 4 de marzo de 2005, 13:09
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.NativeMultipleFieldContainer;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;

public class ThisClassSignatureUtilXML
{
    
    /**
     * Creates a new instance of ThisClassSignatureUtilXML 
     */
    public ThisClassSignatureUtilXML()
    {
    }

    public static String getThisClassAttName()
    {
        return "thisClass";
    }
    
    public static Attr getThisClassTypeAttr(Element methodNode)
    {
        // <... thisClass="thisClass" >        
        return methodNode.getAttributeNode("thisClass");       
    }
    
    public static ClassTypeNativeMultipleFieldContainerImpl getThisClassType(Element methodNode,boolean errorIfNotFound,TaskContext ctx)
    {
        // <... thisClass="thisClass" >

        Attr thisClassAtt = getThisClassTypeAttr(methodNode);
        if (thisClassAtt == null)
        {
            if (errorIfNotFound) throw new JNIEasyXMLException("Attribute \"thisClass\" is mandatory in this context",methodNode);
            return null;
        }
        String thisClassName = thisClassAtt.getValue();

        ClassTypeNativeImpl thisClassType = ctx.getClassType(thisClassName);

        if (!(thisClassType instanceof ClassTypeNativeMultipleFieldContainerImpl))
            throw new JNIEasyXMLException("Declared class on attribute thisClass : " + thisClassType.getClassName() + " must implement " + NativeMultipleFieldContainer.class.getName() + " interface",methodNode);

        return (ClassTypeNativeMultipleFieldContainerImpl)thisClassType;
    }
    
}
