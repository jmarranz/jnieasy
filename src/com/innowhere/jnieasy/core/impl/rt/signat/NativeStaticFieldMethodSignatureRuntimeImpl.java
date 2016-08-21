/*
 * NativeStaticFieldMethodSignatureRuntimeImpl.java
 *
 * Created on 16 de julio de 2005, 16:30
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethod;
import com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.TypeNativeStaticFieldMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/**
 *
 * @author jmarranz
 */
public class NativeStaticFieldMethodSignatureRuntimeImpl extends NativeFieldMethodSignatureRuntimeImpl implements NativeStaticFieldMethodSignature
{
    
    /**
     * Creates a new instance of NativeStaticFieldMethodSignatureRuntimeImpl
     */
    public NativeStaticFieldMethodSignatureRuntimeImpl(NativeStaticFieldMethodSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams,ctx);
    }
    
    public NativeStaticFieldMethodSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
    }   
    
    public static NativeStaticFieldMethodSignatureRuntimeImpl newStaticFieldMethodSignatureRuntime(VarTypeNativeRuntimeImpl fieldTypeDec,RuntimeContext ctx)
    {
        NativeStaticFieldMethodSignatureRuntimeImpl sig = new NativeStaticFieldMethodSignatureRuntimeImpl(ctx);
        sig.setFieldVarType(fieldTypeDec);
        return sig;
    }     
    
    public NativeStaticFieldMethodSignatureImpl getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
    
    public TypeNativeStaticFieldMethod decStaticFieldMethod(Class fieldClass)
    {
        return getTypeManager().decStaticFieldMethod(fieldClass,this);
    }    
    
    public void checkReflectionObject(Member member)
    {    
        Field field = (Field)member;
        Field fieldValid = getField(field.getDeclaringClass(),field.getName());        
        if (!field.equals(fieldValid)) throw new JNIEasyException("Not valid field " + field);        
    }    
  
    public String getNameToExport(Member member)
    {
        return member.getDeclaringClass().getName() + "." + member.getName();
    }    
    
    public NativeStaticFieldMethodReflection newStaticFieldMethodReflection(Class containerClass,String fieldName)    
    {
        Field field = getField(containerClass,fieldName); 
        return (NativeStaticFieldMethodReflection)newBehaviorReflectionInternal(field,false);       
    }    
    
    public NativeDirectStaticFieldCallback newDirectStaticFieldCallback(Class containerClass,String fieldName) 
    {    
        Field field = getField(containerClass,fieldName);        
        return (NativeDirectStaticFieldCallback)newDirectCallbackInternal(field,false);
    }    

    public Field getField(Class containerClass,String fieldName)
    {
        Field field = super.getField(containerClass,fieldName);        
        if (!Modifier.isStatic(field.getModifiers()))
            throw new JNIEasyException("Real Java field must be static: " + field);
        return field;
    }
    
    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeStaticFieldMethodSignatureImpl(jniEasy);
    }       
    
    public Class getNativeBehaviorDefaultInterface()    
    {
        return NativeStaticFieldMethod.class;
    }
}
