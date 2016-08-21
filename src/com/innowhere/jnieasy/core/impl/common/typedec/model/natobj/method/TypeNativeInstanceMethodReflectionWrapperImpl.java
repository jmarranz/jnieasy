/*
 * TypeNativeInstanceMethodReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeInstanceMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeInstanceMethodReflectionWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeInstanceMethodReflectionWrapperRuntimeImpl;



public class TypeNativeInstanceMethodReflectionWrapperImpl extends TypeNativeMethodReflectionWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeInstanceMethodReflectionWrapperImpl
     */
    public TypeNativeInstanceMethodReflectionWrapperImpl(ClassTypeNativeInstanceMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }    
             
    public TypeNativeInstanceMethodReflectionWrapperImpl(ClassTypeNativeInstanceMethodReflectionWrapperImpl dataType,TypeNativeMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }        
    
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeInstanceMethodSignatureImpl)signature;
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeInstanceMethodReflectionWrapperXML(this);
    }
        
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeInstanceMethodReflectionWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    } 
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        return NativeInstanceMethodSignatureXML.newInstanceMethodSignatureXML();
    }       
}
