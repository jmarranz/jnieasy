/*
 * TypeNativeStaticMethodCallbackDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeStaticMethodCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeStaticMethodCallbackDefaultRuntimeImpl;




public class TypeNativeStaticMethodCallbackDefaultImpl extends TypeNativeMethodCallbackDefaultImpl
{
    /**
     * Creates a new instance of TypeNativeStaticMethodCallbackDefaultImpl
     */
    public TypeNativeStaticMethodCallbackDefaultImpl(ClassTypeNativeStaticMethodCallbackDefaultImpl dataType)
    {
        super(dataType);
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
        return new TypeNativeStaticMethodCallbackDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
    }    
}
