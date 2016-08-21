/*
 * TypeNativeStringBasedWrapperXML.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeStringInfoXML;


public class TypeNativeStringBasedWrapperXML extends TypeCanBeNativeCapableWrapperXML
{
    
    /** Creates a new instance of TypeNativeStringBasedWrapperXML */
    public TypeNativeStringBasedWrapperXML(TypeNativeStringBasedWrapperImpl typeDec)
    {
        super(typeDec);
    }
  
    public TypeNativeStringBasedWrapperImpl getTypeNativeStringBasedWrapper()
    {
        return (TypeNativeStringBasedWrapperImpl)typeDec;
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        try
        {
            TypeNativeStringBasedWrapperImpl typeDec = getTypeNativeStringBasedWrapper();

            TypeNativeStringInfoXML stringInfoXML = new TypeNativeStringInfoXML(typeDec);
            stringInfoXML.parse(typeNode);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,typeNode);
        }        
    }    
}
