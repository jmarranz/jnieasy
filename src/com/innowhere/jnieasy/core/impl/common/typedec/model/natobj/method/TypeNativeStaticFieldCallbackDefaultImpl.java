/*
 * TypeNativeStaticFieldCallbackDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeStaticFieldCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeStaticFieldCallbackDefaultRuntimeImpl;



public class TypeNativeStaticFieldCallbackDefaultImpl extends TypeNativeFieldCallbackDefaultImpl
{
    /**
     * Creates a new instance of TypeNativeStaticFieldCallbackDefaultImpl
     */
    public TypeNativeStaticFieldCallbackDefaultImpl(ClassTypeNativeStaticFieldCallbackDefaultImpl dataType)
    {
        super(dataType);
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
        return new TypeNativeStaticFieldCallbackDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
    }    
}
