/*
 * TypeNativeDirectCallbackXML.java
 *
 * Created on 12 de enero de 2005, 19:14
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativeCapableXML;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

public class TypeNativeDirectCallbackXML extends TypeNativeCapableXML
{
    /**
     * Creates a new instance of TypeNativeDirectCallbackXML
     */
    public TypeNativeDirectCallbackXML(TypeNativeDirectCallbackImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeDirectCallbackImpl getTypeNativeDirectCallback()
    {
        return (TypeNativeDirectCallbackImpl)typeDec;
    }

    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        super.parse(typeNode,walker,ctx);
        
        // <field/component ... >
        TypeNativeDirectCallbackImpl typeDec = getTypeNativeDirectCallback();

        // En el caso de user defined puede estar ya definida la signatura
        // por lo que la carga de una nueva es opcional y se hace si detectamos que
        // que en el XML se actualiza la signatura      

        if ((typeDec.getBehaviorSignature() == null) || TreeWalkerUtil.hasChildElement(walker))
        {
            // Una vez aquí dentro, deben existir nodos de declaración de la signatura o falla
            NativeBehaviorSignatureXML sigXML = typeDec.newBehaviorSignatureXML();
            sigXML.parse(typeNode,walker,ctx);
            typeDec.setBehaviorSignature(sigXML.getBehaviorSignature());
        }
    } 
}
