/*
 * TypeNativeStaticFieldMethodReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeStaticFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeStaticFieldMethodReflectionWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeStaticFieldMethodReflectionWrapperRuntimeImpl;




public class TypeNativeStaticFieldMethodReflectionWrapperImpl extends TypeNativeFieldMethodReflectionWrapperImpl
{
    /** Creates a new instance of TypeNativeStaticFieldMethodReflectionWrapperImpl */
    public TypeNativeStaticFieldMethodReflectionWrapperImpl(ClassTypeNativeStaticFieldMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }           
             
    public TypeNativeStaticFieldMethodReflectionWrapperImpl(ClassTypeNativeStaticFieldMethodReflectionWrapperImpl dataType,TypeNativeFieldMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
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

    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeStaticFieldMethodReflectionWrapperXML(this);
    }

    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStaticFieldMethodReflectionWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }      

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()   
    {
        return NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
    }    
}
