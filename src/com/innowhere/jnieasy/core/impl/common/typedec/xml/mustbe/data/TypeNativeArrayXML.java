/*
 * TypeNativeArrayXML.java
 *
 * Created on 25 de marzo de 2004, 13:42
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeArrayInfoXML;


/**
 *
 * @author  jmarranz
 */


public class TypeNativeArrayXML extends TypeCanBeNativeCapableXML
{
    protected TypeNativeArrayInfoXML arrayInfoXML;
    
    /**
     * Creates a new instance of TypeNativeArrayXML
     */
    public TypeNativeArrayXML(TypeNativeArrayImpl typeDec)
    {
        super(typeDec);
        
        this.arrayInfoXML = new TypeNativeArrayInfoXML(typeDec);
    }

    public TypeNativeArrayImpl getTypeNativeArray()
    {
        return (TypeNativeArrayImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        //TypeNativeArrayImpl typeDec = getTypeNativeArray();
        arrayInfoXML.parse(typeNode,walker,ctx);
    }
}
