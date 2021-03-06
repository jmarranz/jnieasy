/*
 * TypeNativeStaticFieldMethodDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeStaticFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeStaticFieldMethodDefaultRuntimeImpl;



public class TypeNativeStaticFieldMethodDefaultImpl extends TypeNativeFieldMethodDefaultImpl
{
    /**
     * Creates a new instance of TypeNativeStaticFieldMethodDefaultImpl
     */
    public TypeNativeStaticFieldMethodDefaultImpl(ClassTypeNativeStaticFieldMethodDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
        
    public NativeStaticFieldMethodSignatureImpl getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    }
    
    public void setStaticFieldMethodSignature(NativeStaticFieldMethodSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeStaticFieldMethodDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
    }    
}
