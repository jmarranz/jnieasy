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
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.BehaviorOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldMethodOfClassEnhancerRender;


public abstract class FieldMethodOfClassEnhancer extends BehaviorOfClassEnhancer
{
    /** Creates a new instance of MethodDec */
    public FieldMethodOfClassEnhancer(CtField ctBehavior,FieldMethodOfClassImpl behaviorOfClass,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(ctBehavior,behaviorOfClass,classEnhancer);
    }
    
    public static FieldMethodOfClassEnhancer newDefaultFieldMethodOfClassEnhancer(CtField ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        boolean isStatic = Modifier.isStatic(ctBehavior.getModifiers());
        if (isStatic)
            return StaticFieldMethodOfClassEnhancer.newDefaultStaticFieldMethodOfClassEnhancer(ctBehavior,classEnhancer,ctx);
        else
            return InstanceFieldMethodOfClassEnhancer.newDefaultInstanceFieldMethodOfClassEnhancer(ctBehavior,(JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer,ctx);
    }    

    public static FieldMethodOfClassEnhancer newDefaultFieldMethodOfClassEnhancer(NativeFieldMethodSignatureImpl sig,CtField ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        CtClass ctClassReturn = getCtClass(ctBehavior);
        ClassTypeNativeImpl retType = ctx.getClassType(ctClassReturn);
        ReturnDeclarationImpl returnType = new ReturnDeclarationImpl(VarTypeNativeImpl.newVarTypeNative(retType));        

        //ClassTypeNativeCapableImpl thisClassType = classEnhancer.getClassTypeNativeCapable();
        sig.setFieldDeclaration(returnType);
        
        return (FieldMethodOfClassEnhancer)newDefaultBehaviorOfClassEnhancer(sig,ctBehavior,classEnhancer,ctx);
    }    
    
    public void init()    
    {
        getFieldMethodOfClass().setName(getCtField().getName());
    }
    
    public FieldMethodOfClassImpl getFieldMethodOfClass()
    {
        return (FieldMethodOfClassImpl)memberOfClass;
    }
    
    public CtField getCtField()
    {
        return (CtField)ctMember;
    }    
     
    public static CtClass getCtClass(CtField ctField)
    {
        try
        {            
            return ctField.getType();
        }
        catch(NotFoundException ex)
        {
            throw new JNIEasyException(ex);
        }
    }        
    
    public static CtField getField(CtClass ctClass,String fieldName)
    {
        try
        {
            return ctClass.getDeclaredField(fieldName);
        }
        catch(javassist.NotFoundException ex)
        {
            throw new JNIEasyException("Not exist field: " + ctClass.getName() + "." + fieldName);
        }      
    }           
   
    public BehaviorOfClassEnhancerRender newBehaviorOfClassEnhancerRender()    
    {
        return new FieldMethodOfClassEnhancerRender(this);
    }       
}
