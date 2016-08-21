/*
 * ConstructorDec.java
 *
 * Created on 28 de febrero de 2005, 20:33
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import javassist.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.BehaviorOfClassRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.BehaviorOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.ConstructorOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeConstructorSignatureRender;
import com.innowhere.jnieasy.core.impl.common.signat.render.ParameterDecListRender;
import java.util.ArrayList;
import java.util.List;


public class ConstructorOfClassEnhancer extends BehaviorOfClassEnhancer
{
    
    /** Creates a new instance of ConstructorDec */
    public ConstructorOfClassEnhancer(CtConstructor ctBehavior,ConstructorOfClassImpl behaviorOfClass,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(ctBehavior,behaviorOfClass,classEnhancer);
    }
    
    public static ConstructorOfClassEnhancer newDefaultConstructorOfClassEnhancer(CtConstructor ctBehavior,JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        NativeConstructorSignatureImpl sig = new NativeConstructorSignatureImpl(ctx.getJNIEasy());
        ClassTypeNativeMultipleFieldContainerImpl classType = classEnhancer.getClassTypeMultipleFieldContainer();
        sig.setThisClassType(classType);
        
        CtClass[] ctClassParams = getParameterTypes(ctBehavior);
        ArrayList params = toParameterDec(ctClassParams,ctx);
        sig.addParameterDecList(params);
        
        return (ConstructorOfClassEnhancer)newDefaultBehaviorOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }
    
    public void init()    
    {
        // No hay que hacer nada 
    }
    
    public ConstructorOfClassImpl getConstructorOfClass()
    {
        return (ConstructorOfClassImpl)memberOfClass;
    }    

    public CtConstructor getCtConstructor()
    {
        CtConstructor ctConstr = (CtConstructor)ctMember;

        // Ver explicación de esto en correspondiente método en MethodOfClassEnhancer
        CtClass ctClass = ctConstr.getDeclaringClass();
        try
        {
            return ctClass.getDeclaredConstructor(ctConstr.getParameterTypes());
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
        
    public static CtClass[] getParameterTypes(CtConstructor ctBehavior)
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
    
    public static CtConstructor getConstructor(CtClass ctClass,List params,EnhancerSourceFileContext ctx)
    {
        try
        {
            return ctClass.getDeclaredConstructor(convertParams(params,ctx));
        }
        catch(javassist.NotFoundException ex)
        {
            throw new JNIEasyException("Not exist constructor: " + BehaviorOfClassRender.getAsJavaBehaviorSignatureString(ctClass.getName(),NativeConstructorSignatureRender.NAME,ParameterDecListRender.extractClassNames(params)),ex);
        }        
    }    
    
    public static CtConstructor getConstructor(CtClass ctClass,CtClass[] params)
    {
        try
        {
            return ctClass.getDeclaredConstructor(params);
        }
        catch(javassist.NotFoundException ex)
        {
            throw new JNIEasyException("Not exist constructor: " + BehaviorOfClassRender.getAsJavaBehaviorSignatureString(ctClass.getName(),NativeConstructorSignatureRender.NAME,EnhancerUtil.extractClassNames(params)),ex);
        }        
    }        
    
    public BehaviorOfClassEnhancerRender newBehaviorOfClassEnhancerRender()    
    {
        return new ConstructorOfClassEnhancerRender(this);
    }    

    public JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClass, EnhancerSharedContext ctx)
    {
        return JavaClassAsNativeDirectConstructorCallbackEnhancer.newJavaClassAsNativeDirectConstructorCallbackEnhancer(ctClass,ctx);
    }
}
