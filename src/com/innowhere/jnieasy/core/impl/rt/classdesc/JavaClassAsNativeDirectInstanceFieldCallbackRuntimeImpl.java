/*
 * JavaClassAsNativeDirectInstanceFieldCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 11:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectInstanceFieldCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature;
import java.lang.reflect.Field;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeDirectInstanceFieldCallbackRuntimeImpl extends JavaClassAsNativeDirectFieldCallbackRuntimeImpl implements NativeDirectInstanceFieldCallbackDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectInstanceFieldCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectInstanceFieldCallbackRuntimeImpl(JavaClassAsNativeDirectInstanceFieldCallbackImpl javaClass,ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public void setFieldMethod(String callbackClassName,String fieldName,boolean exportMethod,NativeFieldMethodSignatureRuntimeImpl sig)
    {
        NativeInstanceFieldMethodSignatureRuntimeImpl sigRt = (NativeInstanceFieldMethodSignatureRuntimeImpl)sig;
        Class containerClass = sigRt.getThisClassTypeNativeRuntime().getDeclaredClass();        
        Field field = ((NativeInstanceFieldMethodSignatureRuntimeImpl)sig).getField(fieldName);
        
        setBehavior(containerClass,field,exportMethod,sig);        
    }       

    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)getBehaviorSignature();
    }
}
