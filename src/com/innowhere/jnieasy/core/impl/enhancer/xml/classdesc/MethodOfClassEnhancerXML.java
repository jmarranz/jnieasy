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
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.MethodOfClassXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.MethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.NativeBehaviorSignatureEnhancerXML;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ParameterDecListXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ReturnDeclarationXML;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticMethodCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;

import java.util.ArrayList;


public class MethodOfClassEnhancerXML extends BehaviorOfClassEnhancerXML
{
    /** Creates a new instance of MethodOfClassXML */
    public MethodOfClassEnhancerXML(MethodOfClassXML accessObjOfClassXML,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }
            
    public MethodOfClassEnhancer getMethodOfClassEnhancer()
    {
        return (MethodOfClassEnhancer)memberOfClassEnh;
    }
    
    public void setMethodOfClassEnhancer(MethodOfClassEnhancer memberOfClassEnh)
    {
        setMemberOfClassEnhancer(memberOfClassEnh);
    }    
    
    public boolean isForceStatic()
    {
        // Ignorar si el método real Java es estático o no, la clase será StaticMethodOfClassEnhancer        
        return (classEnhancer instanceof JavaClassAsNativeDirectStaticMethodCallbackEnhancer);
    }
    
    public void parse(Element methodNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {        
        try
        {
            // <method ... name="addStatic" >

            String methodName = MethodOfClassXML.getName(methodNode);

            JavaClassAsNativeCapableEnhancer classEnh = getJavaClassAsNativeCapableEnhancer();
            
            ClassTypeNativeCapableImpl thisClassType = classEnh.getClassTypeNativeCapable();
            
            CtMethod ctMethod;
            NativeMethodSignatureImpl sig = (NativeMethodSignatureImpl)NativeBehaviorSignatureXML.getBehaviorSignatureStringDec(methodNode,ctx);
            if (sig != null)
            {
                ctMethod = MethodOfClassEnhancer.getMethod(classEnh.getCtClass(), methodName, sig.getParameters(),ctx);
                
                if (!isForceStatic()) // en el caso forceStatic nos da igual lo que sea el método Java
                {
                    boolean isStatic = Modifier.isStatic(ctMethod.getModifiers());
                    if (sig.isStatic())
                    {
                        if (!isStatic)
                            throw new JNIEasyException("Expected static signature of method: " + ctMethod);
                    }
                    else
                    {
                        if (isStatic)
                            throw new JNIEasyException("Expected a instance signature of method: " + ctMethod);
                    }     
                }
            }
            else
            {
                // <method [params="..."]
                ArrayList params; 
                params = ParameterDecListXML.parseParameterDecListAttribute(methodNode,ctx);                
                boolean mustHaveReturnElem = (params == null); // Si ya conocemos qué método es posiblemente no necesitamos declarar nada más y el retorno nos valga el de por defecto (conociendo la clase)
                
                // <return>
                Element returnNode = TreeWalkerUtil.firstChildElement(walker,"return",mustHaveReturnElem); 

                if (params == null)
                {
                    // <params>
                    Element paramsNode = TreeWalkerUtil.nextSiblingElement(walker,"params",true);
                    params = ParameterDecListXML.parseParameterDecListAttribute(paramsNode,ctx);
                    if (params == null)
                        params = ParameterDecListXML.parseParameterDecListTree(paramsNode,walker,ctx);
                }

                if (returnNode != null) // Ha bajado
                    TreeWalkerUtil.parentElement(walker);

                // El tipo se determina a partir del método definido en la clase            
                ctMethod = MethodOfClassEnhancer.getMethod(classEnh.getCtClass(), methodName,params,ctx);
                // Si no existe lanza una excepción
                // El hecho de encontrar el CtMethod indica que las clases definidas en el XML se corresponden con las del método de la clase

                // obtenemos el nombre de la clase del retorno así no es neceasrio declararla en el <return>
                CtClass returnCtClass = ctMethod.getReturnType();
                ClassTypeNativeImpl returnClassType = ctx.getClassType(returnCtClass);
                // No pasamos el walker porque no apunta a returnNode          
                ReturnDeclarationImpl returnType;
                if (returnNode != null)
                {
                    returnType = ReturnDeclarationXML.parseReturnDeclaration(returnNode,returnClassType,ctx);
                }
                else
                {
                    VarTypeNativeImpl varTypeRet = VarTypeNativeImpl.newVarTypeNative(returnClassType);
                    returnType = new ReturnDeclarationImpl(varTypeRet);
                }
                
                if (isForceStatic()) // en el caso forceStatic nos da igual lo que sea el método Java
                {                
                    sig = new NativeStaticMethodSignatureImpl(ctx.getJNIEasy());
                }
                else
                {
                    boolean isStatic = Modifier.isStatic(ctMethod.getModifiers());
                    if (isStatic)
                        sig = new NativeStaticMethodSignatureImpl(ctx.getJNIEasy());
                    else
                    {
                        sig = new NativeInstanceMethodSignatureImpl(ctx.getJNIEasy());
                        ((NativeInstanceMethodSignatureImpl)sig).setThisClassType((ClassTypeNativeMultipleFieldContainerImpl)thisClassType);
                    }
                }
                
                sig.setReturnDeclaration(returnType);
                sig.addParameterDecList(params);
                
                NativeBehaviorSignatureXML.setCallConv(sig,methodNode);                
            }

            if (!sig.isStatic())            
            {
                checkBehaviorContainer(classEnh);
            }
            
            MethodOfClassImpl methodOfClass = (MethodOfClassImpl)BehaviorOfClassImpl.newBehaviorOfClass(sig, thisClassType);
            MethodOfClassEnhancer methodEnh = (MethodOfClassEnhancer)BehaviorOfClassEnhancer.newBehaviorOfClassEnhancer(ctMethod,methodOfClass,classEnh);          
            
            setMethodOfClassEnhancer(methodEnh);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,methodNode);
        }
       
        super.parse(methodNode, walker, ctx);
    }

    public CtBehavior parseParamsNotEnhance(Element methodNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {
        CtClass[] params = NativeBehaviorSignatureEnhancerXML.parseParams(methodNode, walker, ctx);
        String methodName = MethodOfClassXML.getName(methodNode);        
        return MethodOfClassEnhancer.getMethod(classEnhancer.getCtClass(), methodName, params);        
    }    
}
