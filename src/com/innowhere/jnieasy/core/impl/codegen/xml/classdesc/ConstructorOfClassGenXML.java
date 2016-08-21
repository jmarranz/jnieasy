/*
 * MethodOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:58
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.ConstructorOfClassXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.ConstructorOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;



public class ConstructorOfClassGenXML extends BehaviorOfClassGenXML
{
 
    /** Creates a new instance of MethodOfClassXML */
    public ConstructorOfClassGenXML(ConstructorOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObjOfClassXML,classGen);
    }    
    
    public ConstructorOfClassGen getConstructorOfClassGen()
    {
        return (ConstructorOfClassGen)memberOfClassGen;
    }
    
    public void setConstructorOfClassGen(ConstructorOfClassGen memberOfClassGen)
    {
        setMemberOfClassGen(memberOfClassGen);
    }
    
    public ConstructorOfClassXML getConstructorOfClassXML()
    {
        return (ConstructorOfClassXML)memberOfClassXML;
    }
    
    public void parse(Element constrNode,TreeWalker walker,CodeGenContext ctx)
    {
        try
        {
            // <constructor ... >

            ConstructorOfClassXML construcXML = getConstructorOfClassXML();            
            construcXML.parse(constrNode,walker,ctx);
            ConstructorOfClassImpl constr = construcXML.getConstructorOfClass();
            ConstructorOfClassGen constGen = new ConstructorOfClassGen(constr, javaClassGen);

            setConstructorOfClassGen(constGen);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,constrNode);
        }
        
        super.parse(constrNode,walker,ctx);       
    }    
}
