/*
 * TypeNativeXML.java
 *
 * Created on 14 de enero de 2005, 15:15
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.xml.ClassTypeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public class TypeNativeXML
{
    protected TypeNativeImpl typeDec;
    
    /**
     * Creates a new instance of TypeNativeXML
     */
    public TypeNativeXML(TypeNativeImpl typeDec)
    {
        this.typeDec = typeDec;
    }
    
    public TypeNativeImpl getTypeNative()
    {
        return typeDec;
    }
    
    public static TypeNativeXML newTypeNativeXML(TypeNativeImpl typeDec)
    {
        return typeDec.newTypeNativeXML();
    }

    
    public static TypeNativeXML newTypeNativeXML(Element node,TreeWalker walker,ClassTypeNativeImpl classType,TaskContext ctx)
    {    
        try
        {
            // Ej. <param/return/field [class="int"] [...] />  
            ClassTypeXML classTypeXML = ClassTypeXML.newClassTypeXML(node,classType,ctx);
            classTypeXML.parse(node,walker,ctx);
            classType = classTypeXML.getClassType();
            TypeNativeImpl typeDec = TypeNativeImpl.newTypeNative(classType);  
            return newTypeNativeXML(typeDec);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,node);
        }        
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        // por ahora nada
    }    

   
}
