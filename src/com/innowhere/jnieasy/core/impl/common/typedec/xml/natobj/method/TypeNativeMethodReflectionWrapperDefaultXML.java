/*
 * TypeNativeMethodReflectionWrapperDefaultXML.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodReflectionWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ThisClassSignatureUtilXML;


public class TypeNativeMethodReflectionWrapperDefaultXML extends TypeNativeMethodReflectionWrapperXML
{
    
    /** Creates a new instance of TypeNativeMethodReflectionWrapperDefaultXML */
    public TypeNativeMethodReflectionWrapperDefaultXML(TypeNativeMethodReflectionWrapperDefaultImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeMethodReflectionWrapperDefaultImpl getTypeNativeMethodReflectionWrapperDefault()
    {
        return (TypeNativeMethodReflectionWrapperDefaultImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        // <field/component ... >

        try
        {
            TypeNativeMethodReflectionWrapperDefaultImpl typeDec = getTypeNativeMethodReflectionWrapperDefault();
            typeDec.setStatic(ThisClassSignatureUtilXML.getThisClassTypeAttr(typeNode) == null);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,typeNode);
        }
        
        super.parse(typeNode,walker,ctx);
    }  
   
}
