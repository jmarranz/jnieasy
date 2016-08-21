/*
 * TypeNativeBehaviorReflectionXML.java
 *
 * Created on 7 de diciembre de 2004, 14:41
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeBehaviorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;



public abstract class TypeNativeBehaviorReflectionXML extends TypeNativeMemberReflectionXML
{
    
    /**
     * Creates a new instance of TypeNativeMemberReflectionXML
     */
    public TypeNativeBehaviorReflectionXML(TypeNativeBehaviorReflectionImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeBehaviorReflectionImpl getTypeNativeBehaviorReflection()
    {
        return (TypeNativeBehaviorReflectionImpl)typeDec;
    }    
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        // <field/component ... >
        
        TypeNativeBehaviorReflectionImpl typeDec = getTypeNativeBehaviorReflection();
        NativeBehaviorSignatureXML sigXML = typeDec.newBehaviorSignatureXML();
        sigXML.parse(typeNode,walker,ctx);
        typeDec.setBehaviorSignature(sigXML.getBehaviorSignature());
    }   

    
}
