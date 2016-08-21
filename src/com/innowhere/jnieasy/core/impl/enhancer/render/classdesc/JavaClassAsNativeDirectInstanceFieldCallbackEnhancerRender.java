/*
 * JavaClassAsNativeDirectInstanceFieldCallbackEnhancerRender.java
 *
 * Created on 7 de julio de 2005, 19:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeInstanceFieldMethodSignatureRender;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectInstanceFieldCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback;
import com.innowhere.jnieasy.core.method.NativeFieldMethod;
import com.innowhere.jnieasy.core.typedec.NativeDirectInstanceFieldCallbackDescriptor;
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
public class JavaClassAsNativeDirectInstanceFieldCallbackEnhancerRender extends JavaClassAsNativeDirectFieldCallbackEnhancerRender
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectInstanceFieldCallbackEnhancerRender
     */
    public JavaClassAsNativeDirectInstanceFieldCallbackEnhancerRender(JavaClassAsNativeDirectInstanceFieldCallbackEnhancer classEnhancer)
    {
        super(classEnhancer);
    }
    
    public String getDescriptorClassName()
    {
        return NativeDirectInstanceFieldCallbackDescriptor.class.getName();
    }

    public String getNativeInterfaceName()
    {
        return NativeDirectInstanceFieldCallback.class.getName();
    }    

    public String getNativeDirectCallbackSuperClass()
    {
        return NativeDirectInstanceFieldCallbackImpl.class.getName();
    }
    
    public void addMethodDispatcher(EnhancerSourceFileContext ctx)
    {
        /*  
            public Object jnieasyOnCall(Object obj,int opcode,Object value)
            {
                ...
            }
        */
        
        addFieldAccessMethod();        
        
        // Tenemos que llamar a :
        // Clase: Callback concreta
        // public TipoField nombreField(ClaseContainerField obj,int opcode,TipoField value);
        // hay que recordar que la signatura representa la signatura de un hipotético
        // método en la clase contenedora que accedería al field (método que no existe)
        // Sería: FieldType <anonymous>(int opcode,FieldType value);
        // Notar que no es estática pero el parámetro implícito es el clase contenedora del field
        // La clase de la callback la podemos obtener via behaviorEnhRender.getContainerClassName();
        
        FieldMethodOfClassEnhancerRender behaviorEnhRender = getFieldMethodOfClassEnhancerRender();
        //String callbackClassName = behaviorEnhRender.getContainerClassName();
        String methodName = behaviorEnhRender.getFieldMethodOfClassEnhancer().getFieldMethodOfClass().getName();

        NativeInstanceFieldMethodSignatureRender sigRender = (NativeInstanceFieldMethodSignatureRender)behaviorEnhRender.getBehaviorSignatureRender();
        String fieldClassContainerName = sigRender.getInstanceFieldMethodSignature().getThisClassType().getClassName();
 
        String callCode = methodName + "((" + fieldClassContainerName + ")$1,$2," + sigRender.renderPassParamFromObject(1,"$3") + ")";
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  " + sigRender.returnCastToObject(callCode) + "; \n" );
        body.append( "}" );
  
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyOnCall", 
            new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object"),CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object") },
            null, body.toString());  
            
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
            CtClass[] ctParameters = new CtClass[] {ctField.getDeclaringClass(),codeOp,ctReturnType};
            CtClass[] ctExceptions = new CtClass[0];

            String fieldContainerClassName = ctField.getDeclaringClass().getName();
            String fieldTypeName = ctReturnType.getName();
            String fieldName = ctField.getName();
            
            StringBuffer body = new StringBuffer();
            body.append( "{ \n" );
            body.append( "  switch($2) \n" );
            body.append( "  { \n" );            
            body.append( "    case " + NativeFieldMethod.GET + " : \n" );
            body.append( "      return ((" + fieldContainerClassName + ")$1)." + fieldName + "; \n" );
            body.append( "    case " + NativeFieldMethod.SET + " : \n" );            
            body.append( "      ((" + fieldContainerClassName + ")$1)." + fieldName + " = $3 ; \n" );
            body.append( "      return $3; \n" );
            body.append( "    case " + NativeFieldMethod.GET_SET + " : \n" );  
            body.append( "      " + fieldTypeName + " jnieasyRes = ((" + fieldContainerClassName + ")$1)." + fieldName + "; \n" );
            body.append( "      ((" + fieldContainerClassName + ")$1)." + fieldName + " = $3 ; \n" );
            body.append( "      return jnieasyRes; \n" );
            body.append( "    default : \n" );            
            body.append( "       throw new " + JNIEasyException.class.getName() + "(\"Invalid field access code\"); \n" ); 
            body.append( "  } \n" );             
            body.append( "} \n" );            

            // El método debe ser no estático aunque no tenga mucho que ver con lo que hace, debido a que
            // debe ajustarse a como si fuera un método no estático "normal"
            ctBehavior = CtNewMethod.make(Modifier.PUBLIC,ctReturnType,ctField.getName(), 
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
