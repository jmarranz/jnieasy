/*
 * FieldMethodOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:58
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldMethodOfClassXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldMethodOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;


/**
 *
 * @author  jmarranz
 */

public class FieldMethodOfClassGenXML extends BehaviorOfClassGenXML
{
    protected static final String TYPE_C = "C";
    protected static final String TYPE_CPP = "CPP";
    
    /**
     * Creates a new instance of FieldMethodOfClassXML
     */
    public FieldMethodOfClassGenXML(FieldMethodOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObjOfClassXML,classGen);
    }    

    public FieldMethodOfClassGen getFieldMethodOfClassGen()
    {
        return (FieldMethodOfClassGen)memberOfClassGen;
    }
    
    public void setFieldMethodOfClassGen(FieldMethodOfClassGen memberOfClassGen)
    {
        setMemberOfClassGen(memberOfClassGen);
    }
    
    public FieldMethodOfClassXML getFieldMethodOfClassXML()
    {
        return (FieldMethodOfClassXML)memberOfClassXML;
    }
    
    public void parse(Element methodNode,TreeWalker walker,CodeGenContext ctx)
    {
        try
        {
            // <method ... name="addStatic"  fieldType="..." >

            String fieldType = getFieldType(methodNode);

            boolean isStatic;
            if (fieldType.equals(TYPE_C))
                isStatic = true;
            else if (fieldType.equals(TYPE_CPP))
                throw new JNIEasyException("Not exists exported DLL CPP fields");
            else
                throw new JNIEasyException("Not valid method type name: " + fieldType);
            
            
            FieldMethodOfClassXML methodOfClassXML = getFieldMethodOfClassXML();                      
            
            JavaClassAsNativeCapableImpl javaClass = methodOfClassXML.getJavaClassAsNativeCapable();
            ClassTypeNativeMultipleFieldContainerImpl thisClassType = (ClassTypeNativeMultipleFieldContainerImpl)javaClass.getClassTypeNativeCapable();

            NativeFieldMethodSignatureXML sigXML;
            if (isStatic)
            {
                sigXML = NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
            }
            else
            {
                sigXML = NativeInstanceFieldMethodSignatureXML.newInstanceFieldMethodSignatureXML();        
                ((NativeInstanceFieldMethodSignatureXML)sigXML).setThisClassType(thisClassType);
            }

            sigXML.parse(methodNode,walker,ctx);
            NativeFieldMethodSignatureImpl sig = sigXML.getFieldMethodSignature();

            FieldMethodOfClassImpl method = FieldMethodOfClassImpl.newFieldMethodOfClass(sig,thisClassType);
            methodOfClassXML.setFieldMethodOfClass(method);            
            
            FieldMethodOfClassGen methodGen = FieldMethodOfClassGen.newFieldMethodOfClassGen(method, javaClassGen);            

            setFieldMethodOfClassGen(methodGen);            
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

    public static String getFieldType(Element methodNode)
    {
        return XMLUtil.getAttribute(methodNode,"fieldType",TYPE_C);
    }
  
}
