/*
 * MethodSignature.java
 *
 * Created on 4 de febrero de 2004, 20:19
 */

package com.innowhere.jnieasy.core.impl.rt.signat;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecList;
import com.innowhere.jnieasy.core.impl.common.signat.model.ReturnDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerUtil;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeDirectCallbackEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.method.NativeDirectCallback;
import java.util.ArrayList;
import javassist.CtClass;
import javassist.CtMember;
import com.innowhere.jnieasy.core.impl.rt.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeBehaviorReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeAddress;
import com.innowhere.jnieasy.core.method.NativeBehaviorReflection;
import com.innowhere.jnieasy.core.method.NativeBehavior;
import java.lang.reflect.Member;


public abstract class NativeBehaviorSignatureRuntimeImpl implements NativeBehaviorSignature
{
    protected RuntimeManagerImpl rtMgr;
    protected NativeBehaviorSignatureImpl signature;
    protected ReturnDeclarationRuntimeImpl returnType;
    protected ParameterDecListRuntime paramDecList;
    
    
    /** Creates a new instance of MethodSignature */
    public NativeBehaviorSignatureRuntimeImpl(NativeBehaviorSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        this.signature = signature;
        this.returnType = new ReturnDeclarationRuntimeImpl(classRet,signature.getReturnDeclaration(),ctx);
        this.paramDecList = new ParameterDecListRuntime(classParams,signature.getParameterDecList(),ctx);
        this.rtMgr = ctx.getRuntimeManager();
    }  
    
    public NativeBehaviorSignatureRuntimeImpl(RuntimeContext ctx)
    {
        this.rtMgr = ctx.getRuntimeManager();
        this.signature = newBehaviorSignature(ctx.getJNIEasy());  
        this.paramDecList = new ParameterDecListRuntime(signature.getParameterDecList());        
    }    
    
    public static NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(NativeBehaviorSignatureImpl signature,Class classRet,Class[] classParams,RuntimeContext ctx)
    {
        return signature.newBehaviorSignatureRuntime(classRet,classParams,ctx);
    }    

    public static Class getClassReturn(NativeBehaviorSignatureImpl signature)
    {
        TypeNativeImpl typeDecRet = signature.getReturnDeclaration().getVarTypeNative().getTypeNative();
        return TypeNativeRuntimeImpl.getClassImpl(typeDecRet);
    }
    
    public static Class[] getClassParams(NativeBehaviorSignatureImpl signature)
    {
        ParameterDecList paramList = signature.getParameterDecList();
        int paramCount = paramList.length();
        Class[] classParams = new Class[paramCount];       
        for(int i = 0; i < paramCount; i++ )
        {
            TypeNativeImpl typeDecParam = paramList.getParameterDec(i).getVarTypeNative().getTypeNative();
            Class classParam = TypeNativeRuntimeImpl.getClassImpl(typeDecParam);
            classParams[i] = classParam;
        }        
        return classParams;
    }
    
    public static void fillBehaviorSignatureRuntime(NativeBehaviorSignatureRuntimeImpl sig,VarTypeNativeRuntimeImpl returnType,ArrayList params,RuntimeContext ctx)
    {
        sig.setReturnVarType(returnType);
        sig.addParameterDec(params);
    }    
    
    public void addParameterDec(ParameterDecRuntimeImpl param)
    {
        this.signature.addParameterDec(param.getParameterDec());
        this.paramDecList.addParameterDecRuntime(param);
    }    
    
    public void addParameterDec(ArrayList params)
    {
        int count = params.size();
        for(int i = 0; i < count; i++) 
        {
            ParameterDecRuntimeImpl param = (ParameterDecRuntimeImpl)params.get(i);
            addParameterDec(param);
        }
    }
    
    public void setReturnVarType(VarTypeNativeRuntimeImpl returnType)
    {
        this.signature.setReturnVarType(returnType.getVarTypeNative());
        this.returnType = new ReturnDeclarationRuntimeImpl(returnType, signature.getReturnDeclaration());
    }
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
    
    public NativeTypeManager getTypeManager()
    {
        return rtMgr.getTypeManagerRuntime();
    }
    
    public static ReturnDeclarationRuntimeImpl toReturnDeclaration(VarTypeNativeRuntimeImpl varTypeDec)
    {
        return new ReturnDeclarationRuntimeImpl(varTypeDec, new ReturnDeclarationImpl(varTypeDec.getVarTypeNative()));
    }
   
    public ParameterDecListRuntime getParameterDecList()
    {
        return paramDecList;
    }
    
    public VarTypeNative[] getParameters()
    {
        return paramDecList.getParameterVarTypeList();
    }

    public VarTypeNative getParameterVarType(int index)
    {
        return getParameterDec(index).getVarTypeNativeRuntime();
    }    
    
