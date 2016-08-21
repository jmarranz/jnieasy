/*
 * TypeNativeArrayWrapperXML.java
 *
 * Created on 25 de marzo de 2004, 13:42
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;

/**
 *
 * @author  jmarranz
 */
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeArrayInfoXML;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


public class TypeNativeArrayWrapperXML extends TypeCanBeNativeCapableWrapperXML
{
    protected TypeNativeArrayInfoXML arrayInfoXML;
    
    /**
     * Creates a new instance of TypeNativeArrayWrapperXML
     */
    public TypeNativeArrayWrapperXML(TypeNativeArrayWrapperImpl typeDec)
    {
        super(typeDec);
        
        this.arrayInfoXML = new TypeNativeArrayInfoXML(typeDec);
    }

    public TypeNativeArrayWrapperImpl getTypeNativeArrayWrapper()
    {
        return (TypeNativeArrayWrapperImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        TypeNativeArrayWrapperImpl typeDec = getTypeNativeArrayWrapper();
        if (typeDec.isCompleteDeclaration())
        {
            arrayInfoXML.parse(typeNode,walker,ctx);
        }
        else
        {           
            arrayInfoXML.parseToCompleteDeclaration(typeNode,walker,typeDec,ctx);
        }
    }
}
