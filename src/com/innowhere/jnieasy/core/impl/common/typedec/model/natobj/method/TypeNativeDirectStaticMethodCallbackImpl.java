/*
 * TypeNativeDirectStaticMethodCallbackImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectStaticMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectStaticMethodCallbackRuntimeImpl;



public class TypeNativeDirectStaticMethodCallbackImpl extends TypeNativeDirectMethodCallbackImpl
{
    /**
     * Creates a new instance of TypeNativeDirectStaticMethodCallbackImpl
     */
    public TypeNativeDirectStaticMethodCallbackImpl(ClassTypeNativeDirectStaticMethodCallbackImpl dataType)
    {
        super(dataType);
    }

    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }    
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeDirectStaticMethodCallbackRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }  
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        return NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
    }        
}
