/*
 * NativeInstanceMethodSignatureXML.java
 *
 * Created on 1 de abril de 2004, 11:29
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;


public class NativeInstanceMethodSignatureXML extends NativeMethodSignatureXML
{
    protected ClassTypeNativeCapableImpl thisClassType;
    
    /**
     * Creates a new instance of NativeInstanceMethodSignatureXML
     */
    public NativeInstanceMethodSignatureXML()
    {
    }
    
    public static NativeInstanceMethodSignatureXML newInstanceMethodSignatureXML()
    {
        return new NativeInstanceMethodSignatureXML();
    }
    
    public NativeInstanceMethodSignatureImpl getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignatureImpl)signature;
    } 
    
    public ClassTypeNativeMultipleFieldContainerImpl getThisClassType()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)thisClassType;
    }
            
    public void setThisClassType(ClassTypeNativeMultipleFieldContainerImpl thisClassType)
    {
        this.thisClassType = thisClassType;
    }
    
    public void parseTree(Element methodNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            ClassTypeNativeMultipleFieldContainerImpl thisClassType = getThisClassType();
            if (thisClassType == null)
                thisClassType = ThisClassSignatureUtilXML.getThisClassType(methodNode,true, ctx);
            
            super.parseTree(methodNode, walker, ctx);  

            NativeInstanceMethodSignatureImpl sig = getInstanceMethodSignature();
            sig.setThisClassType(thisClassType);            
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }
    }

    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeInstanceMethodSignatureImpl(jniEasy);
    }    
}
