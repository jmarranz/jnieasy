/*
 * TypeNativeFieldMethodReflectionXML.java
 *
 * Created on 7 de diciembre de 2004, 14:41
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ThisClassSignatureUtilXML;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;



public class TypeNativeFieldMethodReflectionXML extends TypeNativeBehaviorReflectionXML
{
    /**
     * Creates a new instance of TypeNativeFieldMethodReflectionXML
     */
    public TypeNativeFieldMethodReflectionXML(TypeNativeFieldMethodReflectionImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeFieldMethodReflectionImpl getTypeNativeFieldMethodReflection()
    {
        return (TypeNativeFieldMethodReflectionImpl)typeDec;
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            TypeNativeFieldMethodReflectionImpl typeDec = getTypeNativeFieldMethodReflection();
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
