/*
 * MethodOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:58
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.MethodOfClassXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MethodOfClassGen;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;

/**
 *
 * @author  jmarranz
 */



public class MethodOfClassGenXML extends BehaviorOfClassGenXML
{
    protected static final String TYPE_C = "C";
    protected static final String TYPE_CPP = "CPP";
    
    /** Creates a new instance of MethodOfClassXML */
    public MethodOfClassGenXML(MethodOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObjOfClassXML,classGen);
    }    

    public MethodOfClassGen getMethodOfClassGen()
    {
        return (MethodOfClassGen)memberOfClassGen;
    }
    
    public void setMethodOfClassGen(MethodOfClassGen memberOfClassGen)
    {
        setMemberOfClassGen(memberOfClassGen);
    }
    
    public MethodOfClassXML getMethodOfClassXML()
    {
        return (MethodOfClassXML)memberOfClassXML;
    }
    
    public void parse(Element methodNode,TreeWalker walker,CodeGenContext ctx)
    {
        try
        {
            // <method ... name="addStatic" [nativeName="DLLMethodName"] methodType="..." >

            String methodType = getMethodType(methodNode);

            boolean isStatic;
            if (methodType.equals(TYPE_C))
                isStatic = true;
            else if (methodType.equals(TYPE_CPP))
                isStatic = false;
            else
                throw new JNIEasyException("Not valid method type name: " + methodType);
            
            
            MethodOfClassXML methodOfClassXML = getMethodOfClassXML();         
            JavaClassAsNativeCapableImpl javaClass = methodOfClassXML.getJavaClassAsNativeCapable();
            ClassTypeNativeMultipleFieldContainerImpl thisClassType = (ClassTypeNativeMultipleFieldContainerImpl)javaClass.getClassTypeNativeCapable();            

            NativeMethodSignatureXML sigXML;
            if (isStatic)
            {
                sigXML = NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
            }
            else
            {
                sigXML = NativeInstanceMethodSignatureXML.newInstanceMethodSignatureXML();        
                ((NativeInstanceMethodSignatureXML)sigXML).setThisClassType(thisClassType);
            }

            sigXML.parse(methodNode,walker,ctx);
            NativeMethodSignatureImpl sig = sigXML.getMethodSignature();

            MethodOfClassImpl method = MethodOfClassImpl.newMethodOfClass(sig,thisClassType);
            methodOfClassXML.setMethodOfClass(method);

            MethodOfClassGen methodGen = MethodOfClassGen.newMethodOfClassGen(method, javaClassGen);            
      
            setMethodOfClassGen(methodGen);            
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }
        
        super.parse(methodNode,walker,ctx);        
    }
    

    public static String getMethodType(Element methodNode)
    {
        return XMLUtil.getAttribute(methodNode,"methodType",TYPE_C);
    }

  
}
