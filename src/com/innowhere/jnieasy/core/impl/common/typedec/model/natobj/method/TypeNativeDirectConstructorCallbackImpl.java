/*
 * TypeNativeDirectConstructorCallbackImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ConstructorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectConstructorCallbackRuntimeImpl;



public class TypeNativeDirectConstructorCallbackImpl extends TypeNativeDirectCallbackImpl
{
    /**
     * Creates a new instance of TypeNativeDirectConstructorCallbackImpl
     */
    public TypeNativeDirectConstructorCallbackImpl(ClassTypeNativeDirectConstructorCallbackImpl dataType)
    {
        super(dataType);
    }
    
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeConstructorSignatureImpl)signature;
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeDirectConstructorCallbackRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        return ConstructorSignatureXML.newConstructorSignatureXML();
    }        
}
