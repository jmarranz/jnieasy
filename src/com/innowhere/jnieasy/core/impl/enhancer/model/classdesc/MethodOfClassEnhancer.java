/*
 * MethodDec.java
 *
 * Created on 28 de febrero de 2005, 20:31
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.BehaviorOfClassRender;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.ParameterDecListRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.BehaviorOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.MethodOfClassEnhancerRender;
import java.util.ArrayList;
import java.util.List;

public abstract class MethodOfClassEnhancer extends BehaviorOfClassEnhancer
{
    /** Creates a new instance of MethodDec */
    public MethodOfClassEnhancer(CtMethod ctBehavior,MethodOfClassImpl behaviorOfClass,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(ctBehavior,behaviorOfClass,classEnhancer);
    }
    
    public static MethodOfClassEnhancer newDefaultMethodOfClassEnhancer(CtMethod ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        boolean isStatic = Modifier.isStatic(ctBehavior.getModifiers());
        if (isStatic)
            return StaticMethodOfClassEnhancer.newDefaultStaticMethodOfClassEnhancer(ctBehavior,classEnhancer,ctx);
        else
            return InstanceMethodOfClassEnhancer.newDefaultInstanceMethodOfClassEnhancer(ctBehavior,(JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer,ctx);
    }    

    public static MethodOfClassEnhancer newDefaultMethodOfClassEnhancer(NativeMethodSignatureImpl sig,CtMethod ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        CtClass ctClassReturn = getReturnType(ctBehavior);
        ClassTypeNativeImpl retType = ctx.getClassType(ctClassReturn);
        ReturnDeclarationImpl returnType = new ReturnDeclarationImpl(VarTypeNativeImpl.newVarTypeNative(retType));        

        //ClassTypeNativeCapableImpl thisClassType = classEnhancer.getClassTypeNativeCapable();
        sig.setReturnDeclaration(returnType);

        CtClass[] ctClassParams = getParameterTypes(ctBehavior);
        ArrayList params = toParameterDec(ctClassParams,ctx);
        sig.addParameterDecList(params);        
        
        return (MethodOfClassEnhancer)newDefaultBehaviorOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }    
    
    public void init()    
    {
        getMethodOfClass().setName(getCtMethod().getName());
    }
    
    public MethodOfClassImpl getMethodOfClass()
    {
        return (MethodOfClassImpl)memberOfClass;
    }
    
    public CtMethod getCtMethod()
    {
        // A continuación se considera un caso muy extraño, pero se ha detectado un caso en donde
        // si el método tiene como parámetros alguna referencia cuya clase es 
        // enhanced al mismo tiempo que el propio método (antes),
        // resulta que el CtClass recrea el objeto método *de su lista* 
        // es decir este ctMethod PUEDE no estar en la lista del CtClass
        // y estar otro objeto, por tanto al generar el bytecode a fichero
        // desde la clase el método no es enhanced (como si no hubieramos hecho el setBody()).
        // Para arreglarlo devolvemos el verdadero CtMethod que tiene el
        // CtClass en su lista y no el ctMember (que es un CtMethod)        
        
        CtMethod ctMethod = (CtMethod)ctMember;        
        CtClass ctClass = ctMethod.getDeclaringClass();
        try
        {
            return ctClass.getDeclaredMethod(ctMethod.getName(), ctMethod.getParameterTypes());
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);            
        }        
    }    
    
    public static CtClass[] getParameterTypes(CtMethod ctBehavior)
    {
        try
        {
            return ctBehavior.getParameterTypes();
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
    
    public static CtMethod getMethod(CtClass ctClass,String methodName,List params,EnhancerSourceFileContext ctx)
    {
        try
        {
            return ctClass.getDeclaredMethod(methodName,convertParams(params,ctx));
        }
        catch(javassist.NotFoundException ex)
        {
            throw new JNIEasyException("Not exist method: " + BehaviorOfClassRender.getAsJavaBehaviorSignatureString(ctClass.getName(),methodName,ParameterDecListRender.extractClassNames(params)));
        }      
    }       

    public static CtMethod getMethod(CtClass ctClass,String methodName,CtClass[] params)
    {
        try
        {
            return ctClass.getDeclaredMethod(methodName,params);
        }
        catch(javassist.NotFoundException ex)
        {
            throw new JNIEasyException("Not exist method: " + BehaviorOfClassRender.getAsJavaBehaviorSignatureString(ctClass.getName(),methodName,EnhancerUtil.extractClassNames(params)));
        }      
    }       
 
    
    public static CtClass getReturnType(CtMethod ctBehavior)
    {
        try
        {
            return ctBehavior.getReturnType();
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }        

    public BehaviorOfClassEnhancerRender newBehaviorOfClassEnhancerRender()    
    {
        return new MethodOfClassEnhancerRender(this);
    }    
}
