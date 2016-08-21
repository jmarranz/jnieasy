/*
 * CPPMethodContructor.java
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

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import java.util.ArrayList;

public class ConstructorSignatureXML extends NativeBehaviorSignatureXML
{
    protected ClassTypeNativeCapableImpl thisClassType;
    
    /** Creates a new instance of CPPMethodContructor */
    public ConstructorSignatureXML()
    {
    }
    
    public static ConstructorSignatureXML newConstructorSignatureXML()
    {
        return new ConstructorSignatureXML();
    }
    
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
	return (NativeConstructorSignatureImpl)signature;
    }
    
    public void setConstructorSignature(NativeConstructorSignatureImpl signature)
    {
        this.signature = signature;
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

            ArrayList params;
            
            params = ParameterDecListXML.parseParameterDecListAttribute(methodNode,ctx);
            if (params == null)
                params = ParameterDecListXML.parseParameterDecListTree(methodNode,walker,ctx);
            
            NativeConstructorSignatureImpl sig = new NativeConstructorSignatureImpl(ctx.getJNIEasy());
            sig.setThisClassType(thisClassType);
            sig.addParameterDecList(params);
            setConstructorSignature( sig );            
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }  
      
        super.parseTree(methodNode, walker, ctx);        
    }    

    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeConstructorSignatureImpl(jniEasy);
    }    
}
