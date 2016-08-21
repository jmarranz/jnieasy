/*
 * NativeConstructorSignature.java
 *
 * Created on 11 de febrero de 2004, 21:12
 */

package com.innowhere.jnieasy.core.impl.rt.signat;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeConstructorSignatureRender;
import com.innowhere.jnieasy.core.impl.rt.RuntimeUtil;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeConstructorReflection;
import com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback;
import com.innowhere.jnieasy.core.method.NativeConstructor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.ArrayList;



public class NativeConstructorSignatureRuntimeImpl extends NativeBehaviorSignatureRuntimeImpl implements NativeConstructorSignature
{
    protected NativeManagerImpl nativeMgr;
    
    /**
     * Creates a new instance of NativeConstructorSignature
     */
    public NativeConstructorSignatureRuntimeImpl(NativeConstructorSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        super(signature,classRet,classParams,ctx);
        this.nativeMgr = (NativeManagerImpl)ctx.getRuntimeManager().getNativeManager();
    }    
        
    public NativeConstructorSignatureRuntimeImpl(RuntimeContext ctx)
    {
        super(ctx);
        this.nativeMgr = (NativeManagerImpl)ctx.getRuntimeManager().getNativeManager();        
    }    
    
    public static NativeConstructorSignatureRuntimeImpl newConstructorSignatureRuntime(Class classObj,ArrayList params,RuntimeContext ctx)
    {
        NativeConstructorSignatureRuntimeImpl sig = new NativeConstructorSignatureRuntimeImpl(ctx);        
        VarTypeNativeRuntimeImpl returnType = ThisClassSignatureRuntimeUtil.decThisType(classObj,ctx);         
        fillBehaviorSignatureRuntime(sig,returnType,params,ctx);
        return sig;
    }    
    
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)signature;
    }   
    
    public String formNativeDirectCallbackUniqueClassName(Member behavior)
    {
        Constructor construc = (Constructor)behavior;
        NativeConstructorSignatureImpl sig = getConstructorSignature();        
        return sig.formNativeDirectCallbackUniqueClassName(construc.getDeclaringClass().getName(),RuntimeUtil.extractClassNames(construc.getParameterTypes()));
    }    
    
    public Class getThisClass()
    {       
        return getThisClassTypeNativeRuntime().getDeclaredClass();
    }
    
    public TypeNativeCapableRuntimeImpl getThisClassTypeNativeRuntime()
    {       
        return (TypeNativeCapableRuntimeImpl)getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime();
    }       
    
    public TypeNativeConstructor decConstructor(Class methodClass)
    {
        return getTypeManager().decConstructor(methodClass,this);
    }
    
    public NativeConstructorReflection newConstructorReflection()
    {
        Constructor constructor = getConstructor();
        return (NativeConstructorReflection)newBehaviorReflectionInternal(constructor,false);
    }
   
    public void checkReflectionObject(Member member)
    {    
        Constructor construc = (Constructor)member;
        Constructor construcValid = getConstructor();        
        if (!construcValid.equals(construc)) throw new JNIEasyException("Not valid constructor " + construc);        
    }
    
    public String getNameToExport(Member member)
    {
        return NativeConstructorSignatureRender.NAME;
    }
    
    public Constructor getConstructor(Class clasz)
    {
        Class[] params = getParamClasses();
        try
        {
            return clasz.getDeclaredConstructor(params);
        }
        catch(NoSuchMethodException ex) 
        {
            throw new JNIEasyException(ex);
        }    
    }    
    
    public Constructor getConstructor()
    {
        Class clasz = getThisClass();
        return getConstructor(clasz);
    }
    
    public NativeDirectConstructorCallback newDirectConstructorCallback() 
    {    
        Constructor construc = getConstructor();
        return (NativeDirectConstructorCallback)newDirectCallbackInternal(construc,false);
    }        
    
    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeConstructorSignatureImpl(jniEasy);
    }
    
    public Class getNativeBehaviorDefaultInterface()    
    {
        return NativeConstructor.class;
    }    
    
    public Object call(NativeCapableInternal container,long address,Object[] args)
    {
        // Sabemos que el retorno debe ser un NativeCapableInternal
        // por tanto llamamos directamente a callObject
        // y no usamos la genérica call() que haría lo mismo pero con chequeo de retorno
        return super.callObject(container,address,args);
    }
      
    public void call(NativeCapableInternal container,long address,Object proxy,Object[] args)
    {
        // Este método se usa cuando el objeto proxy se crea como un objeto 
        // Java enhanced pero cuya finalidad es ser vinculado a un objeto C++ nativo.
        // y servir de proxy, es una alternativa a que el objeto proxy sea
        // creado dinámicamente. Permite la vinculación a un objeto nativo de un objeo Java
        // en el momento de la construcción (en el constructor del obj. Java) 
        returnType.checkValue(proxy); // Chequea que sea del tipo esperado        
        
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.POINTER_RETURN);
        long returnAddr = MethodNative.callPointer(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);       
 
        NativeAddressImpl returnAddress = new NativeAddressImpl(returnAddr);
        NativeCapableInternal registered = this.nativeMgr.getJavaAllocatedObjectRegistry().findObject(returnAddress);
        if (registered != null) 
            throw new JNIEasyException("Already exist a previous allocated Java object linked to the returned native address: " + returnAddress.getValue());

        TypeNativeRuntimeImpl typeDecRet = getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime();
        this.nativeMgr.attach((NativeCapableInternal)proxy,false,returnAddress, 0,typeDecRet);
    }    
}
