/*
 * NativeInstanceFieldMethodSignatureXML.java
 *
 * Created on 18 de julio de 2005, 15:28
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class NativeInstanceFieldMethodSignatureXML extends NativeFieldMethodSignatureXML
{
    protected ClassTypeNativeCapableImpl thisClassType;
    
    /**
     * Creates a new instance of NativeInstanceFieldMethodSignatureXML
     */
    public NativeInstanceFieldMethodSignatureXML()
    {
    }
    
    public static NativeInstanceFieldMethodSignatureXML newInstanceFieldMethodSignatureXML()
    {
        return new NativeInstanceFieldMethodSignatureXML();
    }
    
    public NativeInstanceFieldMethodSignatureImpl getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignatureImpl)signature;
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

            NativeInstanceFieldMethodSignatureImpl sig = getInstanceFieldMethodSignature();
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
        return new NativeInstanceFieldMethodSignatureImpl(jniEasy);
    }    
}
