/*
 * TypeNativeMethodReflectionXML.java
 *
 * Created on 25 de febrero de 2005, 14:44
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ThisClassSignatureUtilXML;


public class TypeNativeMethodReflectionXML extends TypeNativeBehaviorReflectionXML
{
    
    /** Creates a new instance of TypeNativeMethodReflectionXML */
    public TypeNativeMethodReflectionXML(TypeNativeMethodReflectionImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativeMethodReflectionImpl getTypeNativeMethodReflection()
    {
        return (TypeNativeMethodReflectionImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            TypeNativeMethodReflectionImpl typeDec = getTypeNativeMethodReflection();
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
