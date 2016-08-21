/*
 * TypeCMethodImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeCMethodImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeCMethodRuntimeImpl;



public class TypeCMethodImpl extends TypeDLLMethodImpl
{
    /**
     * Creates a new instance of TypeCMethodImpl
     */
    public TypeCMethodImpl(ClassTypeCMethodImpl dataType)
    {
        super(dataType);
    }
        
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }
       
    public NativeStaticMethodSignatureImpl getStaticMethodSignature()
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }
    
    public void setStaticMethodSignature(NativeStaticMethodSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }

    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeCMethodRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
    }    
}
