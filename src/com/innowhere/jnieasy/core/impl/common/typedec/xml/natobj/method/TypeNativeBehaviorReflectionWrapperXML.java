/*
 * TypeNativeBehaviorReflectionWrapperXML.java
 *
 * Created on 30 de marzo de 2005, 12:29
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeBehaviorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;


public abstract class TypeNativeBehaviorReflectionWrapperXML extends TypeNativeMemberReflectionWrapperXML
{
    /**
     * Creates a new instance of TypeNativeBehaviorReflectionWrapperXML
     */
    public TypeNativeBehaviorReflectionWrapperXML(TypeNativeBehaviorReflectionWrapperImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativeBehaviorReflectionWrapperImpl getTypeNativeBehaviorReflectionWrapper()
    {
        return (TypeNativeBehaviorReflectionWrapperImpl)typeDec;
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        // <field/component ... >
        TypeNativeBehaviorReflectionWrapperImpl typeDec = getTypeNativeBehaviorReflectionWrapper();
        NativeBehaviorSignatureXML sigXML = typeDec.newBehaviorSignatureXML();
        sigXML.parse(typeNode,walker,ctx);
        typeDec.setBehaviorSignature(sigXML.getBehaviorSignature());
    }       

}
