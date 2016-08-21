/*
 * JavaClassAsNativeDirectStaticFieldCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectStaticFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectStaticFieldCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectStaticFieldCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature;
import java.lang.reflect.Field;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectStaticFieldCallbackRuntimeImpl extends JavaClassAsNativeDirectFieldCallbackRuntimeImpl implements NativeDirectStaticFieldCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectStaticFieldCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectStaticFieldCallbackRuntimeImpl(JavaClassAsNativeDirectStaticFieldCallbackImpl javaClass,ClassTypeNativeDirectStaticFieldCallbackCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)getBehaviorSignature();
    }    
    
    public void setFieldMethod(String containerClassName,String fieldName,boolean exportMethod,NativeFieldMethodSignatureRuntimeImpl sig)
    {
        // containerClassName puede ser una clase normal Java que contiene el field al que se refiere la Callback
        
        Class containerClass;
        Field field;
        if (getJavaClass().getName().equals(containerClassName))
        {
            containerClass = getJavaClass();
            field = sig.getField(containerClass,fieldName); // No forzamos la comprobación de que el field deba ser estático porque cuando están en callbacks admitimos que sean no estáticos para permitir la herencia (idem métodos)
        }
        else
        {
            containerClass = ClassTypeNativeRuntimeImpl.getClassFromVMClassName(containerClassName,getClassLoader(),true);
            field = ((NativeStaticFieldMethodSignatureRuntimeImpl)sig).getField(containerClass,fieldName);
        }

        setBehavior(containerClass,field,exportMethod,sig);        
    }    
}
