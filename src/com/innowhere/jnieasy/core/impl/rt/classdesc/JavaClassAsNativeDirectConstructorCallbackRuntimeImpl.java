/*
 * JavaClassAsNativeDirectConstructorCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectConstructorCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeConstructorSignature;
import java.lang.reflect.Constructor;


/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectConstructorCallbackRuntimeImpl extends JavaClassAsNativeDirectCallbackRuntimeImpl implements NativeDirectConstructorCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectConstructorCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectConstructorCallbackRuntimeImpl(JavaClassAsNativeDirectConstructorCallbackImpl javaClass,ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl getClassTypeNativeDirectConstructorCallbackCustomRuntime()
    {
        return (ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl)classTypeRt;
    }
    
    public void setConstructor(String containerClassName,boolean exportMethod,NativeConstructorSignatureRuntimeImpl sig)
    {
        // containerClassName también se puede sacar del parámetro sig
        Constructor constructor = sig.getConstructor();
        setBehavior(constructor.getDeclaringClass(),constructor,exportMethod, sig);        
    }
    
    public ConstructorOfClassRuntimeImpl getConstructorOfClassRuntime()
    {
        return (ConstructorOfClassRuntimeImpl)behaviorOfClass;
    }
    
    public NativeConstructorSignature getConstructorSignature()
    {
        return (NativeConstructorSignature)getBehaviorSignature();
    }        
}
