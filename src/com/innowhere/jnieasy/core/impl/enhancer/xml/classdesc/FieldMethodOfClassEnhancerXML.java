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
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.FieldMethodOfClassXML;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.MethodOfClassXML;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.MethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.NativeBehaviorSignatureEnhancerXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ReturnDeclarationXML;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldMethodOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticFieldCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;


public class FieldMethodOfClassEnhancerXML extends BehaviorOfClassEnhancerXML
{
    /** Creates a new instance of MethodOfClassXML */
    public FieldMethodOfClassEnhancerXML(FieldMethodOfClassXML accessObjOfClassXML,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(accessObjOfClassXML,classEnhancer);
    }
    
    public FieldMethodOfClassEnhancer getFieldMethodOfClassEnhancer()
    {
        return (FieldMethodOfClassEnhancer)memberOfClassEnh;
    }
    
    public void setFieldMethodOfClassEnhancer(FieldMethodOfClassEnhancer memberOfClassEnh)
    {
        setMemberOfClassEnhancer(memberOfClassEnh);
    }    
    
    public boolean isForceStatic()
    {
        // Ignorar si el método real Java es estático o no, la clase será StaticMethodOfClassEnhancer        
        return (classEnhancer instanceof JavaClassAsNativeDirectStaticFieldCallbackEnhancer);
    }
    
    public void parse(Element methodNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {        
        try
        {
            // <fieldMethod ... name="addStatic" >

            String fieldName = FieldMethodOfClassXML.getFieldName(methodNode);

            JavaClassAsNativeCapableEnhancer classEnh = getJavaClassAsNativeCapableEnhancer();
            
            ClassTypeNativeCapableImpl thisClassType = classEnh.getClassTypeNativeCapable();
            
            CtField ctField = FieldMethodOfClassEnhancer.getField(classEnh.getCtClass(), fieldName); // Si no existe lanza una excepción
            NativeFieldMethodSignatureImpl sig = (NativeFieldMethodSignatureImpl)NativeBehaviorSignatureXML.getBehaviorSignatureStringDec(methodNode,ctx);
            if (sig != null)
            {
                if (!isForceStatic()) // el caso forceStatic nos da igual lo que sea el método Java
                {
                    boolean isStatic = Modifier.isStatic(ctField.getModifiers());
                    if (sig.isStatic())
                    {
                        if (!isStatic)
                            throw new JNIEasyException("Expected static signature of field method: " + ctField);
                    }
                    else
                    {
                        if (isStatic)
                            throw new JNIEasyException("Expected a instance signature of field method: " + ctField);
                    }     
                }
            }
            else
            {
                // El tipo se determina a partir del field definido en la clase                
                // obtenemos el nombre de la clase del retorno así no es neceasrio declararla en el nodo
                CtClass returnCtClass = ctField.getType();
                ClassTypeNativeImpl returnClassType = ctx.getClassType(returnCtClass);
                
                ReturnDeclarationImpl returnType;
                
                // <fieldType ...>
                Element fieldTypeNode = TreeWalkerUtil.firstChildElement(walker,"fieldType",false);        
                if (fieldTypeNode != null)
                {
                    returnType = ReturnDeclarationXML.parseReturnDeclaration(fieldTypeNode,walker,returnClassType,ctx);
                    TreeWalkerUtil.parentElement(walker);
                }
                else
                {
                    returnType = new ReturnDeclarationImpl(returnClassType);
                } 
           
                if (isForceStatic()) // en el caso forceStatic nos da igual lo que sea el método Java
                {                
                    sig = new NativeStaticFieldMethodSignatureImpl(ctx.getJNIEasy());
                }
                else
                {
                    boolean isStatic = Modifier.isStatic(ctField.getModifiers());
                    if (isStatic)
                        sig = new NativeStaticFieldMethodSignatureImpl(ctx.getJNIEasy());
                    else
                    {
                        sig = new NativeInstanceFieldMethodSignatureImpl(ctx.getJNIEasy());
                        ((NativeInstanceFieldMethodSignatureImpl)sig).setThisClassType((ClassTypeNativeMultipleFieldContainerImpl)thisClassType);
                    }
                }
                
                sig.setFieldDeclaration(returnType);
                
                NativeBehaviorSignatureXML.setCallConv(sig,methodNode);                
            }

            if (!sig.isStatic())            
            {
                checkBehaviorContainer(classEnh);
            }
            
            FieldMethodOfClassImpl methodOfClass = (FieldMethodOfClassImpl)BehaviorOfClassImpl.newBehaviorOfClass(sig, thisClassType);
            FieldMethodOfClassEnhancer methodEnh = (FieldMethodOfClassEnhancer)BehaviorOfClassEnhancer.newBehaviorOfClassEnhancer(ctField,methodOfClass,classEnh);          
            
            setFieldMethodOfClassEnhancer(methodEnh);
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
