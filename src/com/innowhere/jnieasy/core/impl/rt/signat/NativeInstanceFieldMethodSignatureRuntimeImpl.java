/*
 * NativeInstanceFieldMethodSignatureRuntimeImpl.java
 *
 * Created on 16 de julio de 2005, 16:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod;
import com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.TypeNativeInstanceFieldMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/**
 *
 * @author jmarranz
 */
public class NativeInstanceFieldMethodSignatureRuntimeImpl extends NativeFieldMethodSignatureRuntimeImpl implements NativeInstanceFieldMethodSignature
{
    
    /**
     * Creates a new instance of NativeInstanceFieldMethodSignatureRuntimeImpl
     */
    public NativeInstanceFieldMethodSignatureRuntimeImpl(NativeInstanceFieldMethodSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams, ctx);
    }    
        
    public NativeInstanceFieldMethodSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
    }    
    
    public static NativeInstanceFieldMethodSignatureRuntimeImpl newInstanceFieldMethodSignatureRuntime(VarTypeNativeRuntimeImpl fieldTypeDec,Class classObj,RuntimeContext ctx)
    {
        NativeInstanceFieldMethodSignatureRuntimeImpl sig = new NativeInstanceFieldMethodSignatureRuntimeImpl(ctx);
        sig.setThisClassType(classObj,ctx); 
        sig.setFieldVarType(fieldTypeDec);
        return sig;
    }    
    
    public void setThisClassType(Class classObj,RuntimeContext ctx)
    {
        VarTypeNativeRuntimeImpl varTypeThis = ThisClassSignatureRuntimeUtil.decThisType(classObj,ctx);
        addParameterDec(new ParameterDecRuntimeImpl(varTypeThis));        
    }
    
    public NativeInstanceFieldMethodSignatureImpl getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignatureImpl)signature;
    }    
    
    public ParameterDecRuntimeImpl getParameterDec(int index)
    {
        // Sumamos +1 porque el primer parámetro es del objeto (this), pero no 
        // es el primer parámetro desde el punto de vista de la función C++
        return super.getParameterDec(index + 1);
    }
    
    public int getParameterCount()
    {
        return super.getParameterCount() - 1;
    }    
    
    public Class getThisClass()
    {       
        return getThisClassTypeNativeRuntime().getDeclaredClass();
    }
    
    public TypeNativeCapableRuntimeImpl getThisClassTypeNativeRuntime()
    {
        // -1 porque se suma +1 (-1 + 1 = 0 que es el verdadero)         
        return (TypeNativeCapableRuntimeImpl)getParameterDec(-1).getVarTypeNativeRuntime().getTypeNativeRuntime();
    }    
    
    public TypeNativeInstanceFieldMethod decInstanceFieldMethod(Class fieldClass)
    {
        return getTypeManager().decInstanceFieldMethod(fieldClass,this);
    }
    
    public void checkReflectionObject(Member member)
    {    
        Field field = (Field)member;
        Field fieldValid = getField(field.getName());        
        if (!field.equals(fieldValid)) throw new JNIEasyException("Not valid field " + field);        
    }    
    
    public String getNameToExport(Member member)
    {
        return member.getName();
    }        
    
    public NativeInstanceFieldMethodReflection newInstanceFieldMethodReflection(String fieldName)    
    {
        Field field = getField(fieldName);
        return (NativeInstanceFieldMethodReflection)newBehaviorReflectionInternal(field,false);
    }
    
    public Field getField(String fieldName)
    {
        //NativeInstanceFieldMethodSignatureImpl sig = getInstanceFieldMethodSignature();
        Class clasz = getThisClass();
        Field field = super.getField(clasz,fieldName);
        if (Modifier.isStatic(field.getModifiers()))
            throw new JNIEasyException("Real Java field must not be static: " + field);
        return field;
    }
  
    public NativeDirectInstanceFieldCallback newDirectInstanceFieldCallback(String fieldName) 
    {    
        Field field = getField(fieldName);        
        return (NativeDirectInstanceFieldCallback)newDirectCallbackInternal(field,false);
    }    
    
    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeInstanceFieldMethodSignatureImpl(jniEasy);
    }
    
    public Class getNativeBehaviorDefaultInterface()    
    {
        return NativeInstanceFieldMethod.class;
    }
    
    public Object call(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.call(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public void callVoid(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        super.callVoid(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
   
    public boolean callBoolean(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callBoolean(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public byte callByte(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callByte(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public char callChar(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callChar(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public short callShort(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callShort(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }

    public int callInt(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callInt(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
 
    public long callLong(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callLong(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
 
    public float callFloat(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callFloat(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public double callDouble(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callDouble(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }
    
    public Object callObject(NativeCapableInternal container,long address,Object obj, Object[] args)
    {
        return super.callObject(container,address,ThisClassSignatureRuntimeUtil.convertArgs(obj,args));
    }         

}
