/*
 * TypeNativeStringBasedXML.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data;

/**
 *
 * @author  jmarranz
 */
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeStringInfoXML;


public class TypeNativeStringBasedXML extends TypeCanBeNativeCapableXML
{
    
    /** Creates a new instance of TypeNativeStringBasedXML */
    public TypeNativeStringBasedXML(TypeNativeStringBasedImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeStringBasedImpl getTypeNativeStringBased()
    {
        return (TypeNativeStringBasedImpl)typeDec;
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        TypeNativeStringBasedImpl typeDec = getTypeNativeStringBased();

        TypeNativeStringInfoXML stringInfoXML = new TypeNativeStringInfoXML(typeDec);
        stringInfoXML.parse(typeNode);
    }
}