    public ParameterDecRuntimeImpl getParameterDec(int index)
    {
        return paramDecList.getParameterDec(index);
    }    
    
    public int getParameterCount()
    {
        return paramDecList.length(); 
    }        

    public VarTypeNative getReturnVarType()
    {
        return returnType.getVarTypeNativeRuntime();
    }        
    
    public ReturnDeclarationRuntimeImpl getReturnTypeNativeRuntime()
    {
        return returnType;
    }          
    
    public int getCallConv()
    {
        return signature.getCallConv();
    }
    
    public boolean equals(Object obj)
    {
        if (obj == null) return false;        
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        // Son distintos objetos pero la signatura puede ser la misma
        // Comparamos sólo los parámetros no el retorno, pues para un 
        // nombre dado de método no se permite que dos métodos
        // tengan los mismos parámetros, aunque el nombre no esté aquí
        // somos coherentes con esta idea
        NativeBehaviorSignatureRuntimeImpl sig2 = (NativeBehaviorSignatureRuntimeImpl)obj;

        return (signature.equals(sig2.signature));
    }    
    
    public int hashCode()
    {
        return signature.hashCode();
    }
    
    public String getDeclarationString()    
    {
        return signature.getBehaviorSignatureRender().getDeclarationString();
    }

    public String getSignatureString(String methodName)
    {
        return signature.getSignatureString(methodName);        
    }     
    
    public TypeNativeBehavior decBehavior(Class methodClass)    
    {
        return getTypeManager().decBehavior(methodClass, this);
    }
        
    public Class[] getParamClasses()
    {
        int numParams = getParameterCount();
        Class[] paramClasses = new Class[numParams];
        for (int i = 0; i < numParams; i++ )
        {
            ParameterDecRuntimeImpl param = getParameterDec(i);
            paramClasses[i] = param.getVarTypeNativeRuntime().getTypeNativeRuntime().getDeclaredClass();
        }
        return paramClasses;
    }    

    public Class getReturnClass()
    {
        return getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime().getDeclaredClass();
    }
    
    public abstract String formNativeDirectCallbackUniqueClassName(Member behavior);    
    
    public ClassTypeNativeDirectCallbackRuntimeImpl getClassTypeNativeDirectCallbackRuntimeFromScratch(Member member,ClassLoader loader)
    {
        String containerClassName = formNativeDirectCallbackUniqueClassName(member); 
        
        ClassTypeNativeDirectCallbackRuntimeImpl classType = getClassTypeNativeDirectCallbackRuntimeFromScratch(containerClassName,member,loader);
        if (classType == null)
        {
            // Esto seguramente ocurre porque el member es un método de un clase (o field) en un paquete prohibido en donde crear
            // nuevas clases (java, javax etc) , como la clase probablemente no se escribirá en el disco duro
            // forzamos un package inútil
            containerClassName = "jnieasy." + containerClassName;
            classType = getClassTypeNativeDirectCallbackRuntimeFromScratch(containerClassName,member,loader);
        }
        return classType;
    }    
    
    public ClassTypeNativeDirectCallbackRuntimeImpl getClassTypeNativeDirectCallbackRuntimeFromScratch(String containerClassName,Member member,ClassLoader loader)
    {

        // Sincronizamos el loader para que no se hagan cargas en paralelo, porque es un caso de necesitar hacer enhancement en un entorno 
        // multihilo (en ejecución vamos) y que no hace el ClassLoader enhancer (que sí está sincronizado)        
        synchronized (loader)
        {                   
            Class classCallback = ClassTypeNativeRuntimeImpl.getClassFromVMClassName(containerClassName, loader, false);           
            if (classCallback != null) // Ya se ha creado y cargado previamente, o bien existe un .class en archivo y el ClassLoader ha sabido cargarlo y enhancearlo
            {                
                return (ClassTypeNativeDirectCallbackRuntimeImpl)rtMgr.getClassTypeManagerRuntime().findClassType(classCallback);
            }
            else
            {
                // Es el caso de una callback creada "al vuelo" sin que esté en el disco duro
                NativeEnhancerImpl enhancer = (NativeEnhancerImpl)rtMgr.getJNIEasy().getEnhancer();
                EnhancerSharedContext esctx = enhancer.getEnhancerSharedContext(loader);

                CtMember ctMember = esctx.toCtMember(member);

                NativeBehaviorSignatureEnhancerImpl sigEnh = NativeBehaviorSignatureEnhancerImpl.newBehaviorSignatureEnhancer(this.signature, enhancer);
                JavaClassAsNativeDirectCallbackEnhancer javaClassEnh = sigEnh.getJavaClassAsNativeDirectCallbackEnhancer(containerClassName, ctMember, esctx);

                CtClass ctClass = javaClassEnh.getCtClass();  
                if (ctClass.isFrozen())
                    return null; // Ya se usó para crear un Class y falló (pero queda frozen)
                    
                // Cargamos la clase en memoria porque sino no podemos instanciar, pues la clase NO está en el disco duro como .class 
                // está únicamente como CtClass (salvo que ya hayamos pasado por aquí antes)
                classCallback = EnhancerUtil.loadClass(ctClass, loader,(JNIEasyImpl)enhancer.getJNIEasy());    

                if (classCallback == null)
                    return null;  // Esto seguramente ocurre porque el containerClassName es de un paquete prohibido en donde crear nuevas clases (java, javax etc)
                
                ClassTypeNativeDirectCallbackImpl classType = (ClassTypeNativeDirectCallbackImpl)javaClassEnh.getJavaClassAsNativeDirectCallback().getClassTypeNativeCapable();
                return (ClassTypeNativeDirectCallbackRuntimeImpl)classType.getClassTypeRuntime();
            }
        }
    }
    
