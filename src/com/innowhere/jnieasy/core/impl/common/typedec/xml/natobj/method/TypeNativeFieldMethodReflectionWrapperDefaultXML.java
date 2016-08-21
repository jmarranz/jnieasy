/*
 * TypeNativeFieldMethodReflectionWrapperDefaultXML.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodReflectionWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ThisClassSignatureUtilXML;



public class TypeNativeFieldMethodReflectionWrapperDefaultXML extends TypeNativeFieldMethodReflectionWrapperXML
{
    /** Creates a new instance of TypeNativeFieldMethodReflectionWrapperDefaultXML */
    public TypeNativeFieldMethodReflectionWrapperDefaultXML(TypeNativeFieldMethodReflectionWrapperDefaultImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeFieldMethodReflectionWrapperDefaultImpl getTypeNativeFieldMethodReflectionWrapperDefault()
    {
        return (TypeNativeFieldMethodReflectionWrapperDefaultImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        // <field/component ... >

        try
        {
            TypeNativeFieldMethodReflectionWrapperDefaultImpl typeDec = getTypeNativeFieldMethodReflectionWrapperDefault();
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
