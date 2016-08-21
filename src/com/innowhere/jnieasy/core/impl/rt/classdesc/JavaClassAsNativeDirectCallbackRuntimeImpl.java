/*
 * JavaClassAsNativeDirectCallbackRuntimeImpl.java
 *
 * Created on 8 de julio de 2005, 10:43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectCallbackRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeDirectCallbackDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature;
import java.lang.reflect.Member;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectCallbackRuntimeImpl extends JavaClassAsNativeCapableRuntimeImpl implements NativeDirectCallbackDescriptor
{
    protected BehaviorOfClassRuntimeImpl behaviorOfClass;
            
    /**
     * Creates a new instance of JavaClassAsNativeDirectCallbackRuntimeImpl
     */
    public JavaClassAsNativeDirectCallbackRuntimeImpl(JavaClassAsNativeDirectCallbackImpl javaClass,ClassTypeNativeDirectCallbackRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }

    public JavaClassAsNativeDirectCallbackImpl getJavaClassAsNativeDirectCallback()
    {
        return (JavaClassAsNativeDirectCallbackImpl)javaClass;
    }
    
    public long size()
    {
        return typeDecRt.size();
    }

    public long alignSize()
    {
        return typeDecRt.preferredAlignSize();
    }    
    
    public ClassTypeNativeDirectCallbackRuntimeImpl getClassTypeNativeDirectCallbackRuntime()
    {
        return (ClassTypeNativeDirectCallbackRuntimeImpl)classTypeRt;
    }
    
    public static JavaClassAsNativeDirectCallbackRuntimeImpl initRegistrationNativeDirectCallbackType(NativeCapableInternal factoryInst,int licenseUsedByEnhancer,JNIEasyImpl jniEasy)
    {
        RuntimeContext ctx = jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
        Class clasz = factoryInst.getClass();
        ClassTypeNativeDirectCallbackImpl classType = ClassTypeNativeDirectCallbackRuntimeImpl.registerCustomNativeDirectCallbackType(clasz,ctx);
        
        JavaClassAsNativeDirectCallbackRuntimeImpl javaClassRt = (JavaClassAsNativeDirectCallbackRuntimeImpl)sharedInitRegistrationClassTypeNativeCapable(classType,factoryInst,licenseUsedByEnhancer);
        return javaClassRt;
    }
    
    public NativeBehaviorSignatureRuntimeImpl getBehaviorSignatureRuntime()
    {       
        return behaviorOfClass.getBehaviorSignatureRuntime();
    }    
    
    public NativeBehaviorSignature getBehaviorSignature()
    {       
        return behaviorOfClass.getBehaviorSignatureRuntime();
    }
    
    public void finalizeRegistration()
    {
        TypeNativeDirectCallbackRuntimeImpl typeDecRt = (TypeNativeDirectCallbackRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(getJavaClass(),classTypeRt, getDefaultRuntimeContext());
        //typeDecRt.setBehaviorSignature(behaviorOfClass.getBehaviorSignatureRuntime());
        if (getRuntimeManager().getNativeManager().isRuntimeChecking())                   
            typeDecRt.check();
        this.typeDecRt = typeDecRt;
    }      
    
    public ClassTypeNativeMultipleFieldContainerRuntimeImpl getClassTypeMethodContainer(Class containerClass)
    {
        // Hay que recordar que la clase container puede ser diferente a la NativeDirectXXXCallback más aun en el caso
        // de métodos no estáticos y constructores e incluso puede ser no enhanceable (sólo métodos estáticos)
        ClassTypeNativeImpl classType = getDefaultRuntimeContext().getClassType(containerClass,false);
        if ((classType != null)&&(!(classType instanceof ClassTypeNativeDirectCallbackImpl)))
            return (ClassTypeNativeMultipleFieldContainerRuntimeImpl)classType.getClassTypeRuntime();
        else
            return ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl.newClassTypeMultipleFieldContainerUnknownRuntime(containerClass.getName(),getRuntimeManager());        
    }

    public void setBehaviorOfClassRuntime(BehaviorOfClassRuntimeImpl behaviorOfClass)
    {
        this.behaviorOfClass = behaviorOfClass;   
        getJavaClassAsNativeDirectCallback().setBehaviorOfClass(behaviorOfClass.getBehaviorOfClass());
    }
    
    public void setBehavior(Class containerClass,Member behavior,boolean exportMethod,NativeBehaviorSignatureRuntimeImpl sig)
    {
        ClassTypeNativeMultipleFieldContainerRuntimeImpl classTypeContainerRt = getClassTypeMethodContainer(containerClass);        
        BehaviorOfClassRuntimeImpl behaviorOfClass = BehaviorOfClassRuntimeImpl.newBehaviorOfClassRuntime(this,behavior,sig,classTypeContainerRt);
        setBehaviorOfClassRuntime(behaviorOfClass);          
        
        // useReflection debe ser false necesariamente
        behaviorOfClass.setUseReflection(false);
        behaviorOfClass.setClassTypeNativeDirectCallbackRuntime(getClassTypeNativeDirectCallbackRuntime());     
        if (exportMethod)
            behaviorOfClass.exportMethod();                
    }        

}
