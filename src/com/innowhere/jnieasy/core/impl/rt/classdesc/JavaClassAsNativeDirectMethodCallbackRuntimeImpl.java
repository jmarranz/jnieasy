/*
 * JavaClassAsNativeDirectMethodCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectMethodCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectMethodCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;



/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectMethodCallbackRuntimeImpl extends JavaClassAsNativeDirectCallbackRuntimeImpl implements NativeDirectMethodCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectMethodCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectMethodCallbackRuntimeImpl(JavaClassAsNativeDirectMethodCallbackImpl javaClass,ClassTypeNativeDirectMethodCallbackRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public MethodOfClassRuntimeImpl getMethodOfClassRuntime()
    {
        return (MethodOfClassRuntimeImpl)behaviorOfClass;
    }
    
    public ClassTypeNativeDirectMethodCallbackRuntimeImpl getClassTypeNativeDirectMethodCallbackRuntime()
    {
        return (ClassTypeNativeDirectMethodCallbackRuntimeImpl)classTypeRt;
    }
    
    public NativeMethodSignature getMethodSignature()
    {
        return (NativeMethodSignature)getBehaviorSignature();
    }        
    
    public abstract void setMethod(String containerClassName,String methodName,boolean exportMethod,NativeMethodSignatureRuntimeImpl sig);

}
