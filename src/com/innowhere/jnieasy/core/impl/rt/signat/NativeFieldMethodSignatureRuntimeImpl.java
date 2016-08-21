/*
 * NativeFieldMethodSignatureRuntimeImpl.java
 *
 * Created on 18 de julio de 2005, 21:12
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.signat;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeFieldMethodReflection;
import com.innowhere.jnieasy.core.method.NativeDirectFieldCallback;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.TypeNativeFieldMethod;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodSignatureRuntimeImpl extends NativeBehaviorSignatureRuntimeImpl implements NativeFieldMethodSignature
{
    
    /**
     * Creates a new instance of NativeFieldMethodSignatureRuntimeImpl
     */
    public NativeFieldMethodSignatureRuntimeImpl(NativeFieldMethodSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams,ctx);
    }
    
    public NativeFieldMethodSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
    }    
    
    public NativeFieldMethodSignatureImpl getFieldMethodSignature()
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }
    
    public TypeNativeFieldMethod decFieldMethod(Class fieldClass)
    {
        return getTypeManager().decFieldMethod(fieldClass,this);
    }

    public VarTypeNative getFieldVarType()
    {
        return getReturnVarType();
    }    
    
    public void setFieldVarType(VarTypeNativeRuntimeImpl fieldVarType)
    {
        setReturnVarType(fieldVarType);
    }          
    
    public void setReturnVarType(VarTypeNativeRuntimeImpl returnType)
    {    
        super.setReturnVarType(returnType);
        
        NativeFieldMethodSignatureImpl sig = getFieldMethodSignature();
        
        ParameterDecImpl codeParam = sig.getParameterDec(0);
        ParameterDecImpl fieldValueParam = sig.getParameterDec(1);
        RuntimeContext ctx = rtMgr.getDefaultRuntimeContextNotUsingImports(); // Realmente no se usa para obtener el tipo "int"        
        VarTypeNativeRuntimeImpl codeVarType = VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(int.class,codeParam.getVarTypeNative(),ctx); // parámetro "int"
        paramDecList.addParameterDecRuntime(new ParameterDecRuntimeImpl(codeVarType, codeParam));       
        paramDecList.addParameterDecRuntime(new ParameterDecRuntimeImpl(returnType, fieldValueParam));
    }      
    
    public NativeFieldMethodSignatureImpl getNativeFieldMethodSignature()
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }    
    
    public String formNativeDirectCallbackUniqueClassName(Member accessObject)
    {
        Field field = (Field)accessObject;
        NativeFieldMethodSignatureImpl sig = getNativeFieldMethodSignature();
        return sig.formNativeDirectCallbackUniqueClassName(field.getDeclaringClass().getName(),field.getName());        
    }    
    
    public Field getField(Class containerClass,String fieldName)
    {
        Field field;
        try
        {
            field = containerClass.getDeclaredField(fieldName);
        }
        catch(NoSuchFieldException ex)
        {
            throw new JNIEasyException(ex);
        }

        Class fieldClass = getFieldVarType().getType().getDeclaredClass();
        if (!fieldClass.equals(field.getType()))
            throw new JNIEasyException("Bad field type, " + field.getType().getName() + ", expected: " + fieldClass.getName());        
        return field;
    }    
    
    public NativeFieldMethodReflection newFieldMethodReflection(Field field)    
    {
        return (NativeFieldMethodReflection)newBehaviorReflection(field);        
    }    
    
    public NativeDirectFieldCallback newDirectFieldCallback(Field field) 
    {    
        return (NativeDirectFieldCallback)newDirectCallback(field);
    }        
}
