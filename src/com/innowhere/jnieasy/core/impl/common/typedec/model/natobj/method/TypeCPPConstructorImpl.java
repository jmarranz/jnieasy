/*
 * TypeCPPConstructorImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeCPPConstructorImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ConstructorSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeCPPConstructorRuntimeImpl;




public class TypeCPPConstructorImpl extends TypeDLLBehaviorImpl
{
    /**
     * Creates a new instance of TypeCPPConstructorImpl
     */
    public TypeCPPConstructorImpl(ClassTypeCPPConstructorImpl dataType)
    {
        super(dataType);
    }     
        
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeConstructorSignatureImpl)signature;
    }
           
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)signature;
    }
    
    public void setConstructorSignature(NativeConstructorSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeCPPConstructorRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return ConstructorSignatureXML.newConstructorSignatureXML();
    }        
}
