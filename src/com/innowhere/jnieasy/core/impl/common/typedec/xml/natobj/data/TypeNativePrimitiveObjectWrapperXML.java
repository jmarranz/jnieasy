/*
 * TypeNativePrimitiveObjectWrapperXML.java
 *
 * Created on 4 de abril de 2005, 14:34
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data.TypeNativePrimitiveObjectXML;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

public class TypeNativePrimitiveObjectWrapperXML extends TypeCanBeNativeCapableWrapperXML
{
    protected TypeNativePrimitiveObjectXML fieldXML;
    
    /**
     * Creates a new instance of TypeNativePrimitiveObjectWrapperXML
     */
    public TypeNativePrimitiveObjectWrapperXML(TypeNativePrimitiveObjectWrapperImpl typeDec)
    {
        super(typeDec);
        
        this.fieldXML = (TypeNativePrimitiveObjectXML)TypeNativeXML.newTypeNativeXML(typeDec.getTypeNativePrimitiveObject());
    }

    public TypeNativePrimitiveObjectWrapperImpl getTypeNativePrimitiveObjectWrapper()
    {
        return (TypeNativePrimitiveObjectWrapperImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        fieldXML.parse(typeNode,walker,ctx);
    }    
}
