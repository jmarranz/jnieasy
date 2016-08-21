/*
 * TypeNativeStaticMethodReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeStaticMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeStaticMethodReflectionWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeStaticMethodReflectionWrapperRuntimeImpl;




public class TypeNativeStaticMethodReflectionWrapperImpl extends TypeNativeMethodReflectionWrapperImpl
{
    /** Creates a new instance of TypeNativeStaticMethodReflectionWrapperImpl */
    public TypeNativeStaticMethodReflectionWrapperImpl(ClassTypeNativeStaticMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }    
                     
    public TypeNativeStaticMethodReflectionWrapperImpl(ClassTypeNativeStaticMethodReflectionWrapperImpl dataType,TypeNativeMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
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
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeStaticMethodReflectionWrapperXML(this);
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStaticMethodReflectionWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }    
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        return NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
    }    
}
