/*
 * TypeNativeDirectStaticFieldCallbackImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectStaticFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectStaticFieldCallbackRuntimeImpl;




public class TypeNativeDirectStaticFieldCallbackImpl extends TypeNativeDirectFieldCallbackImpl
{
    /**
     * Creates a new instance of TypeNativeDirectStaticFieldCallbackImpl
     */
    public TypeNativeDirectStaticFieldCallbackImpl(ClassTypeNativeDirectStaticFieldCallbackImpl dataType)
    {
        super(dataType);
    }

    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeDirectStaticFieldCallbackRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }   
  
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()   
    {
        return NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
    }    
}
