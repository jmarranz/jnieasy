/*
 * JavaClassAsNativeDirectStaticFieldCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 19:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectStaticFieldCallbackEnhancer;
import com.innowhere.jnieasy.core.typedec.NativeDirectStaticFieldCallbackDescriptor;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeDirectStaticFieldCallbackImpl;
import com.innowhere.jnieasy.core.method.NativeFieldMethod;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticFieldCallbackEnhancerRender extends JavaClassAsNativeDirectFieldCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectStaticFieldCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectStaticFieldCallbackEnhancerRender(JavaClassAsNativeDirectStaticFieldCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }

    public String getDescriptorClassName()
    {
        return NativeDirectStaticFieldCallbackDescriptor.class.getName();
    }

    public String getNativeInterfaceName()
    {
        return NativeDirectStaticFieldCallback.class.getName();
    }

    public String getNativeDirectCallbackSuperClass()
    {
        return NativeDirectStaticFieldCallbackImpl.class.getName();
    }
    
    public void addMethodDispatcher(EnhancerSourceFileContext ctx)
    {
        /* 
            public Object jnieasyOnCall(int opcode,Object value)
            {
                ...
            }
        */
                
        addFieldAccessMethod();
        
        // Tenemos que llamar a :
        // Clase: Callback concreta
        // public static TipoField nombreField(int opcode,TipoField value);
       
        FieldMethodOfClassEnhancerRender behaviorEnhRender = getFieldMethodOfClassEnhancerRender();
        String methodName = behaviorEnhRender.getFieldMethodOfClassEnhancer().getFieldMethodOfClass().getName();

        NativeBehaviorSignatureRender sigRender = behaviorEnhRender.getBehaviorSignatureRender();

        // El "CallbackClassName." sobra pues es en la propia clase callback donde se llama al método SIEMPRE
        String callCode = methodName + "($1," + sigRender.renderPassParamFromObject(1,"$2") + ")";
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  " + sigRender.returnCastToObject(callCode) + "; \n" );
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyOnCall", 
            new CtClass[]{CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object")}, null, body.toString());             

    }     
    
    public void addFieldAccessMethod()
    {    
        FieldMethodOfClassEnhancerRender behaviorEnhRender = getFieldMethodOfClassEnhancerRender();
        CtField ctField = behaviorEnhRender.getFieldMethodOfClassEnhancer().getCtField();
        CtClass ctClassCallback = classEnhancer.getCtClass();
        
        CtMethod ctBehavior;
        try
        {
            CtClass ctReturnType = ctField.getType();
            CtClass codeOp = CtClass.intType;
            CtClass[] ctParameters = new CtClass[] {codeOp,ctReturnType};
            CtClass[] ctExceptions = new CtClass[0];
            
            String fieldContainerClassName = ctField.getDeclaringClass().getName();
            String fieldTypeName = ctReturnType.getName();
            String fieldName = ctField.getName();
            
            StringBuffer body = new StringBuffer();
            body.append( "{ \n" );
            body.append( "  switch($1) \n" );
            body.append( "  { \n" );              
            body.append( "    case " + NativeFieldMethod.GET + " : \n" );
            body.append( "      return " + fieldContainerClassName + "." + fieldName + "; \n" );
            body.append( "    case " + NativeFieldMethod.SET + " : \n" );         
            body.append( "      " + fieldContainerClassName + "." + fieldName + " = $2; \n" );
            body.append( "      return $2; \n" );
            body.append( "    case " + NativeFieldMethod.GET_SET + " : \n" );  
            body.append( "      " + fieldTypeName + " jnieasyRes = " + fieldContainerClassName + "." + fieldName + "; \n" );
            body.append( "      " + fieldContainerClassName + "." + fieldName + " = $2; \n" );
            body.append( "      return jnieasyRes; \n" );
            body.append( "    default : \n" );            
            body.append( "       throw new " + JNIEasyException.class.getName() + "(\"Invalid field access code\"); \n" ); 
            body.append( "  } \n" );              
            body.append( "} \n" );  
            
            ctBehavior = CtNewMethod.make(Modifier.PUBLIC | Modifier.STATIC,ctReturnType,ctField.getName(), 
                ctParameters,ctExceptions,body.toString(),ctClassCallback);
            ctClassCallback.addMethod(ctBehavior);        
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }         
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }  
    }          
}