    public NativeBehaviorReflection newBehaviorReflection(Member member)
    {    
        return newBehaviorReflectionInternal(member,true);
    }    

    public NativeBehaviorReflection newBehaviorReflectionInternal(Member member,boolean check)
    {
        if (check && rtMgr.getNativeManager().isRuntimeChecking()) 
            checkReflectionObject(member);
        TypeNativeBehaviorReflectionRuntimeImpl typeDecImpl = (TypeNativeBehaviorReflectionRuntimeImpl)decBehavior(member.getClass());
        return (NativeBehaviorReflection)typeDecImpl.wrapValue(member);
    }        
    
    public NativeDirectCallback newDirectCallback(Member member) 
    {    
        return newDirectCallbackInternal(member,true);
    }        

    public NativeDirectCallback newDirectCallbackInternal(Member member,boolean check) 
    {    
        if (check) checkReflectionObject(member);         
        ClassLoader currentLoader = rtMgr.getTypeManagerRuntime().getClassLoader();        
        ClassTypeNativeDirectCallbackRuntimeImpl classDescRt = getClassTypeNativeDirectCallbackRuntimeFromScratch(member, currentLoader);
        return (NativeDirectCallback)classDescRt.newValue();
    }        

    public Object getDefaultReturnValue()
    {
        // Devolvemos un valor que sea válido, pues no podemos
        // devolver o pasar como argumento un null cuando el retorno
        // o parámetro es un primitivo.
        int resTypeCode = getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime().returnTypeCode();
        switch(resTypeCode)
        {
            case ClassTypeNativeRuntimeImpl.VOID_RETURN :   return null;
            case ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN : return Boolean.valueOf(false);
            case ClassTypeNativeRuntimeImpl.CHAR_RETURN :   return new Character('\0');            
            case ClassTypeNativeRuntimeImpl.SHORT_RETURN :  return new Short((short)0);            
            case ClassTypeNativeRuntimeImpl.INT_RETURN :    return new Integer(0);            
            case ClassTypeNativeRuntimeImpl.LONG_RETURN :   return new Long(0); 
            case ClassTypeNativeRuntimeImpl.FLOAT_RETURN :  return new Float(0);
            case ClassTypeNativeRuntimeImpl.DOUBLE_RETURN : return new Double(0);
            case ClassTypeNativeRuntimeImpl.POINTER_RETURN :  return null;
        }
        throw new JNIEasyException("INTERNAL ERROR: Not valid return type");        
    }    
    
    public void checkSelectedMethod(int typeCodeOfCall)
    {
        int typeCodeExpected = returnType.getVarTypeNativeRuntime().getTypeNativeRuntime().returnTypeCode();
        if (typeCodeOfCall != typeCodeExpected)
            throw new JNIEasyException("No valid selected method call, return type of method must be compatible with expected return type : " + returnType.getVarTypeNativeRuntime().getTypeNativeRuntime().getTypeNative().getClassName());
    }
            
    public static long getStackSize(NativeBufferImpl buffByValue)
    {
        if (buffByValue == null)
            return 0;
        else
            return buffByValue.size();
    }
    
    public NativeBufferImpl preCall(NativeCapableInternal container,Object[] args,Object[] argsUsed,int typeCodeOfCall)
    {
        checkSelectedMethod(typeCodeOfCall);

        int num = 0;
        if (args != null) num = args.length;
        if (paramDecList.length() != num)
            throw new JNIEasyException("Wrong number of parameters, " + num + " expected " + paramDecList.length());        

        NativeBufferImpl buffByValue = null;
        if (num > 0)         
        {
            long buffSize = paramDecList.stackSize();            
            buffByValue = NativeBufferImpl.createBuffer(buffSize,false,true);
        }
        
        paramDecList.push(args,argsUsed,buffByValue);
        return buffByValue;
    }

