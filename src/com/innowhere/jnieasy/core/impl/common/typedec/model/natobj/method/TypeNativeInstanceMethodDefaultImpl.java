/*
 * TypeNativeInstanceMethodDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeInstanceMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeInstanceMethodDefaultRuntimeImpl;



public class TypeNativeInstanceMethodDefaultImpl extends TypeNativeMethodDefaultImpl
{
    /**
     * Creates a new instance of TypeNativeInstanceMethodDefaultImpl
     */
    public TypeNativeInstanceMethodDefaultImpl(ClassTypeNativeInstanceMethodDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeInstanceMethodSignatureImpl)signature;
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeInstanceMethodDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }    

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeInstanceMethodSignatureXML.newInstanceMethodSignatureXML();
    }    
}
