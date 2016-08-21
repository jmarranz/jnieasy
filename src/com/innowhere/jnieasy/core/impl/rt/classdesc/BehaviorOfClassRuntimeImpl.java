/*
 * BehaviorOfClassRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 13:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.dll.DynamicLibraryImpl;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeBehaviorReflection;
import com.innowhere.jnieasy.core.method.NativeDirectCallback;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorDescriptor;
import com.innowhere.jnieasy.core.method.NativeCallback;
import com.innowhere.jnieasy.core.method.NativeBehavior;
import com.innowhere.jnieasy.core.method.DLLBehavior;
import java.lang.reflect.Member;

/**
 *
 * @author jmarranz
 */
public abstract class BehaviorOfClassRuntimeImpl extends MemberOfClassRuntimeImpl implements NativeBehaviorDescriptor
{
    protected JavaClassAsNativeCapableRuntimeImpl javaClass;    
    protected NativeBehavior nativeBehavior;
    protected NativeBehaviorSignatureRuntimeImpl signature;
    protected ClassTypeNativeDirectCallbackRuntimeImpl callbackClassType;
    protected boolean useReflection = false;
    protected boolean onLibrary = false;
    protected DynamicLibraryImpl dll;
    
    /**
     * Creates a new instance of BehaviorOfClassRuntimeImpl 
     */
    public BehaviorOfClassRuntimeImpl(JavaClassAsNativeCapableRuntimeImpl javaClass,BehaviorOfClassImpl memberOfClass,Member member,NativeBehaviorSignatureRuntimeImpl sig)
    {
        super(memberOfClass,member);
        this.javaClass = javaClass;
        this.signature = sig;
    }
    
    public static BehaviorOfClassRuntimeImpl newBehaviorOfClassRuntime(JavaClassAsNativeCapableRuntimeImpl javaClass,Member member,NativeBehaviorSignatureRuntimeImpl sig,ClassTypeNativeCapableRuntimeImpl classTypeRt)
    {
        BehaviorOfClassImpl methodOfClass = BehaviorOfClassImpl.newBehaviorOfClass(sig.getBehaviorSignature(), classTypeRt.getClassTypeNativeCapable());
        return methodOfClass.newBehaviorOfClassRuntime(javaClass,member,sig);
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {
        return javaClass.getRuntimeManager();
    }
    
    public ClassTypeNativeDirectCallbackRuntimeImpl getClassTypeNativeDirectCallbackRuntime()
    {
        // El proceso de crear una clase NativeDirectCallback desde cero si la callback no está en el disco duro 
        // es un proceso costoso por lo que sólo lo hacemos si se solicita
        // y aunque esté en el disco duro hay que cargar el .class, si no se usa nunca nos ahorramos dicha carga
        if (callbackClassType == null)
            this.callbackClassType = signature.getClassTypeNativeDirectCallbackRuntimeFromScratch(member, getClassLoader());
        return callbackClassType;
    }    
    
    public void setClassTypeNativeDirectCallbackRuntime(ClassTypeNativeDirectCallbackRuntimeImpl callbackClassType)
    {
        this.callbackClassType = callbackClassType;
    }
    
    public ClassLoader getClassLoader()
    {
        return javaClass.getClassLoader();
    }

    
    public BehaviorOfClassImpl getBehaviorOfClass()
    {
        return (BehaviorOfClassImpl)memberOfClass;
    }
    
    public NativeBehaviorSignatureRuntimeImpl getBehaviorSignatureRuntime()
    {
        return signature;
    }

    public NativeCallback newCallback()
    {
        NativeCallback callback;
        
        if (isUseReflection())
        {
            callback = (NativeBehaviorReflection)signature.newBehaviorReflectionInternal(member,false);
        }
        else
        {
            ClassTypeNativeDirectCallbackRuntimeImpl callbackClassType = getClassTypeNativeDirectCallbackRuntime();
            callback = (NativeDirectCallback)callbackClassType.newValue();
        }        
        
        // De poco sirve si no es hecha nativa
        getRuntimeManager().getNativeManager().makeNative(callback);
        return callback;
    }    
    
    public abstract DLLBehavior newDLLBehavior();
    
    public NativeBehavior getNativeBehavior()
    {
        if (nativeBehavior == null)
        {
            if (onLibrary)
                this.nativeBehavior = newDLLBehavior();
            else
                this.nativeBehavior = newCallback();              
        }                
        return nativeBehavior;
    }
    
    public DynamicLibraryImpl getDynamicLibrary()
    {
        return dll;
    }
    
    public void setOnLibrary(DynamicLibraryImpl dll,String nativeName)
    {
        this.onLibrary = true;
        this.dll = dll; 
        getBehaviorOfClass().setNativeNameExpr(nativeName);
    }
    
    public void exportMethod()
    {
        NativeBehavior method = getNativeBehavior();
        // En el caso de métodos proxy de DLLs el propio objeto ya se exporta
        // al crearse pues se usan los métodos de DynamicLibrary
        // pero de esta manera el objeto al obligarse a instanciarse ahora es 
        // también obligar a registrase ahora (pues el objeto no se crea hasta el primer uso)

        if (!onLibrary) // en el caso true ya fue registrado, no aporta nada el registrar de nuevo
        {
            JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)getRuntimeManager().getJNIEasy().getJNIEasyLib();
            dll.exportBehavior((Member)getMember(), method);
        }
    }

    public boolean isUseReflection()
    {
        return useReflection;
    }

    public void setUseReflection(boolean useReflection)
    {
        this.useReflection = useReflection;
    }
    
    public String getNativeName()
    {
        String nativeNameExpr = getBehaviorOfClass().getNativeNameExpr();
        return dll.getDLLManagerImpl().parseNameWithMacros(nativeNameExpr);    
    }
}
