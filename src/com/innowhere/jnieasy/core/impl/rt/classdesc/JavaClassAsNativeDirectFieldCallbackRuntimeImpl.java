/*
 * JavaClassAsNativeDirectFieldCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectFieldCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectFieldCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;



/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectFieldCallbackRuntimeImpl extends JavaClassAsNativeDirectCallbackRuntimeImpl implements NativeDirectFieldCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectFieldCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectFieldCallbackRuntimeImpl(JavaClassAsNativeDirectFieldCallbackImpl javaClass,ClassTypeNativeDirectFieldCallbackRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public FieldMethodOfClassRuntimeImpl getFieldMethodOfClassRuntime()
    {
        return (FieldMethodOfClassRuntimeImpl)behaviorOfClass;
    }
    
    public ClassTypeNativeDirectFieldCallbackRuntimeImpl getClassTypeNativeDirectFieldCallbackRuntime()
    {
        return (ClassTypeNativeDirectFieldCallbackRuntimeImpl)classTypeRt;
    }
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();
    }        
    
    public abstract void setFieldMethod(String callbackClassName,String methodName,boolean exportMethod,NativeFieldMethodSignatureRuntimeImpl sig);
    
}
