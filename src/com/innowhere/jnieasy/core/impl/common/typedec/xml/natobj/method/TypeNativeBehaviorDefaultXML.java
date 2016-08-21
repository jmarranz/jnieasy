/*
 * TypeNativeBehaviorDefaultXML.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorDefaultImpl;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativeCapableXML;

public class TypeNativeBehaviorDefaultXML extends TypeNativeCapableXML
{
    /**
     * Creates a new instance of TypeNativeBehaviorDefaultXML
     */
    public TypeNativeBehaviorDefaultXML(TypeNativeBehaviorDefaultImpl typeDec)
    {
        super(typeDec);
    }
  
    public TypeNativeBehaviorDefaultImpl getTypeNativeBehaviorDefault()
    {
        return (TypeNativeBehaviorDefaultImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        // <field/component ... >
        TypeNativeBehaviorDefaultImpl typeDec = getTypeNativeBehaviorDefault();
        NativeBehaviorSignatureXML sigXML = typeDec.newBehaviorSignatureXML();
        sigXML.parse(typeNode,walker,ctx);
        typeDec.setBehaviorSignature(sigXML.getBehaviorSignature());
    }    
}
