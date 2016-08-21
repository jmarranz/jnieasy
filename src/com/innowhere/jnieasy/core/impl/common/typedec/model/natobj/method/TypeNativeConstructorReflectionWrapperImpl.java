/*
 * TypeNativeConstructorReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeConstructorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ConstructorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeConstructorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeConstructorReflectionWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeConstructorReflectionWrapperRuntimeImpl;



public class TypeNativeConstructorReflectionWrapperImpl extends TypeNativeBehaviorReflectionWrapperImpl
{
    /** Creates a new instance of TypeNativeConstructorReflectionWrapperImpl */
    public TypeNativeConstructorReflectionWrapperImpl(ClassTypeNativeConstructorReflectionWrapperImpl dataType)
    {
        super(dataType);
    }    
                     
    public TypeNativeConstructorReflectionWrapperImpl(ClassTypeNativeConstructorReflectionWrapperImpl dataType,TypeNativeConstructorReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
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

    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeConstructorReflectionWrapperXML(this);
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeConstructorReflectionWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }      
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        return ConstructorSignatureXML.newConstructorSignatureXML();
    }    
}