    public static Object[] newUsedArgsArray(Object[] args)
    {
        return args != null ? new Object[args.length] : null;
    }
    
    public static long getBufferAddress(NativeBufferImpl buff)
    {
        if (buff == null) return 0;
        return buff.getValue();
    }
    
    public void postCall(Object[] args,Object[] argsUsed,NativeBufferImpl buffByValue)
    {
        paramDecList.unwrap(args,argsUsed);
        if (buffByValue != null) buffByValue.free(); // No pasa nada porque no se llame, el GC se encargaría de ello cuando procesara el objeto Buffer        
    }       
    
    public Object call(NativeCapableInternal container,long address,Object[] args)
    {
        int resTypeCode = returnType.getVarTypeNativeRuntime().getTypeNativeRuntime().returnTypeCode();
        switch(resTypeCode)
        {
            case ClassTypeNativeRuntimeImpl.VOID_RETURN :   callVoid(container,address,args); return null;
            case ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN : return Boolean.valueOf(callBoolean(container,address,args));
            case ClassTypeNativeRuntimeImpl.CHAR_RETURN :   return new Character(callChar(container,address,args));            
            case ClassTypeNativeRuntimeImpl.SHORT_RETURN :  return new Short(callShort(container,address,args));            
            case ClassTypeNativeRuntimeImpl.INT_RETURN :    return new Integer(callInt(container,address,args));            
            case ClassTypeNativeRuntimeImpl.LONG_RETURN :   return new Long(callLong(container,address,args)); 
            case ClassTypeNativeRuntimeImpl.FLOAT_RETURN :  return new Float(callFloat(container,address,args));
            case ClassTypeNativeRuntimeImpl.DOUBLE_RETURN : return new Double(callDouble(container,address,args));
            case ClassTypeNativeRuntimeImpl.POINTER_RETURN :  return callObject(container,address,args);
        }
        throw new JNIEasyException("INTERNAL ERROR: Not valid return type");
    }  
    
    public void callVoid(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.VOID_RETURN);
        MethodNative.callVoid(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
    }
   
    public boolean callBoolean(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN);
        boolean res = MethodNative.callBoolean(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
        return res;
    }
    
    public byte callByte(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.BYTE_RETURN);
        byte res = MethodNative.callByte(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);    
        return res;
    }
    
    public char callChar(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.CHAR_RETURN);
        char res = MethodNative.callChar(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
        return res;
    }
    
    public short callShort(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.SHORT_RETURN);
        short res = MethodNative.callShort(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
        return res;
    }

    public int callInt(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.INT_RETURN);
        int res = MethodNative.callInt(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);      
        return res;
    }    
 
    public long callLong(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.LONG_RETURN);
        long res = MethodNative.callLong(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
        return res;
    }
 
    public float callFloat(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.FLOAT_RETURN);
        float res = MethodNative.callFloat(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
        return res;
    }
    
    public double callDouble(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.DOUBLE_RETURN);
        double res = MethodNative.callDouble(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);
        return res;
    }
    
    public Object callObject(NativeCapableInternal container,long address,Object[] args)
    {
        Object[] argsUsed = newUsedArgsArray(args);
        NativeBufferImpl buffByValue = preCall(container,args,argsUsed,ClassTypeNativeRuntimeImpl.POINTER_RETURN);
        long returnAddress = MethodNative.callPointer(address,getCallConv(),getBufferAddress(buffByValue),getStackSize(buffByValue));
        postCall(args,argsUsed,buffByValue);      
        TypeNativeObjectRuntimeImpl retTypeDec = (TypeNativeObjectRuntimeImpl)returnType.getVarTypeNativeRuntime().getTypeNativeRuntime();
        return retTypeDec.getObject(returnAddress); // Si la clase declarada fuera una interfase y fuera necesaria, se creará un proxy de clase predefinida en JNIEasy
    }
    
    public void checkReturnValidOfCallback()
    {
        TypeNativeRuntimeImpl retTypeDec = getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime();
        if (!retTypeDec.isValidAsReturnOfCallback())
            throw new JNIEasyException("Not valid as return of a Java callback: " + retTypeDec.getDeclaredClass().getName());
    }
            
    public NativeBehavior attachBehavior(NativeAddress address,long offset)
    {
        TypeNativeBehavior typeDec = getTypeManager().decBehavior(getNativeBehaviorDefaultInterface(),this);
        NativeBehavior method = (NativeBehavior)typeDec.newValue();
        rtMgr.getNativeManager().attach(method,address,offset);
        return method;
    }
    
    public NativeBehavior attachBehavior(long address)
    {    
        return attachBehavior(new NativeAddressImpl(address),0);
    }
    
    public abstract Class getNativeBehaviorDefaultInterface();
    public abstract void checkReflectionObject(Member member);  
    public abstract String getNameToExport(Member member);
    public abstract NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy);
}
