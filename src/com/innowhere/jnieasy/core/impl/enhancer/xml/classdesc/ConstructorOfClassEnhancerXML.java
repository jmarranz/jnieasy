/*
 * MethodOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:58
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.ConstructorOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.ConstructorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.NativeBehaviorSignatureEnhancerXML;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import java.util.List;

public class ConstructorOfClassEnhancerXML extends BehaviorOfClassEnhancerXML
{

    /** Creates a new instance of MethodOfClassXML */
    public ConstructorOfClassEnhancerXML(ConstructorOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }

    public ConstructorOfClassEnhancer getConstructorOfClassEnhancer()
    {
        return (ConstructorOfClassEnhancer)memberOfClassEnh;
    }
    
    public void setConstructorOfClassEnhancer(ConstructorOfClassEnhancer memberOfClassEnh)
    {
        setMemberOfClassEnhancer(memberOfClassEnh);
    }
    
    public JavaClassAsNativeMultipleFieldContainerEnhancer getJavaClassAsMultipleFieldContainerEnhancer()
    {
        return (JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer;
    }
    
    public ConstructorOfClassXML getConstructorOfClassXML()
    {
        return (ConstructorOfClassXML)accessObjOfClassXML;
    }
    
    public void parse(Element constrNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {
        try
        {
            JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer = getJavaClassAsMultipleFieldContainerEnhancer();            

            // <constructor ... >
           
            ConstructorOfClassXML construcXML = getConstructorOfClassXML();            
            construcXML.parse(constrNode,walker,ctx);
            ConstructorOfClassImpl constr = construcXML.getConstructorOfClass();
            
            NativeConstructorSignatureImpl sig = constr.getConstructorSignature();
            // Obtenemos el constructor definido en la clase a partir de los parámetros declarados
            List params = sig.getParameterDecList().getParameterDecList();
            CtConstructor ctConstructor = ConstructorOfClassEnhancer.getConstructor(classEnhancer.getCtClass(),params,ctx);
            // Si no existe lanza una excepción
            // El hecho de encontrar el CtConstructor indica que las clases de los params definidas en el XML se corresponden con las del método de la clase

            checkBehaviorContainer(classEnhancer);
            
            ConstructorOfClassEnhancer constEnh = new ConstructorOfClassEnhancer(ctConstructor,constr,classEnhancer);
            setConstructorOfClassEnhancer(constEnh);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,constrNode);
        }
        
        super.parse(constrNode,walker,ctx);
    }

    public CtBehavior parseParamsNotEnhance(Element constrNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {
        CtClass[] params = NativeBehaviorSignatureEnhancerXML.parseParams(constrNode, walker, ctx);
        return ConstructorOfClassEnhancer.getConstructor(classEnhancer.getCtClass(),params);
    }
}
